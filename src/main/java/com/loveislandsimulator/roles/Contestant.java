public interface Contestant {
        
    public String getName();
    public double getScore();
    public String getDescription();
    public void updatedScore(double updatedScore);
    public void setStrategy(BehaviorStrategy strategy);

}
