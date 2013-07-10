package com.mize.domain.user;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.NonEmpty;

@Entity
@Table(name = "groups")
public class Group extends MizeEntity implements Comparable<Group>{

	private static final long serialVersionUID = 4856844676138040686L;
	private String name;
	private String code;
	private String description;
	private String active;
	private List<Role> roles = new ArrayList<Role>();
	
	public Group(){		
	}
	
	public Group(String name, String description, String code, String active, List<Role> roles) {
		super();
		this.name = name;
		this.description = description;
		this.code = code;
		this.active = active;
		this.roles = roles;
	}
	

	@Id
	@GenericGenerator(name="Id" , strategy="increment")
	@GeneratedValue(generator="Id")
	@Column(name = "ID", unique = false, nullable = false, length = 11)
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}	
	
	@Column(name = "CODE", nullable = true, length = 20)
	@Size(max = 30)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "DESCRIPTION", nullable = true, length = 200)
	@NonEmpty(message="description.notempty")
	@Size(max = 200)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "GROUP_NAME", nullable = false, length = 100)
	@NonEmpty(message="groupName.notempty")
	@Size(max = 100)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@javax.persistence.Transient
	public List<Role> getRoles() {
		return roles;
	}
	
	@Column(name = "ACTIVE_INDICATOR", nullable = true, length = 1)
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public int compareTo(Group group) {
		if ( this == group ) 
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
		return "Group [name=" + name + ", roles=" + roles + ", id=" + id + ", active=" + active + "]";
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
