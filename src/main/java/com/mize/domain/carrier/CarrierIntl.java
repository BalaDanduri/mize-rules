package com.mize.domain.carrier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeSceEntity;

@Entity
@Table(name="carrier_intl", uniqueConstraints = {@UniqueConstraint (columnNames = {"carrier_id", "locale_id"})})
public class CarrierIntl extends MizeSceEntity implements Comparable<CarrierIntl> {
	
	private static final long serialVersionUID = -3193421149712191082L;
	
	private Carrier carrier; 
	private String carrierName;
	private String carrierDesc;
	private Locale locale;
	
	public CarrierIntl() {
		super();
	}

	public CarrierIntl(Carrier carrier, String carrierName, String carrierDesc,
			Locale locale) {
		super();
		this.carrier = carrier;
		this.carrierName = carrierName;
		this.carrierDesc = carrierDesc;
		this.locale = locale;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		super.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "carrier_id")
	@JsonBackReference(value="intl")
	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}
	
	@Column (name = "carrier_name", length = 250, nullable = true)
	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	
	@Column (name = "carrier_description", length = 500, nullable = true)
	public String getCarrierDesc() {
		return carrierDesc;
	}

	public void setCarrierDesc(String carrierDesc) {
		this.carrierDesc = carrierDesc;
	}
	
	@ManyToOne(fetch = FetchType.EAGER,optional = true)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "locale_id")
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	@Override
	public String toString() {
		return "CarrierIntl [carrierName=" + carrierName + ", carrierDesc="
				+ carrierDesc + ", locale=" + locale + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((carrierDesc == null) ? 0 : carrierDesc.hashCode());
		result = prime * result
				+ ((carrierName == null) ? 0 : carrierName.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
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
		CarrierIntl other = (CarrierIntl) obj;
		if (carrierDesc == null) {
			if (other.carrierDesc != null)
				return false;
		} else if (!carrierDesc.equals(other.carrierDesc))
			return false;
		if (carrierName == null) {
			if (other.carrierName != null)
				return false;
		} else if (!carrierName.equals(other.carrierName))
			return false;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		return true;
	}

	@Override
	public int compareTo(CarrierIntl o) {
		return 0;
	}
	
}
