package com.mize.domain.part;

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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.MizeEntity;
import com.mize.domain.servicelocator.BusinessEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;

@Entity
@Table(name = "part", uniqueConstraints = {@UniqueConstraint (columnNames = {"tenant_id", "part_code"})})
public class Part extends MizeEntity {	

	private static final long serialVersionUID = 2686388059625468728L;
	private BusinessEntity tenant;
	private String code;
	private String type;
	private String isActive;
	private String isKit;
	private String isSerialized;
	private String isReturnable;
	private String uom;
	private List<PartIntl> partIntl;
	private List<PartPrice> partPrices;
	private List<PartAttribute> partAttributes;
	private List<PartKit> partKits;

	public Part() {
		super();
	}

	

	public Part(BusinessEntity tenant, String partCode, String partType,
			String isActive, String isKit, String isSerialized,
			String isReturnable, String uom, List<PartIntl> partIntl,
			List<PartPrice> partPrices, List<PartAttribute> partAttributes,
			List<PartKit> partKits) {
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
		this.partKits = partKits;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}

	@ManyToOne(cascade={CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name="tenant_id")
	public BusinessEntity getTenant() {
		return tenant;
	}

	@Column(name = "part_code", length = 30, nullable = false)
	public String getCode() {
		return code;
	}

	@Column(name = "part_type", length = 30, nullable = true)
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

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "part")
	public List<PartAttribute> getPartAttributes() {
		return partAttributes;
	}

	@Column(name = "uom", length = 30, nullable = true)
	public String getUom() {
		return uom;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER, mappedBy = "part")
	public List<PartIntl> getPartIntl() {
		return partIntl;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade={CascadeType.ALL}, mappedBy = "part")
	public List<PartPrice> getPartPrices() {
		return partPrices;
	}

	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "created_date")
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "updated_date")
	public DateTime getUpdatedDate() {
		return updatedDate;
	}

	@Override
	@JsonIgnore
	@Column(name = "created_by")
	public Long getCreatedBy() {		
		return super.getCreatedBy();
	}

	@Override
	@JsonIgnore
	@Column(name = "updated_by")
	public Long getUpdatedBy() {		
		return super.getUpdatedBy();
	}

	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "part")
	public List<PartKit> getPartKits() {
		return partKits;
	}

	public void setPartKits(List<PartKit> partKits) {
		this.partKits = partKits;
	}



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

	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore
	public void setCreatedDate(DateTime createdDate) {
		super.createdDate = createdDate;
	}

	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore
	public void setUpdatedDate(DateTime updatedDate) {
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


	@PrePersist
	@PreUpdate
	public void auditFields(){
		if(createdDate==null && id==null){
			setCreatedDate(DateTime.now());
		}
		setUpdatedDate(DateTime.now());		
	}



	@Override
	public String toString() {
		return "Part [tenant=" + tenant + ", code=" + code + ", type=" + type
				+ ", isActive=" + isActive + ", isKit=" + isKit
				+ ", isSerialized=" + isSerialized + ", isReturnable="
				+ isReturnable + ", uom=" + uom + ", partIntl=" + partIntl
				+ ", partPrices=" + partPrices + ", partAttributes="
				+ partAttributes + ", partKits=" + partKits + "]";
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
				+ ((partKits == null) ? 0 : partKits.hashCode());
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
		if (partKits == null) {
			if (other.partKits != null)
				return false;
		} else if (!partKits.equals(other.partKits))
			return false;
		if (partPrices == null) {
			if (other.partPrices != null)
				return false;
		} else if (!partPrices.equals(other.partPrices))
			return false;
		if (tenant == null) {
			if (other.tenant != null)
				return false;
		} else if (!tenant.equals(other.tenant))
			return false;
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
	
	

}