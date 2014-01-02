package com.mize.domain.product;

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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
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
@Table(name = "prod_serial", uniqueConstraints = {@UniqueConstraint (columnNames = {"id"})})
public class ProductSerial extends MizeEntity{
	
	private static final long serialVersionUID = 1396934864607540803L;
	private BusinessEntity tenant;
	private Product product;
	private String serialNumber;
	private BusinessEntity deliveryBE;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	protected DateTime deliveryDate;	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime buildDate;
	@Transient
	private EntityComment entityComment;
	private List<ProductSerialComment> comments = new ArrayList<ProductSerialComment>();
	@Transient
	private User user;
	
	public ProductSerial(){
		super();
	}

	public ProductSerial(BusinessEntity tenantId, Product product, String serialNumber,
			BusinessEntity deliveryBE, DateTime deliveryDate, DateTime buildDate) {
		super();
		this.tenant = tenantId;
		this.product = product;
		this.serialNumber = serialNumber;
		this.deliveryBE = deliveryBE;
		this.deliveryDate = deliveryDate;
		this.buildDate = buildDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="tenant_id")
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="prod_id")
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "prod_srl_no", nullable = true)
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="delivery_be_id", nullable = true)
	public BusinessEntity getDeliveryBE() {
		return deliveryBE;
	}

	public void setDeliveryBE(BusinessEntity deliveryBE) {
		this.deliveryBE = deliveryBE;
	}

	@Column(name = "delivery_date", nullable = true)
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using = JsonDateTimeSerializer.class, include = Inclusion.NON_NULL)	
	public DateTime getDeliveryDate() {
		return deliveryDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setDeliveryDate(DateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Column(name = "build_date", nullable = true)
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using = JsonDateTimeSerializer.class, include = Inclusion.NON_NULL)
	public DateTime getBuildDate() {
		return buildDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setBuildDate(DateTime buildDate) {
		this.buildDate = buildDate;
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
	public EntityComment getEntityComment() {
		return entityComment;
	}

	public void setEntityComment(EntityComment entityComment) {
		this.entityComment = entityComment;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "productSerial",orphanRemoval= true)
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	public List<ProductSerialComment> getComments() {
		return comments;
	}

	public void setComments(List<ProductSerialComment> comments) {
		this.comments = comments;
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
		result = prime * result
				+ ((buildDate == null) ? 0 : buildDate.hashCode());
		result = prime * result
				+ ((deliveryBE == null) ? 0 : deliveryBE.hashCode());
		result = prime * result
				+ ((deliveryDate == null) ? 0 : deliveryDate.hashCode());
		result = prime
				* result
				+ ((serialNumber == null) ? 0 : serialNumber.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((tenant == null) ? 0 : tenant.hashCode());
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
		ProductSerial other = (ProductSerial) obj;
		if (buildDate == null) {
			if (other.buildDate != null)
				return false;
		} else if (!buildDate.equals(other.buildDate))
			return false;
		if (deliveryBE == null) {
			if (other.deliveryBE != null)
				return false;
		} else if (!deliveryBE.equals(other.deliveryBE))
			return false;
		if (deliveryDate == null) {
			if (other.deliveryDate != null)
				return false;
		} else if (!deliveryDate.equals(other.deliveryDate))
			return false;
		if (serialNumber == null) {
			if (other.serialNumber != null)
				return false;
		} else if (!serialNumber.equals(other.serialNumber))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (tenant == null) {
			if (other.tenant != null)
				return false;
		} else if (!tenant.equals(other.tenant))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductSerial [tenant=" + tenant + ", product=" + product
				+ ", serialNumber=" + serialNumber + ", deliveryBE="
				+ deliveryBE + ", deliveryDate=" + deliveryDate
				+ ", buildDate=" + buildDate + "]";
	}

	
}
