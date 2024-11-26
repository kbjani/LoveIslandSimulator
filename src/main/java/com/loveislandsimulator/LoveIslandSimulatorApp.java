package com.loveislandsimulator;

import com.loveislandsimulator.challenges.PhysicalChallenge;
import com.loveislandsimulator.challenges.SocialChallenge;
import com.loveislandsimulator.challenges.TriviaChallenge;
import com.loveislandsimulator.controllers.base.SceneController;
import com.loveislandsimulator.models.GameData;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class LoveIslandSimulatorApp extends Application {
    private SceneController sceneController;

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Initialize Data
        GameData gameData = GameData.getInstance();

        // Add predefined challenges
        gameData.addChallenge(new PhysicalChallenge());
        gameData.addChallenge(new SocialChallenge());
        gameData.addChallenge(new TriviaChallenge());

        // UI Startup
        this.sceneController = new SceneController(primaryStage);

        // Initialize scenes
        sceneController.addScene("home", "home-view.fxml", this);
        sceneController.addScene("help", "help-view.fxml", this);
        sceneController.addScene("islander-setup", "islander-setup-view.fxml", this);
        sceneController.addScene("islanders-view", "islanders-view.fxml", this);
        sceneController.addScene("assign-challenge", "assign-challenge.fxml", this);
        sceneController.addScene("challenge-results", "challenge-results.fxml", this);
        sceneController.addScene("game-result", "game-result.fxml", this);
        sceneController.addScene("new-islander", "components/new-islander-component.fxml", this);
        sceneController.addScene("islander", "components/islander-component.fxml", this);

        sceneController.showInitialScene("home"); // Show initial scene
    }

    public SceneController getSceneController() {
        return sceneController;
    }

    public static void main(String[] args) {
        launch();
    }
}