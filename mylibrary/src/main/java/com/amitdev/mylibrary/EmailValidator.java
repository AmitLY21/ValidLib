package com.amitdev.mylibrary;

import java.util.regex.Pattern;

public class EmailValidator {
    private EmailValidator() {
    }

    private static final EmailValidator instance = new EmailValidator();

    public static EmailValidator getInstance() {
        return instance;
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}
