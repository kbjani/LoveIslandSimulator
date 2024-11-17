package com.loveislandsimulator.roles;

import com.loveislandsimulator.decorators.RoleDecorator;
import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.Islander;

public class FlirtRole extends RoleDecorator {

    public FlirtRole(Islander islander) {
        super(islander);
    }

    @Override
    public void participateInChallenge(ChallengeCommand challenge) {
        super.participateInChallenge(challenge);
        System.out.println(islander.getName() + ", Flirt Role");
    }
}


