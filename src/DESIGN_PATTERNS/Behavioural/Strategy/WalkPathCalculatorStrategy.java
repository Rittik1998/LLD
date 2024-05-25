package DESIGN_PATTERNS.Behavioural.Strategy;

public class WalkPathCalculatorStrategy implements PathCalculatorStrategy{
    @Override
    public void findPath(String from, String to) {
        System.out.println("Calculating Path for Walk from " + from + " to " + to);
    }
}
