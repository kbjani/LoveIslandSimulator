public class DoubleFacedRole extends RoleDecorator {


    public DoubleFacedRole(Contestant islander) {
        super(islander);
    }

    
    @Override
    public double getScore() {
        return super.getScore() + 4;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Double-faced Role";
    }
}
