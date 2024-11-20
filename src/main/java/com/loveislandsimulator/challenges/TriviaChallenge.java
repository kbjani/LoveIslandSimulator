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

    @Override
    public String getDescription(){
        return "Islanders are quizzed on a variety of topics to demonstrate their knowledge and quick thinking, competing for points.";
    }

    @Override
    public String getName(){
        return "Trivia Challenge";
    }
}
