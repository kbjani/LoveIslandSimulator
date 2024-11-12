package com.example.loveislandsimulator;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        // UI setup with JavaFX for challenge initiation and score viewing

        Islander john = new Islander("John");
        Islander emma = new Islander("Emma");

        john.setBehaviorStrategy(new AggressiveStrategy());
        emma.setBehaviorStrategy(new PassiveStrategy());

        ChallengeCommand trivia = new TriviaChallenge();
        ChallengeCommand physical = new PhysicalChallenge();

        john.participateInChallenge(trivia);
        emma.participateInChallenge(physical);

        ScoreTrackerSingleton tracker = ScoreTrackerSingleton.getInstance();
        tracker.updateScore(john);
        tracker.updateScore(emma);

        System.out.println("Current Scores: " + tracker.getScoreData());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
