package com.loveislandsimulator.controllers;

import com.loveislandsimulator.LoveIslandSimulatorApp;
import com.loveislandsimulator.controllers.components.IslanderController;
import com.loveislandsimulator.controllers.components.NewIslanderController;
import com.loveislandsimulator.models.AppController;
import com.loveislandsimulator.models.GameData;
import com.loveislandsimulator.models.Islander;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class AssignChallengeController implements AppController {
    private LoveIslandSimulatorApp app;

    //#region FXML Properties
    @FXML
    private VBox islandersContainer;
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
    }

    public void onRandomButtonClick() {
        // TODO: Select a random challenge on the dropdown
    }

    public void onSimulateButtonClick() {
        // TODO: Validate fields and catch errors
        // TODO: Simulate the challenge for each islander and calculate scores.
        app.getSceneController().switchTo("challenge-results");
    }

    /**
     * Validates the fields.
     * @param controller The controller.
     */
    private boolean validateFields(AssignChallengeController controller) {
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
                for (int i = 0; i < islanders.size(); i++) {
                    Islander islander = islanders.get(i);
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

}
