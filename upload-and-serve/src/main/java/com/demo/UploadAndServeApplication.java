package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UploadAndServeApplication {

	public static void main(String[] args) {
		if (!StaticResourceConfiguration.FILES_STORAGE_FOLDER.exists()) {
			StaticResourceConfiguration.FILES_STORAGE_FOLDER.mkdir();
		}
		SpringApplication.run(UploadAndServeApplication.class, args);
	}
}
