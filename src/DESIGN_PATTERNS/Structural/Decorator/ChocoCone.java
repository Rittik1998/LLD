package DESIGN_PATTERNS.Structural.Decorator;

public class ChocoCone implements IceCreamCone{
    @Override
    public String getDescription() {
        return "Choco Cone";
    }

    @Override
    public int getCost() {
        return 20;
    }
}
