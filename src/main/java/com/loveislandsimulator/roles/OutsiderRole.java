public class OutsiderRole extends RoleDecorator {


    public OutsiderRole(Contestant islander) {
        super(islander);
    }

    
    @Override
    public double getScore() {
        return super.getScore() - 10;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Outsider Role";
    }
}
