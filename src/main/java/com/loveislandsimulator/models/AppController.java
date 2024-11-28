package com.loveislandsimulator.models;

import com.loveislandsimulator.LoveIslandSimulatorApp;

/**
 * Interface for controllers in the Love Island Simulator application.
 */
public interface AppController {

    /**
     * Method used to inject the `LoveIslandSimulatorApp` instance into the controller and
     * enabling it to perform actions like scene transitions.
     *
     * @param app The LoveIslandSimulatorApp instance.
     */
    void setApp(LoveIslandSimulatorApp app);
}

