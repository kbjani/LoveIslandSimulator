package com.loveislandsimulator.controllers;

import com.loveislandsimulator.controllers.base.BaseController;
import com.loveislandsimulator.controllers.components.IslanderController;
import com.loveislandsimulator.models.GameData;
import com.loveislandsimulator.models.Islander;
import com.loveislandsimulator.utilities.ControllerUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;

import static com.loveislandsimulator.utilities.ControllerUtils.populateIslanders;

/**
 * Controller for the Challenge Results screen of the application.
 * Associated FXML: challenge-results.fxml
 */
public class ChallengeResultsController extends BaseController {
    //#region FXML Properties
    @FXML
    private VBox islandersContainer;

    @FXML
    private Text titleText;

    @FXML
    private Button endGameButton;
    //#endregion

    @FXML
    public void initialize() {
        islandersContainer.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.windowProperty().addListener((winObservable, oldWindow, newWindow) -> {
                    if (newWindow != null) {
                        populateIslanders();
                        updateChallengeTitle();
                        updateEndGameButton();
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
     * Populates the islanders in the islanders container on page load.
     */
    private void populateIslanders() {
        String path = "/com/loveislandsimulator/components/small-islander-component.fxml";
        List<Islander> islanders = GameData.getInstance().getIslanders();
        ControllerUtils.populateIslanders(islandersContainer, islanders, path);
    }

    /**
     * Updates the challenge title with the current challenge count.
     */
    private void updateChallengeTitle() {
        titleText.setText("Love Island Challenge #" + GameData.getInstance().getChallengeCount());
    }

    /**
     * Updates the visibility of the "end game" button.
     * The button should only appear if at least 3 challenges have been completed.
     */
    private void updateEndGameButton() {
        endGameButton.setVisible(GameData.getInstance().getChallengeCount() >= 3);
    }
}

