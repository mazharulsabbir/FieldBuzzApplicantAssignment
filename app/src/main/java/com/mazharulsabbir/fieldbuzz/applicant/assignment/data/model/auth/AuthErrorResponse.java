package com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model.auth;

public class AuthErrorResponse {
    String message;
    boolean success;

    public AuthErrorResponse() {
    }

    public AuthErrorResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
