package com.loveislandsimulator.controllers.components;

import com.loveislandsimulator.LoveIslandSimulatorApp;
import com.loveislandsimulator.enums.Strategies;
import com.loveislandsimulator.models.AppController;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;

public class NewIslanderController implements AppController {
    private LoveIslandSimulatorApp app;

    @FXML
    private ComboBox<String> strategyComboBox;

    @FXML
    private ImageView avatarImage;

    @FXML
    private TextField nameField;

    @FXML
    private CheckBox leaderCheckBox;

    @FXML
    private CheckBox outsiderCheckBox;

    @FXML
    private CheckBox flirtCheckBox;

    @FXML
    private CheckBox doubleFacedCheckBox;

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

    public TextField getNameField() {
        return nameField;
    }

    public ComboBox<String> getStrategyComboBox() {
        return strategyComboBox;
    }

    public CheckBox getLeaderCheckBox() {
        return leaderCheckBox;
    }

    public CheckBox getOutsiderCheckBox() {
        return outsiderCheckBox;
    }

    public CheckBox getFlirtCheckBox() {
        return flirtCheckBox;
    }

    public CheckBox getDoubleFacedCheckBox() {
        return doubleFacedCheckBox;
    }

    /**
     * Initializes the strategy options for the islander.
     */
    private void initializeStrategies(){
        for (Strategies strategy : Strategies.values()) {
            strategyComboBox.getItems().add(strategy.toString());
        }
    }
}
