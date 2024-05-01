package SOLID;

/*violates LSP, because bird like Penguin can't fly but still Penguin class has to implements the fly() method
  dummy method body or throws an Exception*/

public abstract class Birdv1 {
    private int weight;
    private String color;
    private String size;
    private String beakType;

    public abstract void fly();
}

class Eagle extends Birdv1{

    @Override
    public void fly() {
        System.out.println("Eagle is flying");
    }
}

class Parrot extends Birdv1{

    @Override
    public void fly() {
        System.out.println("Parrot is flying");
    }
}
