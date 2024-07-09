package com.amul.farmer.main.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
@Data
@Entity
public class BuffaloDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int buffaloId;
	private String buffaloBreed;
	private int buffaloAge;
	private int buffaloNumber;
	private float averageMilkQuantity;
	@Lob
	@Column(length = 999999999)
	private byte[] buffaloImage;
}
