package com.mazharulsabbir.fieldbuzz.applicant.assignment.data.model;

public class ErrorResponse {
    String message;
    boolean success;

    public ErrorResponse() {
    }

    public ErrorResponse(String message, boolean success) {
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

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "message='" + message + '\'' +
                ", success=" + success +
                '}';
    }
}
