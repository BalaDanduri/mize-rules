package com.mize.domain.user;

import org.joda.time.DateTime;

import com.mize.domain.common.Gender;
import com.mize.domain.common.PostalAddress;

public class User {
	private String userId;
	private UserType userType;
	private PostalAddress postalAddress;
	
	// Personal Info
	private String firstName;
	private String lastName;
	private DateTime birthdate;
	private Gender gender;
}
