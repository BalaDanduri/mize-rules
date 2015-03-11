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
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.datetime.Date;
import com.mize.domain.datetime.DateTime;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.TenantSerializer;

@Entity
@Table(name = "discount")
public class Discount extends MizeSceEntityAudit implements Comparable<Discount> {

	private static final long serialVersionUID = -5386693947574878416L;	
	private BusinessEntity tenant;
	private String discountNumber;
	private String orderType;
	private BusinessEntity orderBusinessEntity;	
	private Date startDate;
	private Date endDate;	
	private BigDecimal lineDiscountAmount;
	private BigDecimal lineDiscountPercent;
	private BigDecimal orderDiscountAmount;
	private BigDecimal orderDiscountPercent;
	private BigDecimal orderMinimumLines;
	private BigDecimal orderMaximumLines;
	private BigDecimal orderMinimumAmount;
	private BigDecimal orderMaximumAmount;
	private BigDecimal shippingDiscountAmount;
	private BigDecimal shippingDiscountPercent;
	private BigDecimal shippingMinimumAmount;
	private BigDecimal shippingMaximumAmount;
	private BigDecimal shippingMinimumLines;
	private BigDecimal shippingMaximumLines;
	private String shippingMethod;	
	private BigDecimal minimumQuantity;
	private BigDecimal maximumQuantity;	
	private BigDecimal maximumAmountAllowed;
	@Transient
	private User user;	
	@Transient
	private EntityComment entityComment;
	private List<DiscountComment> comments = new ArrayList<DiscountComment>();
	
	public Discount() {
		super();
	}
	
	public Discount(Long id,String discountNumber, String orderType,
			Date startDate, Date endDate,
			BigDecimal lineDiscountAmount, BigDecimal lineDiscountPercent,
			BigDecimal orderDiscountAmount, BigDecimal orderDiscountPercent,
			BigDecimal orderMinimumLines, BigDecimal orderMaximumLines,
			BigDecimal orderMinimumAmount, BigDecimal orderMaximumAmount,
			BigDecimal shippingDiscountAmount,
			BigDecimal shippingDiscountPercent,
			BigDecimal shippingMinimumAmount, BigDecimal shippingMaximumAmount,
			BigDecimal shippingMinimumLines, BigDecimal shippingMaximumLines,
			String shippingMethod, BigDecimal minimumQuantity,
			BigDecimal maximumQuantity, BigDecimal maximumAmountAllowed,DateTime createdDate, DateTime updatedDate) {
		super();
		this.id = id;
		this.discountNumber = discountNumber;
		this.orderType = orderType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.lineDiscountAmount = lineDiscountAmount;
		this.lineDiscountPercent = lineDiscountPercent;
		this.orderDiscountAmount = orderDiscountAmount;
		this.orderDiscountPercent = orderDiscountPercent;
		this.orderMinimumLines = orderMinimumLines;
		this.orderMaximumLines = orderMaximumLines;
		this.orderMinimumAmount = orderMinimumAmount;
		this.orderMaximumAmount = orderMaximumAmount;
		this.shippingDiscountAmount = shippingDiscountAmount;
		this.shippingDiscountPercent = shippingDiscountPercent;
		this.shippingMinimumAmount = shippingMinimumAmount;
		this.shippingMaximumAmount = shippingMaximumAmount;
		this.shippingMinimumLines = shippingMinimumLines;
		this.shippingMaximumLines = shippingMaximumLines;
		this.shippingMethod = shippingMethod;
		this.minimumQuantity = minimumQuantity;
		this.maximumQuantity = maximumQuantity;
		this.maximumAmountAllowed = maximumAmountAllowed;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Override
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tenant_id")
	@JsonSerialize(using=TenantSerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	@Column(name = "discount_number")
	public String getDiscountNumber() {
		return this.discountNumber;
	}

	public void setDiscountNumber(String discountNumber) {
		this.discountNumber = discountNumber;
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

	@Column(name = "maximum_quantity")
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

	@Column(name = "start_date")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "end_date")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="order_be_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
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
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	
	public List<DiscountComment> getComments() {
		return comments;
	}

	public void setComments(List<DiscountComment> comments) {
		this.comments = comments;
	}
	
	@JsonIgnore
	@Transient
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "line_discount_amount")
	public BigDecimal getLineDiscountAmount() {
		return lineDiscountAmount;
	}

	public void setLineDiscountAmount(BigDecimal lineDiscountAmount) {
		this.lineDiscountAmount = lineDiscountAmount;
	}

	@Column(name = "line_discount_percent")
	public BigDecimal getLineDiscountPercent() {
		return lineDiscountPercent;
	}

	public void setLineDiscountPercent(BigDecimal lineDiscountPercent) {
		this.lineDiscountPercent = lineDiscountPercent;
	}

	@Column(name = "order_discount_amount")
	public BigDecimal getOrderDiscountAmount() {
		return orderDiscountAmount;
	}

	public void setOrderDiscountAmount(BigDecimal orderDiscountAmount) {
		this.orderDiscountAmount = orderDiscountAmount;
	}

	@Column(name = "order_discount_percent")
	public BigDecimal getOrderDiscountPercent() {
		return orderDiscountPercent;
	}

	public void setOrderDiscountPercent(BigDecimal orderDiscountPercent) {
		this.orderDiscountPercent = orderDiscountPercent;
	}

	@Column(name = "order_minimum_lines")
	public BigDecimal getOrderMinimumLines() {
		return orderMinimumLines;
	}

	public void setOrderMinimumLines(BigDecimal orderMinimumLines) {
		this.orderMinimumLines = orderMinimumLines;
	}

	@Column(name = "order_maximum_lines")
	public BigDecimal getOrderMaximumLines() {
		return orderMaximumLines;
	}

	public void setOrderMaximumLines(BigDecimal orderMaximumLines) {
		this.orderMaximumLines = orderMaximumLines;
	}

	@Column(name = "shipping_discount_amount")
	public BigDecimal getShippingDiscountAmount() {
		return shippingDiscountAmount;
	}

	public void setShippingDiscountAmount(BigDecimal shippingDiscountAmount) {
		this.shippingDiscountAmount = shippingDiscountAmount;
	}

	@Column(name = "shipping_discount_percent")
	public BigDecimal getShippingDiscountPercent() {
		return shippingDiscountPercent;
	}

	public void setShippingDiscountPercent(BigDecimal shippingDiscountPercent) {
		this.shippingDiscountPercent = shippingDiscountPercent;
	}

	@Column(name = "shipping_minimum_amount")
	public BigDecimal getShippingMinimumAmount() {
		return shippingMinimumAmount;
	}

	public void setShippingMinimumAmount(BigDecimal shippingMinimumAmount) {
		this.shippingMinimumAmount = shippingMinimumAmount;
	}

	@Column(name = "shipping_maximum_amount")
	public BigDecimal getShippingMaximumAmount() {
		return shippingMaximumAmount;
	}

	public void setShippingMaximumAmount(BigDecimal shippingMaximumAmount) {
		this.shippingMaximumAmount = shippingMaximumAmount;
	}

	@Column(name = "shipping_minimum_lines")
	public BigDecimal getShippingMinimumLines() {
		return shippingMinimumLines;
	}

	public void setShippingMinimumLines(BigDecimal shippingMinimumLines) {
		this.shippingMinimumLines = shippingMinimumLines;
	}

	@Column(name = "shipping_maximum_lines")
	public BigDecimal getShippingMaximumLines() {
		return shippingMaximumLines;
	}

	public void setShippingMaximumLines(BigDecimal shippingMaximumLines) {
		this.shippingMaximumLines = shippingMaximumLines;
	}

	@Column(name = "shipping_method")
	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	@Column(name = "maximum_amount_allowed")
	public BigDecimal getMaximumAmountAllowed() {
		return maximumAmountAllowed;
	}

	public void setMaximumAmountAllowed(BigDecimal maximumAmountAllowed) {
		this.maximumAmountAllowed = maximumAmountAllowed;
	}

	@Column(name = "order_minimum_amount")
	public BigDecimal getOrderMinimumAmount() {
		return orderMinimumAmount;
	}

	public void setOrderMinimumAmount(BigDecimal orderMinimumAmount) {
		this.orderMinimumAmount = orderMinimumAmount;
	}

	@Column(name = "order_maximum_amount")
	public BigDecimal getOrderMaximumAmount() {
		return orderMaximumAmount;
	}

	public void setOrderMaximumAmount(BigDecimal orderMaximumAmount) {
		this.orderMaximumAmount = orderMaximumAmount;
	}

	@Override
	public int compareTo(Discount o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
