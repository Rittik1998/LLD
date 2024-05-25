package DESIGN_PATTERNS.Structural.Decorator;

public class VanillaCone implements IceCreamCone{
    @Override
    public String getDescription() {
        return "Vanilla Cone";
    }

    @Override
    public int getCost() {
        return 10;
    }
}
