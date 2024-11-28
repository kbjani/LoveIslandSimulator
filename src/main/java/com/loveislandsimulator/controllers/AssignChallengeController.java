package com.loveislandsimulator.controllers;

import com.loveislandsimulator.LoveIslandSimulatorApp;
import com.loveislandsimulator.controllers.base.BaseController;
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

/**
 * Controller for the Assign Challenge screen of the application.
 * Associated FXML: assign-challenge.fxml
 */
public class AssignChallengeController extends BaseController {
    //#region FXML Properties
    @FXML
    private VBox islandersContainer;

    @FXML
    private ComboBox<String> challengeComboBox;

    @FXML
    private Text selectedChallengeName;

    @FXML
    private Text selectedChallengeDescription;

    @FXML
    private Text titleText;
    //#endregion

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

                        displaySelectedChallenge();
                    }
                });
            }
        });

        // Initialize strategies for combobox
        for (ChallengeCommand command : GameData.getInstance().getChallenges()) {
            challengeComboBox.getItems().add(command.getName());
        }
    }


    public void onRandomButtonClick() {
        Random random = new Random();
        List<ChallengeCommand> challenges = GameData.getInstance().getChallenges();
        challengeComboBox.setValue(challenges.get(random.nextInt(challenges.size())).getName());
    }

    public void onSimulateButtonClick() {
        if (challengeComboBox.getValue() == null) {
            // TODO: Display error to user
            return;
        }

        List<Islander> islanders = GameData.getInstance().getIslanders();
        ChallengeCommand challenge = findChallenge(challengeComboBox.getValue());

        for (Islander islander : islanders) {
            islander.participateInChallenge(challenge);
        }
        app.getSceneController().switchTo("challenge-results");
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

    /**
     * Displays the selected challenge on the UI.
     * Changes the value of the challenge details whenever the selected ComboBox value changes.
     */
    private void displaySelectedChallenge() {
        // Update challenge details when a new challenge is selected from the ComboBox
        challengeComboBox.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                ChallengeCommand selectedChallenge = findChallenge(newVal);

                if (selectedChallenge != null) {
                    selectedChallengeName.setText(selectedChallenge.getName());
                    selectedChallengeDescription.setText(selectedChallenge.getDescription());
                }
            }
        });
    }

    /**
     * Find the challenge that matches the provided string value.
     *
     * @param value The string value.
     * @return The Challenge Command.
     */
    private ChallengeCommand findChallenge(String value) {
        return GameData.getInstance().getChallenges().stream()
                .filter(c -> c.getName().equals(value))
                .findFirst()
                .orElse(null);
    }
}
