package com.microservice.cloudinary.config.cloudinary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("cloudinary.properties")
public class Cloudinary {

    @Autowired
    Environment env;

    @Bean
    public UrlCloudinary urlCloudinary(){
        return new UrlCloudinary(env.getProperty("cloud_name"), env.getProperty("api_key"), env.getProperty("api_secret"));
    }
}
