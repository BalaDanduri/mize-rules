package com.mize.domain.purchaseorder;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name = "purchase_order_requester")
public class PurchaseOrderRequester extends MizeSceEntity implements Comparable<PurchaseOrderRequester>{	

	private static final long serialVersionUID = 444432988617420731L;
	private PurchaseOrder purchaseOrder;
	private BusinessEntity businessEntity;
	private EntityAddress address;
	private String updateAddress;
	@Transient
	List<BusinessEntity> childBusinessEntities = new ArrayList<BusinessEntity>();
	private String beCode;
	private String beTypeCode;
	private String beSubTypeCode;
	private String beName;
	private String beFirstName;
	private String beLastName;
	private String beMiddleInitial;
	private String beReferenceNumber;

	public PurchaseOrderRequester(){
		super();
	}
	
	public PurchaseOrderRequester(BusinessEntity businessEntity,EntityAddress address){
		super();
		this.businessEntity = businessEntity;
		this.address = address;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="requester_be_id")
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

	@OneToOne(fetch=FetchType.EAGER ,cascade =CascadeType.ALL)
	@JoinColumn(name="requester_address_id")
	public EntityAddress getAddress() {
		return address;
	}

	public void setAddress(EntityAddress address) {
		this.address = address;
	}
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="order_id")
	@JsonBackReference(value="requester_purchaseOrder")
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	@Transient
	public String getUpdateAddress() {
		return updateAddress;
	}

	public void setUpdateAddress(String updateAddress) {
		this.updateAddress = updateAddress;
	}

	@Transient
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<BusinessEntity> getChildBusinessEntities() {
		return childBusinessEntities;
	}

	public void setChildBusinessEntities(List<BusinessEntity> childBusinessEntities) {
		this.childBusinessEntities = childBusinessEntities;
	}
	
	@Column(name="requester_be_code")
	public String getBeCode() {
		return beCode;
	}

	public void setBeCode(String beCode) {
		this.beCode = beCode;
	}

	@Column(name="requester_be_type_code")
	public String getBeTypeCode() {
		return beTypeCode;
	}

	public void setBeTypeCode(String beTypeCode) {
		this.beTypeCode = beTypeCode;
	}

	@Column(name="requester_be_sub_type_code")
	public String getBeSubTypeCode() {
		return beSubTypeCode;
	}

	public void setBeSubTypeCode(String beSubTypeCode) {
		this.beSubTypeCode = beSubTypeCode;
	}

	@Column(name="requester_be_name")
	public String getBeName() {
		return beName;
	}

	public void setBeName(String beName) {
		this.beName = beName;
	}

	@Column(name="requester_be_first_name")
	public String getBeFirstName() {
		return beFirstName;
	}

	public void setBeFirstName(String beFirstName) {
		this.beFirstName = beFirstName;
	}

	@Column(name="requester_be_last_name")
	public String getBeLastName() {
		return beLastName;
	}

	public void setBeLastName(String beLastName) {
		this.beLastName = beLastName;
	}

	@Column(name="requester_be_middle_initial")
	public String getBeMiddleInitial() {
		return beMiddleInitial;
	}

	public void setBeMiddleInitial(String beMiddleInitial) {
		this.beMiddleInitial = beMiddleInitial;
	}

	@Column(name="requester_be_reference")	
	public String getBeReferenceNumber() {
		return beReferenceNumber;
	}

	public void setBeReferenceNumber(String beReferenceNumber) {
		this.beReferenceNumber = beReferenceNumber;
	}

	@Override
	public int compareTo(PurchaseOrderRequester o) {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		PurchaseOrderRequester other = (PurchaseOrderRequester) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PurchaseOrderRequester [updateAddress=" + updateAddress
				+ ", beCode=" + beCode + ", beTypeCode=" + beTypeCode
				+ ", beSubTypeCode=" + beSubTypeCode + ", beName=" + beName
				+ ", beFirstName=" + beFirstName + ", beLastName=" + beLastName
				+ ", beMiddleInitial=" + beMiddleInitial
				+ ", beReferenceNumber=" + beReferenceNumber + "]";
	}

	

}
