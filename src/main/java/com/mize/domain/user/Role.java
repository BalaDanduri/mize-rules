package com.mize.domain.user;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name = "role")
public class Role extends MizeSceEntityAudit implements Comparable<Role>{

	private static final long serialVersionUID = 6863889616106407854L;
	private String name;
	private String description;
	private String code;
	private String active;
	private List<GroupRoleMapping> groupsToRole;
	
	@Transient
	private User user;
	
	public Role(){		
	}
	
	public Role(String name, String description, String code, String active,List<GroupRoleMapping> groupsToRole) {
		super();
		this.name = name;
		this.description = description;
		this.code = code;
		this.active = active;
		this.groupsToRole = groupsToRole;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	/*@NonEmpty(message="code.notempty")*/
	@Size(max = 30)
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "ROLE_NAME")
	/*@NonEmpty(message="roleName.notempty")*/
	@Size(max = 100)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "DESCRIPTION")
	/*@NonEmpty(message="description.notempty")*/
	@Size(max = 200)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "ACTIVE_INDICATOR")
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	
	@OneToMany(fetch = FetchType.LAZY,cascade={CascadeType.ALL}, mappedBy ="role")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonManagedReference(value="roleMapping")
	public List<GroupRoleMapping> getGroupsToRole() {
		return groupsToRole;
	}

	public void setGroupsToRole(List<GroupRoleMapping> groupsToRole) {
		this.groupsToRole = groupsToRole;
	}
	
	
	@Transient
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((groupsToRole == null) ? 0 : groupsToRole.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Role other = (Role) obj;
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
		} else if (!groupsToRole.containsAll(other.groupsToRole))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Role [name=" + name + ", description=" + description
				+ ", code=" + code + ", active=" + active + "]";
	}



	public int compareTo(Role role) {
		if ( this == role ) 
			return EQUAL;
		else if (this.id < role.id) 
			return BEFORE;
		else if (role.id == this.id) 
			return EQUAL;
		else if (this.id > role.id)
			return AFTER;
		return EQUAL;		
	}

}
