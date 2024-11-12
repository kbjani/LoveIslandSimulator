package com.loveislandsimulator.services;

import com.loveislandsimulator.models.Islander;

import java.util.HashMap;
import java.util.Map;

public class ScoreTrackerSingleton {
    private static ScoreTrackerSingleton instance;
    private Map<String, Integer> scoreData;

    private ScoreTrackerSingleton() {
        scoreData = new HashMap<>();
    }

    public static ScoreTrackerSingleton getInstance() {
        if (instance == null) {
            instance = new ScoreTrackerSingleton();
        }
        return instance;
    }

    public void updateScore(Islander islander) {
        scoreData.put(islander.getName(), islander.getScore());
    }

    public Map<String, Integer> getScoreData() {
        return scoreData;
    }
}
