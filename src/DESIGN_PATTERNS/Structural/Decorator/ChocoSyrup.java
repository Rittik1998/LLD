package DESIGN_PATTERNS.Structural.Decorator;

public class ChocoSyrup implements AddOns{
    IceCreamCone cone;
    ChocoSyrup(IceCreamCone cone){
        this.cone = cone;
    }
    @Override
    public String getDescription() {
        return cone.getDescription() + ", choco syrup";
    }

    @Override
    public int getCost() {
        return cone.getCost()+5;
    }
}
