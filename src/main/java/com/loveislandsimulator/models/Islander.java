package com.loveislandsimulator.models;

import com.loveislandsimulator.enums.Role;
import com.loveislandsimulator.strategies.IslanderBehaviorStrategy;
import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.ArrayList;

public class Islander implements Serializable {
    private final String name;
    private int score;
    private IslanderBehaviorStrategy behaviorStrategy;
    private Image avatar;
    private ArrayList<Role> roles;

    //#region Constructors
    public Islander(String name) {
        this.name = name;
        this.score = 0;
    }

    public Islander(String name, Image avatar) {
        this.name = name;
        this.avatar = avatar;
        this.score = 0;
        roles = new ArrayList<Role>();
    }
    //#endregion

    /**
     * Adds points to the islander's score.
     * @param points The points to add.
     */
    public void addScore(int points) {
        this.score += points;
    }

    /**
     * Performs the challenge based on the islander's behavior strategy.
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

    public IslanderBehaviorStrategy getBehaviorStrategy() {
        return behaviorStrategy;
    }

    public void setBehaviorStrategy(IslanderBehaviorStrategy strategy) {
        this.behaviorStrategy = strategy;
    }

    public void addRole(Role role){
        this.roles.add(role);
    }

    public ArrayList<Role> getRoles(){
        return this.roles;
    }
    //#endregion
}
