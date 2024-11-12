package com.loveislandsimulator.controllers;

import com.loveislandsimulator.LoveIslandSimulatorApp;
import com.loveislandsimulator.models.AppController;

public class GameResultController implements AppController {
    private LoveIslandSimulatorApp app;

    public void setApp(LoveIslandSimulatorApp app) {
        this.app = app;
    }
}
