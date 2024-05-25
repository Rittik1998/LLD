package DESIGN_PATTERNS.Structural.Decorator;

public class Client {
    public static void main(String[] args) {
        IceCreamCone iceCream1 = new ChocoChips(new ChocoSyrup(new VanillaScoop(new ChocoCone())));
        System.out.println(iceCream1.getDescription());
        System.out.println("The price of the ice cream ordered is: " + iceCream1.getCost());

        IceCreamCone iceCream2 = new ChocoChips(new ChocoSyrup(new VanillaScoop(new VanillaCone())));
        System.out.println(iceCream2.getDescription());
        System.out.println("The price of the ice cream ordered is: " + iceCream2.getCost());
    }
}
