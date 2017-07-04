package com.smartshopper.models.dbo;

import org.springframework.data.annotation.Id;

public class UserDO{

	@Id
	private String userId;
	private String firstName;
	private String lastName;
	private String preferredName;
	private String salutation;
	private String emailId;
	private Long mobileNumber;
	/*Additional attributes needs to be added - Preferences etc*/
	

	
}
