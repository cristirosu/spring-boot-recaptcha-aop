package com.rest.recaptcha.service.model;

public class CaptchaRequest {

    private String secret;
    private String response;

    public CaptchaRequest() {
    }

    public CaptchaRequest(String secret, String response) {
        this.secret = secret;
        this.response = response;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
