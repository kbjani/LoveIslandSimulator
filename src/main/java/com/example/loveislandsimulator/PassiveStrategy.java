package com.example.loveislandsimulator;

public class PassiveStrategy implements IslanderBehaviorStrategy {
    @Override
    public void perform(Islander islander, ChallengeCommand challenge) {
        System.out.println(islander.getName() + " approaches passively.");
        challenge.execute(islander);
    }
}
