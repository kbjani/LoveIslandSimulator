package com.loveislandsimulator.controllers;

import com.loveislandsimulator.LoveIslandSimulatorApp;
import com.loveislandsimulator.controllers.components.NewIslanderController;
import com.loveislandsimulator.enums.Strategies;
import com.loveislandsimulator.models.AppController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class IslanderSetupController implements AppController {
    private LoveIslandSimulatorApp app;
    private final String[] names = {"Alex", "Jordan", "Taylor", "Casey", "Riley", "Morgan", "Jamie", "Drew", "Sydney", "Peyton"};
    private FXMLLoader loader;
    private final ArrayList<NewIslanderController> controllers = new ArrayList<>(); // Store controllers


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
                loader = new FXMLLoader(getClass().getResource("/com/loveislandsimulator/components/new-islander-component.fxml"));
                GridPane islanderComponent = loader.load();

                // Access the controller to set the avatar
                NewIslanderController controller = loader.getController();
                controllers.add(controller);

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
        Random random = new Random();

       ArrayList<String> strategies = new ArrayList<>();
        for (Strategies strategy : Strategies.values()) {
            strategies.add(strategy.toString());
        }

        controllers.forEach(controller -> {
            // Randomize name
            TextField nameField = controller.getNameField();
            nameField.setText(names[random.nextInt(names.length)]);

            // Randomize strategy ComboBox
            ComboBox<String> strategyComboBox = controller.getStrategyComboBox();
            strategyComboBox.getItems().clear();
            strategyComboBox.getItems().addAll(strategies);
            strategyComboBox.setValue(strategies.get(random.nextInt(strategies.size())));

            // Randomize role CheckBoxes
            CheckBox leaderCheckBox = controller.getLeaderCheckBox();
            CheckBox outsiderCheckBox = controller.getOutsiderCheckBox();
            CheckBox flirtCheckBox = controller.getFlirtCheckBox();
            CheckBox doubleFacedCheckBox = controller.getDoubleFacedCheckBox();

            leaderCheckBox.setSelected(random.nextBoolean());
            outsiderCheckBox.setSelected(random.nextBoolean());
            flirtCheckBox.setSelected(random.nextBoolean());
            doubleFacedCheckBox.setSelected(random.nextBoolean());
        });
    }

    public void onStartButtonClick() {
        for (NewIslanderController controller : controllers) {
            validateFields(controller);
        }
        // TODO: Create Islanders instances with data
        app.getSceneController().switchTo("islanders-view");
    }

    /**
     * Validates the fields for the "New Islander" components.
     * @param controller The controller.
     */
    private void validateFields(NewIslanderController controller){
        TextField nameField = controller.getNameField();
        ComboBox<String> strategyComboBox = controller.getStrategyComboBox();

        if (nameField.getText() == null || nameField.getText().trim().isEmpty()) {
            // TODO: Display empty name field error to user
            return;
        }

        // Check if a strategy is selected
        if (strategyComboBox.getValue() == null) {
            // TODO: Display empty strategy error to user
            return;
        }
    }
}
