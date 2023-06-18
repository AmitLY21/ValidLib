package com.amitdev.mylibrary;

import java.util.HashMap;
import java.util.Map;

public class PhonenumberValidator {
    private final Map<String, String> countryPrefixes = new HashMap<>();

    private PhonenumberValidator() {
        countryPrefixes.put("AFG", "+93");
        countryPrefixes.put("ARE", "+971");
        countryPrefixes.put("ARG", "+54");
        countryPrefixes.put("AUS", "+61");
        countryPrefixes.put("AUT", "+43");
        countryPrefixes.put("BEL", "+32");
        countryPrefixes.put("BRA", "+55");
        countryPrefixes.put("CAN", "+1");
        countryPrefixes.put("CHE", "+41");
        countryPrefixes.put("CHL", "+56");
        countryPrefixes.put("CHN", "+86");
        countryPrefixes.put("COL", "+57");
        countryPrefixes.put("CZE", "+420");
        countryPrefixes.put("DEU", "+49");
        countryPrefixes.put("DNK", "+45");
        countryPrefixes.put("EGY", "+20");
        countryPrefixes.put("ESP", "+34");
        countryPrefixes.put("FIN", "+358");
        countryPrefixes.put("FRA", "+33");
        countryPrefixes.put("GBR", "+44");
        countryPrefixes.put("GRC", "+30");
        countryPrefixes.put("HKG", "+852");
        countryPrefixes.put("HUN", "+36");
        countryPrefixes.put("IDN", "+62");
        countryPrefixes.put("IND", "+91");
        countryPrefixes.put("IRL", "+353");
        countryPrefixes.put("ISR", "+972");
        countryPrefixes.put("ITA", "+39");
        countryPrefixes.put("JPN", "+81");
        countryPrefixes.put("KOR", "+82");
        countryPrefixes.put("LKA", "+94");
        countryPrefixes.put("MEX", "+52");
        countryPrefixes.put("MYS", "+60");
        countryPrefixes.put("NGA", "+234");
        countryPrefixes.put("NLD", "+31");
        countryPrefixes.put("NOR", "+47");
        countryPrefixes.put("NZL", "+64");
        countryPrefixes.put("PAK", "+92");
        countryPrefixes.put("PER", "+51");
        countryPrefixes.put("PHL", "+63");
        countryPrefixes.put("POL", "+48");
        countryPrefixes.put("PRT", "+351");
        countryPrefixes.put("ROU", "+40");
        countryPrefixes.put("RUS", "+7");
        countryPrefixes.put("SAU", "+966");
        countryPrefixes.put("SGP", "+65");
        countryPrefixes.put("SWE", "+46");
        countryPrefixes.put("THA", "+66");
        countryPrefixes.put("TUR", "+90");
        countryPrefixes.put("TWN", "+886");
        countryPrefixes.put("UKR", "+380");
        countryPrefixes.put("USA", "+1");
        countryPrefixes.put("VEN", "+58");
        countryPrefixes.put("VNM", "+84");
        countryPrefixes.put("ZAF", "+27");
        // Add more country prefixes here
    }

    private static final PhonenumberValidator instance = new PhonenumberValidator();

    public static PhonenumberValidator getInstance() {
        return instance;
    }

    public Map<String, String> getCountryPrefixes() {
        return countryPrefixes;
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        String cleanedNumber = phoneNumber.replaceAll("\\D", "");

        // Extract the country prefix from the cleaned number
        String countryPrefix = cleanedNumber.substring(0, 3);

        // Check if the extracted country prefix exists in the map
        if (countryPrefixes.containsKey(countryPrefix)) {
            // Perform additional validation as per your requirements
            // For example, check the length, format, etc.

            // Return true if the cleaned number meets your validation criteria
            return cleanedNumber.length() >= 10;
        }

        return false;
    }
}
