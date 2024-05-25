package DESIGN_PATTERNS.Behavioural.Strategy;

public class PathCalculatorStrategyFactory {
    public static PathCalculatorStrategy getStrategy(Mode mode){
        switch(mode){
            case CAR: return new CarPathCalculatorStrategy();
            case BIKE: return new BikePathCalculatorStrategy();
            case WALK: return new WalkPathCalculatorStrategy();
            default: return new CarPathCalculatorStrategy();
        }
    }
}
