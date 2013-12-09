package com.mize.domain.user;
 
 import javax.persistence.Column;
 import javax.persistence.Entity;
 import javax.persistence.FetchType;
 import javax.persistence.GeneratedValue;
 import javax.persistence.Id;
 import javax.persistence.JoinColumn;
 import javax.persistence.ManyToOne;
 import javax.persistence.Table;
 
 import org.codehaus.jackson.annotate.JsonBackReference;
 import org.hibernate.annotations.GenericGenerator;
 
 import com.mize.domain.common.MizeEntity;
 
 @Entity
 @Table(name = "groups_to_role")
 public class GroupsToRole extends MizeEntity implements Comparable<GroupsToRole> {
 
   private static final long serialVersionUID = 6463766045224030020L;
 
   private Group group;
   private Role role;
   private String active;
   public GroupsToRole() {
   }
   public GroupsToRole(Group group, Role role, String active) {
     super();
     this.group = group;
     this.role = role;
     this.active = active;
   }
 
 
 
   @Id
   @GenericGenerator(name = "id", strategy = "increment")
   @GeneratedValue(generator = "id")
   @Column(name = "ID", unique = false, nullable = false, length = 11)
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
   public Group getGroup() {
     return group;
   }
 
   public void setGroup(Group group) {
     this.group = group;
   }
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "role_id")
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
   public int compareTo(GroupsToRole groupsToRole) {
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