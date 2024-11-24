package com.loveislandsimulator.controllers.components;

import com.loveislandsimulator.LoveIslandSimulatorApp;
import com.loveislandsimulator.enums.Role;
import com.loveislandsimulator.models.AppController;
import com.loveislandsimulator.strategies.IslanderBehaviorStrategy;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.util.ArrayList;

/**
 * Controller for the individual Islander component. This component is used after the islanders have been initialized.
 * Associated FXML: islander-component.fxml
 */
public class IslanderController implements AppController {
    private LoveIslandSimulatorApp app;
    private Image image;

    //#region FXML Properties
    @FXML
    private Text nameField;

    @FXML
    private Text strategyField;

    @FXML
    private Text rolesField;

    @FXML
    private Text scoreField;

    @FXML
    private ImageView avatarImage;
 //#endregion

    @Override
    public void setApp(LoveIslandSimulatorApp app) {
        this.app = app;
    }

    /**
     * Sets the name on the UI.
     * @param name The name.
     */
    public void setName(String name) {
        nameField.setText(name);
    }

    /**
     * Sets the strategy field on the UI.
     * @param strategy The islander behavior strategy.
     */
    public void setStrategyField(IslanderBehaviorStrategy strategy) {
        strategyField.setText(strategy.getStrategyName());
    }

    /**
     * Populates the avatar image for the islander.
     * @param avatar The avatar image.
     */
    public void setAvatar(Image avatar) {
        avatarImage.setImage(avatar);
    }

    /**
     * Set the islander's roles in the UI.
     * @param roles
     */
    public void setRoles(ArrayList<Role> roles){
        if(roles == null || roles.isEmpty()){
            return;
        }

        StringBuilder text = new StringBuilder();
        for(Role role: roles){
            text.append(Role.getRoleName(role)).append(" \n");
        }
        rolesField.setText(text.toString());
    }
}
