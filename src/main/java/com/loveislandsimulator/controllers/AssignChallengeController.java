package com.loveislandsimulator.controllers;

import com.loveislandsimulator.LoveIslandSimulatorApp;
import com.loveislandsimulator.controllers.components.IslanderController;
import com.loveislandsimulator.models.AppController;
import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.GameData;
import com.loveislandsimulator.models.Islander;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class AssignChallengeController implements AppController {
    private LoveIslandSimulatorApp app;

    //#region FXML Properties
    @FXML
    private VBox islandersContainer;

    @FXML
    private ComboBox<String> challengeComboBox;

    @FXML
    private Text selectedChallengeName;

    @FXML
    private Text selectedChallengeDescription;
    //#endregion

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
                    }
                });
            }
        });

        // Initialize strategies for combobox
        for (ChallengeCommand command : GameData.getInstance().getChallenges()) {
            challengeComboBox.getItems().add(command.getName());
        }

        displaySelectedChallenge();
    }


    public void onRandomButtonClick() {
        Random random = new Random();
        List<ChallengeCommand> challenges = GameData.getInstance().getChallenges();
        challengeComboBox.setValue(challenges.get(random.nextInt(challenges.size())).getName());
    }

    public void onSimulateButtonClick() {
        // TODO: Validate fields and catch errors
        // TODO: Simulate the challenge for each islander and calculate scores.
        app.getSceneController().switchTo("challenge-results");
    }

    /**
     * Validates the fields.
     *
     */
    private boolean validateFields() {
        //TODO: Validate that a challenge is selected.
        return true;
    }

    /**
     * Populates the islanders in the scoreboard.
     */
    private void populateIslanders() {
        List<Islander> islanders = GameData.getInstance().getIslanders();

        //TODO: Order islanders by score (high -> low) for scoreboard.

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

                    islandersContainer.getChildren().add(islanderComponent);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void displaySelectedChallenge() {
        // Update challenge details when a new challenge is selected from the ComboBox
        challengeComboBox.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                // Find the selected challenge
                ChallengeCommand selectedChallenge = GameData.getInstance().getChallenges().stream()
                        .filter(c -> c.getName().equals(newVal))
                        .findFirst()
                        .orElse(null);

                if (selectedChallenge != null) {
                    selectedChallengeName.setText(selectedChallenge.getName());
                    selectedChallengeDescription.setText(selectedChallenge.getDescription());
                }
            }
        });
    }
}
