package com.kodlamaio.hrmsDemo4.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrmsDemo4.business.abstracts.JobAdvertisementService;
import com.kodlamaio.hrmsDemo4.core.utilities.result.concretes.DataResult;
import com.kodlamaio.hrmsDemo4.core.utilities.result.concretes.Result;
import com.kodlamaio.hrmsDemo4.core.utilities.result.concretes.SuccessDataResult;
import com.kodlamaio.hrmsDemo4.core.utilities.result.concretes.SuccessResult;
import com.kodlamaio.hrmsDemo4.dataAccess.abstracts.JobAdvertisementDao;
import com.kodlamaio.hrmsDemo4.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	
	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;
	}
	
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Yeni iş ilanı başarıyla eklendi.");
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getByActivated() {
		return new SuccessDataResult<List<JobAdvertisement>>("Aktif iş ilanları listelendi.", this.jobAdvertisementDao.findByActiveTrue());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByActivatedOrderByReleaseDateAsc() {
		return new SuccessDataResult<List<JobAdvertisement>>("Aktif iş ilanları listelendi.", this.jobAdvertisementDao.findByActiveTrueOrderByReleaseDateAsc());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByActivatedOrderByApplicationDeadlineAsc() {
		return new SuccessDataResult<List<JobAdvertisement>>("Aktif iş ilanları listelendi.", this.jobAdvertisementDao.findByActiveTrueOrderByApplicationDeadlineAsc());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByActivatedAndEmployerId(Integer id) {
		return new SuccessDataResult<List<JobAdvertisement>>("Aktif iş ilanları listelendi.", this.jobAdvertisementDao.findByActiveTrueAndEmployerId(id));
	}

	@Override
	public Result activateJobAdvertisement(Integer id) {
		JobAdvertisement j = this.jobAdvertisementDao.findById(id).get();
		j.setActive(true);
		this.jobAdvertisementDao.save(j);
		return new SuccessResult("İş ilanı başarıyla aktif edildi");
	}

	@Override
	public Result deactivateJobAdvertisement(Integer id) {
		JobAdvertisement j = this.jobAdvertisementDao.findById(id).get();
		j.setActive(false);
		this.jobAdvertisementDao.save(j);
		return new SuccessResult("İş ilanı başarıyla pasif edildi");
	}
	
}
