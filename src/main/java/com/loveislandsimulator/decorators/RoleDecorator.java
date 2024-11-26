package com.loveislandsimulator.decorators;

import com.loveislandsimulator.enums.Role;
import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.Islander;
import com.loveislandsimulator.strategies.IslanderBehaviorStrategy;

import java.util.ArrayList;
import java.util.List;

public abstract class RoleDecorator extends Islander {
    protected Islander islander;
    private final Role role;

    public RoleDecorator(Islander islander, Role role) {
        super(islander.getName());
        this.islander = islander;
        this.role = role;
    }

    /**
     * Gets all roles for the islander.
     *
     * @return The list of roles.
     */
    public List<Role> getRoles() {
        List<Role> roles = new ArrayList<>();
        if (islander instanceof RoleDecorator) {
            roles.addAll(islander.getRoles());
        }
        roles.add(this.role);
        return roles;
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
    public void addPoints(int points) {
        islander.addPoints(points);
    }

    @Override
    public IslanderBehaviorStrategy getBehaviorStrategy() {
        return islander.getBehaviorStrategy();
    }

    @Override
    public void setBehaviorStrategy(IslanderBehaviorStrategy strategy) {
        islander.setBehaviorStrategy(strategy);
    }

    @Override
    public String getName() {
        return islander.getName();
    }
}
