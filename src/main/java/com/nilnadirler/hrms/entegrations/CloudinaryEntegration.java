package com.nilnadirler.hrms.entegrations;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.cloudinary.utils.ObjectUtils;
import com.nilnadirler.hrms.core.utilities.settings.AppConfig;

public class CloudinaryEntegration {

	@SuppressWarnings("unchecked")
	public String LoadPhoto(File photo) throws IOException{
			Map<String, Object> uploadResult = AppConfig.cloudinary().uploader()
					.upload(photo, ObjectUtils.emptyMap());
			return uploadResult.get("secure_url").toString();
	}
}
