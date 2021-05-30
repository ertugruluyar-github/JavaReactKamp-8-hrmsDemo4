package com.kodlamaio.hrmsDemo4.business.abstracts;

import java.util.List;

import com.kodlamaio.hrmsDemo4.core.utilities.result.concretes.DataResult;
import com.kodlamaio.hrmsDemo4.entities.concretes.City;

public interface CityService {
	DataResult<List<City>> getAll();
}
