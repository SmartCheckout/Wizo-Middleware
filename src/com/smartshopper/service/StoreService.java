package com.smartshopper.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import com.smartshopper.models.Location;
import com.smartshopper.models.dbo.StoreDO;
import com.smartshopper.models.io.Store;
import com.smartshopper.repository.StoreMongoRepository;

@Service
public class StoreService {

	@Autowired
	private StoreMongoRepository storeRepo;
	
	public List<Store> findAllStores(){
		//Business Level Validations - TBD
		List<Store> returnList = new ArrayList<Store>();
		for(StoreDO store : storeRepo.findAll()){
			returnList.add(store.toIO());
		}
		return returnList;
	}
	
	public List<Store> findNearByStores(Location center, Float miles, String context){
		
		if(context !=null && !context.isEmpty()){
			//Setting radius to configurable value for current location store search
			if("STORE_IN_CURRENT_LOC".equalsIgnoreCase(context)){ miles = 0.25f;}
		}
		else{
			//Default radius value
			miles = (miles == null || miles == 0.0f)?1.0f:miles;
		}
		
		Distance radius = new Distance(miles,Metrics.MILES);
		Point point  = new Point(center.getCoordinates()[0], center.getCoordinates()[1]);
		
		List<StoreDO> nearByStoresDBO = storeRepo.findBylocationNear(point,radius);
		List<Store> nearByStores = new ArrayList<Store>();
		for(StoreDO storeDBO : nearByStoresDBO){
			nearByStores.add(storeDBO.toIO());
		}
		
		return nearByStores;
	}

	public Store findStoreByBarcode(String barcode){
		StoreDO storeDBO = storeRepo.findOneBybarcode(barcode);
		return storeDBO!=null?storeDBO.toIO():null;
	}
	
	public Store findStoreById(String storeId){
		StoreDO storeDBO = storeRepo.findOne(storeId);
		return storeDBO!=null?storeDBO.toIO():null;
	}
	
	public String addStoreDetails(Store storeDetails){
		StoreDO storeDBO = new StoreDO();
		if(storeDetails!=null){
			storeDBO = storeDetails.toDBO();
			storeRepo.insert(storeDBO);
		}
		return storeDBO.getId();
	}
}
