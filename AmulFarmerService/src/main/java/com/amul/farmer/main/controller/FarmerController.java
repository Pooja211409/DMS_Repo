package com.amul.farmer.main.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amul.farmer.main.model.FarmerDetails;
import com.amul.farmer.main.serviceInterface.FarmerServiceI;

@RestController
public class FarmerController {

	@Autowired private FarmerServiceI farmerInterface;

	@PostMapping("/InsertFarmer")
	public ResponseEntity<FarmerDetails>postdetails(@RequestPart ("farmer")String farmerJson,
			@RequestPart(value="adhar",required = false)MultipartFile adhar,
			@RequestPart(value="cowImage",required = false)MultipartFile cowImage,
			@RequestPart(value="buffaloImage",required = false)MultipartFile buffaloImage){
			
		FarmerDetails fd=farmerInterface.SaveFarmerData(farmerJson,adhar,cowImage,buffaloImage);
		return new ResponseEntity<FarmerDetails>(fd,HttpStatus.CREATED);
	}

	@GetMapping("/AllFarmerData")
	public List<FarmerDetails>fetchAllDataFarmer(){
	List<FarmerDetails>	fd=farmerInterface.fetchAllDataFarmer();
	return fd;
	
	}

	@GetMapping("/getFarmerSingleData/{farmerId}")
		public ResponseEntity<FarmerDetails> getFarmerSingleData(@PathVariable int farmerId){
		
		FarmerDetails farmerdetails =farmerInterface.displaySingleDataByFarmerId(farmerId);
		
			return new ResponseEntity<FarmerDetails>(farmerdetails,HttpStatus.OK);
		
	}
	
}
