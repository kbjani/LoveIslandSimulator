package com.loveislandsimulator.strategies;

import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.Islander;

public interface IslanderBehaviorStrategy {
    void perform(Islander islander, ChallengeCommand challenge);
}


