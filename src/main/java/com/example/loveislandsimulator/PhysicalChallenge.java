package com.example.loveislandsimulator;

public class PhysicalChallenge implements ChallengeCommand {
    @Override
    public void execute(Islander islander) {
        int score = (int) (Math.random() * 15 + 1);
        islander.addScore(score);
        System.out.println(islander.getName() + " completed Physical Challenge and scored " + score + " points!");
    }
}
