package com.smartshopper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartshopper.models.Location;
import com.smartshopper.models.io.Product;
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
	public List<Store> getNearbyStores(@RequestParam(value="radius", required=false) Float radius,
										@RequestParam(value="context", required=false) String context,
										 @RequestParam(value="longitude", required=true) Double longitude,
										  @RequestParam(value="lattitude", required=true) Double lattitude){
	
		return storeService.findNearByStores(new Location("Point" ,new Double[] {longitude,lattitude}),radius, context);
	}
	
	/**
	 * Handler for client.smartshopper.com/store/barcodesearch/{barcode}	
	 * @param : barcode; barcode of store
	 * @return: Store
	 * */
	@RequestMapping(method=RequestMethod.GET,path="/store/barcodesearch/{barcode}")
	public Store findStoreByBarcode(@PathVariable("barcode") String barcode){
		return storeService.findStoreByBarcode(barcode);
	}
	
	@RequestMapping(path="/store/add", method = RequestMethod.POST)
	public String addStore(@RequestBody Store store){
		return storeService.addStoreDetails(store);
	}
}
