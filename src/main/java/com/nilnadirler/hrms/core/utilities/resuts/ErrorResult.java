package com.nilnadirler.hrms.core.utilities.resuts;

public class ErrorResult extends Result {

	public ErrorResult() {
		super(false);
		
	}
	public ErrorResult(String message) {
		super(false,message);
		
	}

}
