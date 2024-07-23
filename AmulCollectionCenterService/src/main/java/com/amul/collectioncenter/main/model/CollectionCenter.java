package com.amul.collectioncenter.main.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CollectionCenter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "center_id")
	private int centerId ;
	private String centerName;
	private String address;
	private long contactNumber;
	private String centerEmailId;
	@OneToMany(cascade = CascadeType.ALL)
	private Set<CenterHeadDetails> centerHead;
}
