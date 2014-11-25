package com.mize.domain.common;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.MizeDateTime;

@Entity
@Table(name = "entity_address")
public class EntityAddress extends MizeSceEntity implements Comparable<EntityAddress>{
	private static final long serialVersionUID = 8115479374038082156L;
	private String type;
	private String address1;
	private String address2;
	private String address3;
	private String zip;
	private String zipExt;
	private String city;
	private State state;
	private Country country;
	private String email;
	private String landmark;
	List<EntityAddressPhone> addressPhones = new ArrayList<EntityAddressPhone>();
	EntityAddressGeo addressGeo = null;
	
	
	public EntityAddress(){
		super();
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

	@Column(name = "address_type", nullable = true)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "address_1", nullable = true)
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name = "address_2", nullable = true)
	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name = "address_3", nullable = true)
	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	@Column(name = "zip", nullable = true)
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Column(name = "zip_ext", nullable = true)
	public String getZipExt() {
		return zipExt;
	}

	public void setZipExt(String zipExt) {
		this.zipExt = zipExt;
	}

	@Column(name = "city", nullable = true)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "state_id")
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "country_id")
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Column(name = "email", nullable = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "updated_by")
	public Long getUpdatedBy() {
		return this.updatedBy;
	}
	
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Column(name = "created_by" , updatable=false)
	public Long getCreatedBy() {
		return this.createdBy;
	}
	
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	
	
	@Column(name = "created_date", updatable=false)
	@org.hibernate.annotations.Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@JsonInclude(Include.NON_DEFAULT)
	public MizeDateTime getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(MizeDateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name = "updated_date")
	@org.hibernate.annotations.Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@JsonInclude(Include.NON_DEFAULT)
	public MizeDateTime getUpdatedDate() {
		return this.updatedDate;
	}
	
	public void setUpdatedDate(MizeDateTime updatedDate) {
		this.updatedDate = updatedDate;
	} 
	
	@Column(name = "land_mark", nullable = true)
	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "address", orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<EntityAddressPhone> getAddressPhones() {
		return addressPhones;
	}

	public void setAddressPhones(List<EntityAddressPhone> addressPhones) {
		this.addressPhones = addressPhones;
	}

	@OneToOne(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "address", orphanRemoval = true)
	@JsonManagedReference(value="geoAddress")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public EntityAddressGeo getAddressGeo() {
		return addressGeo;
	}

	public void setAddressGeo(EntityAddressGeo addressGeo) {
		this.addressGeo = addressGeo;
	}
	
	@Column(name = "created_by_user", updatable=false)
	public String getCreatedByUser() {
		return createdByUser;
	}
	
	public void setCreatedByUser(String createdByUser) {
		this.createdByUser = createdByUser;
	}
	
	@Column(name = "updated_by_user")
	public String getUpdatedByUser() {
		return updatedByUser;
	}
	
	public void setUpdatedByUser(String updatedByUser) {
		this.updatedByUser = updatedByUser;
	}
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((address1 == null) ? 0 : address1.hashCode());
		result = prime * result
				+ ((address2 == null) ? 0 : address2.hashCode());
		result = prime * result
				+ ((address3 == null) ? 0 : address3.hashCode());
		result = prime * result
				+ ((addressGeo == null) ? 0 : addressGeo.hashCode());
		result = prime * result
				+ ((addressPhones == null) ? 0 : addressPhones.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((landmark == null) ? 0 : landmark.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
		result = prime * result + ((zipExt == null) ? 0 : zipExt.hashCode());
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
		EntityAddress other = (EntityAddress) obj;
		if (address1 == null) {
			if (other.address1 != null)
				return false;
		} else if (!address1.equals(other.address1))
			return false;
		if (address2 == null) {
			if (other.address2 != null)
				return false;
		} else if (!address2.equals(other.address2))
			return false;
		if (address3 == null) {
			if (other.address3 != null)
				return false;
		} else if (!address3.equals(other.address3))
			return false;
		if (addressGeo == null) {
			if (other.addressGeo != null)
				return false;
		} else if (!addressGeo.equals(other.addressGeo))
			return false;
		if (addressPhones == null) {
			if (other.addressPhones != null)
				return false;
		} else if (!addressPhones.equals(other.addressPhones))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (landmark == null) {
			if (other.landmark != null)
				return false;
		} else if (!landmark.equals(other.landmark))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		if (zipExt == null) {
			if (other.zipExt != null)
				return false;
		} else if (!zipExt.equals(other.zipExt))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EntityAddress [type=" + type + ", address1=" + address1
				+ ", address2=" + address2 + ", address3=" + address3
				+ ", zip=" + zip + ", zipExt=" + zipExt + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", email="
				+ email + ", landmark=" + landmark + ", addressPhones="
				+ addressPhones + ", addressGeo=" + addressGeo + ", id=" + id
				+ "]";
	}

	@Override
	public int compareTo(EntityAddress o) {
		return 0;
	}
	
	@JsonIgnore
	public static Comparator<EntityAddress> EntityAddressGeoDistanceComparator = new  Comparator<EntityAddress>() {
		public int compare(EntityAddress addr1, EntityAddress addr2) {
		      return  EntityAddressGeo.EntityGeoDistanceComparator.compare( addr1.getAddressGeo() , addr2.getAddressGeo());
		    }
	};

	
}
