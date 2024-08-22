package com.amul.collectioncenter.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amul.collectioncenter.main.repository.CollectionCenterRepository;
import com.amul.collectioncenter.main.serviceI.CollectionCenterServiceI;

@Service
public class CollectionCenterServiceImpl implements CollectionCenterServiceI {
	@Autowired private  CollectionCenterRepository collectionRepository;

}
