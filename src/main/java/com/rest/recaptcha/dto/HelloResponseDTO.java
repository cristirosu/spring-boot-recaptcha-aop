package com.rest.recaptcha.dto;

public class HelloResponseDTO {

    private String message;

    public HelloResponseDTO() {
    }

    public HelloResponseDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
