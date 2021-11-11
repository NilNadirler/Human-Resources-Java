package com.nilnadirler.hrms.core.concretes;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.nilnadirler.hrms.core.abstracts.FileUploadService;
import com.nilnadirler.hrms.entegrations.CloudinaryEntegration;

@Service
public class FileUploadAdapter implements FileUploadService {

	@Override
	public String UploadPhoto(File photo) {
		try {
			CloudinaryEntegration cloudinaryEntegration = new CloudinaryEntegration();
			return cloudinaryEntegration.LoadPhoto(photo);
		} catch (IOException e) {
			return null;
		}
	}

}
