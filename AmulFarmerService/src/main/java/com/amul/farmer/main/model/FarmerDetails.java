package com.amul.farmer.main.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	@Column(name = "farmer_id")
	private int farmerId;
	private String farmerName;
	private String address;
	private int age;
	private String mail;
	@Lob
	@Column(length = 999999999)
	private byte[] adhar;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "farmer_id", referencedColumnName = "farmer_id")
	private Set<CowDetails> cow;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "farmer_id", referencedColumnName = "farmer_id")
	private Set<BuffaloDetails> buffalo;
	

}
 
/*{
	"farmerId":101,
	"farmerName":"Rahul Gadekar",
   "address":"Amravati",
	"age":26,
	"mail":"rahulgadekar12@gmail.com",
	"cow":[{
		"cowBreed":"white",
		"cowAge":22,
	"cowNumber":223,
		"averageMilkQuantity":3.0			
	}],
	"buffalo":[{
		"buffaloBreed":"Black",
		"buffaloAge":24,
		"buffaloNumber":101,
		"averageMilkQuantity":4.0
	}]*/
	
			

	
