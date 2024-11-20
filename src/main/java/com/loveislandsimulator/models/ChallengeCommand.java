package com.loveislandsimulator.models;

public interface ChallengeCommand {
    void execute(Islander islander);
    String getDescription();
    String getName();
}

