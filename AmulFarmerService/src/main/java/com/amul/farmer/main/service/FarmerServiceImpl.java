package com.amul.farmer.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amul.farmer.main.repository.FarmerRepository;
import com.amul.farmer.main.serviceInterface.FarmerServiceI;

@Service
public class FarmerServiceImpl implements FarmerServiceI{
	@Autowired private FarmerRepository farmerRepository;

}
