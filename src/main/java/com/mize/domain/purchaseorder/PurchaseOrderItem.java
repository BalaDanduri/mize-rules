package com.mize.domain.purchaseorder;


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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.part.Part;
import com.mize.domain.part.PartKit;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name = "purchase_order_item")
public class PurchaseOrderItem extends MizeEntity implements Comparable<PurchaseOrderItem>{	

	private static final long serialVersionUID = 26123880591518728L;
	private PurchaseOrder purchaseOrder;
	private Long itemId;
	private String type;
	private String number;
	private String serial;
	private String name;
	private String description;
	private String uom;	
	private String status;
	private String priceCode;	
	private BigDecimal weight;
	private String productModel;
	private String productSerialNumber;
	private BigDecimal requestedQuantity;
	private BigDecimal backorderQuantity;
	private PurchaseOrderAmount amount = new PurchaseOrderAmount();
	private List<PurchaseOrderItemWarehourse> warehourses = new ArrayList<PurchaseOrderItemWarehourse>();
	@Transient
	private Part part;
	@Transient
	private PartKit partKit;
	@Transient
	private boolean isUpdated;
	@Transient
	private String originalOrderNumber;
	@Transient
	private Long originalOrderNumberId;
	@Transient
	private String reason;
	@Transient
	private String orderType;
	
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

	@Column(name="item_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="item_description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="item_status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="item_weight")
	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	@Column(name="item_prod_srl_no")
	public String getProductSerialNumber() {
		return productSerialNumber;
	}

	public void setProductSerialNumber(String productSerialNumber) {
		this.productSerialNumber = productSerialNumber;
	}	
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	@JsonIgnore(value=false)
	@Column(name="updated_date")
	@org.hibernate.annotations.Type(type="com.mize.domain.util.DateTimeJPA")
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)	
	@org.hibernate.annotations.Type(type="com.mize.domain.util.DateTimeJPA")
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	@JsonIgnore(value=false)
	@Column(name="created_date",updatable = false)
	@org.hibernate.annotations.Type(type="com.mize.domain.util.DateTimeJPA")
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)
	@org.hibernate.annotations.Type(type="com.mize.domain.util.DateTimeJPA")
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@JsonIgnore(value=false)	
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@JsonIgnore(value=false)
	@Column(name="created_by", updatable = false)
	public Long getCreatedBy() {
		return createdBy;
	}
	
	@JsonIgnore(value=false)
	@Column(name="updated_by")
	public Long getUpdatedBy() {
		return updatedBy;
	}

	@JsonIgnore(value=false)
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="order_id")
	@JsonBackReference(value="item_purchaseOrder")
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}
	
	@Column(name="item_type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name="item_number")
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Column(name="item_uom")
	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	@Column(name="item_serial")
	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	@Column(name="item_price_code")
	public String getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(String priceCode) {
		this.priceCode = priceCode;
	}

	@Column(name="item_prod_model")
	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	@Column(name="requested_quantity")
	public BigDecimal getRequestedQuantity() {
		return requestedQuantity;
	}

	public void setRequestedQuantity(BigDecimal requestedQuantity) {
		this.requestedQuantity = requestedQuantity;
	}

	@Column(name="backorder_quantity")
	public BigDecimal getBackorderQuantity() {
		return backorderQuantity;
	}

	public void setBackorderQuantity(BigDecimal backorderQuantity) {
		this.backorderQuantity = backorderQuantity;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	@OneToOne(fetch=FetchType.EAGER ,cascade= CascadeType.ALL)
	@JoinColumn(name="amount_id")
	public PurchaseOrderAmount getAmount() {
		return amount;
	}

	public void setAmount(PurchaseOrderAmount amount) {
		this.amount = amount;
	}	
	
	@Column(name="item_id")
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER, mappedBy = "orderItem",orphanRemoval= true)
	@Fetch(FetchMode.SUBSELECT)
	public List<PurchaseOrderItemWarehourse> getWarehourses() {
		return warehourses;
	}

	public void setWarehourses(List<PurchaseOrderItemWarehourse> warehourses) {
		this.warehourses = warehourses;
	}

	@Transient
	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	@Transient
	public PartKit getPartKit() {
		return partKit;
	}

	public void setPartKit(PartKit partKit) {
		this.partKit = partKit;
	}

	@Override
	public int compareTo(PurchaseOrderItem o) {
		return 0;
	}

	@Transient
	public boolean getIsUpdated() {
		return isUpdated;
	}

	public void setIsUpdated(boolean isUpdated) {
		this.isUpdated = isUpdated;
	}

	@Column(name="reason_for_return")
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Column(name="original_order_number")
	public String getOriginalOrderNumber() {
		return originalOrderNumber;
	}

	public void setOriginalOrderNumber(String originalOrderNumber) {
		this.originalOrderNumber = originalOrderNumber;
	}

	@Transient
	public Long getOriginalOrderNumberId() {
		return originalOrderNumberId;
	}

	public void setOriginalOrderNumberId(Long originalOrderNumberId) {
		this.originalOrderNumberId = originalOrderNumberId;
	}

	@Transient
	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime
				* result
				+ ((backorderQuantity == null) ? 0 : backorderQuantity
						.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((priceCode == null) ? 0 : priceCode.hashCode());
		result = prime * result
				+ ((productModel == null) ? 0 : productModel.hashCode());
		result = prime
				* result
				+ ((productSerialNumber == null) ? 0 : productSerialNumber
						.hashCode());
		result = prime * result
				+ ((purchaseOrder == null) ? 0 : purchaseOrder.hashCode());
		result = prime
				* result
				+ ((requestedQuantity == null) ? 0 : requestedQuantity
						.hashCode());
		result = prime * result + ((serial == null) ? 0 : serial.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((uom == null) ? 0 : uom.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
		PurchaseOrderItem other = (PurchaseOrderItem) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (backorderQuantity == null) {
			if (other.backorderQuantity != null)
				return false;
		} else if (!backorderQuantity.equals(other.backorderQuantity))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (priceCode == null) {
			if (other.priceCode != null)
				return false;
		} else if (!priceCode.equals(other.priceCode))
			return false;
		if (productModel == null) {
			if (other.productModel != null)
				return false;
		} else if (!productModel.equals(other.productModel))
			return false;
		if (productSerialNumber == null) {
			if (other.productSerialNumber != null)
				return false;
		} else if (!productSerialNumber.equals(other.productSerialNumber))
			return false;
		if (purchaseOrder == null) {
			if (other.purchaseOrder != null)
				return false;
		} else if (!purchaseOrder.equals(other.purchaseOrder))
			return false;
		if (requestedQuantity == null) {
			if (other.requestedQuantity != null)
				return false;
		} else if (!requestedQuantity.equals(other.requestedQuantity))
			return false;
		if (serial == null) {
			if (other.serial != null)
				return false;
		} else if (!serial.equals(other.serial))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (uom == null) {
			if (other.uom != null)
				return false;
		} else if (!uom.equals(other.uom))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PurchaseOrderItem [purchaseOrder=" + purchaseOrder + ", type="
				+ type + ", number=" + number + ", serial=" + serial + ", name="
				+ name + ", description=" + description + ", uom=" + uom
				+ ", status=" + status + ", priceCode=" + priceCode
				+ ", weight=" + weight + ", productModel=" + productModel
				+ ", productSerialNumber=" + productSerialNumber
				+ ", requestedQuantity=" + requestedQuantity
				+ ", backorderQuantity=" + backorderQuantity + ", amount="
				+ amount + "]";
	}
	

}
