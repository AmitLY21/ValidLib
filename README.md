# ValidLib - Data Validation Library
<p> 🔒 ValidLib is a powerful data validation library that provides convenient and reliable validation functionalities for various data types such as passwords, email addresses, phone numbers, URLs, and more.<br> It aims to simplify data validation in your Android applications, ensuring data integrity and accuracy.</p>

## Features
<ul>
  <li>✨ Password validation and strength determination</li>
  <li>✉️ Email address validation</li>
  <li>🔑 UUID generation and validation</li>
  <li>📞 Phone number validation</li>
  <li>🌐 URL validation and component extraction</li>
  <li>⏰ Date and time validation</li>
</ul>

## Getting Started
To start using ValidLib in your Android project, follow these steps:

### Step 1: Add the JitPack repository
Add the following repository to your project-level build.gradle file:
``` groovy
allprojects {
    repositories {
        // other repositories
        maven { url 'https://jitpack.io' }
    }
}
```

### Step 2: Add the ValidLib dependency
Add the ValidLib dependency to your module-level build.gradle file:
``` groovy
dependencies {
    implementation 'com.github.YourUsername:ValidLib:1.0.0'
}
```

### Step 3: Sync your project
Sync your project with Gradle to download the ValidLib library.

### Usage
ValidLib provides a simple and intuitive API for validating various data types.<br>Here are some examples of how to use ValidLib in your application:

#### Password Validation
``` Java
Validex validex = Validex.getInstance();

String password = "MySecretPassword123";

// Validate password
boolean isPasswordValid = validex.isValidPassword(password, PasswordValidator.PasswordStrength.MEDIUM.name());
Log.d(TAG, "Is Password Valid: " + isPasswordValid);

// Get password strength
String passwordStrength = validex.getPasswordStrength(password);
Log.d(TAG, "Password Strength: " + passwordStrength);
```

#### Email Validation
``` Java
Validex validex = Validex.getInstance();

String email = "example@example.com";

// Validate email
boolean isEmailValid = validex.isValidEmail(email);
Log.d(TAG, "Is Email Valid: " + isEmailValid);
``` 

#### UUID Generation and Validation
``` Java
Validex validex = Validex.getInstance();

// Generate UUID
String uuid = validex.generateUUID();
Log.d(TAG, "Generated UUID: " + uuid);

String invalidUUID = "invalid-uuid";

// Validate UUID
boolean isUUIDValid = validex.isValidUUID(invalidUUID);
Log.d(TAG, "Is UUID Valid: " + isUUIDValid);
``` 
#### Phone Number Validation
``` Java
Validex validex = Validex.getInstance();

String phoneNumber = "+1234567890";

// Validate phone number
boolean isPhoneNumberValid = validex.isValidPhoneNumber(phoneNumber);
Log.d(TAG, "Is Phone Number Valid: " + isPhoneNumberValid);
```

#### URL Validation and Component Extraction
``` Java
Validex validex = Validex.getInstance();

String url = "https://example.com";

// Validate URL
boolean isURLValid = validex.isValidURL(url);
Log.d(TAG, "Is URL Valid: " + isURLValid);

// Get URL components
Map<String, Object> urlComponents = validex.getURLComponents(url);
Log.d(TAG, "URL Components: " + urlComponents);
```

#### Date and Time Validation
``` Java
Validex validex = Validex.getInstance();

String dateTime = "2023-06-18 10:30:00";
DateTimeValidator.Format format = validex.getDateTimeFormats()[0];

// Validate date and time
boolean isDateTimeValid = validex.isValidDateTime(dateTime, format);
Log.d(TAG, "Is Date and Time Valid: " + isDateTimeValid);

// Get available date and time formats
Log.d(TAG, "Date and Time Formats: " + Arrays.toString(validex.getDateTimeFormats()));
```

#### Contributing
Contributions to ValidLib are welcome! If you encounter any issues or have suggestions for improvements, please create an issue on the GitHub repository.
