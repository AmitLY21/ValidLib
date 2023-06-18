package com.amitdev.validlib;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.amitdev.mylibrary.DateTimeValidator;
import com.amitdev.mylibrary.PasswordValidator;
import com.amitdev.mylibrary.Validex;

import java.util.Arrays;

public class NewActivity extends AppCompatActivity {

    private static final String TAG = "NewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Validex validex = Validex.getInstance();

        // Validate a password
        String password = "password123";
        boolean isPasswordValid = validex.isValidPassword(password);
        Log.d(TAG, "Is Password Valid: " + isPasswordValid);

        // Get password strength
        PasswordValidator.PasswordStrength passwordStrength = PasswordValidator.PasswordStrength.valueOf(validex.getPasswordStrength(password));
        String passwordStrengthDescription = passwordStrength.getDescription();
        Log.d(TAG, "Password Strength: " + passwordStrength.name() + " - " + passwordStrengthDescription);

        // Validate an email address
        String email = "example@example.com";
        boolean isEmailValid = validex.isValidEmail(email);
        Log.d(TAG, "Is Email Valid: " + isEmailValid);

        // Generate a UUID
        String uuid = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            uuid = validex.generateUUID();
        }
        Log.d(TAG, "Generated UUID: " + uuid);

        // Validate a UUID
        String invalidUUID = "invalid-uuid";
        boolean isUUIDValid = validex.isValidUUID(invalidUUID);
        Log.d(TAG, "Is UUID Valid: " + isUUIDValid);

        // Validate a phone number
        String phoneNumber = "+1234567890";
        boolean isPhoneNumberValid = validex.isValidPhoneNumber(phoneNumber);
        Log.d(TAG, "Is Phone Number Valid: " + isPhoneNumberValid);

        // Get country prefixes for phone numbers
        Log.d(TAG, "Country Prefixes: " + validex.getCountryPrefixes());

        // Validate a URL
        String url = "https://example.com";
        boolean isURLValid = validex.isValidURL(url);
        Log.d(TAG, "Is URL Valid: " + isURLValid);

        // Get components of a URL
        Log.d(TAG, "URL Components: " + validex.getURLComponents(url));

        // Validate a date and time string
        String dateTime = "2023-06-18 10:30:00";
        DateTimeValidator.Format format = validex.getDateTimeFormats()[0];
        boolean isDateTimeValid = false;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            isDateTimeValid = validex.isValidDateTime(dateTime, format);
        }
        Log.d(TAG, "Is Date and Time Valid: " + isDateTimeValid);

        // Get available date and time formats
        Log.d(TAG, "Date and Time Formats: " + Arrays.toString(validex.getDateTimeFormats()));
    }
}
