package com.kodlamaio.hrmsDemo4.core.utilities.result.concretes;

public class SuccessResult extends Result {
	
	public SuccessResult() {
		super(true);
	}
	
	public SuccessResult(String infoMessage) {
		super(true, infoMessage);
	}
	
}
