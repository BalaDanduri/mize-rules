package com.mize.domain.user;

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
@Table(name = "role")
public class Role extends MizeEntity implements Comparable<Role>{

	private static final long serialVersionUID = 6863889616106407854L;
	private String name;
	private String description;
	private String code;
	private String active;
	
	
	public Role(){		
	}
	
	public Role(String name, String description, String code, String active) {
		super();
		this.name = name;
		this.description = description;
		this.code = code;
		this.active = active;
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
	@NonEmpty(message="code.notempty")
	@Size(max = 30)
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "ROLE_NAME", nullable = false, length = 100)
	@NonEmpty(message="roleName.notempty")
	@Size(max = 100)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	@Column(name = "ACTIVE_INDICATOR", nullable = true, length = 1)
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
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
		return "Role [id=" + id + ", name=" + name + ", description=" + description + ",active=" + active + "]";
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