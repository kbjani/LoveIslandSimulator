public class Islander implements Contestant {

    // FIELDS

    private String name;
    private double score;
    private BehaviorStrategy strategy;

    // CONSTRUCTORS

    public Islander(String name, BehaviorStrategy strategy) {
        this.name = name;
        this.score = 0;
        this.strategy = strategy;
    }

    // METHODS

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getScore() {
        return score * strategy.getStrategyScoreFactor();
    }

    @Override
    public String getDescription() {
        return name + " with " + strategy.getStrategyDescription();
    }

    @Override
    public void updatedScore(double updatedScore) {
        this.score = updatedScore;
        
    }
    
    @Override
    public void setStrategy(BehaviorStrategy strategy) {
        this.strategy = strategy;
    }

    public BehaviorStrategy getStrategy() {
        return strategy;
    }


}
