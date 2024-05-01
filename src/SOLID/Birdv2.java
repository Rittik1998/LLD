package SOLID;

public abstract class Birdv2 {
    private int weight;
    private String color;
    private String size;
    private String beakType;

    public abstract void walk();
}
/*Instead of creating behaviour interface, if we create a subclass of Birdv2 like FlyableBird and NonFlyableBird
 then make Parrot and Eagle extends to FlyableBird and Penguin extends to NonFlyableBird, the issue is what will we
 do if we want a new behaviour like swim?
 Then we have to create a new abstract class called SwimmableBirds and NonSwimmableBirds extending to Birdv2
 But what to do for a bird whichj can both fly and swim?? as class not extend 2 abstract classes
 So we have to combine the behaviours in one abstract class like SwimableFlyableBird, NonSwimableFlyableBird,
 SwimableNonFlyableBird and NonSwimableNonFlyableBird
 Therefore, for 2 behaviours there are 4 abstract classes, similarly for n behaviours, there will be 2^n abstract classes
*/
//each behaviour should be a separate interface instead of putting in an single interface or else it will violate ISP
interface Flyable{
    void fly();
}

interface Swimmable{
    void swim();
}

class Eaglev2 extends Birdv2 implements Flyable{

    @Override
    public void fly() {
        System.out.println("Eagle is flying");
    }

    @Override
    public void walk() {
        System.out.println("Eagle is walking");
    }
}

class Parrotv2 extends Birdv2 implements Flyable{

    @Override
    public void fly() {
        System.out.println("Parrot is flying");
    }

    @Override
    public void walk() {
        System.out.println("Parrot is walking");
    }
}

class Penguinv2 extends Birdv2 implements Swimmable{

    @Override
    public void walk() {
        System.out.println("Penguin is walking");
    }

    @Override
    public void swim() {
        System.out.println("Penguin is swimming");
    }
}