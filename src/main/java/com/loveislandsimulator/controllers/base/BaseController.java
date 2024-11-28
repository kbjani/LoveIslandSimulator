package com.loveislandsimulator.controllers.base;

import com.loveislandsimulator.LoveIslandSimulatorApp;
import com.loveislandsimulator.models.AppController;

public class BaseController implements AppController {
    protected LoveIslandSimulatorApp app;

    @Override
    public void setApp(LoveIslandSimulatorApp app) {
        this.app = app;
    }

    /**
     * Switches to a specified view.
     *
     * @param viewName The name of the view to switch to.
     */
    protected void switchToView(String viewName) {
        app.getSceneController().switchTo(viewName);
    }
}
