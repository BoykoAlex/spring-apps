package com.demo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class RestApi {

	@RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
	public String uploadFile(@RequestParam(value = "files[]") MultipartFile[] files) {

		for (int i = 0; i < files.length; i++) {

			MultipartFile file = files[i];

			if (file.isEmpty()) {
				continue;
			}

			File localFile = new File(StaticResourceConfiguration.FILES_STORAGE_FOLDER, file.getOriginalFilename());

			if (!localFile.exists()) {
				try {
					localFile.createNewFile();
				} catch (IOException e) {
					System.out.println("Cannot create file " + localFile.toString());
				}
			}

			try {
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(localFile));
				byte[] bytes = file.getBytes();
				stream.write(bytes);
				stream.close();
				System.out.println("Success!");
			} catch (Exception e) {
				System.out.println("Failure... " + e.getMessage());
			}
		}
		
		return "upload";
	}
}
