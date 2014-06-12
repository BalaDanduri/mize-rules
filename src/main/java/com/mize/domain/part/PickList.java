package com.mize.domain.part;

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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name = "picklist", uniqueConstraints = {@UniqueConstraint (columnNames = {"be_id", "picklist_code","tenant_id"})})
public class PickList extends MizeEntity {

	private static final long serialVersionUID = 7197887648853141829L;
	private BusinessEntity pickListLocation;
	private String code;
	private String type;
	private String isActive;
	@Transient
	private User user;
	@Transient
	private EntityComment entityComment;
	private List<PickListComment> comments = new ArrayList<PickListComment>();
	private BusinessEntity tenant;
	private List<PickListItem> listItems;

	public PickList(){
		super();
	}

	public PickList(BusinessEntity pickListLocation, String code, String type,
			String isActive, User user, EntityComment entityComment,
			List<PickListComment> comments, BusinessEntity tenant,
			List<PickListItem> listItems) {
		super();
		this.pickListLocation = pickListLocation;
		this.code = code;
		this.type = type;
		this.isActive = isActive;
		this.user = user;
		this.entityComment = entityComment;
		this.comments = comments;
		this.tenant = tenant;
		this.listItems = listItems;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}

	@Column(name = "picklist_code", length = 30, nullable = false)
	public String getCode() {
		return code;
	}

	@Column(name = "picklist_type", length = 30, nullable = true)
	public String getType() {
		return type;
	}

	@Column(name = "is_active", length = 1, nullable = true)
	public String getIsActive() {
		return isActive;
	}

	@Transient
	public EntityComment getEntityComment() {
		return entityComment;
	}

	public void setEntityComment(EntityComment entityComment) {
		this.entityComment = entityComment;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "pickList")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<PickListComment> getComments() {
		return comments;
	}

	public void setComments(List<PickListComment> comments) {
		this.comments = comments;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tenant_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getTenant() {
		return tenant;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER, mappedBy = "pickList", orphanRemoval= true)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference(value="pickListItem")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
    @JsonInclude(Include.NON_DEFAULT)

	public List<PickListItem> getListItems() {
		return listItems;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "be_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getPickListLocation() {
		return pickListLocation;
	}

	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "created_date",updatable = false)
	@JsonIgnore(value = false)
	@JsonSerialize(using=JsonDateTimeSerializer.class)
    @JsonInclude(Include.NON_DEFAULT)

	public DateTime getCreatedDate() {
		return createdDate;
	}

	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "updated_date")
	@JsonIgnore(value = false)
	@JsonSerialize(using=JsonDateTimeSerializer.class)
    @JsonInclude(Include.NON_DEFAULT)

	public DateTime getUpdatedDate() {
		return updatedDate;
	}

	@Override
	@JsonIgnore
	@Column(name = "created_by",updatable=false)
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

	public void setCode(String code) {
		this.code = code;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	public void setListItems(List<PickListItem> listItems) {
		this.listItems = listItems;
	}

	public void setPickListLocation(BusinessEntity pickListLocation) {
		this.pickListLocation = pickListLocation;
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
	@JsonIgnore
	public void setCreatedBy(Long createdBy) {		
		super.setCreatedBy(createdBy);
	}

	@Override
	@JsonIgnore
	public void setUpdatedBy(Long updatedBy) {		
		super.setUpdatedBy(updatedBy);
	}
	
	@Transient	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((pickListLocation == null) ? 0 : pickListLocation.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result
				+ ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((listItems == null) ? 0 : listItems.hashCode());
		result = prime * result + ((tenant == null) ? 0 : tenant.hashCode());
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
		PickList other = (PickList) obj;
		if (pickListLocation == null) {
			if (other.pickListLocation != null)
				return false;
		} else if (!pickListLocation.equals(other.pickListLocation))
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
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (listItems == null) {
			if (other.listItems != null)
				return false;
		} else if (!listItems.equals(other.listItems))
			return false;
		if (tenant == null) {
			if (other.tenant != null)
				return false;
		} else if (!tenant.equals(other.tenant))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
