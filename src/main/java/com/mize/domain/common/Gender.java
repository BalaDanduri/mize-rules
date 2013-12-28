package com.mize.domain.common;

public enum Gender {
	M("M"), F("F");
	private String gender;
	private Gender(String gender) {
		this.gender = gender;
	}
	public String getValue() {
		return this.gender;
	}
	public static final Gender getGender(String gender) {
		for (Gender s : values() ){
			if (s.gender.equalsIgnoreCase(gender)) return s;
		}
		return null;
	}
	/*@Override
	public String toString() {
		return "Gender [gender="+gender+"]";
	}*/
	
}
