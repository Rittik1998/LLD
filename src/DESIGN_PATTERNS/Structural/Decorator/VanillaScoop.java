package DESIGN_PATTERNS.Structural.Decorator;

public class VanillaScoop implements AddOns{
    IceCreamCone cone;
    VanillaScoop(IceCreamCone cone){
        this.cone = cone;
    }
    @Override
    public String getDescription() {
        return cone.getDescription()+", Vanilla Scoop";
    }

    @Override
    public int getCost() {
        return cone.getCost() + 10;
    }
}
