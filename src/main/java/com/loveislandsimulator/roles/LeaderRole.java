public class LeaderRole extends RoleDecorator {


    public LeaderRole(Contestant islander) {
        super(islander);
    }

    
    @Override
    public double getScore() {
        return super.getScore() + 15;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Leader Role";
    }
}
