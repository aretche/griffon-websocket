package io.github.aretche.griffonWebSocket

import griffon.javafx.JavaFXGriffonApplication

public class Launcher {
    public static void main(String[] args) throws Exception {
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "INFO")
        System.setProperty("griffon.full.stacktrace", "true")
        JavaFXGriffonApplication.main(args)
    }
}