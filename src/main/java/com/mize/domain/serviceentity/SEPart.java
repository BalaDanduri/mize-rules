package com.mize.domain.serviceentity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.MizeEntity;
import com.mize.domain.product.Product;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name = "service_entity_request_part")
public class SEPart extends MizeEntity implements Comparable<SEPart> {

	private static final long serialVersionUID = 68211336389676111L;
	
	private String type;
	private String code;
	private String serialNumber;
	private String description;
	@Transient
	private Long requestId;
	private SERequest request;
	private SEAmount amount = new SEAmount();
	private String uom;
	private BigDecimal weight;
	private String model;
	@Transient
	private Long prodId;
	private Product product;
	private String prodSerialNumber;
	private String warehouseCode;
	
	public SEPart() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}
	@Column(name="part_type")
	public String getType() {
		return type;
	}

	@Column(name="part_code")
	public String getCode() {
		return code;
	}

	@Column(name="part_serial")
	public String getSerialNumber() {
		return serialNumber;
	}

	@Column(name="part_description")
	public String getDescription() {
		return description;
	}

	@Transient
	public Long getRequestId() {
		return requestId;
	}

	@ManyToOne(fetch=FetchType.LAZY,cascade =CascadeType.ALL)
	@JoinColumn(name="request_id")
	public SERequest getRequest() {
		return request;
	}

	@OneToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="amount_id")
	public SEAmount getAmount() {
		return amount;
	}

	@Column(name="part_uom")
	public String getUom() {
		return uom;
	}
	
	@Column(name="part_weight")
	public BigDecimal getWeight() {
		return weight;
	}

	@Column(name="model")
	public String getModel() {
		return model;
	}

	@Transient
	public Long getProdId() {
		return prodId;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="prod_id")
	public Product getProduct() {
		return product;
	}
	
	@Column(name="prod_srl_no")
	public String getProdSerialNumber() {
		return prodSerialNumber;
	}

	@Column(name="warehouse_code")
	public String getWarehouseCode() {
		return warehouseCode;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public void setRequest(SERequest request) {
		this.request = request;
	}

	public void setAmount(SEAmount amount) {
		this.amount = amount;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setProdSerialNumber(String prodSerialNumber) {
		this.prodSerialNumber = prodSerialNumber;
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}	


	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	@JsonIgnore(value=false)
	@Column(name = "created_date",updatable = false)
	@org.hibernate.annotations.Type(type="com.mize.domain.util.DateTimeJPA")
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	@Column(name = "updated_date")
	@org.hibernate.annotations.Type(type="com.mize.domain.util.DateTimeJPA")
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@JsonIgnore(value=false)
	@Column(name = "created_by",updatable=false)
	public Long getCreatedBy() {
		return createdBy;
	}
	
	@JsonIgnore(value=false)
	@Column(name = "updated_by")
	public Long getUpdatedBy() {
		return updatedBy;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@JsonIgnore(value=false)
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
 
	@JsonIgnore(value=false)
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	@Override
	public int compareTo(SEPart arg0) {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((prodId == null) ? 0 : prodId.hashCode());
		result = prime
				* result
				+ ((prodSerialNumber == null) ? 0 : prodSerialNumber.hashCode());
		result = prime * result
				+ ((requestId == null) ? 0 : requestId.hashCode());
		result = prime * result
				+ ((serialNumber == null) ? 0 : serialNumber.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((uom == null) ? 0 : uom.hashCode());
		result = prime * result
				+ ((warehouseCode == null) ? 0 : warehouseCode.hashCode());
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
		SEPart other = (SEPart) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (prodId == null) {
			if (other.prodId != null)
				return false;
		} else if (!prodId.equals(other.prodId))
			return false;
		if (prodSerialNumber == null) {
			if (other.prodSerialNumber != null)
				return false;
		} else if (!prodSerialNumber.equals(other.prodSerialNumber))
			return false;
		if (requestId == null) {
			if (other.requestId != null)
				return false;
		} else if (!requestId.equals(other.requestId))
			return false;
		if (serialNumber == null) {
			if (other.serialNumber != null)
				return false;
		} else if (!serialNumber.equals(other.serialNumber))
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
		if (warehouseCode == null) {
			if (other.warehouseCode != null)
				return false;
		} else if (!warehouseCode.equals(other.warehouseCode))
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
		return "SEPart [type=" + type + ", code=" + code + ", serialNumber="
				+ serialNumber + ", description=" + description
				+ ", requestId=" + requestId + ", amount=" + amount + ", uom="
				+ uom + ", weight=" + weight + ", model=" + model + ", prodId="
				+ prodId + ", prodSerialNumber=" + prodSerialNumber
				+ ", warehouseCode=" + warehouseCode + "]";
	}	

}
