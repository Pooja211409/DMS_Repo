package com.amul.farmer.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CowDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cowId;
	private String cowBreed;
	private int cowAge;
	private int cowNumber;
	private float averageMilkQuantity;
	private byte[] cowImage;
}
