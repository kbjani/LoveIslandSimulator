public class TriviaChallenge implements ChallengeCommand {

    private Contestant islander;

    public TriviaChallenge(Contestant islander) {
        this.islander = islander;
    }

    @Override
    public String getName() {
        return "Trivia Challenge";
    }

    @Override
    public String getDescription() {
        return "Islanders are quizzed on a variety of topics to demonstrate their knowledge and quick thinking, competing for points.";
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