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

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;
 
 @Entity
 @Table(name = "groups_to_role")
 public class GroupRoleMapping extends MizeEntity implements Comparable<GroupRoleMapping> {
 
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
   @Column(name = "id", nullable = false, unique = true)
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
   @JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
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
 
   @Column(name = "ACTIVE_INDICATOR", nullable = true, length = 1)
   public String getActive() {
     return active;
   }
 
   public void setActive(String active) {
     this.active = active;
   }
 
    @Override	
	@DateTimeFormat(pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	@JsonIgnore(value=false)
	@org.hibernate.annotations.Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "created_date",updatable=false)
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	@JsonIgnore(value=false)
	@org.hibernate.annotations.Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "updated_date")
	public DateTime getUpdatedDate() {
		return updatedDate;
	}

	@Override
	@JsonIgnore(value=false)
	@Column(name = "created_by")
	public Long getCreatedBy() {		
		return super.getCreatedBy();
	}

	@Override
	@JsonIgnore(value=false)
	@Column(name = "updated_by")
	public Long getUpdatedBy() {		
		return super.getUpdatedBy();
	}

	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(false)
	public void setCreatedDate(DateTime createdDate) {
		super.createdDate = createdDate;
	}

	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(false)
	public void setUpdatedDate(DateTime updatedDate) {
		super.updatedDate = updatedDate;
	}

	@Override
	@JsonIgnore(value=false)
	public void setCreatedBy(Long createdBy) {		
		super.setCreatedBy(createdBy);
	}

	@Override
	@JsonIgnore(value=false)
	public void setUpdatedBy(Long updatedBy) {		
		super.setUpdatedBy(updatedBy);
	}
   
   
   
   @Override
public String toString() {
	return "GroupRoleMapping [active="+ active + "]";
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