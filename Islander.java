

public class Islander implements Contestant {
    
    private String name;
    private double score;
    private BehaviorStrategy strategy;
    
    public Islander(String name, BehaviorStrategy strategy) {
        this.name = name;
        this.score = 0.0;
        this.strategy = strategy;
    }


    @Override
    public String getName() {
        return name;
    }
    @Override
    public double getScore() {
        return score;
    }
    @Override
    public void addPoints(double points) {
        this.score += points;
    }
    @Override
    public BehaviorStrategy getStrategy() {
        return strategy;
    }
    @Override
    public void setStrategy(BehaviorStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public double applyStrategy(double points) {
        double earnedPoints = this.strategy.applyStrategy(points);
        System.out.println(this.name + " applied " + this.strategy.getStrategyName() + " strategy and earned " + earnedPoints + " points...");
        return earnedPoints;
    } 

    @Override
    public void scoreStatus() {
        System.out.println("Islander " + this.name + " -- Current Score: " + getScore());
    }

    

    
}
