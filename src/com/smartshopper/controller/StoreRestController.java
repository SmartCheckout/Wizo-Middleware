package com.smartshopper.controller;

import java.io.File;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartshopper.exceptions.Exceptions.MoreStoresFoundException;
import com.smartshopper.exceptions.Exceptions.NoStoreFoundException;
import com.smartshopper.models.Location;
import com.smartshopper.models.io.Store;
import com.smartshopper.service.StoreService;

@RestController
public class StoreRestController {
	
	@Autowired
	private StoreService storeService;
	
	/**
	 * Handler for http://www.client.smartshopper.com/store
	 * @param : None
	 * @return  : List<Store>
	 * */
	
	public static Store getRandomStore(){
		
		Random rand = new Random();
		int filenum = rand.nextInt(4)+1;
		Store store = null;
		ObjectMapper mapper = new ObjectMapper();
		try{
			store = mapper.readValue(new File("response/store-"+filenum+".json"), Store.class);
		}catch(Exception e){e.printStackTrace();}
		
		return store;
	}
	
	
	@RequestMapping(method=RequestMethod.GET,path="/stores")
	public List<Store> getStores(){
		return storeService.findAllStores();
	}

	/**
	 * Handler for client.smartshopper.com/store/nearme?longitude=&lattitude=&radius=	
	 * @param : longitude; coordinate of user
	 * @param : lattitude; coordinate of user
	 * @param : radius; sphere radius
	 * @return: List<Store>
	 * */
	@RequestMapping(method=RequestMethod.GET,path="/store/locationsearch")
	public List<Store> getStoreByLocation(@RequestParam(value="radius", required=false) Float radius,
											@RequestParam(value="context", required=false) String context,
											@RequestParam(value="longitude", required=true) Double longitude,
											@RequestParam(value="lattitude", required=true) Double lattitude)
											throws NoStoreFoundException,MoreStoresFoundException{
		
		
		Location queryLoc = new Location("Point", new Double[] {longitude,lattitude});
		List<Store> stores = storeService.findNearByStores(queryLoc, radius, context);
		
		if(stores == null || stores.size() ==0)
			throw new NoStoreFoundException("Store not found for the input location");
		if(stores.size() > 1)
			throw new MoreStoresFoundException("More than one store matched for the input location");
		return stores;
	}
	
	/**
	 * Handler for client.smartshopper.com/store/barcodesearch/{barcode}	
	 * @param : barcode; barcode of store
	 * @return: Store
	 * */
	@RequestMapping(method=RequestMethod.GET,path="/store/barcodesearch")
	public Store findStoreByBarcode(@RequestParam(value= "barcode", required = true) String barcode) throws NoStoreFoundException{
		Store store = storeService.findStoreByBarcode(barcode);
		if(store == null){
			throw new NoStoreFoundException("No store details matched for the input barcode");
		}
		
		return store;
	}
	
	@RequestMapping(path="/store/add", method = RequestMethod.POST)
	public String addStore(@RequestBody Store store){
		return storeService.addStoreDetails(store);
	}
}
