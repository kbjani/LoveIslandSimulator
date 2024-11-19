package com.loveislandsimulator.roles;

import com.loveislandsimulator.decorators.RoleDecorator;
import com.loveislandsimulator.enums.Role;
import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.Islander;

public class LeaderRole extends RoleDecorator {

    public LeaderRole(Islander islander) {
        super(islander, Role.LEADER);
    }

    @Override
    public void participateInChallenge(ChallengeCommand challenge) {
        super.participateInChallenge(challenge);
        System.out.println(islander.getName() + ", " + Role.getRoleName(Role.LEADER));
    }
}
