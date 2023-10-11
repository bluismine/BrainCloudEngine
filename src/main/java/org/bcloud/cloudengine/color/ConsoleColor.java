package org.bcloud.cloudengine.color;

public class ConsoleColor {
    public static final String BLACK = TerminalColor.BLACK.getCode();
    public static final String RED = TerminalColor.RED.getCode();
    public static final String GREEN = TerminalColor.GREEN.getCode();
    public static final String YELLOW = TerminalColor.YELLOW.getCode();
    public static final String BLUE = TerminalColor.BLUE.getCode();
    public static final String PURPLE = TerminalColor.PURPLE.getCode();
    public static final String CYAN = TerminalColor.CYAN.getCode();
    public static final String WHITE = TerminalColor.WHITE.getCode();
    public static final String LIGHT_BLACK = TerminalColor.LIGHT_BLACK.getCode();
    public static final String LIGHT_RED = TerminalColor.LIGHT_RED.getCode();
    public static final String LIGHT_GREEN = TerminalColor.LIGHT_GREEN.getCode();
    public static final String LIGHT_YELLOW = TerminalColor.LIGHT_YELLOW.getCode();
    public static final String LIGHT_BLUE = TerminalColor.LIGHT_BLUE.getCode();
    public static final String LIGHT_PURPLE = TerminalColor.LIGHT_PURPLE.getCode();
    public static final String LIGHT_CYAN = TerminalColor.LIGHT_CYAN.getCode();
    public static final String LIGHT_WHITE = TerminalColor.LIGHT_WHITE.getCode();
    public static final String RESET = TerminalColor.RESET.getCode();

    public enum TerminalColor {
        BLACK("\u001b[30m"),
        RED("\u001b[31m"),
        GREEN("\u001b[32m"),
        YELLOW("\u001b[33m"),
        BLUE("\u001b[34m"),
        PURPLE("\u001b[35m"),
        CYAN("\u001b[36m"),
        WHITE("\u001b[37m"),
        LIGHT_BLACK("\u001b[30;1m"),
        LIGHT_RED("\u001b[31;1m"),
        LIGHT_GREEN("\u001b[32;1m"),
        LIGHT_YELLOW("\u001b[33;1m"),
        LIGHT_BLUE("\u001b[34;1m"),
        LIGHT_PURPLE("\u001b[35;1m"),
        LIGHT_CYAN("\u001b[36;1m"),
        LIGHT_WHITE("\u001b[37;1m"),
        RESET("\u001b[0m");

        private final String code;

        TerminalColor(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        @Override
        public String toString() {
            return code + '\'';
        }
    }
}
