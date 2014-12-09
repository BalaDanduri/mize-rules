package com.mize.domain.carrier;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name="carrier")
public class Carrier extends MizeSceEntityAudit implements Comparable<Carrier>{
	
	private static final long serialVersionUID = -1722230669155286276L;
	
	private BusinessEntity tenant;
	private String carrierCode;
	private String websiteUrl;
	private String trackingUrl;
	private List<CarrierIntl> intls = new ArrayList<CarrierIntl>();
	
	@Transient
	private User user;
	
	public Carrier() {
		super();
	}

	public Carrier(Long id, String carrierCode, String websiteUrl, String trackingUrl) {
		super();
		this.id = id;
		this.carrierCode =  makeNotNullString(carrierCode);
		this.websiteUrl = websiteUrl;
		this.trackingUrl = trackingUrl;
	}
	
	public Carrier(String carrierCode, String websiteUrl, String trackingUrl) {
		super();
		this.carrierCode =  makeNotNullString(carrierCode);
		this.websiteUrl = websiteUrl;
		this.trackingUrl = trackingUrl;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tenant_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	@Column (name = "carrier_code", length = 50, nullable = false)
	public String getCarrierCode() {
		return carrierCode;
	}

	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}
	
	@Column (name = "website_url")
	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}
	
	@Column (name = "tracking_url")
	public String getTrackingUrl() {
		return trackingUrl;
	}

	public void setTrackingUrl(String trackingUrl) {
		this.trackingUrl = trackingUrl;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER, mappedBy = "carrier", orphanRemoval = true)
	@JsonManagedReference(value="intl")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<CarrierIntl> getIntls() {
		return intls;
	}

	public void setIntls(List<CarrierIntl> intls) {
		this.intls = intls;
	}

	@Transient
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Transient
	@JsonIgnore
	public static String makeNotNullString(String str){
		return str == null ? null:str.trim();
	}
	
	@Override
	public String toString() {
		return "Carrier [carrierCode=" + carrierCode + ", websiteUrl="
				+ websiteUrl + ", trackingUrl=" + trackingUrl + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((carrierCode == null) ? 0 : carrierCode.hashCode());
		result = prime * result + ((tenant == null) ? 0 : tenant.hashCode());
		result = prime * result
				+ ((trackingUrl == null) ? 0 : trackingUrl.hashCode());
		result = prime * result
				+ ((websiteUrl == null) ? 0 : websiteUrl.hashCode());
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
		Carrier other = (Carrier) obj;
		if (carrierCode == null) {
			if (other.carrierCode != null)
				return false;
		} else if (!carrierCode.equals(other.carrierCode))
			return false;
		if (tenant == null) {
			if (other.tenant != null)
				return false;
		} else if (!tenant.equals(other.tenant))
			return false;
		if (trackingUrl == null) {
			if (other.trackingUrl != null)
				return false;
		} else if (!trackingUrl.equals(other.trackingUrl))
			return false;
		if (websiteUrl == null) {
			if (other.websiteUrl != null)
				return false;
		} else if (!websiteUrl.equals(other.websiteUrl))
			return false;
		return true;
	}

	@Override
	public int compareTo(Carrier carrier) {
		if ( this == carrier ) 
			return EQUAL;
		else if (this.id < carrier.id) 
			return BEFORE;
		else if (carrier.id == this.id) 
			return EQUAL;
		else if (this.id > carrier.id)
			return AFTER;
		return EQUAL;
	}
}
