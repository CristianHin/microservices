package com.microservice.cloudinary.utils.Exceptions;

import com.microservice.cloudinary.utils.Answers.AnswerNotData;
import org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ApiImageInvalid.class)
    public ResponseEntity<Object> apiImageInvalid(ApiImageInvalid error){
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(error.getAnswerNotData());
    }

    @ExceptionHandler(SizeLimitExceededException.class)
    public ResponseEntity<Object> error(){
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new AnswerNotData(HttpStatus.NOT_ACCEPTABLE,"El archivo debe ser una imágen"));
    }
}
