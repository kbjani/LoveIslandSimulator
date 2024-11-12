package com.loveislandsimulator.strategies;

import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.Islander;

public class AggressiveStrategy implements IslanderBehaviorStrategy {
    @Override
    public void perform(Islander islander, ChallengeCommand challenge) {
        System.out.println(islander.getName() + " approaches aggressively.");
        challenge.execute(islander);
    }
}
