package com.example.loveislandsimulator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoveIslandSimulatorApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoveIslandSimulatorApp.class.getResource("home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Love Island Game Show Simulator");
        stage.setScene(scene);

        stage.setWidth(1024);
        stage.setHeight(768);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}