// Love Island Simulation
// Main method to test program is in TestSimulation.java

public class AggressiveStrategy implements BehaviorStrategy {
    
    // METHODS

    @Override
    public double getStrategyScoreFactor() {
        return .96;
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
