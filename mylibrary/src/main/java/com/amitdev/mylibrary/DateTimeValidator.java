package com.amitdev.mylibrary;

import android.os.Build;
import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTimeValidator {
    public enum Format {
        ISO_DATE("yyyy-MM-dd"),
        ISO_DATE_TIME("yyyy-MM-dd HH:mm:ss"),
        BASIC_ISO_DATE("yyyyMMdd"),
        FULL_DATE_TIME("EEEE, MMMM d, yyyy HH:mm:ss"),
        MONTH_DAY_YEAR("MMMM d, yyyy"),
        HOUR_MINUTE("HH:mm"),
        YEAR_MONTH("MMMM yyyy");

        private final String pattern;

        Format(String pattern) {
            this.pattern = pattern;
        }

        public String getPattern() {
            return pattern;
        }
    }

    private DateTimeValidator() {
    }

    private static final DateTimeValidator instance = new DateTimeValidator();

    public static DateTimeValidator getInstance() {
        return instance;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean isValidDateTime(String dateTime, Format format) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format.getPattern());
            LocalDateTime.parse(dateTime, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
