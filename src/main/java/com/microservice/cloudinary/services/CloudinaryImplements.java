package com.microservice.cloudinary.services;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.microservice.cloudinary.config.cloudinary.UrlCloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class CloudinaryImplements implements ICloudinary{

    @Autowired
    UrlCloudinary cloudinary;

    public Cloudinary context () {
        Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("cloud_name", cloudinary.getCluodName());
        valuesMap.put("api_key", cloudinary.getApiKey());
        valuesMap.put("api_secret", cloudinary.getApiSecret());
        return  new Cloudinary(valuesMap);
    }

    @Override
    public Map<?, ?> upload(MultipartFile multipartFile) throws IOException {
        File file = convert(multipartFile);
        Map<?, ?> result = this.context().uploader().upload(file, ObjectUtils.emptyMap());
        file.delete();
        return result;
    }

    @Override
    public Map<?, ?> delete(String id) throws IOException {
        Map<?, ?> result = this.context().uploader().destroy(id, ObjectUtils.emptyMap());
        return result;
    }

    @Override
    public File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fo = new FileOutputStream(file);
        fo.write(multipartFile.getBytes());
        fo.close();
        return file;
    }
}
