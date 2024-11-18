package com.loveislandsimulator.controllers.components;

import com.loveislandsimulator.LoveIslandSimulatorApp;
import com.loveislandsimulator.enums.Strategies;
import com.loveislandsimulator.models.AppController;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.util.Arrays;

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
        initializeStrategies();
    }

    /**
     * Populates the avatar image for the islander.
     * @param avatarFileName The avatar file name.
     */
    public void setAvatar(String avatarFileName) {
        String filePath = "/com/loveislandsimulator/images/" + avatarFileName;
        InputStream inputStream = getClass().getResourceAsStream(filePath);

        if(inputStream != null){
            Image avatar = new Image(inputStream);
            avatarImage.setImage(avatar);
        }
    }

    /**
     * Initializes the strategy options for the islander.
     */
    private void initializeStrategies(){
        for (Strategies strategy : Strategies.values()) {
            strategyComboBox.getItems().add(strategy.toString());
        }    }
}
