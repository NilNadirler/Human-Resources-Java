package com.nilnadirler.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nilnadirler.hrms.business.abstracts.CvService;
import com.nilnadirler.hrms.core.abstracts.FileUploadService;
import com.nilnadirler.hrms.core.utilities.resuts.DataResult;
import com.nilnadirler.hrms.core.utilities.resuts.ErrorResult;
import com.nilnadirler.hrms.core.utilities.resuts.Result;
import com.nilnadirler.hrms.core.utilities.resuts.SuccessDataResult;
import com.nilnadirler.hrms.core.utilities.resuts.SuccessResult;
import com.nilnadirler.hrms.dataAccess.abstracts.CvDao;
import com.nilnadirler.hrms.entities.concretes.Cv;
import com.nilnadirler.hrms.entities.dtos.CvSaveDto;

@Service
public class CvManager implements CvService{

	private CvDao cvDao;
	private FileUploadService fileUploadService;


	@Autowired
	public CvManager(CvDao cvDao, FileUploadService fileUploadService) {
		this.cvDao = cvDao;
		this.fileUploadService = fileUploadService;
	}

	@Override
	public Result add(CvSaveDto cvSaveDto) {
		String photo=this.fileUploadService.UploadPhoto(cvSaveDto.getPhoto());
		if(photo==null) {
			return new ErrorResult("Photo is not uploaded. Please try again..");
		}
		Cv cv= new Cv();
		cv.setCoverLetter(cvSaveDto.getCoverLetter());
		cv.setPhoto(photo);
		this.cvDao.save(cv);
		return new SuccessResult("Added");
		
		

	}

	@Override
	public DataResult<List<Cv>> getAll() {
		
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll());
	}
	
	

}
