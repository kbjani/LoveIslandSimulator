package com.loveislandsimulator.strategies;

import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.Islander;

import java.util.Arrays;
import java.util.List;

/**
 * Interface for defining the behavior strategies of Islanders.
 */
public interface IslanderBehaviorStrategy {
    /**
     * Executes the behavior strategy for an islander during a challenge.
     *
     * @param islander The islander.
     * @param challenge The challenge the islander is participating in.
     */
    void perform(Islander islander, ChallengeCommand challenge);

    /**
     * Returns the name of the strategy in a user-friendly format.
     *
     * @return The name of the strategy.
     */
    String getStrategyName();

    /**
     * Retrieves all available strategies.
     *
     * @return A list of all available IslanderBehaviorStrategy.
     */
    static List<IslanderBehaviorStrategy> getAllStrategies() {
        return Arrays.asList(
                new AggressiveStrategy(),
                new BalancedStrategy(),
                new PassiveStrategy()
        );
    }

    /**
     * Converts a string to a corresponding IslanderBehaviorStrategy instance.
     *
     * @param name The name of the strategy (case-insensitive).
     * @return The IslanderBehaviorStrategy instance corresponding to the name.
     * @throws IllegalArgumentException If no matching strategy is found.
     */
    static IslanderBehaviorStrategy fromString(String name) {
        return switch (name.toLowerCase()) {
            case "aggressive" -> new AggressiveStrategy();
            case "balanced" -> new BalancedStrategy();
            case "passive" -> new PassiveStrategy();
            default -> null;
        };
    }

}


