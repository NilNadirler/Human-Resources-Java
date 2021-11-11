package com.nilnadirler.hrms.entegrations;

public class MailEntegration {
	public boolean SendMail(String mailAddress,String content) {
		System.out.println("Mail adresi: "+mailAddress);
		System.out.println("içerik: "+content);
		return true;
	}
}
