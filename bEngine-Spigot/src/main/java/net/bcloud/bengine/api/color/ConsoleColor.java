package net.bcloud.bengine.api.color;

/**
 * Color for console.
 */
public class ConsoleColor {

    public static final String BLACK = CommandLineColor.BLACK.getCode();
    public static final String RED = CommandLineColor.RED.getCode();
    public static final String GREEN = CommandLineColor.GREEN.getCode();
    public static final String YELLOW = CommandLineColor.YELLOW.getCode();
    public static final String BLUE = CommandLineColor.BLUE.getCode();
    public static final String PURPLE = CommandLineColor.PURPLE.getCode();
    public static final String LIGHT_BLUE = CommandLineColor.LIGHT_BLUE.getCode();
    public static final String WHITE = CommandLineColor.WHITE.getCode();
    public static final String BOLD = CommandLineColor.BOLD.getCode();
    public static final String RESET = CommandLineColor.RESET.getCode();

    public enum CommandLineColor {
        BLACK("\u001b[30m"),
        RED("\u001b[31m"),
        GREEN("\u001b[32m"),
        YELLOW("\u001b[33m"),
        BLUE("\u001b[34m"),
        PURPLE("\u001b[35m"),
        LIGHT_BLUE("\u001b[36m"),
        WHITE("\u001b[37m"),
        BOLD("\u001b[1m"),
        RESET("\u001b[0m");

        private final String code;

        CommandLineColor(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
