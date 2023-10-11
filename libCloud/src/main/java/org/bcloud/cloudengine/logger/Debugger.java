package org.bcloud.cloudengine.logger;

import org.bcloud.cloudengine.color.ConsoleColor;

public abstract class Debugger extends LogType {

    private static boolean isDebugEnable;

    public static void debug(String... messages) {
        if (isDebugEnable) {
            for (String message : messages) {
                System.out.println(ConsoleColor.CYAN + "[" + DEBUG + "] " + message + ConsoleColor.RESET);
            }
        }
    }

    public static boolean isDebugEnable() {
        return isDebugEnable;
    }

    public static void toggleDebugMode(boolean isDebugEnable) {
        Debugger.isDebugEnable = isDebugEnable;
    }

    public static void toggleDebugMode(int isDebugEnable) {
        Debugger.isDebugEnable = isDebugEnable == 1;
    }
}
