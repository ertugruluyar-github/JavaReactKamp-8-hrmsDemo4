package com.kodlamaio.hrmsDemo4.business.abstracts;

import java.util.List;

import com.kodlamaio.hrmsDemo4.core.utilities.result.concretes.DataResult;
import com.kodlamaio.hrmsDemo4.core.utilities.result.concretes.Result;
import com.kodlamaio.hrmsDemo4.entities.concretes.EmployeePosition;

public interface EmployeePositionService {
	DataResult<List<EmployeePosition>> getAll();
	DataResult<EmployeePosition> get(int id);
	Result add(EmployeePosition employeePosition);
	Result delete(int id);
	Result update(EmployeePosition employeePosition);
	boolean existsEmployeePositionByPositionName(String positionName);
}
