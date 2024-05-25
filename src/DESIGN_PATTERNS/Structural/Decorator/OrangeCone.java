package DESIGN_PATTERNS.Structural.Decorator;

public class OrangeCone implements IceCreamCone{
    @Override
    public String getDescription() {
        return "Orange Cone";
    }

    @Override
    public int getCost() {
        return 15;
    }
}
