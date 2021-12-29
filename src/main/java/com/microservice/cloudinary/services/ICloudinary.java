package com.microservice.cloudinary.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public interface ICloudinary {
    public Map<?, ?> upload(MultipartFile multipartFile) throws IOException;
    public Map<?, ?> delete(String id) throws IOException;
    public File convert(MultipartFile multipartFile) throws IOException;
}
