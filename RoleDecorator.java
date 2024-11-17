// Love Island Simulation
// Main method to test program is in TestSimulation.java


public abstract class RoleDecorator implements Contestant {
    
    // FIELDS

    protected Contestant islander;

    // CONSTRUCTORS
    public RoleDecorator(Contestant islander) {
        this.islander = islander;
    }

    // METHODS

    @Override
    public String getName() {
        return islander.getName();
    }

    @Override
    public double getScore() {
        return islander.getScore();
    }

    @Override
    public String getDescription() {
        return islander.getDescription();
    }

    @Override
    public void updatedScore(double updatedScore) {
        islander.updatedScore(updatedScore);
    }

    @Override
    public void setStrategy(BehaviorStrategy strategy) {
        islander.setStrategy(strategy);
    }

}
