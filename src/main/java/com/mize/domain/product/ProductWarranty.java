package com.mize.domain.product;

import javax.persistence.CascadeType;
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
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.JodaDateDeserializer;
import com.mize.domain.util.JsonDateSerializer;

@Entity
@Table(name = "prod_warranty")
public class ProductWarranty extends MizeEntity {


	private static final long serialVersionUID = -7775495768578959130L;
	
	 private ProductSerial productSerial;
	 private DateTime startDate;
	 private DateTime endDate;
	 private String coverageType;
	 private String coverageName;
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}

	@ManyToOne(fetch = FetchType.EAGER ,cascade = CascadeType.REFRESH)
	@JoinColumn(name="prod_serial_id")
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	public ProductSerial getProductSerial() {
		return productSerial;
	}

	@Column(name = "start_date", nullable = true)
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using = JsonDateSerializer.class)
	@JsonInclude(Include.NON_NULL)
	public DateTime getStartDate() {
		return startDate;
	}


	@Column(name = "end_date", nullable = true)
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using = JsonDateSerializer.class)
	@JsonInclude(Include.NON_NULL)
	public DateTime getEndDate() {
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

	
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setEndDate(DateTime endDate) {
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
		result = prime * result
				+ ((coverageName == null) ? 0 : coverageName.hashCode());
		result = prime * result
				+ ((coverageType == null) ? 0 : coverageType.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
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

	
	
}
