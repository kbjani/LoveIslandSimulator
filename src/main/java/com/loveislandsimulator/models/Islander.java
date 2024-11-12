package com.loveislandsimulator.models;

import com.loveislandsimulator.strategies.IslanderBehaviorStrategy;

import java.io.Serializable;

public class Islander implements Serializable {
    private String name;
    private int score;
    private IslanderBehaviorStrategy behaviorStrategy;

    public Islander(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setBehaviorStrategy(IslanderBehaviorStrategy strategy) {
        this.behaviorStrategy = strategy;
    }

    public void addScore(int points) {
        this.score += points;
    }

    public void participateInChallenge(ChallengeCommand challenge) {
        behaviorStrategy.perform(this, challenge);
    }
}
