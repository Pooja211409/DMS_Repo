package com.cjc.main.controller;

import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.main.model.Employee;
import com.cjc.main.service.EmployeeServiceInterface;
@CrossOrigin("http://localhost:3000")
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
	@GetMapping("/allEmployeeDetails")
	public List<Employee>fetchAllEmployee(){
		List<Employee> emp=employeeServiceInterface.fetchAllEmployee();
		return emp;
		
	}
	@GetMapping("getEmployee/{userName}/{password}")
	public ResponseEntity<Employee> getAuthEmployee(@PathVariable String userName, @PathVariable String  password )
	{
		Employee emp=employeeServiceInterface.authenticateEmployee(userName,password);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		
	}
	}