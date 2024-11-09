package com.example.loveislandsimulator;

public class AggressiveStrategy implements IslanderBehaviorStrategy {
    @Override
    public void perform(Islander islander, ChallengeCommand challenge) {
        System.out.println(islander.getName() + " approaches aggressively.");
        challenge.execute(islander);
    }
}
