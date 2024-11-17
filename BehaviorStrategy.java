// Love Island Simulation
// Main method to test program is in TestSimulation.java

public interface BehaviorStrategy {

    // METHODS (to be overridden by concrete strategies that have a factor that influences score)
    
    public double getStrategyScoreFactor();
    public String getStrategyDescription();
    public void applyBehavior(Islander islander);

    
}
