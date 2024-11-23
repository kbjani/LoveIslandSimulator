public class BalancedStrategy implements BehaviorStrategy {
    
    @Override
    public String getStrategyName() {
        return "Balanced";
    }

    @Override
    public double applyStrategy(double points) {
        double luck = Math.random();
        if (luck < 0.5) {
            points = points * 0.98;
        } else {
            points = points * 0.91;
        }
        return points;
    }
}
