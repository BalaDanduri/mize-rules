package com.mize.domain.user;

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
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
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
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name = "groups", uniqueConstraints = { @UniqueConstraint(columnNames = {"tenant_id", "CODE" }) })
public class Group extends MizeEntity implements Comparable<Group> {

	private static final long serialVersionUID = 4856844676138040686L;
	private String name;
	private String code;
	private String description;
	private String active;
	private List<Role> roles = new ArrayList<Role>();
	private BusinessEntity owner;
	private List<UserGroup> userGroups = new ArrayList<UserGroup>();
	private List<GroupRoleMapping> groupsToRole = new ArrayList<GroupRoleMapping>();
	private List<GroupRelation> relatedGroups = new ArrayList<GroupRelation>();
	
	@Transient
	private User user;

	public Group() {
	}
	 
	public Group(String name, String code, String description, String active,
			List<Role> roles, BusinessEntity owner,
			List<GroupRoleMapping> groupsToRole, List<GroupRelation> relatedGroups) {
		super();
		this.name = name;
		this.code = code;
		this.description = description;
		this.active = active;
		this.roles = roles;
		this.owner = owner;
		this.groupsToRole = groupsToRole;
		this.relatedGroups = relatedGroups;
	}



	public Group(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}
	
	public Group(Long id,String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

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

	@Column(name = "CODE", nullable = true, length = 20)
	/*@Size(max = 30)*/
	public String getCode() {
		return code;
	}

	@Column(name = "DESCRIPTION", nullable = true, length = 200)
	/*@NonEmpty(message = "description.notempty")
	@Size(max = 200)*/
	public String getDescription() {
		return description;
	}

	@Column(name = "GROUP_NAME", nullable = false, length = 100)
	/*@NonEmpty(message = "groupName.notempty")
	@Size(max = 100)
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z\\s]+$", message = "groupName.alpha")*/
	public String getName() {
		return name;
	}
	
	@Transient
	public List<Role> getRoles() {
		return roles;
	}

	@Column(name = "ACTIVE_INDICATOR", nullable = true, length = 1)
	public String getActive() {
		return active;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tenant_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getOwner() {
		return owner;
	}

	public void setActive(String active) {
		this.active = active;
	}
	
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void setOwner(BusinessEntity tenant) {
		this.owner = tenant;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@OneToMany(mappedBy="group", cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JsonSerialize(using=JPASerializer.class)	
	@JsonInclude(Include.NON_NULL)
	public List<UserGroup> getUserGroups() {
		return userGroups;
	}
	
	public void setUserGroups(List<UserGroup> userGroups) {
		this.userGroups = userGroups;
	}
	

	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL , mappedBy ="group", orphanRemoval = true)
	@Fetch(value=FetchMode.SUBSELECT)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonManagedReference(value="groupMapping")
	public List<GroupRoleMapping> getGroupsToRole() {
		return groupsToRole;
	}

	public void setGroupsToRole(List<GroupRoleMapping> groupsToRole) {
		this.groupsToRole = groupsToRole;
	}
	
	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL , mappedBy ="group", orphanRemoval = true)
	@Fetch(value=FetchMode.SUBSELECT)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonManagedReference(value="groupRelationMapping")
	public List<GroupRelation> getRelatedGroups() {
		return relatedGroups;
	}

	public void setRelatedGroups(List<GroupRelation> relatedGroups) {
		this.relatedGroups = relatedGroups;
	}
	
	@Transient
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@Override
	@JsonIgnore(value=false)
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
 
	@Override
	@JsonIgnore(value=false)
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	@JsonIgnore(value=false)
	@Column(name = "created_date",updatable = false)
	@org.hibernate.annotations.Type(type="com.mize.domain.util.DateTimeJPA")
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	@JsonIgnore(value=false)
	@Column(name = "updated_date")
	@org.hibernate.annotations.Type(type="com.mize.domain.util.DateTimeJPA")
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@Override
	@JsonIgnore(value=false)
	@Column(name = "created_by" , updatable=false)
	public Long getCreatedBy() {
		return createdBy;
	}
	
	@Override
	@JsonIgnore
	@Column(name = "updated_by")
	public Long getUpdatedBy() {		
		return super.getUpdatedBy();
	}

	
	public int compareTo(Group group) {
		if (this == group)
			return EQUAL;
		else if (this.id < group.id)
			return BEFORE;
		else if (group.id == this.id)
			return EQUAL;
		else if (this.id > group.id)
			return AFTER;
		return EQUAL;
	}



	@Override
	public String toString() {
		return "Group [name=" + name + ", code=" + code + ", description="
				+ description + ", active=" + active + "]";
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = PRIME * result + ((name == null) ? 0 : name.hashCode());
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
		Group other = (Group) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
