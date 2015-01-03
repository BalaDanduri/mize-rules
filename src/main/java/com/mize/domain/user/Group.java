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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name = "groups")
public class Group extends MizeSceEntityAudit implements Comparable<Group> {

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
	@Column(name = "id")
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "CODE")
	/*@Size(max = 30)*/
	public String getCode() {
		return code;
	}

	@Column(name = "DESCRIPTION")
	/*@NonEmpty(message = "description.notempty")
	@Size(max = 200)*/
	public String getDescription() {
		return description;
	}

	@Column(name = "GROUP_NAME")
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

	@Column(name = "ACTIVE_INDICATOR")
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
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((groupsToRole == null) ? 0 : groupsToRole.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((relatedGroups == null) ? 0 : relatedGroups.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((userGroups == null) ? 0 : userGroups.hashCode());
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
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
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
		if (groupsToRole == null) {
			if (other.groupsToRole != null)
				return false;
		} else if (!groupsToRole.equals(other.groupsToRole))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (relatedGroups == null) {
			if (other.relatedGroups != null)
				return false;
		} else if (!relatedGroups.equals(other.relatedGroups))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (userGroups == null) {
			if (other.userGroups != null)
				return false;
		} else if (!userGroups.equals(other.userGroups))
			return false;
		return true;
	}

	
	
}
