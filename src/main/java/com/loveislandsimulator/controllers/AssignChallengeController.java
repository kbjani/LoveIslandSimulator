package com.loveislandsimulator.controllers;

import com.loveislandsimulator.controllers.base.BaseController;
import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.GameData;
import com.loveislandsimulator.models.Islander;
import com.loveislandsimulator.utilities.ControllerUtils;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.List;
import java.util.Random;

import static com.loveislandsimulator.utilities.ControllerUtils.showErrorPopup;

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
                        populateIslanders();
                        titleText.setText(ControllerUtils.getChallengeTitle());
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


    /**
     * Handles the button click action of the "random" button.
     */
    public void onRandomButtonClick() {
        Random random = new Random();
        List<ChallengeCommand> challenges = GameData.getInstance().getChallenges();
        challengeComboBox.setValue(challenges.get(random.nextInt(challenges.size())).getName());
    }

    /**
     * Handles the button click action of the "simulate challenge" button.
     * Each islander participates in the challenge,
     * then the page is navigated to the results screen of that challenge.
     */
    public void onSimulateButtonClick() {
        if (challengeComboBox.getValue() == null) {
            showErrorPopup("Field validation failed. Please be sure to select a challenge from the dropdown.");
            return;
        }

        List<Islander> islanders = GameData.getInstance().getIslanders();
        ChallengeCommand challenge = findChallenge(challengeComboBox.getValue());

        for (Islander islander : islanders) {
            islander.participateInChallenge(challenge);
        }

        switchToView("challenge-results");
    }

    /**
     * Populates the islanders in the islanders container on page load.
     */
    private void populateIslanders() {
        String path = "/com/loveislandsimulator/components/small-islander-component.fxml";
        List<Islander> islanders = GameData.getInstance().getIslanders();
        ControllerUtils.populateIslanders(islandersContainer, islanders, path);
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
