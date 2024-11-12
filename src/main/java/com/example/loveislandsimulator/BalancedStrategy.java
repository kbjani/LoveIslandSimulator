package com.example.loveislandsimulator;

public class BalancedStrategy implements IslanderBehaviorStrategy {
    @Override
    public void perform(Islander islander, ChallengeCommand challenge) {
        System.out.println(islander.getName() + " approaches with balance.");
        challenge.execute(islander);
    }
}
