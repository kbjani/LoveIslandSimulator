package com.loveislandsimulator.controllers;

import com.loveislandsimulator.LoveIslandSimulatorApp;
import com.loveislandsimulator.models.AppController;

public class ChallengeResultsController implements AppController {
    private LoveIslandSimulatorApp app;

    public void setApp(LoveIslandSimulatorApp app) {
        this.app = app;
    }

    public void onNextChallengeButtonClick() {
        app.getSceneController().switchTo("assign-challenge");
    }

    public void onEndGameButtonClick(){
        app.getSceneController().switchTo("game-result");
    }
}

