package com.mize.domain.brand;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.product.ProductRegister;
import com.mize.domain.product.ProductRepeatOrderShipOptions;
import com.mize.domain.user.UserBrandMapping;
import com.mize.domain.util.JPASerializer;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, include="all")
@Table(name = "brand")
public class Brand extends MizeSceEntity implements Comparable<Brand>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5317108190942485164L;
	private String name;
	private String department;
	private String website;
	private String logoName;
	private String feedbackEmail ; 	
	private String registered;
	private List<BrandSupport> brandSupports = new ArrayList<BrandSupport>();
	private List<BrandFeed> brandFeeds = new ArrayList<BrandFeed>();
	private List<ProductRepeatOrderShipOptions> shippings = new ArrayList<ProductRepeatOrderShipOptions>();
	private List<ProductRegister> productRegisters = new ArrayList<ProductRegister>();
	private String searchType;
	private List<UserBrandMapping> userBrands = new ArrayList<UserBrandMapping>();

	public enum SearchType{
		equals,like;	
	}
	
	public static SearchType getSearchType(String num){
		for (SearchType sType : SearchType.values()) {
			if( sType.toString().equals(num) ){
				return sType;
			}
		}
		return null;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BRAND_ID")
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}	

	@Transient
	public Long getBrandId() {
		return id;
	}

	public void setBrandId(Long id) {
		this.id = id;
	}	

	public Brand() {
		
	}
	
	public Brand(Long id, String brandName, String website) {
		this(id, brandName, website, null, null, null);
	}

	public Brand(Long id, String brandName, String website, String logoName) {
		this(id, brandName, website, logoName, null, null);
	}

	public Brand(Long id, String name, String website, String logoName, String feedbackEmail, List<BrandSupport> brandSupports) {
		this.id = id;
		this.name = name;
		this.website = website;
		this.logoName = logoName;
		this.feedbackEmail = feedbackEmail;
		this.brandSupports = brandSupports;
	}
	
	@Transient
	public String getBrandName() {
		return name;
	}
	public void setBrandName(String brandName) {
		this.name = brandName;
	}
	
	@Column(name = "BRAND_NAME")
	public String getName() {
		return name;
	}
	public void setName(String brandName) {
		this.name = brandName;
	}
	@Column(name = "department")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "BRAND_LINK")
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Transient
	public List<BrandSupport> getBrandSupports() {
		return brandSupports;
	}

	public void setBrandSupports(List<BrandSupport> brandSupports) {
		this.brandSupports = brandSupports;
	}
	@Column(name = "BRAND_LOGO",  nullable = true, length = 50)
	public String getLogoName() {
		return logoName;
	}

	public void setLogoName(String logoName) {
		this.logoName = logoName;
	}
	@Column(name = "FEEDBACK_EMAIL")
	public String getFeedbackEmail() {
		return feedbackEmail;
	}

	public void setFeedbackEmail(String feedbackEmail) {
		this.feedbackEmail = feedbackEmail;
	}
	
	
	@Transient
	public List<BrandFeed> getBrandFeeds() {
		return brandFeeds;
	}

	public void setBrandFeeds(List<BrandFeed> brandFeeds) {
		this.brandFeeds = brandFeeds;
	}

	@Transient
	public List<ProductRepeatOrderShipOptions> getShippings() {
		return shippings;
	}

	public void setShippings(List<ProductRepeatOrderShipOptions> shippings) {
		this.shippings = shippings;
	}

	@Column(name = "registered")
	public String getRegistered() {
		return registered;
	}

	public void setRegistered(String registered) {
		this.registered = registered;
	}
	
	@Transient
	public List<ProductRegister> getProductRegisters() {
		return productRegisters;
	}

	public void setProductRegisters(List<ProductRegister> productRegisters) {
		this.productRegisters = productRegisters;
	}

	@Transient
	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}	
	
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL,mappedBy="brand")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<UserBrandMapping> getUserBrands() {
		return userBrands;
	}
	
	public void setUserBrands(List<UserBrandMapping> userBrands) {
		this.userBrands = userBrands;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((department == null) ? 0 : department.hashCode());
		result = prime * result
				+ ((feedbackEmail == null) ? 0 : feedbackEmail.hashCode());
		result = prime * result
				+ ((logoName == null) ? 0 : logoName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((registered == null) ? 0 : registered.hashCode());
		result = prime * result
				+ ((userBrands == null) ? 0 : userBrands.hashCode());
		result = prime * result + ((website == null) ? 0 : website.hashCode());
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
		Brand other = (Brand) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (feedbackEmail == null) {
			if (other.feedbackEmail != null)
				return false;
		} else if (!feedbackEmail.equals(other.feedbackEmail))
			return false;
		if (logoName == null) {
			if (other.logoName != null)
				return false;
		} else if (!logoName.equals(other.logoName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (registered == null) {
			if (other.registered != null)
				return false;
		} else if (!registered.equals(other.registered))
			return false;
		if (userBrands == null) {
			if (other.userBrands != null)
				return false;
		} else if (!userBrands.containsAll(other.userBrands))
			return false;
		if (website == null) {
			if (other.website != null)
				return false;
		} else if (!website.equals(other.website))
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Brand [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", department=");
		builder.append(department);
		builder.append(", website=");
		builder.append(website);
		builder.append(", logoName=");
		builder.append(logoName);
		builder.append(", feedbackEmail=");
		builder.append(feedbackEmail);
		builder.append(", brandSupports=");
		builder.append(brandSupports);
		builder.append(", brandFeeds=");
		builder.append(brandFeeds);
		builder.append("]");
		return builder.toString();
	}

	
	public int compareTo(Brand thatBrand) {
		if ( this == thatBrand ) 
			return EQUAL;
		else if (this.id < thatBrand.id) 
			return BEFORE;
		else if (thatBrand.id == this.id) 
			return EQUAL;
		else if (this.id > thatBrand.id)
			return AFTER;
		return EQUAL;		
	}	
	
}
