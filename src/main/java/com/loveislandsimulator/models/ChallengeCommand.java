package com.loveislandsimulator.models;

/**
 * Interface of a challenge that islander's complete.
 * Design Pattern: Command Pattern
 */
public interface ChallengeCommand {
    /**
     * Executes the challenge for the specified islander.
     *
     * @param islander The islander to execute the challenge for.
     */
    void execute(Islander islander);

    /**
     * Gets the description of the challenge.
     * @return The challenge description.
     */
    String getDescription();

    /**
     * Gets the name of the challenge.
     * @return The challenge's name.
     */
    String getName();
}

