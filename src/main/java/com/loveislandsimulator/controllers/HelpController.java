package com.loveislandsimulator.controllers;

import com.loveislandsimulator.LoveIslandSimulatorApp;
import com.loveislandsimulator.models.AppController;
import javafx.fxml.FXML;

public class HelpController implements AppController {
    private LoveIslandSimulatorApp app;

    public void setApp(LoveIslandSimulatorApp app) {
        this.app = app;
    }

    @FXML
    protected void onBackButtonClick() {
        app.getSceneController().switchTo("home");
    }
}
