package com.mize.domain.serviceentity;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.MizeDateTime;

public class ServiceEntitySearch extends MizeSceEntity implements Comparable<ServiceEntitySearch> {

	private static final long serialVersionUID = 6821133638967617947L;
	private String code;
	private String status;
	private ServiceEntityAddress address;
	private String type;
//	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private MizeDateTime createdDate;
	private Long createdBy;
	private Long submittedBy;
	
	List<ServiceEntitySearch> results = new ArrayList<ServiceEntitySearch>(); 
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ServiceEntityAddress getAddress() {
		return address;
	}

	public void setAddress(ServiceEntityAddress address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/*@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)*/
	public MizeDateTime getCreatedDate() {
		return createdDate;
	}

	/*@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	*/
	public void setCreatedDate(MizeDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(Long submittedBy) {
		this.submittedBy = submittedBy;
	}

	public ServiceEntitySearch() {
		super();
	}
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}	

	
	@Override
	public int compareTo(ServiceEntitySearch arg0) {
		return 0;
	}	

}
