package com.loveislandsimulator.challenges;

import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.Islander;

public class TriviaChallenge implements ChallengeCommand {
    @Override
    public void execute(Islander islander) {
        int score = (int) (Math.random() * 10 + 1);
        islander.addScore(score);
        System.out.println(islander.getName() + " completed Trivia Challenge and scored " + score + " points!");
    }
}
