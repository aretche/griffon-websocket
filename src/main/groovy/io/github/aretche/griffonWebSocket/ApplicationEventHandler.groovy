package io.github.aretche.griffonWebSocket

import griffon.core.event.EventHandler
import griffon.exceptions.GriffonViewInitializationException
import javafx.application.Platform

class ApplicationEventHandler implements EventHandler {
    void onUncaughtGriffonViewInitializationException(GriffonViewInitializationException x) {
        Platform.exit()
    }
}