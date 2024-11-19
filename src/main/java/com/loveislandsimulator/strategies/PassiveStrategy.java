package com.loveislandsimulator.strategies;

import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.Islander;

/**
 * Implementation of a passive behavior strategy for an Islander.
 */
public class PassiveStrategy implements IslanderBehaviorStrategy {
    /**
     * Returns the name of this strategy.
     *
     * @return The name of the strategy, which is "Passive".
     */
    @Override
    public String getStrategyName() {
        return "Passive";
    }

    /**
     * Executes the passive behavior strategy for an islander during a challenge.
     *
     * @param islander The islander.
     * @param challenge The challenge the islander is participating in.
     */
    @Override
    public void perform(Islander islander, ChallengeCommand challenge) {
        System.out.println(islander.getName() + " approaches passively.");
        challenge.execute(islander);
    }
}
