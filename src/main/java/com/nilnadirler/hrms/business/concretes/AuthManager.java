package com.nilnadirler.hrms.business.concretes;



import java.util.ArrayList;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nilnadirler.hrms.business.abstracts.AuthService;

import com.nilnadirler.hrms.business.abstracts.UserService;
import com.nilnadirler.hrms.core.abstracts.MailService;
import com.nilnadirler.hrms.core.utilities.generators.KeyGenerator;
import com.nilnadirler.hrms.core.utilities.resuts.DataResult;
import com.nilnadirler.hrms.core.utilities.resuts.ErrorDataResult;
import com.nilnadirler.hrms.core.utilities.resuts.ErrorResult;
import com.nilnadirler.hrms.core.utilities.resuts.Result;
import com.nilnadirler.hrms.core.utilities.resuts.SuccessDataResult;
import com.nilnadirler.hrms.core.utilities.resuts.SuccessResult;
import com.nilnadirler.hrms.core.utilities.settings.AppConfig;
import com.nilnadirler.hrms.entities.concretes.User;
import com.nilnadirler.hrms.entities.concretes.VerificationCode;
import com.nilnadirler.hrms.entities.dtos.CandidateForRegisterDto;
import com.nilnadirler.hrms.entities.dtos.EmployerForRegisterDto;
import com.nilnadirler.hrms.entities.dtos.ValidateVerificationCodeDto;


@Service
public class AuthManager implements AuthService {

	UserService userService;

	MailService mailService;

	@Autowired
	public AuthManager(UserService userService, MailService mailService) {
		super();
		this.userService = userService;
		this.mailService = mailService;

	}

	@Override
	public DataResult<User> registerForCandidate(CandidateForRegisterDto dto) {
		User user=AppConfig.modelMapper().map(dto, User.class);
		 if(!this.validatePassword(user.getPassword())) {
			 //return new ErrorDataResult<User>(null,"Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character.");
		 }
		Result uniqueResult= this.userService.existsByEmail(user.getEmail());
		if(!uniqueResult.isSuccess() && dto.getPassword()!=dto.getRePassword()) {
			return new ErrorDataResult<User>(null,uniqueResult.getMessage());
		}
        String key =KeyGenerator.Generate(6);
        mailService.Send(user.getEmail(), "Verification Code: "+key);
        List<VerificationCode> codeList= new ArrayList<VerificationCode>();
        codeList.add(new VerificationCode(user,key));
        user.setVerificationCodes(codeList);
        user.getCandidate().setIsActivate(false);
		this.userService.add(user);
        return new SuccessDataResult<User>(user,"Candidated registered");

	}
	
	@Override
	public DataResult<User> registerForEmployer(EmployerForRegisterDto dto) {
		 User user = AppConfig.modelMapper().map(dto, User.class);
		 if(!this.validatePassword(user.getPassword())) {
			 //return new ErrorDataResult<User>(null,"Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character.");
		 }
		 Result uniqueResult = this.userService.existsByEmail(user.getEmail());
		 if(!uniqueResult.isSuccess() && dto.getPassword()!=dto.getRepassword()) {
			return new ErrorDataResult<User>(null,uniqueResult.getMessage());
		}
		 String emailExt=user.getEmail().split("@")[1];
		 if(!user.getEmployer().getDomain().contains(emailExt)) {
			 return new ErrorDataResult<User>(null,"Email domain ile eşleşmiyor.");
		 }
        String key =KeyGenerator.Generate(6);
        mailService.Send(user.getEmail(), "Verification Code: "+key);
        List<VerificationCode> codeList= new ArrayList<VerificationCode>();
        codeList.add(new VerificationCode(user,key));
        user.setVerificationCodes(codeList);
        user.getEmployer().setIsActivate(false);
		this.userService.add(user);
	     return new SuccessDataResult<User>(user,"Employer is registered");
	}

	@Override
	public DataResult<User> login() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean validatePassword(String password) {
		Pattern VALID_PASSWORD_CONTAINS=
				Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",Pattern.CASE_INSENSITIVE);
		return VALID_PASSWORD_CONTAINS.matcher(password).matches();
		
	}

	@Override
	public Result validateVerificationCode(ValidateVerificationCodeDto dto) {
		User user=this.userService.getByEmail(dto.getEmail()).getData();
		int index = 0;
		if(user.getCandidate()!=null && user.getCandidate().getIsActivate()) {
			return new ErrorResult("This user already activated.");
		}
		if(user.getEmployer()!=null && user.getEmployer().getIsActivate()) {
			return new ErrorResult("This user already activated.");
		}
		for (VerificationCode verificationCode : user.getVerificationCodes()) {
			if(verificationCode.getCode().equals(dto.getCode())&&!verificationCode.getStatus()) {
				if(user.getCandidate()!=null)
					user.getCandidate().setIsActivate(true);
				if(user.getEmployer()!=null)
					user.getEmployer().setIsActivate(true);
				user.getVerificationCodes().get(index).setStatus(true);
				this.userService.update(user);
				return new SuccessResult("Verification is successfull");
			}
			index++;
		}
		return new ErrorResult("Email or Verification Code not finded");
	}

	
}
