package com.mize.domain.common;

public class Address extends MizeEntity implements Comparable<Address>{
	
	private static final long serialVersionUID = 752510264260453186L;
	private String address1;
	private String address2;
	private String address3;
	private String address4;
	private String city;
	private String state;
	private String zipCode;
	private String country;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}	
	
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getAddress4() {
		return address4;
	}
	public void setAddress4(String address4) {
		this.address4 = address4;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "Address [address1=" + address1 + ", address2=" + address2 + ", address3=" + address3 + ", address4=" + address4 + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", country=" + country + ", id=" + id + "]";
	}
	
	@Override
	public int hashCode() {
		int result = super.hashCode();
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (id == null) {
			if (other.id != id)
				return false;
		}
		return true;
	}
	
	public int compareTo(Address address) {
		if ( this == address ) 
			return EQUAL;
		else if (this.id < address.id) 
			return BEFORE;
		else if (address.id == this.id) 
			return EQUAL;
		else if (this.id > address.id)
			return AFTER;
		return EQUAL;		
	}	
	public static void main(String[] args) {
		Address address = new Address();
		address.toString();
	}
	
}