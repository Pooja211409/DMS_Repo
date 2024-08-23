package com.cjc.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpel implements EmployeeServiceInterface {
	@Autowired private EmployeeRepository er;

}
