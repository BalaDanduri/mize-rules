package com.mize.domain.part;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.MizeDateTime;

@Entity
@Inheritance
@DiscriminatorColumn(name = "discriminator")
@DiscriminatorValue("Part")
@Table(name = "part", uniqueConstraints = {@UniqueConstraint (columnNames = {"tenant_id", "part_code"})})
public class Part extends MizeSceEntity implements Comparable<Part>{	

	private static final long serialVersionUID = 2686388059625468728L;
	private BusinessEntity tenant;
	private String code;
	private String type;
	private String isActive;
	private String isKit;
	private String isSerialized;
	private String isReturnable;
	private String uom;
	private List<PartIntl> partIntl = new ArrayList<PartIntl>();
	private List<PartPrice> partPrices = new ArrayList<PartPrice>();
	private List<PartAttribute> partAttributes = new ArrayList<PartAttribute>();
	private BigDecimal unitListPrice;
	private BigDecimal unitNetPrice;
	private String productClass;
	@Transient
	private String originalPart;
	@Transient
	private BigDecimal onHandQuantity;	
	@Transient
	private User user;
	@Transient
	private List<PartAvailability> partAvailabilities;
	
	public Part() {
		super();
	}	

	public Part(BusinessEntity tenant, String partCode, String partType,
			String isActive, String isKit, String isSerialized,
			String isReturnable, String uom, List<PartIntl> partIntl,
			List<PartPrice> partPrices, List<PartAttribute> partAttributes) {
		super();
		this.tenant = tenant;
		this.code = partCode;
		this.type = partType;
		this.isActive = isActive;
		this.isKit = isKit;
		this.isSerialized = isSerialized;
		this.isReturnable = isReturnable;
		this.uom = uom;
		this.partIntl = partIntl;
		this.partPrices = partPrices;
		this.partAttributes = partAttributes;
	}
	
	public Part(Long id, String partCode, String partType, String isActive, String isKit, String isSerialized, String isReturnable, String uom) {
		super();
		this.id = id;
		this.code = partCode;
		this.type = partType;
		this.isActive = isActive;
		this.isKit = isKit;
		this.isSerialized = isSerialized;
		this.isReturnable = isReturnable;
		this.uom = uom;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tenant_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getTenant() {
		return tenant;
	}

	@Column(name = "part_code", length = 50, nullable = false)
	public String getCode() {
		return code;
	}

	@Column(name = "part_type", length = 50, nullable = true)
	public String getType() {
		return type;
	}

	@Column(name = "is_active", length = 1, nullable = true)
	public String getIsActive() {
		return isActive;
	}

	@Column(name = "is_kit", length = 1, nullable = true)
	public String getIsKit() {
		return isKit;
	}

	@Column(name = "is_serialized", length = 1, nullable = true)
	public String getIsSerialized() {
		return isSerialized;
	}

	@Column(name = "is_returnable", length = 1, nullable = true)
	public String getIsReturnable() {
		return isReturnable;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "part",orphanRemoval= true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonManagedReference(value="partAttribute")
	public List<PartAttribute> getPartAttributes() {
		return partAttributes;
	}

	@Column(name = "uom", length = 50, nullable = true)
	public String getUom() {
		return uom;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER, mappedBy = "part" ,orphanRemoval= true)
	@Fetch(FetchMode.SELECT)
	@JsonManagedReference(value="partIntl")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<PartIntl> getPartIntl() {
		return partIntl;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade={CascadeType.ALL}, mappedBy = "part", orphanRemoval= true )
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonManagedReference(value="partPrice")
	public List<PartPrice> getPartPrices() {
		return partPrices;
	}

	
/*	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "part")
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	@JsonManagedReference(value="partKits")
	public List<PartKit> getPartKits() {
		return partKits;
	}

	public void setPartKits(List<PartKit> partKits) {
		this.partKits = partKits;
	}*/



	@Override
	public void setId(Long id) {
		super.id = id;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public void setIsKit(String isKit) {
		this.isKit = isKit;
	}

	public void setIsSerialized(String isSerialized) {
		this.isSerialized = isSerialized;
	}

	public void setIsReturnable(String isReturnable) {
		this.isReturnable = isReturnable;
	}

	public void setPartAttributes(List<PartAttribute> partAttributes) {
		this.partAttributes = partAttributes;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}	

	public void setPartIntl(List<PartIntl> partIntl) {
		this.partIntl = partIntl;
	}

	public void setPartPrices(List<PartPrice> partPrices) {
		this.partPrices = partPrices;
	}

	@Column(name = "created_by" , updatable=false)
	@JsonIgnore
	public Long getCreatedBy() {
		return createdBy;
	}
	
	@JsonIgnore
	public void setCreatedBy(Long createdBy) {		
		super.setCreatedBy(createdBy);
	}
	
	@JsonIgnore
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name = "updated_by")
	@JsonIgnore
	public Long getUpdatedBy() {		
		return super.getUpdatedBy();
	}
	
	@JsonIgnore(false)
	public void setCreatedDate(MizeDateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name = "created_date",updatable = false)
	@org.hibernate.annotations.Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@JsonInclude(Include.NON_DEFAULT)
	@JsonIgnore(value = false)
	public MizeDateTime getCreatedDate() {
		return createdDate;
	}

	@JsonIgnore(false)
	public void setUpdatedDate(MizeDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@Column(name = "updated_date")
	@org.hibernate.annotations.Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@JsonInclude(Include.NON_DEFAULT)
	@JsonIgnore(value = false)
	public MizeDateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@Column(name = "created_by_user")
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
	
	@PrePersist
	@PreUpdate
	public void auditFields(){
		if(createdDate==null && id==null){
			setCreatedDate(MizeDateTime.now());
		}
		setUpdatedDate(MizeDateTime.now());		
	}



	@Override
	public String toString() {
		return "Part [tenant=" + tenant + ", code=" + code + ", type=" + type
				+ ", isActive=" + isActive + ", isKit=" + isKit
				+ ", isSerialized=" + isSerialized + ", isReturnable="
				+ isReturnable + ", uom=" + uom + ", partIntl=" + partIntl
				+ ", partPrices=" + partPrices + ", partAttributes="
				+ partAttributes  + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((isKit == null) ? 0 : isKit.hashCode());
		result = prime * result
				+ ((isReturnable == null) ? 0 : isReturnable.hashCode());
		result = prime * result
				+ ((isSerialized == null) ? 0 : isSerialized.hashCode());
		result = prime * result
				+ ((partAttributes == null) ? 0 : partAttributes.hashCode());
		result = prime * result
				+ ((partIntl == null) ? 0 : partIntl.hashCode());
		result = prime * result
				+ ((partPrices == null) ? 0 : partPrices.hashCode());
		result = prime * result + ((tenant == null) ? 0 : tenant.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((uom == null) ? 0 : uom.hashCode());
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
		Part other = (Part) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (isKit == null) {
			if (other.isKit != null)
				return false;
		} else if (!isKit.equals(other.isKit))
			return false;
		if (isReturnable == null) {
			if (other.isReturnable != null)
				return false;
		} else if (!isReturnable.equals(other.isReturnable))
			return false;
		if (isSerialized == null) {
			if (other.isSerialized != null)
				return false;
		} else if (!isSerialized.equals(other.isSerialized))
			return false;
		if (partAttributes == null) {
			if (other.partAttributes != null)
				return false;
		} else if (!partAttributes.equals(other.partAttributes))
			return false;
		if (partIntl == null) {
			if (other.partIntl != null)
				return false;
		} else if (!partIntl.equals(other.partIntl))
			return false;
		if (partPrices == null) {
			if (other.partPrices != null)
				return false;
		} else if (!partPrices.equals(other.partPrices))
			return false;
		if (tenant == null) {
			if (other.tenant != null)
				return false;
		} else {
			if(tenant.getId() == null) {
				if(other.tenant.getId() != null)
					return false;
				} else if(!tenant.getId().equals(other.tenant.getId()))
				return false;
		}
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (uom == null) {
			if (other.uom != null)
				return false;
		} else if (!uom.equals(other.uom))
			return false;
		return true;
	}

	@Transient
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Transient
	public BigDecimal getUnitListPrice() {
		return unitListPrice;
	}

	public void setUnitListPrice(BigDecimal unitListPrice) {
		this.unitListPrice = unitListPrice;
	}

	@Transient
	public BigDecimal getUnitNetPrice() {
		return unitNetPrice;
	}

	public void setUnitNetPrice(BigDecimal unitNetPrice) {
		this.unitNetPrice = unitNetPrice;
	}

	@Transient
	public String getProductClass() {
		return productClass;
	}

	public void setProductClass(String productClass) {
		this.productClass = productClass;
	}

	@Transient
	public String getOriginalPart() {
		return originalPart;
	}

	public void setOriginalPart(String originalPart) {
		this.originalPart = originalPart;
	}
	
	@Transient
	public BigDecimal getOnHandQuantity() {
		return onHandQuantity;
	}
	
	public void setOnHandQuantity(BigDecimal onHandQuantity) {
		this.onHandQuantity = onHandQuantity;
	}

	@Transient
	public List<PartAvailability> getPartAvailabilities() {
		return partAvailabilities;
	}

	public void setPartAvailabilities(List<PartAvailability> partAvailabilities) {
		this.partAvailabilities = partAvailabilities;
	}

	@Override
	public int compareTo(Part arg0) {
		return 0;
	}
	
	
}
