package com.amul.farmer.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amul.farmer.main.model.FarmerDetails;

@Repository
public interface FarmerRepository extends CrudRepository<FarmerDetails, Integer>{

	

}

