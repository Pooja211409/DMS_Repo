package com.cjc.main.controller;

import java.net.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.main.model.Employee;
import com.cjc.main.service.EmployeeServiceInterface;

@RestController
@RequestMapping("employee_details")
public class EmployeeController {
	@Autowired private EmployeeServiceInterface employeeServiceInterface;

	@PostMapping("/employee")
	public ResponseEntity<Employee>createEmployee(@RequestPart("Employeejson")String employeeJson,
			                                     @RequestPart("ProfileImage")MultipartFile profileImage)
	{
	Employee employeeDetailsRef	=employeeServiceInterface.saveEmployeeDetails(employeeJson,profileImage);
	return new ResponseEntity<Employee>(employeeDetailsRef,HttpStatus.CREATED);
	}
	
	
}
