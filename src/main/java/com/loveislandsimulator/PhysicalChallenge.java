public class PhysicalChallenge implements ChallengeCommand {

    private Contestant islander;

    public PhysicalChallenge(Contestant islander) {
        this.islander = islander;
    }

    @Override
    public String getName() {
        return "Physical Challenge";
    }

    @Override
    public String getDescription() {
        return "Islanders face a physically demanding task that requires strength, agility, and endurance to compete to score points.";
    }

    @Override
    public void execute() {
        double challengePoints = (int) (Math.random() * 6) + 15;
        System.out.println(getName() + " for " + challengePoints + " points has begun for Islander " + islander.getName() + "!");
        System.out.print("Before the challenge...\t");
        islander.scoreStatus();
        double earnedPoints = islander.applyStrategy(challengePoints);
        islander.addPoints(earnedPoints);
        System.out.print("After the challenge...\t");
        islander.scoreStatus();
    }
    
}
