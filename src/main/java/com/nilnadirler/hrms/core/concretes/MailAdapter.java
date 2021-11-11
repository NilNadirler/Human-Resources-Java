package com.nilnadirler.hrms.core.concretes;

import org.springframework.stereotype.Service;

import com.nilnadirler.hrms.core.abstracts.MailService;
import com.nilnadirler.hrms.entegrations.MailEntegration;

@Service
public class MailAdapter implements MailService {

	@Override
	public boolean Send(String mailAddress, String content) {
		
		MailEntegration mailEntegration= new MailEntegration();
		return mailEntegration.SendMail(mailAddress, content);
		
		
	}

}
