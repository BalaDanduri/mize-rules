package com.mize.domain.user;
 
 import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.util.JPASerializer;
 
 @Entity
 @Table(name = "groups_to_role")
 public class GroupRoleMapping extends MizeSceEntityAudit implements Comparable<GroupRoleMapping> {
 
   private static final long serialVersionUID = 6463766045224030020L;
 
   private Group group;
   private Role role;
   private String active;
   public GroupRoleMapping() {
   }
   public GroupRoleMapping(Group group, Role role, String active) {
     super();
     this.group = group;
     this.role = role;
     this.active = active;
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
 
   @ManyToOne(fetch=FetchType.LAZY,optional= false)
   @JoinColumn(name="group_id")
   @JsonBackReference(value="groupMapping")
   @JsonSerialize(using=JPASerializer.class)
   @JsonInclude(Include.NON_NULL)
   public Group getGroup() {
     return group;
   }
 
   public void setGroup(Group group) {
     this.group = group;
   }
   
   @ManyToOne(fetch=FetchType.EAGER,optional= false)
   @JoinColumn(name="role_id")
   @JsonBackReference(value="roleMapping")
   public Role getRole() {
     return role;
   }
 
   public void setRole(Role role) {
     this.role = role;
   }
 
   @Column(name = "ACTIVE_INDICATOR")
   public String getActive() {
     return active;
   }
 
   public void setActive(String active) {
     this.active = active;
   }
 
   @Override
public String toString() {
	return "GroupRoleMapping [active="+ active + "]";
}
@Override
public int hashCode() {
	final int prime = PRIME;
	int result = super.hashCode();
	result = prime * result + ((active == null) ? 0 : active.hashCode());
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
	GroupRoleMapping other = (GroupRoleMapping) obj;
	if (active == null) {
		if (other.active != null)
			return false;
	} else if (!active.equals(other.active))
		return false;
		return true;
}

@Override
   public int compareTo(GroupRoleMapping groupsToRole) {
     if ( this == groupsToRole ) 
       return EQUAL;
     else if (this.id < groupsToRole.id) 
       return BEFORE;
     else if (groupsToRole.id == this.id) 
       return EQUAL;
     else if (this.id > groupsToRole.id)
       return AFTER;
     return EQUAL;
   }
 
   
 }