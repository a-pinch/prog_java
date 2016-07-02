package org.stepic.pinch.s43_8;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class Main {

    public static void main(String[] args) {
        configureLogging();
    }

    private static void configureLogging() {
        Logger.getLogger("org.stepic.java.logging.ClassA").setLevel(Level.ALL);
        Logger.getLogger("org.stepic.java.logging.ClassB").setLevel(Level.WARNING);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new XMLFormatter());
        Logger logger = Logger.getLogger("org.stepic.java");
        logger.addHandler(consoleHandler);
        logger.setUseParentHandlers(false);
    }
}
