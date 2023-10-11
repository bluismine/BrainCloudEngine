package org.bcloud.cloudengine.logger;

public class LogType {

    public static final String INFO = LogTypeEnum.INFO.getType();
    public static final String WARN = LogTypeEnum.WARN.getType();
    public static final String SEVERE = LogTypeEnum.SEVERE.getType();
    public static final String DEBUG = LogTypeEnum.DEBUG.getType();

    public enum LogTypeEnum {
        INFO("INFO"),
        WARN("WARN"),
        SEVERE("SEVERE"),
        DEBUG("DEBUG");

        private final String type;

        LogTypeEnum(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public String toString() {
            return type;
        }
    }
}
