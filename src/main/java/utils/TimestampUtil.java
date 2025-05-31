package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimestampUtil {

	public static String getCurrentTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        LocalDateTime now = LocalDateTime.now();
        return now.format(formatter);
    }

}
