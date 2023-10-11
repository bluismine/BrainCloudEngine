package org.bcloud.cloudengine.date;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatted {

    private static final DateFormat dateFormat = DateFormat.getDateInstance();
    private static DateTimeFormatter format = DateTimeFormatter.ofPattern("eeee / dd-MM-yyyy / HH:mm:ss");

    public static String now() {
        LocalDateTime now = LocalDateTime.now();
        return format.format(now);
    }

    public static String getTimeZone() {
        return dateFormat.getTimeZone().getID();
    }

    public static void main(String[] args) {
        System.out.println(now());
    }

    public static DateTimeFormatter getFormat() {
        return format;
    }

    public static void setFormat(DateTimeFormatter format) {
        DateFormatted.format = format;
    }
}
