package com.amul.farmer.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.amul.farmer.main.serviceInterface.FarmerServiceI;

@RestController
public class FarmerController {
	@Autowired FarmerServiceI farmerInterface;
	
	
}
