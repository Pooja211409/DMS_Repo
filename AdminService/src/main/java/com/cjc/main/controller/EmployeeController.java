package com.cjc.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.service.EmployeeServiceInterface;

@RestController
public class EmployeeController {
	@Autowired private EmployeeServiceInterface esi;

}
