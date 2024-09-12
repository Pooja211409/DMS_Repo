package com.amul.farmer.main.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.amul.farmer.main.model.BuffaloDetails;
import com.amul.farmer.main.model.CowDetails;
import com.amul.farmer.main.model.FarmerDetails;
import com.amul.farmer.main.repository.FarmerRepository;
import com.amul.farmer.main.serviceInterface.FarmerServiceI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FarmerServiceImpl implements FarmerServiceI{
	@Autowired private FarmerRepository farmerRepository;
	
	public FarmerDetails SaveFarmerData(String farmerJson, MultipartFile adhar, MultipartFile cowImage,
			MultipartFile buffaloImage) {
		ObjectMapper mapper=new ObjectMapper();
		FarmerDetails f=null;
		
		try {
			f=mapper.readValue(farmerJson,FarmerDetails.class);
		} catch (JsonMappingException e) {
		
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		if(adhar!=null)
		{
			try {
				f.setAdhar(adhar.getBytes());
			} catch (IOException e) {
				
				e.printStackTrace();
			}

			  if(cowImage!=null)
		        {
		        	for(CowDetails cow :f.getCow())
		        	try {
						cow.setCowImage(cowImage.getBytes());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		        if(buffaloImage!=null)
		        {
		        	for(BuffaloDetails buffalo:f.getBuffalo())
		        	{
		        	try {
						buffalo.setBuffaloImage(buffaloImage.getBytes());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	}
		        }
		   }
		 FarmerDetails fd=farmerRepository.save(f);
			return fd;
	}

	public FarmerDetails updateBuffalo(int id,String json, MultipartFile img) {
		Optional<FarmerDetails> opFarmer = farmerRepository.findById(id);
		 FarmerDetails fd=opFarmer.get();
		// Object Mapper is user to convert json String into the desired class instance/object
		 ObjectMapper mapper=new ObjectMapper();
		FarmerDetails f=null;
		BuffaloDetails buffalo=new BuffaloDetails();
		try {
			f=mapper.readValue(json,FarmerDetails.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(img!=null)
		{
			try {
				buffalo.setBuffaloImage(img.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		FarmerDetails fData=farmerRepository.save(f);
		return fData;
	}

	
		
	@Override
	public List<FarmerDetails> fetchAllDataFarmer() {
		Iterable<FarmerDetails>fd= farmerRepository.findAll();
		return (List<FarmerDetails>) fd;
	}
	@Override                     // 1                 2               3
	public FarmerDetails AddNewCow(String cowjson, MultipartFile img,int id) {
		
		Optional<FarmerDetails> fd=farmerRepository.findById(id);
		if(fd.isPresent())
		{
			FarmerDetails originalfd=fd.get();
			CowDetails cow=null;
			ObjectMapper mapper=new ObjectMapper();
			         //         json-String,desired class which instance in need
			try {
				cow=mapper.readValue(cowjson, CowDetails.class);
				cow.setCowImage(img.getBytes());
				
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(IOException ie)
			{
				ie.printStackTrace();
			}
			if(cow!=null)
			{
				originalfd.getCow().add(cow);
				return farmerRepository.save(originalfd);
				
			}
			else
			
				throw new RuntimeException("Cow is not Present");
		}
		return null;
	}		
	@Override
	public FarmerDetails displaySingleDataByFarmerId(int farmerId) {
		
		Optional<FarmerDetails> fd=farmerRepository.findById(farmerId);
		return fd.get()  ;
	}

	@Override
	public FarmerDetails AddNewBuffalo(String buffaloJson, MultipartFile buffaloImage, int farmerId) {
		Optional<FarmerDetails> fd=farmerRepository.findById(farmerId);
		if(fd.isPresent())
		{
			FarmerDetails originalfd=fd.get();
			BuffaloDetails buffalo=null;
			ObjectMapper mapper=new ObjectMapper();
			        
			try {
				buffalo=mapper.readValue(buffaloJson, BuffaloDetails.class);
				buffalo.setBuffaloImage(buffaloImage.getBytes());
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}catch(IOException ie)
			{
				ie.printStackTrace();
			}
			if(buffalo!=null)
			{
				originalfd.getBuffalo().add(buffalo);
				return farmerRepository.save(originalfd);
			}
			else
			
				throw new RuntimeException("Buffalo is not Present");
		}
		return null;
	}


}
