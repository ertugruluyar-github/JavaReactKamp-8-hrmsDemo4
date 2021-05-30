package com.kodlamaio.hrmsDemo4.core.validators.systemEmployeeVerify.abstracts;

import com.kodlamaio.hrmsDemo4.entities.concretes.Employer;

public interface SystemEmployeeVerifyService {
	boolean hasVerifyBySystemEmployee(Employer employer);
}
