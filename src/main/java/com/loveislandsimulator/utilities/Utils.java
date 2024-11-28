package com.loveislandsimulator.utilities;

import java.util.Random;

/**
 * Utility methods to be used across the application.
 */
public class Utils {
    static Random random = new Random();

    // Static list of names to use to randomly populate islander names.
    private static final String[] names = {
            "Alex", "Jordan", "Taylor", "Casey", "Riley", "Morgan", "Jamie", "Drew",
            "Sydney", "Peyton", "Avery", "Quinn", "Charlie", "Cameron", "Rowan",
            "Skyler", "Harper", "Elliot", "Emerson", "Dakota", "Phoenix", "Logan",
            "Finley", "Hayden", "Reese", "Sage", "Shiloh", "Tanner", "Oakley", "Kai"
    };

    /**
     * Gets a random name from a list of predefined names.
     *
     * @return The randomly selected name.
     */
    public static String getRandomName() {
        return names[random.nextInt(names.length)];
    }
}