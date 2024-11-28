package com.loveislandsimulator.models;

import com.loveislandsimulator.enums.Role;
import com.loveislandsimulator.strategies.IslanderBehaviorStrategy;
import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/**
 * Represents an Islander that is a contestant in the Love Island game.
 */
public class Islander implements Serializable {
    private final String name;
    private int score;
    private IslanderBehaviorStrategy behaviorStrategy;
    private Image avatar;

    public Islander(String name) {
        this.name = name;
        this.score = 0;
    }

    /**
     * Default getRoles method to return an empty list for an islander that is not decorated.
     *
     * @return An empty list.
     */
    public List<Role> getRoles() {
        return new ArrayList<>();
    }

    /**
     * Adds points to the islander's score.
     * @param points The points to add.
     */
    public void addPoints(int points) {
        this.score += points;
    }

    /**
     * Performs the challenge based on the islander's behavior strategy.
     * Increments the count of completed challenges.
     * @param challenge The ChallengeCommand.
     */
    public void participateInChallenge(ChallengeCommand challenge) {
        behaviorStrategy.perform(this, challenge);
    }

    //#region Getters & Setters
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public Image getAvatar() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }

    public IslanderBehaviorStrategy getBehaviorStrategy() {
        return behaviorStrategy;
    }

    public void setBehaviorStrategy(IslanderBehaviorStrategy strategy) {
        this.behaviorStrategy = strategy;
    }
    //#endregion
}
