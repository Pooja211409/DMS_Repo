package com.cjc.main.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.main.model.Employee;


public interface EmployeeServiceInterface  {

	public Employee saveEmployeeDetails(String employeeJson, MultipartFile profileImage);

	public List<Employee> fetchAllEmployee();

	public Employee authenticateEmployee(String userName, String password);

	
}
