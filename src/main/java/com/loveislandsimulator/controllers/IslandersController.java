package com.loveislandsimulator.controllers;

import com.loveislandsimulator.LoveIslandSimulatorApp;
import com.loveislandsimulator.models.AppController;

public class IslandersController implements AppController {
    private LoveIslandSimulatorApp app;

    @Override
    public void setApp(LoveIslandSimulatorApp app) {
        this.app = app;
    }

    public void onContinueButtonClick() {
        app.getSceneController().switchTo("assign-challenge");
    }
}
