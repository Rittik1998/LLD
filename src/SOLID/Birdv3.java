package SOLID;

public abstract class Birdv3 {
    private int weight;
    private String type;
    private String color;
    private String size;
    private String beakType;

    public String getType() {
        return type;
    }

    public Birdv3(String type) {
        this.type = type;
    }

    public abstract void walk();
}

interface Flyablev3{
    void fly();
}

interface Swimmablev3{
    void swim();
}

/*Many birds can have the same flying behaviour, so if we implements and have same method body for different bird class
 it will violate DRY(not part of solid)
 e.g
  class Eagle implements Flyable {
    @Override
    public void fly() {
        System.out.println("Eagle is gliding");
    }
}

 class Sparrow implements Flyable {
    @Override
    public void fly() {
        System.out.println("Sparrow is gliding");
    }
}

 Instead we should have a Implementation class of specific flying behaviour, so that bird class like Eagle
 HAS-A(association) with FlyingBehaviour
 */

interface FlyingBehaviour{
    void fly();
}

class GlidingFlyingBehaviour implements  FlyingBehaviour{
    String type;

    GlidingFlyingBehaviour(String type){
        this.type = type;
    }

    @Override
    public void fly() {
        System.out.println(type + " is flying");
    }
}

class Eaglev3 extends Birdv3 implements Flyablev3{
    /*violates DIP(Dependency Inversion), because incase FlyingBehaviour change, it would need code modification
   as it is tightly coupled and directly dependent ton concrete class

   //GlidingFlyingBehaviour glidingFlyingBehaviour = new GlidingFlyingBehaviour(this.getType())

    */
    FlyingBehaviour flyingBehaviour;
    /*
    this is bit bit for flexible than before, but still creating GlidingFlyingBehaviour() object inside class,
    so not fully loosely coupled, so here er can use Dependency Injection(not part of SOLID)
    Eaglev3(){
        super("Eagle");
        this.flyingBehaviour = new GlidingFlyingBehaviour();
    }

     */

    Eaglev3(FlyingBehaviour flyingBehaviour){
        super("Eagle");
        this.flyingBehaviour = flyingBehaviour;
    }

    @Override
    public void walk() {
        System.out.println(this.getType() + " is walking");
    }

    @Override
    public void fly() {
        flyingBehaviour.fly();
    }
}

