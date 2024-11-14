// Love Island Simulation
// Main method to test program is in TestSimulation.java

public class DoubleFacedRole extends RoleDecorator {

    // CONSTRUCTORS

    public DoubleFacedRole(Contestant islander) {
        super(islander);
    }

    // METHODS
    
    @Override
    public double getScore() {
        return super.getScore() + 4;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Double-faced Role";
    }
}