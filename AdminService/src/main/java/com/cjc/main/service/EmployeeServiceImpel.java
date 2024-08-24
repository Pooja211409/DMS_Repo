package com.cjc.main.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.main.model.Employee;
import com.cjc.main.repository.EmployeeRepository;
import com.cjc.main.utility.CredentialGeneratorUtility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeeServiceImpel implements EmployeeServiceInterface {
	@Autowired private ObjectMapper objectMapper;
	@Autowired private EmployeeRepository employeeRepository;
	@Override
	public Employee saveEmployeeDetails(String employeeJson, MultipartFile profileImage) {
	Employee employee=null;
		try {
		employee	=objectMapper.readValue(employeeJson, Employee.class);
		employee.setUserName(CredentialGeneratorUtility.getUsername(employee.getFirstName()));
		employee.setPassword(CredentialGeneratorUtility.getPassword(employee.getFirstName()));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(employee!=null)
		{
			try {
				employee.setProfileImage(profileImage.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return employeeRepository.save(employee); 
	}

}
