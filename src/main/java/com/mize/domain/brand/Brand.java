package com.mize.domain.brand;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.mize.domain.common.MizeEntity;
import com.mize.domain.product.ProductRegister;
import com.mize.domain.product.ProductRepeatOrderShipOptions;

@Entity
@Table(name = "brand")
public class Brand extends MizeEntity implements Comparable<Brand>{
	
	private static final long serialVersionUID = -7447355457187568168L;
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
	
	
	@Id
	@GenericGenerator(name="brandId" , strategy="increment")
	@GeneratedValue(generator="brandId")
	@Column(name = "BRAND_ID", unique = true, nullable = false, length = 10)
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
	
	@Column(name = "BRAND_NAME", unique = true, nullable = false, length = 250)
	public String getName() {
		return name;
	}
	public void setName(String brandName) {
		this.name = brandName;
	}
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "BRAND_LINK",  nullable = true, length = 250)
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "brand")
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
	@Column(name = "FEEDBACK_EMAIL",  nullable = true, length = 50)
	public String getFeedbackEmail() {
		return feedbackEmail;
	}

	public void setFeedbackEmail(String feedbackEmail) {
		this.feedbackEmail = feedbackEmail;
	}
	
	
	@OneToMany(mappedBy = "brand",fetch = FetchType.LAZY)
	public List<BrandFeed> getBrandFeeds() {
		return brandFeeds;
	}

	public void setBrandFeeds(List<BrandFeed> brandFeeds) {
		this.brandFeeds = brandFeeds;
	}

	@OneToMany(mappedBy = "brand")
	public List<ProductRepeatOrderShipOptions> getShippings() {
		return shippings;
	}

	public void setShippings(List<ProductRepeatOrderShipOptions> shippings) {
		this.shippings = shippings;
	}

	public String getRegistered() {
		return registered;
	}

	public void setRegistered(String registered) {
		this.registered = registered;
	}
	
	@OneToMany(fetch = FetchType.LAZY, cascade =CascadeType.ALL)
	@JoinColumn(name="prod_regn_id") 
	public List<ProductRegister> getProductRegisters() {
		return productRegisters;
	}

	public void setProductRegisters(List<ProductRegister> productRegisters) {
		this.productRegisters = productRegisters;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = PRIME * result	+ ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if ( !(obj instanceof Brand))
			return false;
		Brand other = (Brand) obj;
		
		if (id==null) {
			if (other.id!= null)
				return false;
		} else if (!id.equals(other.id)) 
			return false;

		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
