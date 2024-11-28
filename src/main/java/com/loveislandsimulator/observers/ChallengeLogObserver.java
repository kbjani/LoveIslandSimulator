package com.loveislandsimulator.observers;

import java.util.List;

public interface ChallengeLogObserver {
    void onLogUpdated(List<String> logs);
}
