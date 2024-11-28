package com.loveislandsimulator.controllers;

import com.loveislandsimulator.LoveIslandSimulatorApp;
import com.loveislandsimulator.controllers.base.BaseController;
import com.loveislandsimulator.models.AppController;

/**
 * Controller for the Home screen of the application.
 * Associated FXML: home-view.fxml
 */
public class HomeController extends BaseController {
    /**
     * Handles the button click action for the "Start" button.
     * Navigates to the Islander Setup screen on click.
     */
    public void onStartButtonClick() {
        switchToView("islander-setup");
    }

    /**
     * Handles the button click action for the "Help" button.
     * Navigates to the Help screen on click.
     */
    public void onHelpButtonClick() {
        switchToView("help");
    }
}

