package com.mize.domain.discount;

import java.math.BigDecimal;
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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name = "discount", uniqueConstraints = { @UniqueConstraint(columnNames = {"id"}) })
public class Discount extends MizeEntity {

	private static final long serialVersionUID = -5386693947574878416L;
	
	private BusinessEntity tenant;
	private String discountNumber;
	private BigDecimal discountAmount;
	private BigDecimal discountPercent;
	private BigDecimal minimumAmount; 
	private BigDecimal maximumAmount; 
	private String discountLevel;
	private BigDecimal minimumQuantity;
	private BigDecimal maximumQuantity;
	private String orderType;
	private DateTime startDate;
	private DateTime endDate;
	private BusinessEntity orderBusinessEntity;	
	@Transient
	private User user;	
	@Transient
	private EntityComment entityComment;
	private List<DiscountComment> comments = new ArrayList<DiscountComment>();
	

	public Discount() {
		super();
	}

	public Discount(BusinessEntity tenant, String discountNumber,
			BigDecimal discountAmount, BigDecimal discountPercent,
			BigDecimal minimumAmount, BigDecimal maximumAmount,
			String discountLevel, BigDecimal minimumQuantity,
			BigDecimal maximumQuantity, String orderType, DateTime startDate,
			DateTime endDate, BusinessEntity orderBusinessEntity, User user,
			EntityComment entityComment, List<DiscountComment> comments) {
		super();
		this.tenant = tenant;
		this.discountNumber = discountNumber;
		this.discountAmount = discountAmount;
		this.discountPercent = discountPercent;
		this.minimumAmount = minimumAmount;
		this.maximumAmount = maximumAmount;
		this.discountLevel = discountLevel;
		this.minimumQuantity = minimumQuantity;
		this.maximumQuantity = maximumQuantity;
		this.orderType = orderType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.orderBusinessEntity = orderBusinessEntity;
		this.user = user;
		this.entityComment = entityComment;
		this.comments = comments;
	}

	@Id
	@GenericGenerator(name="id",strategy="increment")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tenant_id")
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	@Column(name = "discount_number",length = 250)
	public String getDiscountNumber() {
		return discountNumber;
	}

	public void setDiscountNumber(String discountNumber) {
		this.discountNumber = discountNumber;
	}

	@Column(name = "discount_amount")
	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal DiscountAmount) {
		this.discountAmount = DiscountAmount;
	}

	@Column(name = "discount_percent")
	public BigDecimal getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(BigDecimal DiscountPercent) {
		this.discountPercent = DiscountPercent;
	}
	
	@Column(name = "minimum_amount")
	public BigDecimal getMinimumAmount() {
		return minimumAmount;
	}

	public void setMinimumAmount(BigDecimal minimumAmount) {
		this.minimumAmount = minimumAmount;
	}
	
	@Column(name = "maximum_amount")
	public BigDecimal getMaximumAmount() {
		return maximumAmount;
	}

	public void setMaximumAmount(BigDecimal maximumAmount) {
		this.maximumAmount = maximumAmount;
	}

	@Column(name = "discount_level")
	public String getDiscountLevel() {
		return discountLevel;
	}

	public void setDiscountLevel(String discountLevel) {
		this.discountLevel = discountLevel;
	}

	@Column(name = "minimum_quantity")
	public BigDecimal getMinimumQuantity() {
		return minimumQuantity;
	}

	public void setMinimumQuantity(BigDecimal minimumQuantity) {
		this.minimumQuantity = minimumQuantity;
	}
	
	@Column(name = "maximum_quantity")
	public BigDecimal getMaximumQuantity() {
		return maximumQuantity;
	}

	public void setMaximumQuantity(BigDecimal maximumQuantity) {
		this.maximumQuantity = maximumQuantity;
	}

	@Column(name = "order_type")
	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	@Column(name = "start_date", nullable = true)
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using = JsonDateTimeSerializer.class, include = Inclusion.NON_NULL)	
	public DateTime getStartDate() {
		return startDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}

	@Column(name = "end_date", nullable = true)
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using = JsonDateTimeSerializer.class, include = Inclusion.NON_NULL)
	public DateTime getEndDate() {
		return endDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)
	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="order_be_id")
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	public BusinessEntity getOrderBusinessEntity() {
		return orderBusinessEntity;
	}

	public void setOrderBusinessEntity(BusinessEntity orderBusinessEntity) {
		this.orderBusinessEntity = orderBusinessEntity;
	}
	
	@Transient
	public EntityComment getEntityComment() {
		return entityComment;
	}

	public void setEntityComment(EntityComment entityComment) {
		this.entityComment = entityComment;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "discount")
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	public List<DiscountComment> getComments() {
		return comments;
	}

	public void setComments(List<DiscountComment> comments) {
		this.comments = comments;
	}
	
	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "created_date",updatable=false)
	@JsonIgnore(false)
	public DateTime getCreatedDate() {
		return createdDate;
	}
	
	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "updated_date")
	@JsonIgnore(false)
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@Override
	@JsonIgnore(false)
	@Column(name = "created_by",updatable=false)
	public Long getCreatedBy() {		
		return super.getCreatedBy();
	}

	@Override
	@JsonIgnore(false)
	@Column(name = "updated_by")
	public Long getUpdatedBy() {		
		return super.getUpdatedBy();
	}
	
	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(false)
	public void setCreatedDate(DateTime createdDate) {
		super.createdDate = createdDate;
	}
	
	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(false)
	public void setUpdatedDate(DateTime updatedDate) {
		super.updatedDate = updatedDate;
	}
	
	@Override
	@JsonIgnore(false)
	public void setCreatedBy(Long createdBy) {		
		super.setCreatedBy(createdBy);
	}
	
	@Override
	@JsonIgnore(false)
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
	
	@Transient
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
		result = prime * result + ((discountAmount == null) ? 0 : discountAmount.hashCode());
		result = prime * result
				+ ((discountLevel == null) ? 0 : discountLevel.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result
				+ ((maximumAmount == null) ? 0 : maximumAmount.hashCode());
		result = prime * result
				+ ((maximumQuantity == null) ? 0 : maximumQuantity.hashCode());
		result = prime * result
				+ ((minimumAmount == null) ? 0 : minimumAmount.hashCode());
		result = prime * result
				+ ((minimumQuantity == null) ? 0 : minimumQuantity.hashCode());
		result = prime * result + ((discountNumber == null) ? 0 : discountNumber.hashCode());
		result = prime * result
				+ ((orderType == null) ? 0 : orderType.hashCode());
		result = prime * result + ((discountPercent == null) ? 0 : discountPercent.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
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
		Discount other = (Discount) obj;
		if (discountAmount == null) {
			if (other.discountAmount != null)
				return false;
		} else if (!discountAmount.equals(other.discountAmount))
			return false;
		if (discountLevel == null) {
			if (other.discountLevel != null)
				return false;
		} else if (!discountLevel.equals(other.discountLevel))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (maximumAmount == null) {
			if (other.maximumAmount != null)
				return false;
		} else if (!maximumAmount.equals(other.maximumAmount))
			return false;
		if (maximumQuantity == null) {
			if (other.maximumQuantity != null)
				return false;
		} else if (!maximumQuantity.equals(other.maximumQuantity))
			return false;
		if (minimumAmount == null) {
			if (other.minimumAmount != null)
				return false;
		} else if (!minimumAmount.equals(other.minimumAmount))
			return false;
		if (minimumQuantity == null) {
			if (other.minimumQuantity != null)
				return false;
		} else if (!minimumQuantity.equals(other.minimumQuantity))
			return false;
		if (discountNumber == null) {
			if (other.discountNumber != null)
				return false;
		} else if (!discountNumber.equals(other.discountNumber))
			return false;
		if (orderType == null) {
			if (other.orderType != null)
				return false;
		} else if (!orderType.equals(other.orderType))
			return false;
		if (discountPercent == null) {
			if (other.discountPercent != null)
				return false;
		} else if (!discountPercent.equals(other.discountPercent))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Discount [number=" + discountNumber + ", amount=" + discountAmount
				+ ", percent=" + discountPercent + ", minimumAmount=" + minimumAmount
				+ ", maximumAmount=" + maximumAmount + ", discountLevel="
				+ discountLevel + ", minimumQuantity=" + minimumQuantity
				+ ", maximumQuantity=" + maximumQuantity + ", orderType="
				+ orderType + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}
	
}
