package com.mize.domain.shipping;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.CachedEntity;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name="shipment_tracking_party")
public class ShipmentParty extends MizeSceEntity implements Comparable<ShipmentParty>{
	private static final long serialVersionUID = -7073856017006485033L;
	private ShipmentTracking shipmentTracking;
	private String partyType;
	private BusinessEntity businessEntity;
	private String code;
	private String typeCode;
	private String subTypeCode;
	private String name;
	private String firstName;
	private String lastName;
	private String middleInitial;
	private String contactName;
	@CachedEntity
	private EntityAddress address;	

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",unique=true,nullable=false)
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="shipment_tracking_id")
	@JsonBackReference(value="shipment_party")
	public ShipmentTracking getShipmentTracking() {
		return shipmentTracking;
	}

	public void setShipmentTracking(ShipmentTracking shipmentTracking) {
		this.shipmentTracking = shipmentTracking;
	}

	@Column(name="party_type")
	public String getPartyType() {
		return partyType;
	}

	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	@JoinColumn(name = "party_be_id")
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

	@Column(name="party_be_code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name="party_be_type_code")
	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	@Column(name="party_be_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="party_be_first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name="party_be_last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name="party_be_middle_initial")
	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	@Column(name="party_contact_name")
	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "party_address_id")
	public EntityAddress getAddress() {
		return address;
	}

	public void setAddress(EntityAddress address) {
		this.address = address;
	}

	@Column(name="party_be_sub_type_code")
	public String getSubTypeCode() {
		return subTypeCode;
	}

	public void setSubTypeCode(String subTypeCode) {
		this.subTypeCode = subTypeCode;
	}

	@Override
	public String toString() {
		return "ShipmentParty [partyType="
				+ partyType + ", businessEntity=" + businessEntity + ", code="
				+ code + ", typeCode=" + typeCode + ", name=" + name
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", middleInitial=" + middleInitial + ", contactName="
				+ contactName + "]";
	}

	@Override
	public int compareTo(ShipmentParty o) {
		return 0;
	}

}
