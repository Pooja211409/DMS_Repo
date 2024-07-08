package com.amul.farmer.main.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
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
	@Lob
	@Column(length = 999999999)
	@OneToMany(cascade = CascadeType.ALL)
	private Set<CowDetails> cow=new HashSet<>();
	@Lob
	@Column(length = 999999999)
	@OneToMany(cascade = CascadeType.ALL)
	private Set<BuffaloDetails> buffalo=new HashSet<>();
	

}
