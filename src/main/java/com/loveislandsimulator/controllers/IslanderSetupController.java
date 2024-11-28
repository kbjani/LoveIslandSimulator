package com.loveislandsimulator.controllers;

import com.loveislandsimulator.controllers.base.BaseController;
import com.loveislandsimulator.controllers.components.NewIslanderController;
import com.loveislandsimulator.models.GameData;
import com.loveislandsimulator.models.Islander;
import com.loveislandsimulator.roles.DoubleFacedRole;
import com.loveislandsimulator.roles.FlirtRole;
import com.loveislandsimulator.roles.LeaderRole;
import com.loveislandsimulator.roles.OutsiderRole;
import com.loveislandsimulator.strategies.IslanderBehaviorStrategy;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.loveislandsimulator.utilities.Utils;

/**
 * Controller for the Islander Setup view. This view is used to set all initial values for the islanders.
 * Associated FXML: islander-setup-view.fxml
 */
public class IslanderSetupController extends BaseController {
    private final ArrayList<String> strategies = new ArrayList<>();
    private final Random random = new Random();
    private final ArrayList<NewIslanderController> controllers = new ArrayList<>(); // Store controllers

    @FXML
    private HBox islandersContainer;

    /**
     * Constructor for the Islander Setup Controller & Gets the IslanderBehaviorStrategies.
     */
    public IslanderSetupController() {
        // Get friendly strategy names for GUI
        List<IslanderBehaviorStrategy> strategies = IslanderBehaviorStrategy.getAllStrategies();
        for(IslanderBehaviorStrategy strategy: strategies){
            this.strategies.add(strategy.getStrategyName());
        }
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

    /**
     *  Method to control the Randomize Button in the GUI.
     *  This button will populate all available field(s) with random values, including
     *  name, strategy, and role(s).
     */
    public void onRandomizeButtonClick() {
        controllers.forEach(controller -> {
            randomizeName(controller);
            randomizeStrategy(controller);
            randomizeRoles(controller);
        });
    }

    /**
     * Method to control the Start Button in the GUI.
     * When the start button is clicked, the fields are to be validated.
     * If all entries are valid, then Islanders are created and saved in the GameData.
     */
    public void onStartButtonClick() {
        for (NewIslanderController controller : controllers) {
            if (!validateFields(controller)) {
                return; // validation fails
            }

            String name = controller.getNameField().getText();
            String strategy = controller.getStrategyComboBox().getValue();
            Islander islander = getIslander(controller, name);

            islander.setAvatar(controller.getAvatar());
            islander.setBehaviorStrategy(IslanderBehaviorStrategy.fromString(strategy));
            GameData.getInstance().addIslander(islander);
        }

        switchToView("islanders-view");
    }

    /**
     * Gets the islander with all information populated on the UI.
     *
     * @param controller The New Islander Controller.
     * @param name       The islander's name.
     * @return The islander with all information set.
     */
    private static Islander getIslander(NewIslanderController controller, String name) {
        Islander islander = new Islander(name);

        if (controller.getLeaderCheckBox().isSelected()) {
            islander = new LeaderRole(islander);
        }

        if (controller.getOutsiderCheckBox().isSelected()) {
            islander = new OutsiderRole(islander);
        }

        if (controller.getFlirtCheckBox().isSelected()) {
            islander = new FlirtRole(islander);
        }

        if (controller.getDoubleFacedCheckBox().isSelected()) {
            islander = new DoubleFacedRole(islander);
        }

        return islander;
    }

    /**
     * Sets a random name in the name field for the islander.
     * @param controller The controller.
     */
    private void randomizeName(NewIslanderController controller){
        TextField nameField = controller.getNameField();
        nameField.setText(Utils.getRandomName());
    }

    /**
     * Sets a random strategy in the strategy combo box for the islander.
     * @param controller The controller.
     */
    private void randomizeStrategy(NewIslanderController controller){
        ComboBox<String> strategyComboBox = controller.getStrategyComboBox();
        strategyComboBox.getItems().clear();
        strategyComboBox.getItems().addAll(this.strategies);
        strategyComboBox.setValue(this.strategies.get(random.nextInt(this.strategies.size())));
    }

    /**
     * Randomizes the role selection and sets the associated checkboxes.
     * @param controller The controller.
     */
    private void randomizeRoles(NewIslanderController controller){
        controller.getLeaderCheckBox().setSelected(random.nextBoolean());
        controller.getOutsiderCheckBox().setSelected(random.nextBoolean());
        controller.getFlirtCheckBox().setSelected(random.nextBoolean());
        controller.getDoubleFacedCheckBox().setSelected(random.nextBoolean());
    }

    /**
     * Validates the fields for the "New Islander" components.
     * @param controller The controller.
     */
    private boolean validateFields(NewIslanderController controller) {
        TextField nameField = controller.getNameField();
        ComboBox<String> strategyComboBox = controller.getStrategyComboBox();

        if (nameField.getText() == null || nameField.getText().trim().isEmpty()) {
            // TODO: Display empty name field error to user
            return false;
        }

        // Check if a strategy is selected
        // TODO: Display empty strategy error to user
        return strategyComboBox.getValue() != null;
    }
}
