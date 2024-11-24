public class SocialChallenge implements ChallengeCommand {

    private Contestant islander;

    public SocialChallenge(Contestant islander) {
        this.islander = islander;
    }

    @Override
    public String getName() {
        return "Social Challenge";
    }

    @Override
    public String getDescription() {
        return "Islanders engage in activities that test their social skills, including persuasion, alliance building, and emotional intelligence, to score points.";
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
