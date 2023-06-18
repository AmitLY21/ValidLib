package com.amitdev.mylibrary;

import android.os.Build;
import androidx.annotation.RequiresApi;

import java.util.Map;

public class Validex {
    private PasswordValidator passwordValidator;
    private EmailValidator emailValidator;
    private UUID uuidValidator;
    private PhonenumberValidator phoneNumberValidator;
    private URLValidator urlValidator;
    private DateTimeValidator dateTimeValidator;

    private Validex() {
        passwordValidator = PasswordValidator.getInstance();
        emailValidator = EmailValidator.getInstance();
        uuidValidator = UUID.getInstance();
        phoneNumberValidator = PhonenumberValidator.getInstance();
        urlValidator = URLValidator.getInstance();
        dateTimeValidator = DateTimeValidator.getInstance();
    }

    public static Validex getInstance() {
        return Holder.instance;
    }

    private static class Holder {
        private static final Validex instance = new Validex();
    }

    public boolean isValidPassword(String password) {
        return passwordValidator.isValidPassword(password);
    }

    public String getPasswordStrength(String password) {
        return passwordValidator.getPasswordStrength(password).name();
    }

    public static class PasswordValidatorBuilder {
        private final PasswordValidator.Builder builder;

        public PasswordValidatorBuilder() {
            builder = new PasswordValidator.Builder();
        }

        public PasswordValidatorBuilder setMinLength(int length) {
            builder.setMinLength(length);
            return this;
        }

        public PasswordValidatorBuilder setRequireUppercase(boolean required) {
            builder.setRequireUppercase(required);
            return this;
        }

        public PasswordValidatorBuilder setRequireLowercase(boolean required) {
            builder.setRequireLowercase(required);
            return this;
        }

        public PasswordValidatorBuilder setRequireDigit(boolean required) {
            builder.setRequireDigit(required);
            return this;
        }

        public PasswordValidatorBuilder setRequireSpecialChar(boolean required) {
            builder.setRequireSpecialChar(required);
            return this;
        }

        public PasswordValidator build() {
            return builder.build();
        }
    }

    public boolean isValidEmail(String email) {
        return emailValidator.isValidEmail(email);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String generateUUID() {
        return uuidValidator.generateUUID();
    }

    public boolean isValidUUID(String uuid) {
        return uuidValidator.isValidUUID(uuid);
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumberValidator.isValidPhoneNumber(phoneNumber);
    }

    public Map<String, String> getCountryPrefixes() {
        return phoneNumberValidator.getCountryPrefixes();
    }

    public boolean isValidURL(String url) {
        return urlValidator.isValidURL(url);
    }

    public Map<String, Object> getURLComponents(String url) {
        return urlValidator.getURLComponents(url);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean isValidDateTime(String dateTime, DateTimeValidator.Format format) {
        return dateTimeValidator.isValidDateTime(dateTime, format);
    }

    public DateTimeValidator.Format[] getDateTimeFormats() {
        return DateTimeValidator.Format.values();
    }
}
