package com.smartshopper.models;

public class Payment {

	// Specifies the type of payment - CREDIT CARD/ DEBIT CARD /WALLET/CASH
	private String paymentType;
	private String paymentSource;
	private String paymentGateway;
	private String paymentRef;
	private String paymentStatus;
	// Specifies the information about the card id/ wallet id etc
	

	public Payment(){
		super();
	}
	
	public Payment(String paymentType, String paymentSource, String paymentGateway, String paymentRef, String paymentStatus) {
		super();
		this.paymentType = paymentType;
		this.paymentSource = paymentSource;
		this.paymentGateway = paymentGateway;
		this.paymentRef = paymentRef;
		this.paymentStatus = paymentStatus;
	}



	public String getPaymentType() {
		return paymentType;
	}


	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}


	public String getPaymentSource() {
		return paymentSource;
	}


	public void setPaymentSource(String paymentSource) {
		this.paymentSource = paymentSource;
	}

	public String getPaymentGateway() {
		return paymentGateway;
	}

	public void setPaymentGateway(String paymentGateway) {
		this.paymentGateway = paymentGateway;
	}
	
	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentRef() {
		return paymentRef;
	}

	public void setPaymentRef(String paymentRef) {
		this.paymentRef = paymentRef;
	}
	
	
	
}
