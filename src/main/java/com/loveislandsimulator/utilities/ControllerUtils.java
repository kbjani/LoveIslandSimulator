package com.loveislandsimulator.utilities;

import com.loveislandsimulator.controllers.components.IslanderController;
import com.loveislandsimulator.models.Islander;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class ControllerUtils {
    private static final Random RANDOM = new Random();

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
     * Selects a random item from a list.
     *
     * @param items The list of items.
     * @param <T>   The type of items.
     * @return A random item from the list.
     */
    public static <T> T getRandomItem(List<T> items) {
        return items.get(RANDOM.nextInt(items.size()));
    }
}
