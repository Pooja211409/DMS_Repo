package com.amul.farmer.main.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	 @PutMapping("/update/{farmerId}")
	 public ResponseEntity<FarmerDetails>putdetails(@RequestPart("farmer")String farmerJson,
			 @RequestPart(value="adhar",required = false)MultipartFile adhar,
@RequestPart(value="cowImage",required= false)MultipartFile cowImage,
@RequestPart(value="buffaloImage",required=false)MultipartFile buffaloImage,@PathVariable int farmerId)
			 {
		FarmerDetails fd =farmerInterface.updatefarmerDataByusingId(farmerJson,adhar,cowImage,buffaloImage,farmerId);
		return new ResponseEntity<FarmerDetails>(fd,HttpStatus.OK);

	}


	
}
