package DESIGN_PATTERNS.Behavioural.Strategy;

public class GoogleMap {
    public void findPath(String from, String to, Mode mode){
        PathCalculatorStrategy pathCalculatorStrategy = PathCalculatorStrategyFactory.getStrategy(mode);
        pathCalculatorStrategy.findPath(from, to);
    }
}
