package com.microservice.cloudinary.utils.Answers;

import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.Optional;

public class AnswerData {

    private Date timestamp ;
    private HttpStatus status;
    private Optional<Object> data;



    public AnswerData( HttpStatus status, Optional<Object> data) {
        this.timestamp = new Date();
        this.status = status;
        this.data = Optional.of(data.orElse("[]"));
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

    public Optional<Object> getData() {
        return data;
    }

    public void setData(Optional<Object> data) {
        this.data = data;
    }
}
