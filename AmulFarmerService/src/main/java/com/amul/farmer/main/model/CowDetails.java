package com.amul.farmer.main.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class CowDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cowId;
	private String cowBreed;
	private int cowAge;
	private int cowNumber;
	private float averageMilkQuantity;
	@Lob
	@Column(length = 999999999)
	private byte[] cowImage;
}
//{
//	"cowBreed":"darkBlack",
//	"cowAge":16,
//	"cowNumber":105,
//	"averageMilkQuantity":5
//	
//}