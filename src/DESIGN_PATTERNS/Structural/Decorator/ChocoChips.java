package DESIGN_PATTERNS.Structural.Decorator;

public class ChocoChips implements AddOns{
    IceCreamCone cone;
    ChocoChips(IceCreamCone cone){
        this.cone = cone;
    }

    @Override
    public String getDescription() {
        return cone.getDescription() + ", Choco chips";
    }

    @Override
    public int getCost() {
        return cone.getCost() + 5;
    }
}
