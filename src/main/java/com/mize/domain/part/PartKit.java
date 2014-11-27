package com.mize.domain.part;

import java.math.BigDecimal;
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
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.MizeDateTime;

@Entity
@Table(name = "part_kit", uniqueConstraints = {@UniqueConstraint (columnNames = {"part_id"})})
public class PartKit extends MizeSceEntity implements Comparable<PartKit>{

	private static final long serialVersionUID = 4502594935806813253L;
	
	private Part part;
	private String priceMethod;
	private String type;
	private String isActive;
	private MizeDateTime startDate;
	private MizeDateTime endDate;
	private List<PartKitItem> partKitItems = new ArrayList<PartKitItem>();
	@Transient
	private User user;
	@Transient
	private BusinessEntity tenant;
	@Transient
	private BigDecimal partQty;
	@Transient
	private BigDecimal partPrice;
	@Transient
	private List<PartSubstitute> partSubstitutes = new ArrayList<PartSubstitute>();
		
	public PartKit(){
		super();
	}
	
	public PartKit(Part part, String priceMethod, String type,
			String isActive, MizeDateTime startDate, MizeDateTime endDate,
			List<PartKitItem> partKitItems) {
		super();
		this.part = part;
		this.priceMethod = priceMethod;
		this.type = type;
		this.isActive = isActive;
		this.startDate = startDate;
		this.endDate = endDate;
		this.partKitItems = partKitItems;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "part_id")
	//@JsonBackReference(value="partKits")
	public Part getPart() {
		return part;
	}

	@Column(name = "price_method", length = 50, nullable = false)
	public String getPriceMethod() {
		return priceMethod;
	}

	@Column(name = "kit_type", length = 50, nullable = false)
	public String getType() {
		return type;
	}

	@Column(name = "is_active", length = 1, nullable = false)
	public String getIsActive() {
		return isActive;
	}

	
	@Column(name = "start_date", nullable = false)
	@Type(type="com.mize.domain.util.MizeDateTimeJPA")
	public MizeDateTime getStartDate() {
		return startDate;
	}

	
	@Column(name = "end_date", nullable = false)
	@Type(type="com.mize.domain.util.MizeDateTimeJPA")
	public MizeDateTime getEndDate() {
		return endDate;
	}
	
	@Override	
	@Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@Column(name = "created_date",updatable=false)
	@JsonIgnore(false)
	public MizeDateTime getCreatedDate() {
		return createdDate;
	}
	
	@Override	
	@Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@Column(name = "updated_date")
	@JsonIgnore(false)
	public MizeDateTime getUpdatedDate() {
		return updatedDate;
	}
	
	
	@Override
	@JsonIgnore
	@Column(name = "created_by",updatable=false)
	public Long getCreatedBy() {		
		return super.getCreatedBy();
	}

	
	@Override
	@JsonIgnore
	@Column(name = "updated_by")
	public Long getUpdatedBy() {		
		return super.getUpdatedBy();
	}
	
	@Override
	@JsonIgnore
	@Column(name = "created_by_user",updatable=false)
	public String getCreatedByUser() {
		return super.getCreatedByUser();
	}
	
	@Override
	@JsonIgnore
	@Column(name = "updated_by_user")
	public String getUpdatedByUser() {
		return super.getUpdatedByUser();
	}
	
	@OneToMany(cascade={CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "partKit" , orphanRemoval= true)
	@Fetch(FetchMode.SUBSELECT)
	public List<PartKitItem> getPartKitItems() {
		return partKitItems;
	}

	
	public void setPartKitItems(List<PartKitItem> partKitItems) {
		this.partKitItems = partKitItems;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public void setPriceMethod(String priceMethod) {
		this.priceMethod = priceMethod;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public void setStartDate(MizeDateTime startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(MizeDateTime endDate) {
		this.endDate = endDate;
	}
	
	@Override
	@JsonIgnore(false)
	public void setCreatedDate(MizeDateTime createdDate) {
		super.createdDate = createdDate;
	}
	
	@Override
	@JsonIgnore(false)
	public void setUpdatedDate(MizeDateTime updatedDate) {
		super.updatedDate = updatedDate;
	}
	
	@Override
	@JsonIgnore
	public void setCreatedBy(Long createdBy) {		
		super.setCreatedBy(createdBy);
	}
	
	@Override
	@JsonIgnore
	public void setUpdatedBy(Long updatedBy) {		
		super.setUpdatedBy(updatedBy);
	}
	
	@Override
	@JsonIgnore
	public void setCreatedByUser(String createdByUser) {
		super.setCreatedByUser(createdByUser);
	}
	
	@Override
	@JsonIgnore
	public void setUpdatedByUser(String updatedByUser) {
		super.setUpdatedByUser(updatedByUser);
	}
	
	@Transient	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Transient
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	@Transient
	public BigDecimal getPartQty() {
		return partQty;
	}
	
	public void setPartQty(BigDecimal partQty) {
		this.partQty = partQty;
	}

	@Transient
	public BigDecimal getPartPrice() {
		return partPrice;
	}

	public void setPartPrice(BigDecimal partPrice) {
		this.partPrice = partPrice;
	}

	@Transient
	public List<PartSubstitute> getPartSubstitutes() {
		return partSubstitutes;
	}

	public void setPartSubstitutes(List<PartSubstitute> partSubstitutes) {
		this.partSubstitutes = partSubstitutes;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result
				+ ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result
				+ ((partKitItems == null) ? 0 : partKitItems.hashCode());
		result = prime * result
				+ ((priceMethod == null) ? 0 : priceMethod.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		PartKit other = (PartKit) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (partKitItems == null) {
			if (other.partKitItems != null)
				return false;
		} else if (!partKitItems.equals(other.partKitItems))
			return false;
		if (priceMethod == null) {
			if (other.priceMethod != null)
				return false;
		} else if (!priceMethod.equals(other.priceMethod))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PartKit [part=" + part + ", priceMethod=" + priceMethod
				+ ", type=" + type + ", isActive=" + isActive + ", startDate="
				+ startDate + ", endDate=" + endDate + ", partKitItems="
				+ partKitItems + "]";
	}

	@Override
	public int compareTo(PartKit o) {
		return 0;
	}
	
	
}
