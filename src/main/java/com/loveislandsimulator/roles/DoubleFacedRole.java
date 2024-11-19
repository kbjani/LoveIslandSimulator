package com.loveislandsimulator.roles;

import com.loveislandsimulator.decorators.RoleDecorator;
import com.loveislandsimulator.enums.Role;
import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.Islander;

public class DoubleFacedRole extends RoleDecorator {

    public DoubleFacedRole(Islander islander) {
        super(islander, Role.DOUBLE_FACED);
    }

    @Override
    public void participateInChallenge(ChallengeCommand challenge) {
        super.participateInChallenge(challenge);
        System.out.println(islander.getName() + ", " + Role.getRoleName(Role.DOUBLE_FACED));
    }
}
