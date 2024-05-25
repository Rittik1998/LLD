package DESIGN_PATTERNS.Behavioural.Strategy;

public class BikePathCalculatorStrategy implements PathCalculatorStrategy{
    @Override
    public void findPath(String from, String to) {
        System.out.println("Calculating Path for Bike from " + from + " to " + to);
    }
}
