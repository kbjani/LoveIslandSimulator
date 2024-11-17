// Love Island Simulation
// Main method to test program is in TestSimulation.java


public class OutsiderRole extends RoleDecorator {

    // CONSTRUCTOR

    public OutsiderRole(Contestant islander) {
        super(islander);
    }

    // METHODS
    
    @Override
    public double getScore() {
        return super.getScore() - 10;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Outsider Role";
    }
}