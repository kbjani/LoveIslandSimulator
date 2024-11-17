package com.loveislandsimulator.controllers;

import com.loveislandsimulator.LoveIslandSimulatorApp;
import com.loveislandsimulator.models.AppController;

public class AssignChallengeController implements AppController {
    private LoveIslandSimulatorApp app;

    public void setApp(LoveIslandSimulatorApp app) {
        this.app = app;
    }

    public void onRandomButtonClick() {
        // TODO: Select a random challenge on the dropdown
    }

    public void onSimulateButtonClick() {
        // TODO: Validate fields and catch errors
        app.getSceneController().switchTo("challenge-results");
    }
}
