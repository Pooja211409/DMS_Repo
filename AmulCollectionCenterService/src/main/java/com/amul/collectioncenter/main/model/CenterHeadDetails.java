package com.amul.collectioncenter.main.model;


import java.util.Set;

import jakarta.persistence.CascadeType;
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
public class CenterHeadDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int headId;	
	private String headName;	
	private long headContact;	
	private String headaddress;	
	private String headEmailId;	
	private int headAge;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "collection_center_id", referencedColumnName = "center_id")
	private Set<FarmerData> farmer;

}
