package com.amul.farmer.main.service;

import java.io.IOException;
import java.util.List;
import java.util.Set;

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

	@Override
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
        FarmerDetails fd=farmerRepository.save(f);
		return fd;
	}

	@Override
	public List<FarmerDetails> fetchAllDataFarmer() {
		Iterable<FarmerDetails>fd=farmerRepository.findAll();
		return (List<FarmerDetails>) fd;
	}

}
