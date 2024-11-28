package com.loveislandsimulator.utilities;

import com.loveislandsimulator.controllers.components.IslanderController;
import com.loveislandsimulator.models.GameData;
import com.loveislandsimulator.models.Islander;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.List;

public class ControllerUtils {
    /**
     * Populates a container with islander components.
     *
     * @param container     The container to populate.
     * @param islanders     The list of islanders to display.
     * @param componentPath The FXML path of the islander component.
     */
    public static void populateIslanders(Pane container, List<Islander> islanders, String componentPath) {
        container.getChildren().clear();
        if (islanders.isEmpty()) return;

        // Sort islanders in descending order
        islanders = islanders.stream()
                .sorted((i1, i2) -> Integer.compare(i2.getScore(), i1.getScore()))
                .toList();

        try {
            for (Islander islander : islanders) {
                FXMLLoader loader = new FXMLLoader(ControllerUtils.class.getResource(componentPath));
                GridPane islanderComponent = loader.load();

                IslanderController controller = loader.getController();
                controller.setAvatar(islander.getAvatar());
                controller.setName(islander.getName());
                controller.setStrategyField(islander.getBehaviorStrategy());
                controller.setRoles(islander.getRoles());
                controller.setScore(islander.getScore());

                container.getChildren().add(islanderComponent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the title for the current challenge containing the number of the current challenge.
     * @return The challenge title text.
     */
    public static String getChallengeTitle() {
        int currentGame = GameData.getInstance().getChallengeCount();
        return "Love Island Challenge #" + currentGame;
    }
}
