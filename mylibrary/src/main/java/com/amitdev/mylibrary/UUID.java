package com.amitdev.mylibrary;

import android.os.Build;
import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class UUID {
    private static final UUID instance = new UUID();

    private UUID() {
    }

    public static UUID getInstance() {
        return instance;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String generateUUID() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = dateTime.format(formatter);

        String randomChars = generateRandomChars(16);
        String xoredUUID = xorUUID(formattedDateTime, randomChars);

        return xoredUUID;
    }

    public boolean isValidUUID(String uuid) {
        return uuid.matches("[a-fA-F0-9]{32}");
    }

    private String generateRandomChars(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }

        return sb.toString();
    }

    private String xorUUID(String uuid, String randomChars) {
        StringBuilder sb = new StringBuilder(uuid.length());

        for (int i = 0; i < uuid.length(); i++) {
            char char1 = uuid.charAt(i);
            char char2 = randomChars.charAt(i % randomChars.length());
            int xorResult = char1 ^ char2;
            sb.append(Integer.toHexString(xorResult));
        }

        return sb.toString();
    }
}
