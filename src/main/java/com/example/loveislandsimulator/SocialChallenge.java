package com.example.loveislandsimulator;

public class SocialChallenge implements ChallengeCommand {
    @Override
    public void execute(Islander islander) {
        int score = (int) (Math.random() * 8 + 1);
        islander.addScore(score);
        System.out.println(islander.getName() + " completed Social Challenge and scored " + score + " points!");
    }
}
