package com.mize.domain.sce.part;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.Country;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateDeserializer;
import com.mize.domain.util.JsonDateSerializer;

@Entity
@Table(name = "part_price")
public class PartPrice extends MizeEntity {
	
	private static final long serialVersionUID = -3133914500164853623L;
	private Part part;
	private BigDecimal unitPrice;
	private BigDecimal listPrice;
	private BigDecimal netPrice;
	private DateTime startDate;
	private DateTime endDate;
	private String currencyCode;
	private Country country;
	
	public PartPrice() {
		super();
	}	
	
	
	public PartPrice(Part part, BigDecimal unitPrice, BigDecimal listPrice,
			BigDecimal netPrice, DateTime startDate, DateTime endDate,
			String currencyCode, Country country) {
		this.part = part;
		this.unitPrice = unitPrice;
		this.listPrice = listPrice;
		this.netPrice = netPrice;
		this.startDate = startDate;
		this.endDate = endDate;
		this.currencyCode = currencyCode;
		this.country = country;
	}


	@Id
	@GenericGenerator(name = "partPriceId", strategy = "increment")
	@GeneratedValue(generator = "partPriceId")
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {		
		return id;
	}

	@Override
	public void setId(Long id) {
		super.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "part_id")
	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}
	
	@Column(name = "unit_price", nullable = true)
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	@Column(name = "list_price", nullable = true)
	public BigDecimal getListPrice() {
		return listPrice;
	}

	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}
	
	@Column(name = "net_price", nullable = true)
	public BigDecimal getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(BigDecimal netPrice) {
		this.netPrice = netPrice;
	}
	
	@Column(name = "start_date", nullable = true)
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using = JsonDateSerializer.class, include = Inclusion.NON_NULL)
	public DateTime getStartDate() {
		return startDate;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	@JsonDeserialize(using = JodaDateDeserializer.class)
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}
	
	@Column(name = "end_date", nullable = true)
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using = JsonDateSerializer.class,include=Inclusion.NON_NULL)
	public DateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}
	
	@Column(name = "currency_code", nullable = true, length = 30)
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id")
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}


	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result
				+ ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result
				+ ((listPrice == null) ? 0 : listPrice.hashCode());
		result = prime * result
				+ ((netPrice == null) ? 0 : netPrice.hashCode());
		result = prime * result + ((part == null) ? 0 : part.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
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
		if (part == null) {
			if (other.part != null)
				return false;
		} else if (!part.equals(other.part))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
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
		StringBuffer builder = new StringBuffer();
		builder.append("PartPrice [part=");
		builder.append(part);
		builder.append(", unitPrice=");
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
		builder.append("]");		
		return builder.toString();		
		
	}	
	

}
