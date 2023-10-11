package org.bcloud.cloudengine.logger;

import org.bcloud.cloudengine.color.ConsoleColor;
import org.jetbrains.annotations.NotNull;

public class Logger extends Debugger {

    public static void info(String @NotNull ... messages) {
        for (String message : messages) {
            System.out.println(ConsoleColor.WHITE + "[" + INFO + "] " + message + ConsoleColor.RESET);
        }
    }

    public static void warn(String @NotNull ... messages) {
        for (String message : messages) {
            System.out.println(ConsoleColor.YELLOW + "[" + WARN + "] " + message + ConsoleColor.RESET);
        }
    }

    public static void severe(String @NotNull ... messages) {
        for (String message : messages) {
            System.out.println(ConsoleColor.RED + "[" + SEVERE + "] " + message + ConsoleColor.RESET);
        }
    }

}
