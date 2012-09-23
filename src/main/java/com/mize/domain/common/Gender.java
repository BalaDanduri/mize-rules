package com.mize.domain.common;

public enum Gender {
	MALE("M"), FEMALE("F");
	private String gender;
	private Gender(String gender) {
		this.gender = gender;
	}
	
	public static final Gender getGender(String gender) {
		for (Gender s : values() ){
			if (s.gender.equalsIgnoreCase(gender)) return s;
		}
		return null;
	}
}
