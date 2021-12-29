package com.microservice.cloudinary.config.cloudinary;

public class UrlCloudinary {

    String cluodName;
    String apiKey;
    String apiSecret;

    public UrlCloudinary(String cluodName, String apiKey, String apiSecret) {
        this.cluodName = cluodName;
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
    }

    public String getCluodName() {
        return cluodName;
    }

    public void setCluodName(String cluodName) {
        this.cluodName = cluodName;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
    }
}
