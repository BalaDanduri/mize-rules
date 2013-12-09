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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeEntity;

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

	public Group() {
	}

	public Group(String name, String code, String description, String active,
			List<Role> roles, BusinessEntity owner) {
		super();
		this.name = name;
		this.code = code;
		this.description = description;
		this.active = active;
		this.roles = roles;
		this.owner = owner;
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

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "groups_to_role", joinColumns = { @JoinColumn(name = "group_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") })
	/*@JsonManagedReference(value="group_roles")*/
	public List<Role> getRoles() {
		return roles;
	}

	@Column(name = "ACTIVE_INDICATOR", nullable = true, length = 1)
	public String getActive() {
		return active;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tenant_id")
	public BusinessEntity getOwner() {
		return owner;
	}

	public void setActive(String active) {
		this.active = active;
	}
	
	/*@JsonManagedReference(value="group_roles")*/
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
				+ description + ", active=" + active + ", roles=" + roles
				+ ", owner=" + owner + "]";
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
