package com.nilnadirler.hrms.core.utilities.settings;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;

@Configuration
public class AppConfig {
    @Bean
    public static ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Bean
    public static Cloudinary cloudinary() {
        return new Cloudinary("cloudinary://468154447886835:pttIVHjWUxJSgAWNpQuEawZA4yI@nilnadirler");
    }
}