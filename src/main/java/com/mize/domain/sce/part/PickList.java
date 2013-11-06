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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.MizeEntity;
import com.mize.domain.servicelocator.BusinessEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;

@Entity
@Table(name = "picklist", uniqueConstraints = {@UniqueConstraint (columnNames = {"be_id", "picklist_code","tenant_id"})})
public class PickList extends MizeEntity {

	private static final long serialVersionUID = 7197887648853141829L;
	private BusinessEntity businessEntity;
	private String pickListCode;
	private String pickListType;
	private String isActive;
	private String pickListComments;
	private BusinessEntity tenant;
	private List<PickListItem> pickListItems;

	public PickList(){
		super();
	}

	public PickList(BusinessEntity businessEntity, String pickListCode,
			String pickListType, String isActive, String pickListComments,
			BusinessEntity tenant, List<PickListItem> pickListItems) {
		super();
		this.businessEntity = businessEntity;
		this.pickListCode = pickListCode;
		this.pickListType = pickListType;
		this.isActive = isActive;
		this.pickListComments = pickListComments;
		this.tenant = tenant;
		this.pickListItems = pickListItems;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}

	@Column(name = "picklist_code", length = 30, nullable = false)
	public String getPickListCode() {
		return pickListCode;
	}

	@Column(name = "picklist_type", length = 30, nullable = true)
	public String getPickListType() {
		return pickListType;
	}

	@Column(name = "is_active", length = 1, nullable = true)
	public String getIsActive() {
		return isActive;
	}

	@Column(name = "picklist_comments", length = 500, nullable = false)
	public String getPickListComments() {
		return pickListComments;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tenant_id")
	public BusinessEntity getTenant() {
		return tenant;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pickList")
	public List<PickListItem> getPickListItems() {
		return pickListItems;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "be_id")
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
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

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public void setPickListCode(String pickListCode) {
		this.pickListCode = pickListCode;
	}

	public void setPickListType(String pickListType) {
		this.pickListType = pickListType;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public void setPickListComments(String pickListComments) {
		this.pickListComments = pickListComments;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	public void setPickListItems(List<PickListItem> pickListItems) {
		this.pickListItems = pickListItems;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
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


	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((businessEntity == null) ? 0 : businessEntity.hashCode());
		result = prime * result
				+ ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result
				+ ((pickListCode == null) ? 0 : pickListCode.hashCode());
		result = prime
				* result
				+ ((pickListComments == null) ? 0 : pickListComments.hashCode());
		result = prime * result
				+ ((pickListItems == null) ? 0 : pickListItems.hashCode());
		result = prime * result
				+ ((pickListType == null) ? 0 : pickListType.hashCode());
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
		PickList other = (PickList) obj;
		if (businessEntity == null) {
			if (other.businessEntity != null)
				return false;
		} else if (!businessEntity.equals(other.businessEntity))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (pickListCode == null) {
			if (other.pickListCode != null)
				return false;
		} else if (!pickListCode.equals(other.pickListCode))
			return false;
		if (pickListComments == null) {
			if (other.pickListComments != null)
				return false;
		} else if (!pickListComments.equals(other.pickListComments))
			return false;
		if (pickListItems == null) {
			if (other.pickListItems != null)
				return false;
		} else if (!pickListItems.equals(other.pickListItems))
			return false;
		if (pickListType == null) {
			if (other.pickListType != null)
				return false;
		} else if (!pickListType.equals(other.pickListType))
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
		StringBuilder builder = new StringBuilder();
		builder.append("PickList [businessEntity=");
		builder.append(businessEntity);
		builder.append(", pickListCode=");
		builder.append(pickListCode);
		builder.append(", pickListType=");
		builder.append(pickListType);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append(", pickListComments=");
		builder.append(pickListComments);
		builder.append(", tenant=");
		builder.append(tenant);
		builder.append(", pickListItems=");
		builder.append(pickListItems);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}
}
