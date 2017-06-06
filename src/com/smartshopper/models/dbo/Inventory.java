package com.smartshopper.models.dbo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="smartshopper.inventory")
public class Inventory {

	@Id
	private String id;
	private List<InventoryItem> items;
	
		
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Inventory(String id, List<InventoryItem> items) {
		super();
		this.id = id;
		this.items = items;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public List<InventoryItem> getItems() {
		return items;
	}



	public void setItems(List<InventoryItem> items) {
		this.items = items;
	}
	
	
}

