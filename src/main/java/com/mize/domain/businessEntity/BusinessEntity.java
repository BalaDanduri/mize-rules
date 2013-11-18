package com.mize.domain.businessEntity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.mize.domain.common.MizeEntity;

@Entity
@Table(name = "business_entity", uniqueConstraints = {@UniqueConstraint (columnNames={"tenant_id", "code"})})
public class BusinessEntity extends MizeEntity {

	private static final long serialVersionUID = 5842902035928465555L;
	
	private String code;
	private String typeCode;
	private String subTypeCode;
	private String logo;
	private BusinessEntity tenant;
	private BusinessEntity parentBE;
	private String isActive;
	private String currencyCode;
	private List<BusinessEntityIntl> businessEntityIntl;
	
	
	public BusinessEntity() {
	}

	public BusinessEntity(String code, String typeCode, String subTypeCode,
			String logo, BusinessEntity tenantId, BusinessEntity parentBeId, String isActive,
			String currencyCode) {
		super();
		this.code = code;
		this.typeCode = typeCode;
		this.subTypeCode = subTypeCode;
		this.logo = logo;
		this.tenant = tenantId;
		this.parentBE = parentBeId;
		this.isActive = isActive;
		this.currencyCode = currencyCode;
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false, length = 10)
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id= id;

	}

	@Column(name = "code",  nullable = true, length = 50)
	public String getCode() {
		return code;
	}

	@Column(name = "type_code",  nullable = true, length = 50)
	public String getTypeCode() {
		return typeCode;
	}

	@Column(name = "sub_type_code",  nullable = true, length = 50)
	public String getSubTypeCode() {
		return subTypeCode;
	}

	@Column(name = "logo",  nullable = true, length = 100)
	public String getLogo() {
		return logo;
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tenant_id")
	public BusinessEntity getTenant() {
		return tenant;
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parent_be_id")
	public BusinessEntity getParentBE() {
		return parentBE;
	}

	@Column(name = "is_active",  nullable = true, length = 1)
	public String getIsActive() {
		return isActive;
	}

	@Column(name = "currency_code",  nullable = true, length = 30)
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public void setSubTypeCode(String subTypeCode) {
		this.subTypeCode = subTypeCode;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	public void setParentBE(BusinessEntity parentBe) {
		this.parentBE = parentBe;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public List<BusinessEntityIntl> getBusinessEntityIntl() {
		return businessEntityIntl;
	}

	public void setBusinessEntityIntl(List<BusinessEntityIntl> businessEntityIntl) {
		this.businessEntityIntl = businessEntityIntl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((logo == null) ? 0 : logo.hashCode());
		result = prime * result
				+ ((parentBE == null) ? 0 : parentBE.hashCode());
		result = prime * result
				+ ((subTypeCode == null) ? 0 : subTypeCode.hashCode());
		result = prime * result
				+ ((tenant == null) ? 0 : tenant.hashCode());
		result = prime * result
				+ ((typeCode == null) ? 0 : typeCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof BusinessEntity)) {
			return false;
		}
		BusinessEntity other = (BusinessEntity) obj;
		if (code == null) {
			if (other.code != null) {
				return false;
			}
		} else if (!code.equals(other.code)) {
			return false;
		}
		if (currencyCode == null) {
			if (other.currencyCode != null) {
				return false;
			}
		} else if (!currencyCode.equals(other.currencyCode)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (isActive == null) {
			if (other.isActive != null) {
				return false;
			}
		} else if (!isActive.equals(other.isActive)) {
			return false;
		}
		if (logo == null) {
			if (other.logo != null) {
				return false;
			}
		} else if (!logo.equals(other.logo)) {
			return false;
		}
		if (parentBE == null) {
			if (other.parentBE != null) {
				return false;
			}
		} else if (!parentBE.equals(other.parentBE)) {
			return false;
		}
		if (subTypeCode == null) {
			if (other.subTypeCode != null) {
				return false;
			}
		} else if (!subTypeCode.equals(other.subTypeCode)) {
			return false;
		}
		if (tenant == null) {
			if (other.tenant != null) {
				return false;
			}
		} else if (!tenant.equals(other.tenant)) {
			return false;
		}
		if (typeCode == null) {
			if (other.typeCode != null) {
				return false;
			}
		} else if (!typeCode.equals(other.typeCode)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BusinessEntity [id=");
		builder.append(id);
		builder.append(", code=");
		builder.append(code);
		builder.append(", typeCode=");
		builder.append(typeCode);
		builder.append(", subTypeCode=");
		builder.append(subTypeCode);
		builder.append(", logo=");
		builder.append(logo);
		builder.append(", tenantId=");
		builder.append(tenant);
		builder.append(", parentBeId=");
		builder.append(parentBE);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append(", currencyCode=");
		builder.append(currencyCode);
		builder.append("]");
		return builder.toString();
	}
}
