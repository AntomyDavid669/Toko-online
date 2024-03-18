package com.projectbaru.TokoOnline.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ImageConfig implements WebMvcConfigurer{
    //resourseshandler
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path = new FileSystemResource("").getFile().getAbsolutePath();
        path += "\\uploads\\";

        // func to open path "localhost/images/..."
        // get the file from uploads folder
        registry.addResourceHandler("/images/**").addResourceLocations("file:///" +path);

        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}