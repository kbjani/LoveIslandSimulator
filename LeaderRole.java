// Love Island Simulation
// Main method to test program is in TestSimulation.java


public class LeaderRole extends RoleDecorator {

    // CONSTRUCTOR

    public LeaderRole(Contestant islander) {
        super(islander);
    }

    // METHODS
    
    @Override
    public double getScore() {
        return super.getScore() + 15;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Leader Role";
    }
}