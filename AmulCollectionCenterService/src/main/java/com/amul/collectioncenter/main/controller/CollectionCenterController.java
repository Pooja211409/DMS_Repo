package com.amul.collectioncenter.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.amul.collectioncenter.main.serviceI.CollectionCenterServiceI;

@RestController
public class CollectionCenterController {
	@Autowired private CollectionCenterServiceI collectionInterface;
	

}
