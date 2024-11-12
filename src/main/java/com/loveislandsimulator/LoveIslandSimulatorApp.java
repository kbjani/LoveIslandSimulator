package com.loveislandsimulator;

import com.loveislandsimulator.challenges.PhysicalChallenge;
import com.loveislandsimulator.challenges.TriviaChallenge;
import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.Islander;
import com.loveislandsimulator.services.ScoreTrackerSingleton;
import com.loveislandsimulator.strategies.AggressiveStrategy;
import com.loveislandsimulator.strategies.PassiveStrategy;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoveIslandSimulatorApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
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

        FXMLLoader fxmlLoader = new FXMLLoader(LoveIslandSimulatorApp.class.getResource("home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Love Island Game Show Simulator");
        stage.setScene(scene);

        stage.setWidth(1024);
        stage.setHeight(768);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}