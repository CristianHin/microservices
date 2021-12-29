package com.microservice.cloudinary.utils.Exceptions;

import com.microservice.cloudinary.utils.Answers.AnswerNotData;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ApiImageInvalid extends RuntimeException{

    AnswerNotData answerNotData;

    public ApiImageInvalid(AnswerNotData answerNotData){
        this.answerNotData = answerNotData;
    }


    public AnswerNotData getAnswerNotData() {
        return answerNotData;
    }

    public void setAnswerNotData(AnswerNotData answerNotData) {
        this.answerNotData = answerNotData;
    }
}
