package com.amitdev.mylibrary;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {
    private int minLength = 8;
    private boolean requireUppercase = true;
    private boolean requireLowercase = true;
    private boolean requireDigit = true;
    private boolean requireSpecialChar = true;

    private PasswordValidator() {
    }

    private static final PasswordValidator instance = new PasswordValidator();

    public static PasswordValidator getInstance() {
        return instance;
    }

    public static class Builder {
        private final PasswordValidator validator;

        public Builder() {
            validator = new PasswordValidator();
        }

        public Builder setMinLength(int length) {
            validator.minLength = length;
            return this;
        }

        public Builder setRequireUppercase(boolean required) {
            validator.requireUppercase = required;
            return this;
        }

        public Builder setRequireLowercase(boolean required) {
            validator.requireLowercase = required;
            return this;
        }

        public Builder setRequireDigit(boolean required) {
            validator.requireDigit = required;
            return this;
        }

        public Builder setRequireSpecialChar(boolean required) {
            validator.requireSpecialChar = required;
            return this;
        }

        public PasswordValidator build() {
            return validator;
        }
    }

    public boolean isValidPassword(String password) {
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else {
                hasSpecialChar = true;
            }
        }

        return password.length() >= minLength &&
                (!requireUppercase || hasUppercase) &&
                (!requireLowercase || hasLowercase) &&
                (!requireDigit || hasDigit) &&
                (!requireSpecialChar || hasSpecialChar);
    }

    public enum PasswordStrength {
        WEAK("Weak password: Does not meet minimum requirements."),
        MEDIUM("Medium password: Meets some but not all requirements."),
        STRONG("Strong password: Meets all requirements."),
        LENGTH("Meets minimum length requirement."),
        UPPERCASE("Contains uppercase letters."),
        LOWERCASE("Contains lowercase letters."),
        DIGIT("Contains digits."),
        SPECIAL_CHAR("Contains special characters.");

        private final String description;

        PasswordStrength(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public PasswordStrength getPasswordStrength(String password) {
        List<PasswordStrength> strength = new ArrayList<>();

        if (password.length() >= minLength) {
            strength.add(PasswordStrength.LENGTH);
        }
        if (requireUppercase && password.chars().anyMatch(Character::isUpperCase)) {
            strength.add(PasswordStrength.UPPERCASE);
        }
        if (requireLowercase && password.chars().anyMatch(Character::isLowerCase)) {
            strength.add(PasswordStrength.LOWERCASE);
        }
        if (requireDigit && password.chars().anyMatch(Character::isDigit)) {
            strength.add(PasswordStrength.DIGIT);
        }
        if (requireSpecialChar && password.chars().anyMatch(ch -> !Character.isLetterOrDigit(ch))) {
            strength.add(PasswordStrength.SPECIAL_CHAR);
        }

        int size = strength.size();
        if (size == 0) {
            return PasswordStrength.WEAK;
        } else if (size >= 1 && size <= 2) {
            return PasswordStrength.MEDIUM;
        } else {
            return PasswordStrength.STRONG;
        }
    }
}
