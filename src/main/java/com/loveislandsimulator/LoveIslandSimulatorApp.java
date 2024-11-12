package com.loveislandsimulator;

import com.loveislandsimulator.challenges.PhysicalChallenge;
import com.loveislandsimulator.challenges.TriviaChallenge;
import com.loveislandsimulator.controllers.HelpController;
import com.loveislandsimulator.controllers.HomeController;
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
    private Stage stage;
    private Scene homeScene, gameScene, helpScene;

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
        this.stage = primaryStage;
        stage.setTitle("Love Island Game Show Simulator");

        // Load each FXML into a Scene
        homeScene = loadScene("home-view.fxml");
        //gameScene = loadScene("islander-setup-view.fxml");
        helpScene = loadScene("help-view.fxml");

        stage.setScene(homeScene);
        stage.setWidth(1024);
        stage.setHeight(768);
        stage.show();
    }

    public void setScene(Scene scene) {
        stage.setScene(scene);
    }

    public void showGameScene() {
        setScene(gameScene);
    }

    public void showHelpScene() {
        setScene(helpScene);
    }

    public void showHomeScene() {
        setScene(homeScene);
    }

    public static void main(String[] args) {
        launch();
    }

    // Utility to load FXML as Scene
    private Scene loadScene(String fxmlFile) throws IOException {
        FXMLLoader loader = new FXMLLoader(LoveIslandSimulatorApp.class.getResource(fxmlFile));
        Scene scene = new Scene(loader.load(), 1024, 768);

        // Set the app instance in the controller if it exists
        Object controller = loader.getController();
        if (controller instanceof HomeController) {
            ((HomeController) controller).setApp(this);
        }

        if (controller instanceof HelpController) {
            ((HelpController) controller).setApp(this);
        }

        return scene;
    }

}