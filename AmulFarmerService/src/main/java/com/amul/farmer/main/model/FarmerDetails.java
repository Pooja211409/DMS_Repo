package com.amul.farmer.main.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Data
@Entity
public class FarmerDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int farmerId;
	private String farmerName;
	private String address;
	private int age;
	private String mail;
	private byte adhar;
	@OneToMany(cascade = CascadeType.ALL)
	private CowDetails farmerCow;
	@OneToMany(cascade = CascadeType.ALL)
	private BuffaloDetails farmerBuffalo;

}
