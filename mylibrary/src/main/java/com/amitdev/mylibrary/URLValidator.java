package com.amitdev.mylibrary;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class URLValidator {
    private static final URLValidator instance = new URLValidator();

    private URLValidator() {
    }

    public static URLValidator getInstance() {
        return instance;
    }

    public boolean isValidURL(String url) {
        if (!url.matches("^https?://.+")) {
            return false;
        }

        try {
            URL urlObj = new URL(url);

            String scheme = urlObj.getProtocol();
            if (!"http".equals(scheme) && !"https".equals(scheme)) {
                return false;
            }

            String domain = urlObj.getHost();
            if (!domain.matches("^[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                return false;
            }

            String path = urlObj.getPath();

            String queryParams = urlObj.getQuery();
            if (queryParams != null) {
                String[] parameters = queryParams.split("&");
                boolean hasSortParameter = false;
                for (String parameter : parameters) {
                    if (parameter.startsWith("sort=")) {
                        hasSortParameter = true;
                        break;
                    }
                }
                if (!hasSortParameter) {
                    return false;
                }
            }

            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }

    public Map<String, Object> getURLComponents(String url) {
        try {
            URL urlObj = new URL(url);

            String scheme = urlObj.getProtocol();
            String domain = urlObj.getHost();
            String queryParams = urlObj.getQuery();

            Map<String, Object> urlComponents = new HashMap<>();
            urlComponents.put("scheme", scheme);
            urlComponents.put("domain", domain);

            if (queryParams != null) {
                Map<String, String> queryParamMap = new HashMap<>();
                String[] parameters = queryParams.split("&");
                for (String parameter : parameters) {
                    String[] keyValue = parameter.split("=");
                    if (keyValue.length == 2) {
                        String key = keyValue[0];
                        String value = keyValue[1];
                        queryParamMap.put(key, value);
                    }
                }
                urlComponents.put("queryParams", queryParamMap);
            }

            return urlComponents;
        } catch (MalformedURLException e) {
            return null;
        }
    }
}
