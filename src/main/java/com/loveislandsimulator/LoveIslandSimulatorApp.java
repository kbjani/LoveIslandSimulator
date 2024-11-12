package com.loveislandsimulator;

import com.loveislandsimulator.challenges.PhysicalChallenge;
import com.loveislandsimulator.challenges.TriviaChallenge;
import com.loveislandsimulator.controllers.SceneController;
import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.Islander;
import com.loveislandsimulator.services.ScoreTrackerSingleton;
import com.loveislandsimulator.strategies.AggressiveStrategy;
import com.loveislandsimulator.strategies.PassiveStrategy;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class LoveIslandSimulatorApp extends Application {
    private SceneController sceneController;

    @Override
    public void start(Stage primaryStage) throws IOException {
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

        // UI Startup
        this.sceneController = new SceneController(primaryStage);

        // Initialize scenes
        sceneController.addScene("home", "home-view.fxml", this);
        sceneController.addScene("help", "help-view.fxml", this);

        /* TODO: Implement additional views
        sceneController.addScene("assign-challenge", "assign-challenge-view.fxml", this);
        sceneController.addScene("challenge-results", "challenge-results-view.fxml", this);
        sceneController.addScene("error", "error-view.fxml", this);
        sceneController.addScene("game-result", "game-result-view.fxml", this);
        sceneController.addScene("islander-info", "islander-info-view.fxml", this);
        sceneController.addScene("islander-info", "islander-info-view.fxml", this);
        sceneController.addScene("islander-setup", "islander-setup-view.fxml", this);
        sceneController.addScene("islander-view", "islander-view.fxml", this);
         */

        // Show initial scene
        sceneController.showInitialScene("home");
    }

    public SceneController getSceneController() {
        return sceneController;
    }

    public static void main(String[] args) {
        launch();
    }
}