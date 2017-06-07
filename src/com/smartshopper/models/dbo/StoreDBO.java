package com.smartshopper.models.dbo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.smartshopper.models.Address;
import com.smartshopper.models.Location;

@Document(collection="smartshopper.store")
public class StoreDBO {

	@Id
	private String id;
	private String barcode;
	private String title;
	private Address address;
	private String phone;
	private String email;
	private Location location;
	
	public StoreDBO(){
		super();
	}
	public StoreDBO(String id, String barcode, String title, Address address, String phone,
			String email, Location location) {
		super();
		this.id = id;
		this.title = title;
		this.barcode = barcode;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.location = location;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Location getlocation() {
		return location;
	}
	public void setGeo(Location location) {
		this.location = location;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	
	
	
	
	
	
}
