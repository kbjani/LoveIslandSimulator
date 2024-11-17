package com.loveislandsimulator.controllers;

import com.loveislandsimulator.LoveIslandSimulatorApp;
import com.loveislandsimulator.models.AppController;

public class IslanderSetupController implements AppController {
    private LoveIslandSimulatorApp app;

    @Override
    public void setApp(LoveIslandSimulatorApp app) {
        this.app = app;
    }

    public void onRandomizeButtonClick() {
        // TODO: Randomize all islander information
    }

    public void onStartButtonClick() {
        // TODO: Validate fields and catch errors
        app.getSceneController().switchTo("islanders-view");
    }
}
