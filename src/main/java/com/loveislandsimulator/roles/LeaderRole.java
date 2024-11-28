package com.loveislandsimulator.roles;

import com.loveislandsimulator.decorators.RoleDecorator;
import com.loveislandsimulator.enums.Role;
import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.Islander;

public class LeaderRole extends RoleDecorator {
    
    public LeaderRole(Contestant islander) {
        super(islander);
    }

    @Override
    public void addPoints(double points) {
        double wrappedPoints = points + 10;
        super.addPoints(wrappedPoints);
        System.out.println(this.wrappedIslander.getName() + " applied Leader role for 10 extra points...");
    }

}
