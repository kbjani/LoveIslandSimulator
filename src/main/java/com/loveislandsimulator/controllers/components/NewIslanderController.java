package com.loveislandsimulator.controllers.components;

import com.loveislandsimulator.LoveIslandSimulatorApp;
import com.loveislandsimulator.models.AppController;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;

public class NewIslanderController implements AppController {
    private LoveIslandSimulatorApp app;

    @FXML
    private ComboBox<String> strategyComboBox;

    @FXML
    private ImageView avatarImage;

    public void setApp(LoveIslandSimulatorApp app) {
        this.app = app;
    }

    @FXML
    public void initialize() {
        strategyComboBox.getItems().addAll(
                "Aggressive",
                "Balanced",
                "Passive"
        );

        strategyComboBox.setOnAction(event -> {
            String selectedStrategy = strategyComboBox.getValue();
            System.out.println("Selected Strategy: " + selectedStrategy);
        });
    }

    public void setAvatar(String avatarFileName) {
        InputStream inputStream = getClass().getResourceAsStream("/com/loveislandsimulator/images/" + avatarFileName);
        if(inputStream != null){
            Image avatar = new Image(inputStream);
            avatarImage.setImage(avatar);
        }
    }
}
