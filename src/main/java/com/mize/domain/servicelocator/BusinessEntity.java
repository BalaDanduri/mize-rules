package com.mize.domain.servicelocator;


import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import com.mize.domain.common.Entity;

public class BusinessEntity  extends Entity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3712437162456355278L;
	long id;
	private String code;
	private String typeCode;
	private String subTypeCode;
	private String name;
	private String logo;
	@JsonProperty
	private List<BusinessEntityAddress> businessEntityAddressList;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getSubTypeCode() {
		return subTypeCode;
	}
	public void setSubTypeCode(String subTypeCode) {
		this.subTypeCode = subTypeCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	@JsonIgnore
	public boolean addAddress(BusinessEntityAddress businessEntityAddress) {
		if(businessEntityAddressList==null) {
			businessEntityAddressList = new ArrayList<BusinessEntityAddress>();
		}
		if(businessEntityAddressList.contains(businessEntityAddress) && businessEntityAddress.getId()>0 ) {
			businessEntityAddressList.set(businessEntityAddressList.lastIndexOf(businessEntityAddress), businessEntityAddress);
		}
		businessEntityAddressList.add(businessEntityAddress);
		return true;
	}
	
	@JsonIgnore
	public int getAddressCount() {
		return businessEntityAddressList==null?0:businessEntityAddressList.size();
	}
	
	@JsonIgnore
	public BusinessEntityAddress getAddressAt(int index) {
		return (businessEntityAddressList!=null&& businessEntityAddressList.size()<index)? businessEntityAddressList.get(0) : null;
	}
	
	@JsonIgnore
	public boolean updateAddressAt(int index,BusinessEntityAddress businessEntityAddress) {
		if(businessEntityAddressList!=null&& businessEntityAddressList.size()<index) {
			businessEntityAddressList.set(index, businessEntityAddress);
			return true;
		}
		return false;
	}
	
}
