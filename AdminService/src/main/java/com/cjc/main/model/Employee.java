package com.cjc.main.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int EmployeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String Occupation;
	private float salary;
	private int age;
	@Enumerated(EnumType.STRING)
	private UserType userType;
	
	private String userName;
	
	private String password;
	@Lob
	@Column(length =999999999)
	private byte[] profileImage;

}
