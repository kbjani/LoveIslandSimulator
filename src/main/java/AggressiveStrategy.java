public class AggressiveStrategy implements BehaviorStrategy {
    
    @Override
    public String getStrategyName() {
        return "Aggressive";
    }

    @Override
    public double applyStrategy(double points) {
        double luck = Math.random();
        if (luck < 0.5) {
            points = points * 0.95;
        } else {
            points = points * 0.87;
        }
        return points;
    }
}
