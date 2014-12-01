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
import com.mize.domain.common.MizeAuditEntity;
import com.mize.domain.util.MizeDateTime;

@Entity
@Table(name = "prod_regn_audit")
public class ProductRegistrationAudit extends MizeAuditEntity implements Comparable<ProductRegistrationAudit>{	


	private static final long serialVersionUID = -5121973394689627876L;
	private String statusCode;
	private ProductRegistration productRegistration;

	public ProductRegistrationAudit(){
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="status_code")
	public String getStatusCode() {
		return statusCode;
	}
	
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}


	@Column(name = "status_date")
	@Type(type = "com.mize.domain.util.MizeDateTimeJPA")
	public MizeDateTime getStatusDate() {
		return statusDate;
	}


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
	@JoinColumn(name="prod_regn_id")
	@JsonBackReference(value="productRegistration_audit")
	public ProductRegistration getProductRegistration() {
		return productRegistration;
	}
	
	public void setProductRegistration(ProductRegistration productRegistration) {
		this.productRegistration = productRegistration;
	}
	
	@Column(name = "status_by_user")
	@Override
	public String getStatusByUser() {
		return statusByUser;
	}

	public void setStatusByUser(String statusByUser) {
		this.statusByUser = statusByUser;
	}
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((statusBy == null) ? 0 : statusBy.hashCode());
		result = prime * result + ((statusCode == null) ? 0 : statusCode.hashCode());
		result = prime * result + ((statusDate == null) ? 0 : statusDate.hashCode());
		result = prime * result + ((statusByUser == null) ? 0 : statusByUser.hashCode());
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
		ProductRegistrationAudit other = (ProductRegistrationAudit) obj;
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
		} else if (!statusDate.equals(other.statusDate)){
			return false;
		}
		if (statusByUser == null) {
			if (other.statusByUser != null)
				return false;
		} else if (!statusByUser.equals(other.statusByUser)){
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ProductRegistration [statusCode=" + statusCode + ", statusDate="
				+ statusDate + ", statusBy=" + statusBy +",id ="+id+ "]";
	}

	@Override
	public int compareTo(ProductRegistrationAudit o) {
		return 0;
	}

}
