// Love Island Simulation
// Main method to test program is in TestSimulation.java


public class FlirtRole extends RoleDecorator {

    // CONSTRUCTOR

    public FlirtRole(Contestant islander) {
        super(islander);
    }

    // METHODS
    
    @Override
    public double getScore() {
        return super.getScore() + 7;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Flirt Role";
    }
}