package com.cjc.main.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.main.model.Employee;


public interface EmployeeServiceInterface  {

	public Employee saveEmployeeDetails(String employeeJson, MultipartFile profileImage);

	
}
