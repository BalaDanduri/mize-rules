package com.mize.domain.sce.part;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name = "part_kit", uniqueConstraints = {@UniqueConstraint (columnNames = {"part_id"})})
public class PartKit extends MizeEntity{

	private static final long serialVersionUID = 4502594935806813253L;
	
	private Part part;
	private String priceMethod;
	private String type;
	private String isActive;
	private DateTime startDate;
	private DateTime endDate;
	private List<PartKitItem> partKitItems;
	
	public PartKit(){
		super();
	}
	
	public PartKit(Part part, String priceMethod, String type,
			String isActive, DateTime startDate, DateTime endDate,
			List<PartKitItem> partKitItems) {
		super();
		this.part = part;
		this.priceMethod = priceMethod;
		this.type = type;
		this.isActive = isActive;
		this.startDate = startDate;
		this.endDate = endDate;
		this.partKitItems = partKitItems;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "part_id")
	public Part getPart() {
		return part;
	}

	@Column(name = "price_method", length = 30, nullable = false)
	public String getPriceMethod() {
		return priceMethod;
	}

	@Column(name = "kit_type", length = 30, nullable = false)
	public String getType() {
		return type;
	}

	@Column(name = "is_active", length = 1, nullable = false)
	public String getIsActive() {
		return isActive;
	}

	@Column(name = "start_date", nullable = false)
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	public DateTime getStartDate() {
		return startDate;
	}

	@Column(name = "end_date", nullable = false)
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	public DateTime getEndDate() {
		return endDate;
	}
	
	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "created_date")
	public DateTime getCreatedDate() {
		return createdDate;
	}
	
	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "updated_date")
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	
	@Override
	@JsonIgnore
	@Column(name = "created_by")
	public Long getCreatedBy() {		
		return super.getCreatedBy();
	}

	
	@Override
	@JsonIgnore
	@Column(name = "updated_by")
	public Long getUpdatedBy() {		
		return super.getUpdatedBy();
	}
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "partKit")
	public List<PartKitItem> getPartKitItems() {
		return partKitItems;
	}

	
	public void setPartKitItems(List<PartKitItem> partKitItems) {
		this.partKitItems = partKitItems;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public void setPriceMethod(String priceMethod) {
		this.priceMethod = priceMethod;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}
	
	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore
	public void setCreatedDate(DateTime createdDate) {
		super.createdDate = createdDate;
	}
	
	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore
	public void setUpdatedDate(DateTime updatedDate) {
		super.updatedDate = updatedDate;
	}
	
	@Override
	@JsonIgnore
	public void setCreatedBy(Long createdBy) {		
		super.setCreatedBy(createdBy);
	}
	
	@Override
	@JsonIgnore
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result
				+ ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((part == null) ? 0 : part.hashCode());
		result = prime * result
				+ ((partKitItems == null) ? 0 : partKitItems.hashCode());
		result = prime * result
				+ ((priceMethod == null) ? 0 : priceMethod.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		PartKit other = (PartKit) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (part == null) {
			if (other.part != null)
				return false;
		} else if (!part.equals(other.part))
			return false;
		if (partKitItems == null) {
			if (other.partKitItems != null)
				return false;
		} else if (!partKitItems.equals(other.partKitItems))
			return false;
		if (priceMethod == null) {
			if (other.priceMethod != null)
				return false;
		} else if (!priceMethod.equals(other.priceMethod))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PartKit [part=" + part + ", priceMethod=" + priceMethod
				+ ", type=" + type + ", isActive=" + isActive + ", startDate="
				+ startDate + ", endDate=" + endDate + ", partKitItems="
				+ partKitItems + "]";
	}
	
	
}
