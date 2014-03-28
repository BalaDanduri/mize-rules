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
import javax.validation.constraints.Size;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name = "role")
public class Role extends MizeEntity implements Comparable<Role>{

	private static final long serialVersionUID = 6863889616106407854L;
	private String name;
	private String description;
	private String code;
	private String active;	
   /* private List<Group> groups;*/
	
	private List<GroupRoleMapping> groupsToRole;
	
	
	
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
	@Column(name = "id", unique = false, nullable = false, length = 11)
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "CODE", nullable = true, length = 20)
	/*@NonEmpty(message="code.notempty")*/
	@Size(max = 30)
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "ROLE_NAME", nullable = false, length = 100)
	/*@NonEmpty(message="roleName.notempty")*/
	@Size(max = 100)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "DESCRIPTION", nullable = true, length = 200)
	/*@NonEmpty(message="description.notempty")*/
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
	
	@OneToMany(fetch = FetchType.LAZY,cascade={CascadeType.ALL}, mappedBy ="role")
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	@JsonManagedReference(value="roleMapping")
	public List<GroupRoleMapping> getGroupsToRole() {
		return groupsToRole;
	}

	public void setGroupsToRole(List<GroupRoleMapping> groupsToRole) {
		this.groupsToRole = groupsToRole;
	}
/*
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	@JsonManagedReference(value="role_groups")
	public List<Group> getGroups() {
		return groups;
	}
	
	@JsonManagedReference(value="role_groups")
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}*/
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@JsonIgnore(value=false)
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
 
	@JsonIgnore(value=false)
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	@JsonIgnore(value=false)
	@Column(name = "created_date",updatable = false)
	@org.hibernate.annotations.Type(type="com.mize.domain.util.DateTimeJPA")
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	@JsonIgnore(value=false)
	@Column(name = "updated_date")
	@org.hibernate.annotations.Type(type="com.mize.domain.util.DateTimeJPA")
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
