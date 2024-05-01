package SOLID;

public class Birdv0 {
    int weight;
    String color;
    String type;
    String size;
    String beakType;

    //violating SRP(because instead of just flying logic, it is also determining type of Bird)
    //violating OCP(for addition of new bird type, we need to modify the fly() method)
    public void fly(){
        if(type.equals("eagle")){
            System.out.println("Eagle is flying");
        }
        else if(type.equals("parrot")){
            System.out.println("Parrot is flying");
        }
    }
}
