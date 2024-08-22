package com.amul.farmer.main.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
=======
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
>>>>>>> stash

<<<<<<< HEAD
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

=======
>>>>>>> stash
import com.amul.farmer.main.model.FarmerDetails;
import com.amul.farmer.main.serviceInterface.FarmerServiceI;

@RestController
public class FarmerController {
<<<<<<< HEAD


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
	public ResponseEntity<FarmerDetails>AddNewCowDetails(@RequestPart("Cow") String json,@RequestPart("image") MultipartFile img,@PathVariable int id)
	{
		System.out.println(json);
		FarmerDetails fData=farmerInterface.AddNewCow(json,img,id);
		return new ResponseEntity<FarmerDetails>(fData,HttpStatus.OK);
		
	}
	
=======
	@Autowired FarmerServiceI farmerInterface;
	@PatchMapping("/updateDataBuffalo/{id}")
	public ResponseEntity<FarmerDetails> updateBuffaloDetails(@RequestPart ("buffalo")String json,@RequestPart("image") MultipartFile img)
	{
		FarmerDetails fData=farmerInterface.updateBuffalo(json,img);
		return new ResponseEntity<FarmerDetails>(fData,HttpStatus.OK);
		
	}
>>>>>>> stash
	
	
}
