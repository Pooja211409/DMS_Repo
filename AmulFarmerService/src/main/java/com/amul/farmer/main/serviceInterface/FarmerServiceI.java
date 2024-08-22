package com.amul.farmer.main.serviceInterface;

import org.springframework.web.multipart.MultipartFile;
<<<<<<< HEAD


import java.util.List;



import com.amul.farmer.main.model.FarmerDetails;


=======
>>>>>>> stash

import com.amul.farmer.main.model.FarmerDetails;

public interface FarmerServiceI {
<<<<<<< HEAD



	public FarmerDetails SaveFarmerData(String farmerJson, MultipartFile adhar, MultipartFile cowImage,
			MultipartFile buffaloImage);

	public List<FarmerDetails> fetchAllDataFarmer();


	public FarmerDetails updateBuffalo(int id, String json, MultipartFile img);
	public FarmerDetails AddNewCow (String json,MultipartFile img,int id);

	

=======
	public FarmerDetails updateBuffalo(String json, MultipartFile img);
>>>>>>> stash
}
