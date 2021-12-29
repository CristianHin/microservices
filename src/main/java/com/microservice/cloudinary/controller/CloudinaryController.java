package com.microservice.cloudinary.controller;

import com.microservice.cloudinary.services.ICloudinary;
import com.microservice.cloudinary.utils.Answers.AnswerData;
import com.microservice.cloudinary.utils.Answers.AnswerNotData;
import com.microservice.cloudinary.utils.validator.IValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;


@RestController
public class CloudinaryController {

    @Autowired
    ICloudinary cloudinary;

    @Autowired
    IValidator validator;

    @PostMapping(value="/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> uploadImage(MultipartFile multipartFile) throws IOException {
        validator.validatorImage(multipartFile);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new AnswerData(HttpStatus.ACCEPTED, Optional.of(cloudinary.upload(multipartFile))));
    }

    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<Object> deleteImage( @PathVariable String id) throws IOException {
        Map<?,?> result = this.cloudinary.delete(id);
        if (result.get("result") == "ok"){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new AnswerNotData(HttpStatus.NOT_FOUND,"Imágen no encontrada"));
        }
        return ResponseEntity.ok(new AnswerNotData(HttpStatus.ACCEPTED,"Imágen eliminada") );

    }
}
