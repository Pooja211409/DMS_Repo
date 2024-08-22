package com.amul.collectioncenter.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amul.collectioncenter.main.model.CollectionCenter;

@Repository
public interface CollectionCenterRepository extends CrudRepository<CollectionCenter, Integer> {

}
