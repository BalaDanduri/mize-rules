package com.mize.domain.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.mize.domain.common.MizeEntity;

@Entity
@Table(name = "role")
public class Role extends MizeEntity implements Comparable<Role>{

	private static final long serialVersionUID = 6863889616106407854L;
	private String name;
	private String description;
	private String code;
	private List<Group> groups = new ArrayList<Group>(); 
	
	public Role(){		
	}
	
	public Role(String name, String description, String code, List<Group> groups) {
		super();
		this.name = name;
		this.description = description;
		this.code = code;
		this.groups = groups;
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
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "ROLE_NAME", nullable = false, length = 100)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "DESCRIPTION", nullable = true, length = 200)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@javax.persistence.Transient
	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
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
		Role other = (Role) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", description=" + description + "]";
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
