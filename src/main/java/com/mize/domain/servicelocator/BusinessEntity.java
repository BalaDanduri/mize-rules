package com.mize.domain.servicelocator;


import com.mize.domain.common.Entity;

public class BusinessEntity  extends Entity{
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
	
}
