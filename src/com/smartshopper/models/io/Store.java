package com.smartshopper.models.io;

import com.smartshopper.models.Address;
import com.smartshopper.models.Location;
import com.smartshopper.models.dbo.StoreDO;

public class Store {

	private String id;
	private String title;
	private String barcode;
	private Address address;
	private String displayAddress;
	private String phone;
	private String email;
	private Location location;
	
	public Store() {
		// TODO Auto-generated constructor stub
	}

	public Store(String id, String barcode, String title, Address address, String phone,
			String email, Location location) {
		super();
		this.id = id;
		this.title = title;
		this.barcode = barcode;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.location = location;
		this.displayAddress = this.generateDisplayAddress(address, title);
	}
	
	public StoreDO toDBO(){
		return new StoreDO(id, barcode, title, address, phone, email, location);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
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

	public String getDisplayAddress() {
		return displayAddress;
	}

	public void setDisplayAddress(String displayAddress) {
		this.displayAddress = displayAddress;
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	public String generateDisplayAddress(Address address, String storeTitle){
		
		StringBuffer displayAddrBuffer = new StringBuffer();
		if(address!=null){
			displayAddrBuffer.append(storeTitle);
			displayAddrBuffer.append(", ");
			displayAddrBuffer.append(address.getAddressLine1());
			displayAddrBuffer.append(", ");
			displayAddrBuffer.append(address.getCity());
			
		}
		
		return displayAddrBuffer.toString();
	}

}
