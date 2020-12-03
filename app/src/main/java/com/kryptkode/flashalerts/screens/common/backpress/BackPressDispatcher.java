package com.kryptkode.flashalerts.screens.common.backpress;

public interface BackPressDispatcher {
    void registerListener(BackPressedListener listener);
    void unregisterListener(BackPressedListener listener);
}
