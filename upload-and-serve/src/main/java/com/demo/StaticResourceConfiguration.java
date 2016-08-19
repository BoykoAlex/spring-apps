package com.demo;

import java.io.File;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan
public class StaticResourceConfiguration extends WebMvcConfigurerAdapter {
	
	public static final File FILES_STORAGE_FOLDER = new File("./ide");

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/ide/**").addResourceLocations(FILES_STORAGE_FOLDER.toURI().toString());
        super.addResourceHandlers(registry);
    }
    
}