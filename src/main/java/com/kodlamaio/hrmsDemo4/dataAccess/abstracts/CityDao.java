package com.kodlamaio.hrmsDemo4.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodlamaio.hrmsDemo4.entities.concretes.City;

@Repository
public interface CityDao extends JpaRepository<City, Integer> {

}
