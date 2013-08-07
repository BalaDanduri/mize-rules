package com.mize.domain.servicelocator;

import java.util.Comparator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import com.mize.domain.common.Country;
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.common.State;

@Entity
@Table(name="business_entity_address")
public class BusinessEntityAddress  extends MizeEntity  implements Comparable<BusinessEntityAddress>{

	private static final long serialVersionUID = 625412111910612584L;	
	private long beId;
	private String code;
	private Locale locale;
	private String name;
	private String address1;
	private String address2;
	private String address3;
	private String zip;
	private String zipExt;
	private String city;
	private String county;
	private State state;
	private Country country;
	private String phone1;
	private String phone2;
	private String email;
	private String fax;
	private String landMark;
	private String url;
	private String toolTipLogo;
	private String icon;
	private BusinessEntityGeo geoLocation;
	private BusinessEntity businessEntity;
	
	
	
	public BusinessEntityAddress() {
		geoLocation = new BusinessEntityGeo();
	}
	
	
	
	public BusinessEntityAddress(long beId, String code, Locale locale,
			String name, String address1, String address2, String address3,
			String zip, String zipExt, String city, String county, State state,
			Country country, String phone1, String phone2, String email,
			String fax, String landMark, String url, String toolTipLogo,
			String icon, BusinessEntityGeo geoLocation) {
		super();
		this.beId = beId;
		this.code = code;
		this.locale = locale;
		this.name = name;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.zip = zip;
		this.zipExt = zipExt;
		this.city = city;
		this.county = county;
		this.state = state;
		this.country = country;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.email = email;
		this.fax = fax;
		this.landMark = landMark;
		this.url = url;
		this.toolTipLogo = toolTipLogo;
		this.icon = icon;
		this.geoLocation = geoLocation;
	}



	@Id
	@GenericGenerator(name="businessEntityAddressId",strategy="increment")
	@GeneratedValue(generator="businessEntityAddressId")
	@Column(name="id",nullable=false,unique=true)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="be_id",insertable=false,updatable=false)
	public long getBeId() {
		return beId;
	}
	public void setBeId(long beId) {
		this.beId = beId;
	}
	@Column(name="code",nullable=true,length=50)
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	@ManyToOne(targetEntity=Locale.class)
	@JoinColumn(name="locale_id",nullable=true)
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	@Column(name="name",nullable=true,length=200)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="address_1",nullable=true,length=100)
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	@Column(name="address_2",nullable=true,length=100)
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	@Column(name="address_3",nullable=true,length=100)
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	@Column(name="zip",nullable=true,length=10)
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Column(name="zip_ext",nullable=true,length=10)
	public String getZipExt() {
		return zipExt;
	}
	public void setZipExt(String zipExt) {
		this.zipExt = zipExt;
	}
	@Column(name="city",nullable=true,length=50)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name="county",nullable=true,length=50)
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	
	@ManyToOne(targetEntity=State.class)
	@JoinColumn(name="state_id",nullable=true)
	//@Column(name="state_id",nullable=true)
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	
	@ManyToOne(targetEntity=Country.class)
	@JoinColumn(name="country_id",nullable=true)
	//@Column(name="country_id",nullable=true)
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	@Column(name="phone_1",nullable=true,length=50)
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	@Column(name="phone_2",nullable=true,length=50)
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	@Column(name="email",nullable=true,length=50)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="fax",nullable=true,length=50)
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	@Column(name="land_mark",nullable=true,length=500)
	public String getLandMark() {
		return landMark;
	}
	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}
	@Column(name="url",nullable=true,length=256)
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Column(name="tool_tip_logo",nullable=true,length=100)
	public String getToolTipLogo() {
		return toolTipLogo;
	}
	public void setToolTipLogo(String toolTipLogo) {
		this.toolTipLogo = toolTipLogo;
	}
	@Column(name="icon",nullable=true,length=100)
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int compareTo(BusinessEntityAddress o) {
		return(int)( this.getId() - o.getId());
	}
	@OneToOne(cascade = CascadeType.ALL,mappedBy="businessEntityAddress")	
	public BusinessEntityGeo getGeoLocation() {
		return geoLocation;
	}
	public void setGeoLocation(BusinessEntityGeo geoLocation) {
		this.geoLocation = geoLocation;
	}
	
	@JsonIgnore
	public static Comparator<BusinessEntityAddress> BusinessEntityAddressDurationComparator = new  Comparator<BusinessEntityAddress>() {
		public int compare(BusinessEntityAddress beAddress1, BusinessEntityAddress beAddress2) {
		    return BusinessEntityGeo.BusinessEntityGeoDurationComparator.compare(beAddress1.getGeoLocation(),beAddress2.getGeoLocation());
		}
	};
	
	@JsonIgnore
	public static Comparator<BusinessEntityAddress> BusinessEntityAddressDistanceComparator = new  Comparator<BusinessEntityAddress>() {
		public int compare(BusinessEntityAddress beAddress1, BusinessEntityAddress beAddress2) {
		    return beAddress1.getGeoLocation().compareTo(beAddress2.getGeoLocation());
		}
	};


	@ManyToOne
	@JoinColumn(name="be_id")
	@JsonIgnore
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((address1 == null) ? 0 : address1.hashCode());
		result = prime * result
				+ ((address2 == null) ? 0 : address2.hashCode());
		result = prime * result
				+ ((address3 == null) ? 0 : address3.hashCode());
		result = prime * result + (int) (beId ^ (beId >>> 32));
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((county == null) ? 0 : county.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result
				+ ((geoLocation == null) ? 0 : geoLocation.hashCode());
		result = prime * result + ((icon == null) ? 0 : icon.hashCode());
		result = prime * result
				+ ((landMark == null) ? 0 : landMark.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone1 == null) ? 0 : phone1.hashCode());
		result = prime * result + ((phone2 == null) ? 0 : phone2.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result
				+ ((toolTipLogo == null) ? 0 : toolTipLogo.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		BusinessEntityAddress other = (BusinessEntityAddress) obj;
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
		if (beId != other.beId)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (county == null) {
			if (other.county != null)
				return false;
		} else if (!county.equals(other.county))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (geoLocation == null) {
			if (other.geoLocation != null)
				return false;
		} else if (!geoLocation.equals(other.geoLocation))
			return false;
		if (icon == null) {
			if (other.icon != null)
				return false;
		} else if (!icon.equals(other.icon))
			return false;
		if (landMark == null) {
			if (other.landMark != null)
				return false;
		} else if (!landMark.equals(other.landMark))
			return false;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone1 == null) {
			if (other.phone1 != null)
				return false;
		} else if (!phone1.equals(other.phone1))
			return false;
		if (phone2 == null) {
			if (other.phone2 != null)
				return false;
		} else if (!phone2.equals(other.phone2))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (toolTipLogo == null) {
			if (other.toolTipLogo != null)
				return false;
		} else if (!toolTipLogo.equals(other.toolTipLogo))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
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
	
	
}
