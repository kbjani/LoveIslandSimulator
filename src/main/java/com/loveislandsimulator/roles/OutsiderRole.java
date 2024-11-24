package com.loveislandsimulator.roles;

import com.loveislandsimulator.decorators.RoleDecorator;
import com.loveislandsimulator.enums.Role;
import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.Islander;

public class OutsiderRole extends RoleDecorator {

    public OutsiderRole(Islander islander) {
        super(islander, Role.OUTSIDER);
    }

    @Override
    public void participateInChallenge(ChallengeCommand challenge) {
        super.participateInChallenge(challenge);
        System.out.println(islander.getName() + ", " + Role.getRoleName(Role.LEADER));
    }
}
