package com.loveislandsimulator.roles;

import com.loveislandsimulator.decorators.RoleDecorator;
import com.loveislandsimulator.enums.Role;
import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.Islander;

public class FlirtRole extends RoleDecorator {
    
    public FlirtRole(Contestant islander) {
        super(islander);
    }

    @Override
    public void addPoints(double points) {
        double wrappedPoints = points + 8;
        super.addPoints(wrappedPoints);
        System.out.println(this.wrappedIslander.getName() + " applied Flirt role for 8 extra points...");
    }

}


