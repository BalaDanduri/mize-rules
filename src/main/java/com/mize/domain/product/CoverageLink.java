package com.mize.domain.product;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.brand.Brand;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.datetime.DateTime;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name = "coverage_link")
public class CoverageLink extends MizeSceEntity implements Comparable<CoverageLink> {

	private static final long serialVersionUID = -7541961903982887434L;

	private BusinessEntity tenant;
	private Brand brand;
	private ProductCategory productCategory;
	private Product product;
	private String coverageType;
	private String coverageName;
	private String coverageUOM;
	private BigDecimal coverageDuration;
	private String coverageTriggerType;
	private BigDecimal coverageTriggerDuration;
	private String coverageTriggerUOM;



	public CoverageLink() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="tenant_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getTenant() {
		return tenant;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name="brand_id")
	public Brand getBrand() {
		return brand;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name="prod_cat_id")
	public ProductCategory getProductCategory() {
		return productCategory;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="prod_id")
	public Product getProduct() {
		return product;
	}

	@Column(name ="coverage_type" , nullable = true)
	public String getCoverageType() {
		return coverageType;
	}
	@Column(name ="coverage_name" , nullable = true)
	public String getCoverageName() {
		return coverageName;
	}

	@Column(name ="coverage_uom" )
	public String getCoverageUOM() {
		return coverageUOM;
	}

	@Column(name ="coverage_duration")
	public BigDecimal getCoverageDuration() {
		return coverageDuration;
	}

	@Column(name="coverage_trigger_type")
	public String getCoverageTriggerType() {
		return coverageTriggerType;
	}

	@Column(name ="coverage_trigger_duration")
	public BigDecimal getCoverageTriggerDuration() {
		return coverageTriggerDuration;
	}

	@Column(name ="coverage_trigger_uom")
	public String getCoverageTriggerUOM() {
		return coverageTriggerUOM;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setCoverageType(String coverageType) {
		this.coverageType = coverageType;
	}

	public void setCoverageName(String coverageName) {
		this.coverageName = coverageName;
	}

	public void setCoverageUOM(String coverageUOM) {
		this.coverageUOM = coverageUOM;
	}

	public void setCoverageDuration(BigDecimal coverageDuration) {
		this.coverageDuration = coverageDuration;
	}

	public void setCoverageTriggerType(String coverageTriggerType) {
		this.coverageTriggerType = coverageTriggerType;
	}

	public void setCoverageTriggerDuration(BigDecimal coverageTriggerDuration) {
		this.coverageTriggerDuration = coverageTriggerDuration;
	}

	public void setCoverageTriggerUOM(String coverageTriggerUOM) {
		this.coverageTriggerUOM = coverageTriggerUOM;
	}


	@Override	
	@Column(name = "created_date",updatable=false)
	@JsonIgnore(false)
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@Override	
	@Column(name = "updated_date")
	@JsonIgnore(false)
	public DateTime getUpdatedDate() {
		return updatedDate;
	}

	@Override
	@JsonIgnore(false)
	public void setCreatedDate(DateTime createdDate) {
		super.createdDate = createdDate;
	}

	@Override
	@JsonIgnore(false)
	public void setUpdatedDate(DateTime updatedDate) {
		super.updatedDate = updatedDate;
	}

	@Override
	@JsonIgnore(value=false)
	@Column(name = "created_by" , updatable=false)
	public Long getCreatedBy() {
		return createdBy;
	}

	@Override
	@JsonIgnore(value=false)
	@Column(name = "updated_by")
	public Long getUpdatedBy() {
		return updatedBy;
	}

	@JsonIgnore(value=false)
	@Override
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@JsonIgnore(value=false)
	@Override
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime
				* result
				+ ((coverageDuration == null) ? 0 : coverageDuration.hashCode());
		result = prime * result
				+ ((coverageName == null) ? 0 : coverageName.hashCode());
		result = prime
				* result
				+ ((coverageTriggerDuration == null) ? 0
						: coverageTriggerDuration.hashCode());
		result = prime
				* result
				+ ((coverageTriggerType == null) ? 0 : coverageTriggerType
						.hashCode());
		result = prime
				* result
				+ ((coverageTriggerUOM == null) ? 0 : coverageTriggerUOM
						.hashCode());
		result = prime * result
				+ ((coverageType == null) ? 0 : coverageType.hashCode());
		result = prime * result
				+ ((coverageUOM == null) ? 0 : coverageUOM.hashCode());
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
		if (!(obj instanceof CoverageLink)) {
			return false;
		}
		CoverageLink other = (CoverageLink) obj;
		if (coverageDuration == null) {
			if (other.coverageDuration != null) {
				return false;
			}
		} else if (!coverageDuration.equals(other.coverageDuration)) {
			return false;
		}
		if (coverageName == null) {
			if (other.coverageName != null) {
				return false;
			}
		} else if (!coverageName.equals(other.coverageName)) {
			return false;
		}
		if (coverageTriggerDuration == null) {
			if (other.coverageTriggerDuration != null) {
				return false;
			}
		} else if (!coverageTriggerDuration
				.equals(other.coverageTriggerDuration)) {
			return false;
		}
		if (coverageTriggerType == null) {
			if (other.coverageTriggerType != null) {
				return false;
			}
		} else if (!coverageTriggerType.equals(other.coverageTriggerType)) {
			return false;
		}
		if (coverageTriggerUOM == null) {
			if (other.coverageTriggerUOM != null) {
				return false;
			}
		} else if (!coverageTriggerUOM.equals(other.coverageTriggerUOM)) {
			return false;
		}
		if (coverageType == null) {
			if (other.coverageType != null) {
				return false;
			}
		} else if (!coverageType.equals(other.coverageType)) {
			return false;
		}
		if (coverageUOM == null) {
			if (other.coverageUOM != null) {
				return false;
			}
		} else if (!coverageUOM.equals(other.coverageUOM)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "CoverageLink [id=" + id + ", brand=" + brand
				+ ", coverageDuration=" + coverageDuration + ", coverageName="
				+ coverageName + ", coverageTriggerDuration="
				+ coverageTriggerDuration + ", coverageTriggerType="
				+ coverageTriggerType + ", coverageTriggerUOM="
				+ coverageTriggerUOM + ", coverageType=" + coverageType
				+ ", coverageUOM=" + coverageUOM + ", product=" + product
				+ ", productCategory=" + productCategory + "]";
	}

	@Override
	public int compareTo(CoverageLink o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
