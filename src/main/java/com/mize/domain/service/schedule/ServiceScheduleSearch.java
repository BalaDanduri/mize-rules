package com.mize.domain.service.schedule;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.util.JodaDateDeserializer;
import com.mize.domain.util.JsonDateSerializer;

public class ServiceScheduleSearch {
	
	Long id;
	Long brandId;
	String serviceType;
	Long category;
	Long subCategory;
	String zipCode;
	String problem;
	String address;
	String city;
	String state;
	String phone;
	String email;
	String specialInstructions;
	Long productId;
	String productName;
	String productSerialNumber;		
	DateTime scheduleDate;
	String startTime;
	String endTime;
	Double latitude;
	Double longitude;
	String firstName;
	String lastName;
	String serviceOrderNumber;
	String confirmationNumber;
	String caseNumber;
	Long prodId;
	private String serviceFormat;
	
	public ServiceScheduleSearch() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}

	public Long getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(Long subCategory) {
		this.subCategory = subCategory;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getSpecialInstructions() {
		return specialInstructions;
	}

	public void setSpecialInstructions(String specialInstructions) {
		this.specialInstructions = specialInstructions;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductSerialNumber() {
		return productSerialNumber;
	}

	public void setProductSerialNumber(String productSerialNumber) {
		this.productSerialNumber = productSerialNumber;
	}
	
	@DateTimeFormat(pattern="MM-dd-yyyy")
	@JsonSerialize(using = JsonDateSerializer.class)
	public DateTime getScheduleDate() {
		return scheduleDate;
	}
	
	@DateTimeFormat(pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setScheduleDate(DateTime scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getServiceOrderNumber() {
		return serviceOrderNumber;
	}

	public void setServiceOrderNumber(String serviceOrderNumber) {
		this.serviceOrderNumber = serviceOrderNumber;
	}

	public String getConfirmationNumber() {
		return confirmationNumber;
	}

	public void setConfirmationNumber(String confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}

	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	public Long getProdId() {
		return prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}

	public String getServiceFormat() {
		return serviceFormat;
	}

	public void setServiceFormat(String serviceFormat) {
		this.serviceFormat = serviceFormat;
	}

	@Override
	public String toString() {
		return "ServiceScheduleSearch [id=" + id + ", brandId=" + brandId
				+ ", serviceType=" + serviceType + ", category=" + category
				+ ", subCategory=" + subCategory + ", zipCode=" + zipCode
				+ ", problem=" + problem + ", address=" + address + ", city="
				+ city + ", state=" + state + ", phone=" + phone + ", email="
				+ email + ", specialInstructions=" + specialInstructions
				+ ", productId=" + productId + ", productName=" + productName
				+ ", productSerialNumber=" + productSerialNumber
				+ ", scheduleDate=" + scheduleDate + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", serviceOrderNumber="
				+ serviceOrderNumber + ", confirmationNumber="
				+ confirmationNumber + ", caseNumber=" + caseNumber
				+ ", prodId=" + prodId + ", serviceFormat=" + serviceFormat
				+ "]";
	}
	
	

}
