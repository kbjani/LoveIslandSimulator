package com.loveislandsimulator.controllers;

import com.loveislandsimulator.controllers.base.BaseController;
import javafx.fxml.FXML;

/**
 * Controller for the "Help" screen of the application.
 * Associated FXML: help-view.fxml
 */
public class HelpController extends BaseController {
    @FXML
    protected void onBackButtonClick() {
        app.getSceneController().switchTo("home");
    }
}
