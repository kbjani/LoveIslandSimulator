package com.loveislandsimulator.decorators;

import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.Islander;
import com.loveislandsimulator.strategies.IslanderBehaviorStrategy;

public abstract class RoleDecorator extends Islander {

    protected Islander islander;

    public RoleDecorator(Islander islander) {
        super(islander.getName());
        this.islander = islander;
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
