package com.mize.domain.product;

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

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.MizeDate;

@Entity
@Table(name = "prod_warranty")
@Inheritance
@DiscriminatorColumn(name = "discriminator")
@DiscriminatorValue("ProductWarranty")
public class ProductWarranty extends MizeSceEntity implements Comparable<ProductWarranty> {


	private static final long serialVersionUID = -7775495768578959130L;
	
	 private ProductSerial productSerial;
	 private MizeDate startDate;
	 private MizeDate endDate;
	 private String coverageType;
	 private String coverageName;
	 private String partCode;
	 private String partDescription;
	 private String salesOrderNumber;
	 private String purcahseOrderNumber;
	 private MizeDate soldDate;
	 private BusinessEntity customer;
	 private BusinessEntity invoiceBE;
	 
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
	@Type(type = "com.mize.domain.util.MizeDateJPA")
	public MizeDate getStartDate() {
		return startDate;
	}


	@Column(name = "end_date", nullable = true)
	@Type(type = "com.mize.domain.util.MizeDateJPA")
	public MizeDate getEndDate() {
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

	public void setStartDate(MizeDate startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(MizeDate endDate) {
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
	public int compareTo(ProductWarranty o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Column(name = "wrrnty_part_cd")
	public String getPartCode() {
		return partCode;
	}

	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}

	@Column(name = "wrrnty_part_desc")
	public String getPartDescription() {
		return partDescription;
	}

	
	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}

	@Column(name = "wrrnty_so_num")
	public String getSalesOrderNumber() {
		return salesOrderNumber;
	}

	public void setSalesOrderNumber(String salesOrderNumber) {
		this.salesOrderNumber = salesOrderNumber;
	}

	@Column(name = "wrrnty_po_num")
	public String getPurcahseOrderNumber() {
		return purcahseOrderNumber;
	}

	public void setPurcahseOrderNumber(String purcahseOrderNumber) {
		this.purcahseOrderNumber = purcahseOrderNumber;
	}

	@Column(name = "wrrnty_sold_date")
	@Type(type = "com.mize.domain.util.MizeDateJPA")
	public MizeDate getSoldDate() {
		return soldDate;
	}

	public void setSoldDate(MizeDate soldDate) {
		this.soldDate = soldDate;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="invoice_cust_id", nullable = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getCustomer() {
		return customer;
	}

	public void setCustomer(BusinessEntity customer) {
		this.customer = customer;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="invoice_be_id", nullable = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getInvoiceBE() {
		return invoiceBE;
	}

	public void setInvoiceBE(BusinessEntity invoiceBE) {
		this.invoiceBE = invoiceBE;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((coverageName == null) ? 0 : coverageName.hashCode());
		result = prime * result + ((coverageType == null) ? 0 : coverageType.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((invoiceBE == null) ? 0 : invoiceBE.hashCode());
		result = prime * result + ((partCode == null) ? 0 : partCode.hashCode());
		result = prime * result + ((partDescription == null) ? 0 : partDescription.hashCode());
		result = prime * result + ((purcahseOrderNumber == null) ? 0 : purcahseOrderNumber.hashCode());
		result = prime * result + ((salesOrderNumber == null) ? 0 : salesOrderNumber.hashCode());
		result = prime * result + ((soldDate == null) ? 0 : soldDate.hashCode());
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
		if (customer == null) {
			if (other.customer != null) {
				return false;
			}
		} else if (!customer.equals(other.customer)) {
			return false;
		}
		if (endDate == null) {
			if (other.endDate != null) {
				return false;
			}
		} else if (!endDate.equals(other.endDate)) {
			return false;
		}
		if (invoiceBE == null) {
			if (other.invoiceBE != null) {
				return false;
			}
		} else if (!invoiceBE.equals(other.invoiceBE)) {
			return false;
		}
		if (partCode == null) {
			if (other.partCode != null) {
				return false;
			}
		} else if (!partCode.equals(other.partCode)) {
			return false;
		}
		if (partDescription == null) {
			if (other.partDescription != null) {
				return false;
			}
		} else if (!partDescription.equals(other.partDescription)) {
			return false;
		}
		if (purcahseOrderNumber == null) {
			if (other.purcahseOrderNumber != null) {
				return false;
			}
		} else if (!purcahseOrderNumber.equals(other.purcahseOrderNumber)) {
			return false;
		}
		if (salesOrderNumber == null) {
			if (other.salesOrderNumber != null) {
				return false;
			}
		} else if (!salesOrderNumber.equals(other.salesOrderNumber)) {
			return false;
		}
		if (soldDate == null) {
			if (other.soldDate != null) {
				return false;
			}
		} else if (!soldDate.equals(other.soldDate)) {
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
		return "ProductWarranty [productSerial=" + productSerial
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", coverageType=" + coverageType + ", coverageName="
				+ coverageName + ", partCode=" + partCode
				+ ", partDescription=" + partDescription
				+ ", salesOrderNumber=" + salesOrderNumber
				+ ", purcahseOrderNumber=" + purcahseOrderNumber
				+ ", soldDate=" + soldDate + ", customer=" + customer
				+ ", invoice=" + invoiceBE + "]";
	}

	
	
	
	
}
