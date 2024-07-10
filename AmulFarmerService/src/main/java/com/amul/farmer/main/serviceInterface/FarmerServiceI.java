package com.amul.farmer.main.serviceInterface;


import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.amul.farmer.main.model.FarmerDetails;


public interface FarmerServiceI {


	public FarmerDetails SaveFarmerData(String farmerJson, MultipartFile adhar, MultipartFile cowImage,
			MultipartFile buffaloImage);

	public List<FarmerDetails> fetchAllDataFarmer();

	public FarmerDetails displaySingleDataByFarmerId(int farmerId);

	
  
	}

