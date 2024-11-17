package com.loveislandsimulator.controllers.base;

import com.loveislandsimulator.LoveIslandSimulatorApp;
import com.loveislandsimulator.models.AppController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SceneController {
    private final Stage stage;
    private final Map<String, Scene> scenes = new HashMap<>();

    public SceneController(Stage stage) {
        this.stage = stage;
    }

    public void addScene(String name, String fxmlPath, LoveIslandSimulatorApp app) throws IOException {
        FXMLLoader loader = new FXMLLoader(app.getClass().getResource(fxmlPath));
        Scene scene = new Scene(loader.load(), 1024, 768);

        // Pass the main app to the controller if applicable
        Object controller = loader.getController();
        if (controller instanceof AppController) {
            ((AppController) controller).setApp(app);
        }

        scenes.put(name, scene);
    }

    public void switchTo(String name) {
        stage.setScene(scenes.get(name));
    }

    public void showInitialScene(String name) {
        stage.setScene(scenes.get(name));
        stage.setWidth(1024);
        stage.setHeight(768);
        stage.show();
    }
}
