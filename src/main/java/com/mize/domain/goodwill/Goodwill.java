package com.mize.domain.goodwill;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.datetime.Date;
import com.mize.domain.product.Product;
import com.mize.domain.product.ProductSerial;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name="goodwill")
public class Goodwill extends MizeSceEntityAudit implements Comparable<Goodwill> {
	private static final long serialVersionUID = 7577184605741571133L;
	private BusinessEntity tenant;
	private String code;
	private String statusCode;
	private String typeCode;
	private String description;
	private String currencyCode;
	private String reference;
	private String authorisedBy;
	private Date startDate;
	private Date endDate;
	private BusinessEntity requestor;
	private Product product;
	private ProductSerial productSerial;
	private GoodwillAmount approvedAmount;
	private GoodwillAmount claimedAmount;
	private String claimedEntityCode;
	private String claimedEntityType;
	private Long claimedEntityId;
	private List<GoodwillAudit> audits = new ArrayList<GoodwillAudit>();
	private List<GoodwillComment> comments = new ArrayList<GoodwillComment>();
	@Transient
	private EntityComment entityComment;
	@Transient
	private User user;
	
	public Goodwill(){
		super();
	}
	
	
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tenant_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getTenant() {
		return tenant;
	}

	@Column(name = "goodwill_code")
	public String getCode() {
		return code;
	}

	@Column(name = "goodwill_status")
	public String getStatusCode() {
		return statusCode;
	}

	@Column(name = "goodwill_type")
	public String getTypeCode() {
		return typeCode;
	}
	
	@Column(name = "goodwill_description")
	public String getDescription() {
		return description;
	}

	@Column(name = "currency_code")
	public String getCurrencyCode() {
		return currencyCode;
	}

	@Column(name = "goodwill_reference")
	public String getReference() {
		return reference;
	}

	@Column(name = "goodwill_auth_by")
	public String getAuthorisedBy() {
		return authorisedBy;
	}

	
	@Column(name = "goodwill_start_date")
	public Date getStartDate() {
		return startDate;
	}
	
	@Column(name = "goodwill_end_date")
	public Date getEndDate() {
		return endDate;
	}

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="rqstr_be_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getRequestor() {
		return requestor;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="prod_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public Product getProduct() {
		return product;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="prod_serial_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public ProductSerial getProductSerial() {
		return productSerial;
	}

	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="approved_amount_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public GoodwillAmount getApprovedAmount() {
		return approvedAmount;
	}

	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="claimed_amount_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public GoodwillAmount getClaimedAmount() {
		return claimedAmount;
	}

	@Column(name = "claimed_entity_id")
	public Long getClaimedEntityId() {
		return claimedEntityId;
	}
	
	@Column(name = "claimed_entity_code")
	public String getClaimedEntityCode() {
		return claimedEntityCode;
	}
	
	@Column(name = "claimed_entity_type")
	public String getClaimedEntityType() {
		return claimedEntityType;
	}
	
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "goodwill" ,orphanRemoval = true)
	@JsonManagedReference(value="audits")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<GoodwillAudit> getAudits() {
		return audits;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "goodwill" ,orphanRemoval = true)
	@JsonManagedReference(value="comments")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<GoodwillComment> getComments() {
		return comments;
	}

	@Transient
	public EntityComment getEntityComment() {
		return entityComment;
	}
	
	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public void setAuthorisedBy(String authorisedBy) {
		this.authorisedBy = authorisedBy;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setRequestor(BusinessEntity requestor) {
		this.requestor = requestor;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setProductSerial(ProductSerial productSerial) {
		this.productSerial = productSerial;
	}

	public void setApprovedAmount(GoodwillAmount approvedAmount) {
		this.approvedAmount = approvedAmount;
	}

	public void setClaimedAmount(GoodwillAmount claimedAmount) {
		this.claimedAmount = claimedAmount;
	}
	
	public void setClaimedEntityCode(String claimedEntityCode) {
		this.claimedEntityCode = claimedEntityCode;
	}
	
	public void setClaimedEntityType(String claimedEntityType) {
		this.claimedEntityType = claimedEntityType;
	}

	public void setClaimedEntityId(Long claimedEntityId) {
		this.claimedEntityId = claimedEntityId;
	}
	
	public void setAudits(List<GoodwillAudit> audits) {
		this.audits = audits;
	}
	
	public void setComments(List<GoodwillComment> comments) {
		this.comments = comments;
	}
	
	public void setEntityComment(EntityComment entityComment) {
		this.entityComment = entityComment;
	}

	@Transient
	@JsonIgnore
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((approvedAmount == null) ? 0 : approvedAmount.hashCode());
		result = prime * result + ((audits == null) ? 0 : audits.hashCode());
		result = prime * result
				+ ((authorisedBy == null) ? 0 : authorisedBy.hashCode());
		result = prime * result
				+ ((claimedAmount == null) ? 0 : claimedAmount.hashCode());
		result = prime
				* result
				+ ((claimedEntityCode == null) ? 0 : claimedEntityCode
						.hashCode());
		result = prime * result
				+ ((claimedEntityId == null) ? 0 : claimedEntityId.hashCode());
		result = prime
				* result
				+ ((claimedEntityType == null) ? 0 : claimedEntityType
						.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result
				+ ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result
				+ ((productSerial == null) ? 0 : productSerial.hashCode());
		result = prime * result
				+ ((reference == null) ? 0 : reference.hashCode());
		result = prime * result
				+ ((requestor == null) ? 0 : requestor.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result
				+ ((statusCode == null) ? 0 : statusCode.hashCode());
		result = prime * result + ((tenant == null) ? 0 : tenant.hashCode());
		result = prime * result
				+ ((typeCode == null) ? 0 : typeCode.hashCode());
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
		Goodwill other = (Goodwill) obj;
		if (approvedAmount == null) {
			if (other.approvedAmount != null)
				return false;
		} else if (!approvedAmount.equals(other.approvedAmount))
			return false;
		if (audits == null) {
			if (other.audits != null)
				return false;
		} else if (!audits.equals(other.audits))
			return false;
		if (authorisedBy == null) {
			if (other.authorisedBy != null)
				return false;
		} else if (!authorisedBy.equals(other.authorisedBy))
			return false;
		if (claimedAmount == null) {
			if (other.claimedAmount != null)
				return false;
		} else if (!claimedAmount.equals(other.claimedAmount))
			return false;
		if (claimedEntityCode == null) {
			if (other.claimedEntityCode != null)
				return false;
		} else if (!claimedEntityCode.equals(other.claimedEntityCode))
			return false;
		if (claimedEntityId == null) {
			if (other.claimedEntityId != null)
				return false;
		} else if (!claimedEntityId.equals(other.claimedEntityId))
			return false;
		if (claimedEntityType == null) {
			if (other.claimedEntityType != null)
				return false;
		} else if (!claimedEntityType.equals(other.claimedEntityType))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (currencyCode == null) {
			if (other.currencyCode != null)
				return false;
		} else if (!currencyCode.equals(other.currencyCode))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (productSerial == null) {
			if (other.productSerial != null)
				return false;
		} else if (!productSerial.equals(other.productSerial))
			return false;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		if (requestor == null) {
			if (other.requestor != null)
				return false;
		} else if (!requestor.equals(other.requestor))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (statusCode == null) {
			if (other.statusCode != null)
				return false;
		} else if (!statusCode.equals(other.statusCode))
			return false;
		if (tenant == null) {
			if (other.tenant != null)
				return false;
		} else if (!tenant.equals(other.tenant))
			return false;
		if (typeCode == null) {
			if (other.typeCode != null)
				return false;
		} else if (!typeCode.equals(other.typeCode))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Goodwill [code=" + code
				+ ", statusCode=" + statusCode + ", typeCode=" + typeCode
				+ ", description=" + description + ", currencyCode="
				+ currencyCode + ", reference=" + reference + ", authorisedBy="
				+ authorisedBy + ", startDate=" + startDate + ", endDate="
				+ endDate + ", requestor=" + requestor + ", product=" + product
				+ ", productSerial=" + productSerial + ", approvedAmount="
				+ approvedAmount + ", claimedAmount=" + claimedAmount
				+ ", claimedEntityCode=" + claimedEntityCode
				+ ", claimedEntityType=" + claimedEntityType
				+ ", claimedEntityId=" + claimedEntityId + ", audits=" + audits
				+ ", comments=" + comments + ", entityComment=" + entityComment +"]";
	}


	@Override
	public int compareTo(Goodwill o) {
		return 0;
	}
}
