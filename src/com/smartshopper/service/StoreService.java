package com.smartshopper.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import com.smartshopper.models.Location;
import com.smartshopper.models.Store;
import com.smartshopper.models.dbo.StoreDBO;
import com.smartshopper.repository.StoreMongoRepository;

@Service
public class StoreService {

	@Autowired
	private StoreMongoRepository storeRepo;
	
	public List<StoreDBO> findAllStores(){
		//Business Level Validations - TBD
		return storeRepo.findAll();
	}
	
	public List<Store> findNearByStores(Location center, Float miles, String context){
		
		if(context !=null && !context.isEmpty()){
			//Setting radius to configurable value for current location store search
			if("STORE_IN_CURRENT_LOC".equalsIgnoreCase(context)){ miles = 0.25f;}
		}
		else{
			//Default radius value
			miles = (miles == null || miles == 0.0f)?2.0f:miles;
		}
		
		Distance radius = new Distance(miles,Metrics.MILES);
		
		List<StoreDBO> nearByStoresDBO = storeRepo.findByLocationNear(new Point(center.getCoordinates()[0], center.getCoordinates()[1]),radius);
		List<Store> nearByStores = new ArrayList<Store>();
		for(StoreDBO storeDBO : nearByStoresDBO){
			nearByStores.add(new Store(storeDBO));
		}
		
		return nearByStores;
	}

	public Store findStoreByBarcode(String barcode){
		StoreDBO storeDBO = storeRepo.findOneBybarcode(barcode);
		Store store = null;
		if(storeDBO!=null){
			store = new Store(storeDBO);
		}
		return store;
	}
	
	public StoreDBO findStoreById(String storeId){
		return storeRepo.findOne(storeId);
	}
	
	public void addStoreDetails(StoreDBO storeDetails){
		storeRepo.insert(storeDetails);
	}
}
