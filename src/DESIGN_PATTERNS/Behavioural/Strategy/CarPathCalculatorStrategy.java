package DESIGN_PATTERNS.Behavioural.Strategy;

public class CarPathCalculatorStrategy implements PathCalculatorStrategy{
    @Override
    public void findPath(String from, String to) {
        System.out.println("Calculating Path for Car from " + from + " to " + to);
    }
}
