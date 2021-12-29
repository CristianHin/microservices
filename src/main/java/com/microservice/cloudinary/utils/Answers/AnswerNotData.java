package com.microservice.cloudinary.utils.Answers;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class AnswerNotData {

    private Date timestamp;
    private HttpStatus status;
    private String message;

    public AnswerNotData( HttpStatus status, String message) {
        this.timestamp = new Date();
        this.status = status;
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
