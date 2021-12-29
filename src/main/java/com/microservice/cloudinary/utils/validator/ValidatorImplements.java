package com.microservice.cloudinary.utils.validator;

import com.microservice.cloudinary.utils.Answers.AnswerNotData;
import com.microservice.cloudinary.utils.Exceptions.ApiImageInvalid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Component
public class ValidatorImplements implements IValidator{
    @Override
    public void validatorImage(MultipartFile multipartFile) throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if(bi == null){
            throw new ApiImageInvalid(new AnswerNotData(HttpStatus.NOT_ACCEPTABLE,"El archivo debe ser una imágen"));
        }
    }
}
