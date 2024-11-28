package com.loveislandsimulator.controllers;

import com.loveislandsimulator.controllers.base.BaseController;
import com.loveislandsimulator.models.GameData;
import com.loveislandsimulator.models.Islander;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.List;

/**
 * Controller for the Game Result screen of the application.
 * Associated FXML: game-result.fxml
 */
public class GameResultController extends BaseController {
    //#region FXML Properties
    @FXML
    private VBox container;

    @FXML
    private Text firstPlace;

    @FXML
    private Text secondPlace;

    @FXML
    private Text thirdPlace;

    //#endregion

    @FXML
    public void initialize() {
        container.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.windowProperty().addListener((winObservable, oldWindow, newWindow) -> {
                    if (newWindow != null) {
                        populateResults();
                    }
                });
            }
        });
    }

    public void onNewGameButtonClick(){
        GameData.getInstance().reset();
        switchToView("islander-setup");
    }

    public void onQuitButtonClick(){
        switchToView("home");
    }

    private void populateResults() {
        List<Islander> islanders = GameData.getInstance().getIslanders();

        // Order islanders by score in descending order
        islanders = islanders.stream()
                .sorted((i1, i2) -> Integer.compare(i2.getScore(), i1.getScore()))
                .toList();

        Islander first = islanders.get(0);
        Islander second = islanders.get(1);
        Islander third = islanders.get(2);

        firstPlace.setText(first.getName() + " Score: " + first.getScore());
        secondPlace.setText(second.getName() + " Score: " + second.getScore());
        thirdPlace.setText(third.getName() + " Score: " + third.getScore());
    }
}
