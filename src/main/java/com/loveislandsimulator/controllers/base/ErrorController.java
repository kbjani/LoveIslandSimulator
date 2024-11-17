package com.loveislandsimulator.controllers.base;

import com.loveislandsimulator.LoveIslandSimulatorApp;
import com.loveislandsimulator.models.AppController;

public class ErrorController implements AppController {
    private LoveIslandSimulatorApp app;

    public void setApp(LoveIslandSimulatorApp app) {
        this.app = app;
    }
}
