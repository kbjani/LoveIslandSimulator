package com.loveislandsimulator.controllers;

import com.loveislandsimulator.LoveIslandSimulatorApp;
import com.loveislandsimulator.controllers.components.NewIslanderController;
import com.loveislandsimulator.models.AppController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class IslanderSetupController implements AppController {
    private LoveIslandSimulatorApp app;

    @FXML
    private HBox islandersContainer;

    @Override
    public void setApp(LoveIslandSimulatorApp app) {
        this.app = app;
    }

    @FXML
    public void initialize() {
        try {
            GridPane gridPane = new GridPane();
            gridPane.setHgap(20);
            gridPane.setVgap(20);

            // Add 10 components in pairs of 2
            for (int i = 0; i < 10; i++) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/loveislandsimulator/components/new-islander-component.fxml"));
                GridPane islanderComponent = loader.load();

                // Access the controller to set the avatar
                NewIslanderController controller = loader.getController();
                String avatarFileName = "avatar" + (i + 1) + ".png";
                controller.setAvatar(avatarFileName);

                int row = i / 2;  // Each row has 2 items
                int col = i % 2;  // Alternates between 0 (left) and 1 (right)

                gridPane.add(islanderComponent, col, row);
            }

            islandersContainer.getChildren().add(gridPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onRandomizeButtonClick() {
        // TODO: Randomize all islander information
    }

    public void onStartButtonClick() {
        // TODO: Validate fields and catch errors
        app.getSceneController().switchTo("islanders-view");
    }
}
