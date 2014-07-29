package com.mize.domain.shipping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name="shipment_tracking_party")
public class ShipmentParty extends MizeEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7073856017006485033L;
	private Shipment shipment;
	private String partyType;
	private BusinessEntity businessEntity;
	private String code;
	private String typeCode;
	private String name;
	private String firstName;
	private String lastName;
	private String middleNameInitial;
	private String contactName;
	private EntityAddress partyAddress;
	

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",unique=true,nullable=false)
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="shipment_tracking_id")
	@JsonBackReference(value="shipment_party")
	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

	@Column(name="party_type")
	public String getPartyType() {
		return partyType;
	}

	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
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
	public String getMiddleNameInitial() {
		return middleNameInitial;
	}

	public void setMiddleNameInitial(String middleNameInitial) {
		this.middleNameInitial = middleNameInitial;
	}

	@Column(name="party_contact_name")
	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	@JoinColumn(name = "party_address_id")
	public EntityAddress getPartyAddress() {
		return partyAddress;
	}

	public void setPartyAddress(EntityAddress partyAddress) {
		this.partyAddress = partyAddress;
	}

	@Override
	public String toString() {
		return "ShipmentParty [shipment=" + shipment + ", partyType="
				+ partyType + ", businessEntity=" + businessEntity + ", code="
				+ code + ", typeCode=" + typeCode + ", name=" + name
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", middleNameInitial=" + middleNameInitial + ", contactName="
				+ contactName + ", partyAddress=" + partyAddress + "]";
	}

}
