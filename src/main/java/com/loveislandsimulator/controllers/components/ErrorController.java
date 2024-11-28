package com.loveislandsimulator.controllers.components;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * The Controller for the "error" popup module.
 * Associated FXML: error-view.fxml
 */
public class ErrorController {
    //#region FXML Properties
    @FXML
    private Label errorMessageLabel;

    @FXML
    private Button closeButton;
    //#endregion

    /**
     * Sets the error message to be displayed.
     *
     * @param message The error message.
     */
    public void setErrorMessage(String message) {
        errorMessageLabel.setText(message);
    }

    /**
     * Closes the popup window when the close button is clicked.
     */
    @FXML
    private void onCloseButtonClick() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
