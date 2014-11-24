package com.mize.domain.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.MizeDateTime;

@Entity
@Table(name = "prod_warranty")
public class ProductWarranty extends MizeSceEntity implements Comparable<ProductWarranty> {


	private static final long serialVersionUID = -7775495768578959130L;
	
	 private ProductSerial productSerial;
	 private MizeDateTime startDate;
	 private MizeDateTime endDate;
	 private String coverageType;
	 private String coverageName;
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="prod_serial_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonBackReference(value="productSerial_warranty")
	public ProductSerial getProductSerial() {
		return productSerial;
	}

	
	@Column(name = "start_date", nullable = true)
	@Type(type = "com.mize.domain.util.MizeDateTimeJPA")
	public MizeDateTime getStartDate() {
		return startDate;
	}


	@Column(name = "end_date", nullable = true)
	@Type(type = "com.mize.domain.util.MizeDateTimeJPA")
	public MizeDateTime getEndDate() {
		return endDate;
	}

	@Column(name = "coverage_type", nullable = true)
	public String getCoverageType() {
		return coverageType;
	}

	@Column(name = "coverage_name", nullable = true)
	public String getCoverageName() {
		return coverageName;
	}

	public void setProductSerial(ProductSerial productSerial) {
		this.productSerial = productSerial;
	}

	
	@Override
	public void setCreatedByUser(String createdByUser){
	      this.createdByUser=createdByUser;
	}
	
	@Override
	@JsonIgnore(value=false)
	@Column(name = "created_by_user" , updatable=false)
	public String getCreatedByUser(){
		 return createdByUser;
		 
	}
	
	@Override
	@JsonIgnore(value=false)
	@Column(name = "updated_by_user")
	public String getUpdatedByUser() {
		return updatedByUser;
	}
    
	@JsonIgnore(value=false)
	@Override
	public void setUpdatedByUser(String updatedByUser) {
		this.updatedByUser = updatedByUser;
	}
	
	
	
	public void setStartDate(MizeDateTime startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(MizeDateTime endDate) {
		this.endDate = endDate;
	}

	public void setCoverageType(String coverageType) {
		this.coverageType = coverageType;
	}

	public void setCoverageName(String coverageName) {
		this.coverageName = coverageName;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((coverageName == null) ? 0 : coverageName.hashCode());
		result = prime * result + ((coverageType == null) ? 0 : coverageType.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		if (!(obj instanceof ProductWarranty)) {
			return false;
		}
		ProductWarranty other = (ProductWarranty) obj;
		if (coverageName == null) {
			if (other.coverageName != null) {
				return false;
			}
		} else if (!coverageName.equals(other.coverageName)) {
			return false;
		}
		if (coverageType == null) {
			if (other.coverageType != null) {
				return false;
			}
		} else if (!coverageType.equals(other.coverageType)) {
			return false;
		}
		if (endDate == null) {
			if (other.endDate != null) {
				return false;
			}
		} else if (!endDate.equals(other.endDate)) {
			return false;
		}
		if (startDate == null) {
			if (other.startDate != null) {
				return false;
			}
		} else if (!startDate.equals(other.startDate)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ProductWarranty [id=" + id + ", coverageName=" + coverageName
				+ ", coverageType=" + coverageType + ", endDate=" + endDate
				+ ", productSerial=" + productSerial + ", startDate="
				+ startDate + "]";
	}

	@Override
	public int compareTo(ProductWarranty o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
