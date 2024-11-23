public class LeaderRole extends RoleDecorator {
    
    public LeaderRole(Contestant islander) {
        super(islander);
    }

    @Override
    public void addPoints(double points) {
        double wrappedPoints = points + 10;
        super.addPoints(wrappedPoints);
        System.out.println(this.wrappedIslander.getName() + " applied Leader role for 10 extra points...");
    }

}
