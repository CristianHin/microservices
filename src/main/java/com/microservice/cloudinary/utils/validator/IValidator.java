package com.microservice.cloudinary.utils.validator;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface IValidator {

    void validatorImage(MultipartFile multipartFile) throws IOException;
}
