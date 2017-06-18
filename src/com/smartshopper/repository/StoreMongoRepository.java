package com.smartshopper.repository;

import java.util.List;

import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.geo.Point;

import com.smartshopper.models.dbo.StoreDO;

public interface StoreMongoRepository extends MongoRepository<StoreDO, String> {

	public List<StoreDO> findByLocationWithin(Circle circle);
	public List<StoreDO> findBylocationNear(Point point, Distance distance);
	public StoreDO findOneBybarcode(String barcode);
}
