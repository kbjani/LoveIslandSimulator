package com.loveislandsimulator.controllers.components;

import com.loveislandsimulator.LoveIslandSimulatorApp;
import com.loveislandsimulator.models.AppController;
import com.loveislandsimulator.strategies.IslanderBehaviorStrategy;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;

public class NewIslanderController {
    private Image image;

    //#region FXML Properties
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
    //#endregion

    @FXML
    public void initialize() {
        // Initialize strategies for combobox
        for (IslanderBehaviorStrategy strategy : IslanderBehaviorStrategy.getAllStrategies()) {
            strategyComboBox.getItems().add(strategy.getStrategyName());
        }
    }

    /**
     * Populates the avatar image for the islander.
     * @param avatarFileName The avatar file name.
     */
    public void setAvatar(String avatarFileName) {
        String filePath = "/com/loveislandsimulator/images/" + avatarFileName;
        InputStream inputStream = getClass().getResourceAsStream(filePath);

        if(inputStream != null){
            this.image = new Image(inputStream);
            avatarImage.setImage(this.image);
        }
    }

    //#region Getters & Setters
    public TextField getNameField() {
        return nameField;
    }

    public Image getAvatar() {
        System.out.println(this.image);
        return this.image;
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
    //#endregion
}
