package com.nilnadirler.hrms.business.abstracts;

import java.util.List;

import com.nilnadirler.hrms.core.utilities.resuts.DataResult;
import com.nilnadirler.hrms.core.utilities.resuts.Result;
import com.nilnadirler.hrms.entities.dtos.LanguageLevelDto;
import com.nilnadirler.hrms.entities.dtos.LanguageLevelSaveDto;


public interface LanguageService {

	DataResult<List<LanguageLevelDto>> getAll();
	Result add(LanguageLevelSaveDto languageSaveDto);
}
