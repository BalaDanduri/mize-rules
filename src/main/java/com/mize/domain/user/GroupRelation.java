package com.mize.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name = "groups_rltn")
public class GroupRelation extends MizeSceEntityAudit implements Comparable<GroupRelation>  {
	
	private static final long serialVersionUID = -3807516414484114241L;
	
	private Group group;
	private Group relatedGroup;
	private String relationType;
	
	public GroupRelation() {
	}
	
	public GroupRelation(Group group, Group relatedGroup, String relationType) {
	     super();
	     this.group = group;
	     this.relatedGroup = relatedGroup;
	     this.relationType = relationType;
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
   
   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="group_id")
   @JsonBackReference(value="groupRelationMapping")
   @JsonSerialize(using=JPASerializer.class)
   @JsonInclude(Include.NON_NULL)
   public Group getGroup() {
	return group;
   }

	public void setGroup(Group group) {
		this.group = group;
	}
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="rltd_group_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public Group getRelatedGroup() {
		return relatedGroup;
	}
	
	public void setRelatedGroup(Group relatedGroup) {
		this.relatedGroup = relatedGroup;
	}
	
	@Column(name="relation_type",nullable=true,length=50)
	public String getRelationType() {
		return relationType;
	}
	
	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}
	
	
   @Override
	public String toString() {
		return "GroupRelations [relationType=" + relationType + "]";
	}

   @Override
   public int compareTo(GroupRelation groupRelations) {
     if ( this == groupRelations ) 
       return EQUAL;
     else if (this.id < groupRelations.id) 
       return BEFORE;
     else if (groupRelations.id == this.id) 
       return EQUAL;
     else if (this.id > groupRelations.id)
       return AFTER;
     return EQUAL;
   }

@Override
public int hashCode() {
	final int prime = PRIME;
	int result = super.hashCode();
	result = prime * result + ((relationType == null) ? 0 : relationType.hashCode());
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
	GroupRelation other = (GroupRelation) obj;
	if (relationType == null) {
		if (other.relationType != null)
			return false;
	} else if (!relationType.equals(other.relationType))
		return false;
	return true;
}

}
