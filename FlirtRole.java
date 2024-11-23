public class FlirtRole extends RoleDecorator {
    
    public FlirtRole(Contestant islander) {
        super(islander);
    }

    @Override
    public void addPoints(double points) {
        double wrappedPoints = points + 8;
        super.addPoints(wrappedPoints);
        System.out.println(this.wrappedIslander.getName() + " applied Flirt role for 8 extra points...");
    }

}
