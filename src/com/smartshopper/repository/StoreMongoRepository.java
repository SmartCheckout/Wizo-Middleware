package com.smartshopper.repository;

import java.util.List;

import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.geo.Point;

import com.smartshopper.models.dbo.StoreDBO;

public interface StoreMongoRepository extends MongoRepository<StoreDBO, String> {

	public List<StoreDBO> findByLocationWithin(Circle circle);
	public List<StoreDBO> findByLocationNear(Point point, Distance distance);
	public StoreDBO findOneBybarcode(String barcode);
}
