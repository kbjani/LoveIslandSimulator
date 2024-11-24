package com.loveislandsimulator.decorators;

import com.loveislandsimulator.enums.Role;
import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.Islander;
import com.loveislandsimulator.strategies.IslanderBehaviorStrategy;

import java.util.ArrayList;

public abstract class RoleDecorator extends Islander {
    protected Islander islander;
    private final ArrayList<Role> roles = new ArrayList<>();

    public RoleDecorator(Islander islander, Role role) {
        super(islander.getName());
        this.islander = islander;
        this.roles.add(role);
        this.setBehaviorStrategy(islander.getBehaviorStrategy()); // Propagate strategy
    }

    public ArrayList<Role> getRoles() {
        return this.roles;
    }

    @Override
    public void participateInChallenge(ChallengeCommand challenge) {
        islander.participateInChallenge(challenge);
    }

    @Override
    public int getScore() {
        return islander.getScore();
    }

    @Override
    public void addScore(int points) {
        islander.addScore(points);
    }

    @Override
    public void setBehaviorStrategy(IslanderBehaviorStrategy strategy) {
        islander.setBehaviorStrategy(strategy);
    }
}
