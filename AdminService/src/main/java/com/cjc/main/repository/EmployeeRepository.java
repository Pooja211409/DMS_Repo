package com.cjc.main.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.cjc.main.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
	
	public Optional<Employee> findByUserNameAndPassword(String userName, String password);

}
