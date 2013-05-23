package com.mize.domain.servicelocator;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.mize.domain.common.Country;
import com.mize.domain.common.Entity;
import com.mize.domain.common.State;
import com.mize.domain.prod.Locale;

public class BusinessEntityAddress  extends Entity  implements Comparable<BusinessEntityAddress>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 625412111910612584L;
	
	private long id;
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
	private ArrayList<BusinessEntityGeo> geoLocationList;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getBeId() {
		return beId;
	}
	public void setBeId(long beId) {
		this.beId = beId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getZipExt() {
		return zipExt;
	}
	public void setZipExt(String zipExt) {
		this.zipExt = zipExt;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getLandMark() {
		return landMark;
	}
	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getToolTipLogo() {
		return toolTipLogo;
	}
	public void setToolTipLogo(String toolTipLogo) {
		this.toolTipLogo = toolTipLogo;
	}
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
	
	@JsonIgnore
	public boolean addGeoLocation(BusinessEntityGeo businessEntityGeo) {
		if(geoLocationList==null) {
			geoLocationList = new ArrayList<BusinessEntityGeo>();
		}
		geoLocationList.add(businessEntityGeo);
		return true;
	}
	
	@JsonIgnore
	public int getGeoLocationCount() {
		return geoLocationList==null?0:geoLocationList.size();
	}
	
	@JsonIgnore
	public BusinessEntityGeo getAddressAt(int index) {
		return (geoLocationList!=null&& geoLocationList.size()>index)? geoLocationList.get(index) : null;
	}
	
	@JsonIgnore
	public boolean updateGeoLocationAt(int index,BusinessEntityGeo businessEntityGeo) {
		if(geoLocationList!=null&& geoLocationList.size()>index) {
			geoLocationList.set(index, businessEntityGeo);
			return true;
		}
		return false;
	}
}
