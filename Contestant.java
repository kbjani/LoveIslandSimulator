// Love Island Simulation
// Main method to test program is in TestSimulation.java

public interface Contestant {
    
    // METHODS
    
    public String getName();
    public double getScore();
    public String getDescription();
    public void updatedScore(double updatedScore);
    public void setStrategy(BehaviorStrategy strategy);

}
