package com.mize.domain.purchaseorder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.MizeDateTime;

@Entity
@Table(name = "purchase_order_audit")
public class PurchaseOrderAudit extends MizeSceEntity implements Comparable<PurchaseOrderAudit>{	

	private static final long serialVersionUID = 268638805962518728L;
	private String statusCode;
	private MizeDateTime statusDate;
	private Long statusBy;
	private PurchaseOrder purchaseOrder;

	public PurchaseOrderAudit(){
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
	
	@Column(name="status_code",length = 50)
	public String getStatusCode() {
		return statusCode;
	}
	
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	@JsonInclude(Include.NON_DEFAULT)
	@Column(name = "status_date")
	@JsonIgnore(value=false)
	@org.hibernate.annotations.Type(type="com.mize.domain.util.MizeDateTimeJPA")
	public MizeDateTime getStatusDate() {
		return statusDate;
	}

	@JsonIgnore(value=false)
	@org.hibernate.annotations.Type(type="com.mize.domain.util.MizeDateTimeJPA")
	public void setStatusDate(MizeDateTime statusDate) {
		this.statusDate = statusDate;
	}

	@Column(name = "status_by")
	public Long getStatusBy() {
		return statusBy;
	}

	public void setStatusBy(Long statusBy) {
		this.statusBy = statusBy;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="order_id")
	@JsonBackReference(value="audit_purchaseOrder")
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((statusBy == null) ? 0 : statusBy.hashCode());
		result = prime * result
				+ ((statusCode == null) ? 0 : statusCode.hashCode());
		result = prime * result
				+ ((statusDate == null) ? 0 : statusDate.hashCode());
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
		PurchaseOrderAudit other = (PurchaseOrderAudit) obj;
		if (statusBy == null) {
			if (other.statusBy != null)
				return false;
		} else if (!statusBy.equals(other.statusBy))
			return false;
		if (statusCode == null) {
			if (other.statusCode != null)
				return false;
		} else if (!statusCode.equals(other.statusCode))
			return false;
		if (statusDate == null) {
			if (other.statusDate != null)
				return false;
		} else if (!statusDate.equals(other.statusDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PartsOrderAudit [statusCode=" + statusCode + ", statusDate="
				+ statusDate + ", statusBy=" + statusBy +",id ="+id+ "]";
	}

	@Override
	public int compareTo(PurchaseOrderAudit o) {
		return 0;
	}

}
