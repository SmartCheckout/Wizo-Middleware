package com.smartshopper.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import com.smartshopper.models.Location;
import com.smartshopper.models.dbo.ProductDBO;
import com.smartshopper.models.dbo.StoreDBO;
import com.smartshopper.models.io.Store;
import com.smartshopper.repository.StoreMongoRepository;

@Service
public class StoreService {

	@Autowired
	private StoreMongoRepository storeRepo;
	
	public List<Store> findAllStores(){
		//Business Level Validations - TBD
		List<Store> returnList = new ArrayList<Store>();
		for(StoreDBO store : storeRepo.findAll()){
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
			miles = (miles == null || miles == 0.0f)?2.0f:miles;
		}
		
		Distance radius = new Distance(miles,Metrics.MILES);
		
		List<StoreDBO> nearByStoresDBO = storeRepo.findByLocationNear(new Point(center.getCoordinates()[0], center.getCoordinates()[1]),radius);
		List<Store> nearByStores = new ArrayList<Store>();
		for(StoreDBO storeDBO : nearByStoresDBO){
			nearByStores.add(storeDBO.toIO());
		}
		
		return nearByStores;
	}

	public Store findStoreByBarcode(String barcode){
		StoreDBO storeDBO = storeRepo.findOneBybarcode(barcode);
		return storeDBO!=null?storeDBO.toIO():null;
	}
	
	public Store findStoreById(String storeId){
		StoreDBO storeDBO = storeRepo.findOne(storeId);
		return storeDBO!=null?storeDBO.toIO():null;
	}
	
	public String addStoreDetails(Store storeDetails){
		StoreDBO storeDBO = new StoreDBO();
		if(storeDetails!=null){
			storeDBO = storeDetails.toDBO();
			storeRepo.insert(storeDBO);
		}
		return storeDBO.getId();
	}
}
