public class FlirtRole extends RoleDecorator {


    public FlirtRole(Contestant islander) {
        super(islander);
    }

    
    @Override
    public double getScore() {
        return super.getScore() + 7;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Flirt Role";
    }
}
