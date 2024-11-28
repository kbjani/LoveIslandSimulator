package com.loveislandsimulator.controllers;

import com.loveislandsimulator.LoveIslandSimulatorApp;
import com.loveislandsimulator.controllers.components.IslanderController;
import com.loveislandsimulator.models.AppController;
import com.loveislandsimulator.models.GameData;
import com.loveislandsimulator.models.Islander;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;

public class ChallengeResultsController implements AppController {
    private LoveIslandSimulatorApp app;

    @FXML
    private VBox islandersContainer;

    @FXML
    private Text titleText;

    @FXML
    private Button endGameButton;

    public void setApp(LoveIslandSimulatorApp app) {
        this.app = app;
    }

    @FXML
    public void initialize() {
        islandersContainer.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.windowProperty().addListener((winObservable, oldWindow, newWindow) -> {
                    if (newWindow != null) {
                        populateIslanders(); // run method when scene is set (on load)

                        // Initialize page title with game number
                        int currentGame = GameData.getInstance().getChallengeCount();
                        titleText.setText("Love Island Challenge #" + currentGame);

                        // End button should only be visible after 3 challenges are completed
                        endGameButton.setVisible(GameData.getInstance().getChallengeCount() >= 3);
                    }
                });
            }
        });
    }

    public void onNextChallengeButtonClick() {
        GameData.getInstance().incrementCompleted();
        app.getSceneController().switchTo("assign-challenge");
    }

    public void onEndGameButtonClick(){
        app.getSceneController().switchTo("game-result");
    }

    /**
     * Populates the islanders in the scoreboard.
     */
    private void populateIslanders() {
        islandersContainer.getChildren().clear(); // avoid duplicating islanders on consecutive loads

        List<Islander> islanders = GameData.getInstance().getIslanders();

        // Order islanders by score in descending order
        islanders = islanders.stream()
                .sorted((i1, i2) -> Integer.compare(i2.getScore(), i1.getScore()))
                .toList();

        if (!islanders.isEmpty()) {
            try {
                for (Islander islander : islanders) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/loveislandsimulator/components/small-islander-component.fxml"));
                    GridPane islanderComponent = loader.load();

                    IslanderController controller = loader.getController();

                    controller.setAvatar(islander.getAvatar());
                    controller.setName(islander.getName());
                    controller.setStrategyField(islander.getBehaviorStrategy());
                    controller.setRoles(islander.getRoles());
                    controller.setScore(islander.getScore());

                    islandersContainer.getChildren().add(islanderComponent);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

