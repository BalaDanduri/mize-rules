package com.mize.domain.sce.part;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

import com.mize.domain.common.MizeEntity;
import com.mize.domain.servicelocator.BusinessEntity;

@Entity
@Table(name = "part", uniqueConstraints = {@UniqueConstraint (columnNames = {"tenant_id", "part_code"})})
public class Part extends MizeEntity {	
	
	private static final long serialVersionUID = 2686388059625468728L;
	private BusinessEntity tenant;
	private String partCode;
	private String partType;
	private String isActive;
	private String isKit;
	private String uom;
	private List<PartIntl> partIntl;
	private List<PartPrice> partPrice;
	
	
	public Part() {
		super();
	}

	public Part(BusinessEntity tenant, String partCode, String partType,
			String isActive, String isKit, String uom, List<PartIntl> partIntl,
			List<PartPrice> partPrice) {
		this.tenant = tenant;
		this.partCode = partCode;
		this.partType = partType;
		this.isActive = isActive;
		this.isKit = isKit;
		this.uom = uom;
		this.partIntl = partIntl;
		this.partPrice = partPrice;
	}

	@Id
	@GenericGenerator(name = "partId", strategy = "increment")
	@GeneratedValue(generator = "partId")
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		super.id = id;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tenant_id")
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}
	
	@Column(name = "part_code", length = 100, nullable = false)
	public String getPartCode() {
		return partCode;
	}

	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}
	
	@Column(name = "part_type", length = 300, nullable = true)
	public String getPartType() {
		return partType;
	}

	public void setPartType(String partType) {
		this.partType = partType;
	}
	
	@Column(name = "is_active", length = 1, nullable = true)
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	@Column(name = "is_kit", length = 1, nullable = true)
	public String getIsKit() {
		return isKit;
	}

	public void setIsKit(String isKit) {
		this.isKit = isKit;
	}
	
	@Column(name = "uom", length = 30, nullable = true)
	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "part")
	public List<PartIntl> getPartIntl() {
		return partIntl;
	}

	public void setPartIntl(List<PartIntl> partIntl) {
		this.partIntl = partIntl;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "part")
	public List<PartPrice> getPartPrice() {
		return partPrice;
	}

	public void setPartPrice(List<PartPrice> partPrice) {
		this.partPrice = partPrice;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((isKit == null) ? 0 : isKit.hashCode());
		result = prime * result
				+ ((partCode == null) ? 0 : partCode.hashCode());
		result = prime * result
				+ ((partIntl == null) ? 0 : partIntl.hashCode());
		result = prime * result
				+ ((partPrice == null) ? 0 : partPrice.hashCode());
		result = prime * result
				+ ((partType == null) ? 0 : partType.hashCode());
		result = prime * result + ((tenant == null) ? 0 : tenant.hashCode());
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
		if (partCode == null) {
			if (other.partCode != null)
				return false;
		} else if (!partCode.equals(other.partCode))
			return false;
		if (partIntl == null) {
			if (other.partIntl != null)
				return false;
		} else if (!partIntl.equals(other.partIntl))
			return false;
		if (partPrice == null) {
			if (other.partPrice != null)
				return false;
		} else if (!partPrice.equals(other.partPrice))
			return false;
		if (partType == null) {
			if (other.partType != null)
				return false;
		} else if (!partType.equals(other.partType))
			return false;
		if (tenant == null) {
			if (other.tenant != null)
				return false;
		} else if (!tenant.equals(other.tenant))
			return false;
		if (uom == null) {
			if (other.uom != null)
				return false;
		} else if (!uom.equals(other.uom))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuffer builder = new StringBuffer();
		builder.append("Part [tenant=");
		builder.append(tenant);
		builder.append(", partCode=");
		builder.append(partCode);
		builder.append(", partType=");
		builder.append(partType);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append(", isKit=");
		builder.append(isKit);
		builder.append(", uom=");
		builder.append(uom);
		builder.append(", partIntl=");
		builder.append(partIntl);
		builder.append(", partPrice=");
		builder.append(partPrice);
		builder.append("]");		
		return builder.toString();
	}	
	

}
