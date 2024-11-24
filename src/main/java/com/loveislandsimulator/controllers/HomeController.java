package com.loveislandsimulator.controllers;

import com.loveislandsimulator.LoveIslandSimulatorApp;
import com.loveislandsimulator.models.AppController;

public class HomeController implements AppController {
    private LoveIslandSimulatorApp app;

    @Override
    public void setApp(LoveIslandSimulatorApp app) {
        this.app = app;
    }

    public void onStartButtonClick() {
        app.getSceneController().switchTo("islander-setup");
    }

    public void onHelpButtonClick() {
        app.getSceneController().switchTo("help");
    }
}

