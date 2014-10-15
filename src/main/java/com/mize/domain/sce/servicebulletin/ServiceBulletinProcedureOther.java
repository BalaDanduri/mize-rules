package com.mize.domain.sce.servicebulletin;

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
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;

/**
 * @author SrinivasThodupunuri
 * @version 1.0
 */

@Entity
@Table(name = "srvc_blltn_proc_oth")
public class ServiceBulletinProcedureOther extends MizeEntity {

	
	private static final long serialVersionUID = 1955038213931636949L;
	
	private ServiceBulletinProcedure serviceBulletinProcedure;
	private String chargeType;
	private String chargeCode;
	private String chargeDescription;
	private String chargeUom;
	private String chargeReference;
	private ServiceBulletinAmount chargeAmount;

	public ServiceBulletinProcedureOther() {
		
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {		
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "blltn_proc_id")
	@JsonBackReference(value="service_procedure_otherCharges")
	@JsonSerialize(using=JPASerializer.class)
	public ServiceBulletinProcedure getServiceBulletinProcedure() {
		return serviceBulletinProcedure;
	}

	public void setServiceBulletinProcedure(ServiceBulletinProcedure serviceBulletinProcedure) {
		this.serviceBulletinProcedure = serviceBulletinProcedure;
	}
	
	
	@Column(name = "other_charge_type", length = 50)
	public String getChargeType() {
		return chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}
	
	@Column(name = "other_charge_code", length = 100)
	public String getChargeCode() {
		return chargeCode;
	}

	public void setChargeCode(String chargeCode) {
		this.chargeCode = chargeCode;
	}
	
	@Column(name = "other_charge_descr", length = 500)
	public String getChargeDescription() {
		return chargeDescription;
	}

	public void setChargeDescription(String chargeDescription) {
		this.chargeDescription = chargeDescription;
	}
	
	@Column(name = "other_charge_uom", length = 50)
	public String getChargeUom() {
		return chargeUom;
	}

	public void setChargeUom(String chargeUom) {
		this.chargeUom = chargeUom;
	}
	
	@Column(name = "other_charge_reference", length = 100)
	public String getChargeReference() {
		return chargeReference;
	}

	public void setChargeReference(String chargeReference) {
		this.chargeReference = chargeReference;
	}
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "other_amount_id")
	public ServiceBulletinAmount getChargeAmount() {
		return chargeAmount;
	}

	public void setChargeAmount(ServiceBulletinAmount chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime
				* result
				+ ((chargeAmount == null) ? 0 : chargeAmount
						.hashCode());
		result = prime * result
				+ ((chargeCode == null) ? 0 : chargeCode.hashCode());
		result = prime
				* result
				+ ((chargeDescription == null) ? 0
						: chargeDescription.hashCode());
		result = prime * result
				+ ((chargeType == null) ? 0 : chargeType.hashCode());
		result = prime * result
				+ ((chargeUom == null) ? 0 : chargeUom.hashCode());
		result = prime * result
				+ ((chargeReference == null) ? 0 : chargeReference.hashCode());
		result = prime
				* result
				+ ((serviceBulletinProcedure == null) ? 0 : serviceBulletinProcedure
						.hashCode());
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
		ServiceBulletinProcedureOther other = (ServiceBulletinProcedureOther) obj;
		if (chargeAmount == null) {
			if (other.chargeAmount != null)
				return false;
		} else if (!chargeAmount.equals(other.chargeAmount))
			return false;
		if (chargeCode == null) {
			if (other.chargeCode != null)
				return false;
		} else if (!chargeCode.equals(other.chargeCode))
			return false;
		if (chargeDescription == null) {
			if (other.chargeDescription != null)
				return false;
		} else if (!chargeDescription.equals(other.chargeDescription))
			return false;
		if (chargeType == null) {
			if (other.chargeType != null)
				return false;
		} else if (!chargeType.equals(other.chargeType))
			return false;
		if (serviceBulletinProcedure == null) {
			if (other.serviceBulletinProcedure != null)
				return false;
		} else {
			if(serviceBulletinProcedure.getId() == null) {
				if(other.serviceBulletinProcedure.getId() != null)
					return false;
			} else if(!serviceBulletinProcedure.getId().equals(other.serviceBulletinProcedure.getId()))
				return false;
		}
		return true;
	}
}
