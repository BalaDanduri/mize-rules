package com.mize.domain.part;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.common.Country;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.datetime.Date;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.PopulateCountry;

@Entity
@Inheritance
@DiscriminatorColumn(name = "discriminator")
@DiscriminatorValue("PartPrice")
@Table(name = "part_price")
public class PartPrice extends MizeSceEntityAudit implements Comparable<PartPrice>{

	private static final long serialVersionUID = -3133914500164853623L;
	private Part part;
	private BigDecimal unitPrice;
	private BigDecimal listPrice;
	private BigDecimal netPrice;
	private Date startDate;
	private Date endDate;
	private String currencyCode;
	@PopulateCountry
	private Country country;
	private Long countryId;
	private Long taxId;
	@Transient
	private User user;

	public PartPrice() {
		super();
	}	

	public PartPrice(Part part, BigDecimal unitPrice, BigDecimal listPrice,
			BigDecimal netPrice, Date startDate, Date endDate,
			String currencyCode, Country country, Long taxId) {
		super();
		this.part = part;
		this.unitPrice = unitPrice;
		this.listPrice = listPrice;
		this.netPrice = netPrice;
		this.startDate = startDate;
		this.endDate = endDate;
		this.currencyCode = currencyCode;
		this.country = country;
		this.taxId = taxId;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	@Override
	public Long getId() {		
		return id;
	}
 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "part_id")
	@JsonBackReference(value ="partPrice")
	public Part getPart() {
		return part;
	}


	@Column(name = "unit_price")
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	
	@Column(name = "list_price")
	public BigDecimal getListPrice() {
		return listPrice;
	}
	
	@Column(name = "net_price")
	public BigDecimal getNetPrice() {
		return netPrice;
	}
	
	@Column(name = "start_date")
    @JsonInclude(Include.NON_DEFAULT)
	public Date getStartDate() {
		return startDate;
	}

	@Column(name = "end_date")
    @JsonInclude(Include.NON_DEFAULT)
	public Date getEndDate() {
		return endDate;
	}
    

	@JsonSerialize(using=JPASerializer.class)
    @JsonInclude(Include.NON_NULL)
	@Transient
	public Country getCountry() {
		return country;
	}
	
	@Column(name = "currency_code")
	public String getCurrencyCode() {
		return currencyCode;
	}
    
	@Column(name = "tax_id")
	public Long getTaxId() {
		return taxId;
	}
	
	@Override
	public void setId(Long id) {
		super.id = id;
	}

	
	public void setPart(Part part) {
		this.part = part;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}

	public void setNetPrice(BigDecimal netPrice) {
		this.netPrice = netPrice;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	public void setTaxId(Long taxId) {
		this.taxId = taxId;
	}

	@Transient
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Column(name = "country_id")
	@JsonIgnore
	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result
				+ ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result
				+ ((listPrice == null) ? 0 : listPrice.hashCode());
		result = prime * result
				+ ((netPrice == null) ? 0 : netPrice.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((taxId == null) ? 0 : taxId.hashCode());
		result = prime * result
				+ ((unitPrice == null) ? 0 : unitPrice.hashCode());
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
		PartPrice other = (PartPrice) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (currencyCode == null) {
			if (other.currencyCode != null)
				return false;
		} else if (!currencyCode.equals(other.currencyCode))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (listPrice == null) {
			if (other.listPrice != null)
				return false;
		} else if (!listPrice.equals(other.listPrice))
			return false;
		if (netPrice == null) {
			if (other.netPrice != null)
				return false;
		} else if (!netPrice.equals(other.netPrice))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (taxId == null) {
			if (other.taxId != null)
				return false;
		} else if (!taxId.equals(other.taxId))
			return false;
		if (unitPrice == null) {
			if (other.unitPrice != null)
				return false;
		} else if (!unitPrice.equals(other.unitPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PartPrice [");
		builder.append(" unitPrice=");
		builder.append(unitPrice);
		builder.append(", listPrice=");
		builder.append(listPrice);
		builder.append(", netPrice=");
		builder.append(netPrice);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", currencyCode=");
		builder.append(currencyCode);
		builder.append(", country=");
		builder.append(country);
		builder.append(", taxId=");
		builder.append(taxId);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(PartPrice arg0) {
		return 0;
	}
}
