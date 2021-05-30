package com.kodlamaio.hrmsDemo4.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrmsDemo4.business.abstracts.JobAdvertisementService;
import com.kodlamaio.hrmsDemo4.core.utilities.result.concretes.DataResult;
import com.kodlamaio.hrmsDemo4.core.utilities.result.concretes.Result;
import com.kodlamaio.hrmsDemo4.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("jobadvertisements")
public class JobAdvertisementController {
	
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@PostMapping("add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("getallactivated")
	public DataResult<List<JobAdvertisement>> getAllActivated() {
		return this.jobAdvertisementService.getByActivated();
	}
	
	@GetMapping("getallactivatedorderbyreleasedateasc")
	public DataResult<List<JobAdvertisement>> getByActivatedOrderByReleaseDateAsc() {
		return this.jobAdvertisementService.getByActivatedOrderByReleaseDateAsc();
	}	

	@GetMapping("getallactivatedorderbyapplicationdeadlineasc")
	public DataResult<List<JobAdvertisement>> getByActivatedOrderByApplicationDeadlineAsc() {
		return this.jobAdvertisementService.getByActivatedOrderByApplicationDeadlineAsc();
	}		
	
	@GetMapping("getallactivatedandemployerid")
	public DataResult<List<JobAdvertisement>> getByActivatedAndEmployerId(@RequestParam(name = "id") Integer id) {
		return this.jobAdvertisementService.getByActivatedAndEmployerId(id);
	}
	
	@GetMapping("activatejobadvertisement")
	public Result activateJobAdvertisement(Integer id) {
		return this.jobAdvertisementService.activateJobAdvertisement(id);
	}
	
	@GetMapping("deactivatejobadvertisement")
	public Result deactivateJobAdvertisement(Integer id) {
		return this.jobAdvertisementService.deactivateJobAdvertisement(id);
	}
	
}
