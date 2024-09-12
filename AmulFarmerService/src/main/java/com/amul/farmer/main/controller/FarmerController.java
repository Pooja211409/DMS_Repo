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

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.amul.farmer.main.model.FarmerDetails;
import com.amul.farmer.main.serviceInterface.FarmerServiceI;


@CrossOrigin("http://localhost:3000")
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
	
	
	
	@PatchMapping("/updateDataBuffalo/{id}")
	public ResponseEntity<FarmerDetails> updateBuffaloDetails(@RequestPart ("buffalo")String json,@RequestPart("image") MultipartFile img,
			                                                @PathVariable int id)
	{
		FarmerDetails fData=farmerInterface.updateBuffalo(id,json,img);
		return new ResponseEntity<FarmerDetails>(fData,HttpStatus.OK);
	}
	@PostMapping("/AddNewCow/{id}")
	public ResponseEntity<FarmerDetails>AddNewCowDetails(@RequestPart("cow") String json,@RequestPart("image") MultipartFile img,@PathVariable int id)
	{
		System.out.println(json);
		FarmerDetails fData=farmerInterface.AddNewCow(json,img,id);
		return new ResponseEntity<FarmerDetails>(fData,HttpStatus.OK);
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


	


	@GetMapping("/getFarmerSingleData/{farmerId}")
		public ResponseEntity<FarmerDetails> getFarmerSingleData(@PathVariable int farmerId){
		
		FarmerDetails farmerdetails =farmerInterface.displaySingleDataByFarmerId(farmerId);
		
			return new ResponseEntity<FarmerDetails>(farmerdetails,HttpStatus.OK);
		
	}

	@PostMapping("/AddNewBuffalo/{farmerId}")
	public ResponseEntity<FarmerDetails>AddNewBuffaloDetails(@RequestPart("buffalo") String buffaloJson,@RequestPart("buffaloImage") MultipartFile buffaloImage,@PathVariable int farmerId)
	{
		System.out.println(buffaloJson);
		FarmerDetails fData=farmerInterface.AddNewBuffalo(buffaloJson,buffaloImage,farmerId);
		return new ResponseEntity<FarmerDetails>(fData,HttpStatus.OK);
	}



	

}
