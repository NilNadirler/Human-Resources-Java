package com.nilnadirler.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nilnadirler.hrms.business.abstracts.LanguageService;
import com.nilnadirler.hrms.core.utilities.resuts.DataResult;
import com.nilnadirler.hrms.core.utilities.resuts.Result;
import com.nilnadirler.hrms.core.utilities.resuts.SuccessDataResult;
import com.nilnadirler.hrms.core.utilities.resuts.SuccessResult;
import com.nilnadirler.hrms.core.utilities.settings.AppConfig;
import com.nilnadirler.hrms.dataAccess.abstracts.LanguageDao;

import com.nilnadirler.hrms.entities.concretes.Language;
import com.nilnadirler.hrms.entities.dtos.LanguageLevelDto;
import com.nilnadirler.hrms.entities.dtos.LanguageLevelSaveDto;


@Service
public class LanguageManager implements LanguageService {

	@Autowired
	private LanguageDao languageDao;
	
	@Override
	public DataResult<List<LanguageLevelDto>> getAll() {
		return new SuccessDataResult<List<LanguageLevelDto>>(this.languageDao.findAll().stream()
				.map(item->AppConfig.modelMapper().map(item, LanguageLevelDto.class))
				.collect(Collectors.toList()));
	}

	@Override
	public Result add(LanguageLevelSaveDto languageSaveDto) {

		Language language= AppConfig.modelMapper().map(languageSaveDto, Language.class);
		this.languageDao.save(language);
		return new SuccessResult("Success");
	}

}
