// Love Island Simulation
// Main method to test program is in TestSimulation.java

public class SafeStrategy implements BehaviorStrategy {
    
    // METHODS
    
    @Override
    public double getStrategyScoreFactor() {
        return 0.89;
    }
    @Override
    public String getStrategyDescription() {
        return "Safe Strategy";
    }
    @Override
    public void applyBehavior(Islander islander) {
        // fill in later
    }
}
