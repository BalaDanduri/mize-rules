package com.mize.domain.user;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonBackReference;

import com.mize.domain.auth.User;
import com.mize.domain.common.MizeEntity;

@Entity
@Table(name="user_to_groups")
public class UserGroup extends MizeEntity implements Comparable<UserGroup> {

	private static final long serialVersionUID = -922509907830867390L;
	private User user;
	private Group group;
	private Long groupId;
	private String groupName;
	
	public UserGroup(){
		user = new User();
	}
	
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	@JsonBackReference(value="user_userGroups")
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="group_id")
	@JsonBackReference(value="group_userGroups")
	public Group getGroup() {
		return group;
	}
	
	public void setGroup(Group group) {
		this.group = group;
	}
	
	//@Column(name="group_id", nullable=false)
	@Transient
	public Long getGroupId() {
		return groupId;
	}
	
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	
	//@Column(name="group_name", nullable=false)
	@Transient
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "UserGroup [groupId=" + groupId
				+ ", groupName=" + groupName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result
				+ ((groupName == null) ? 0 : groupName.hashCode());
		//result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserGroup other = (UserGroup) obj;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		/*if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;*/
		return true;
	}
	
	public int compareTo(UserGroup userGroup) {
		if ( this == userGroup ) 
			return EQUAL;
		else if (this.id < userGroup.id) 
			return BEFORE;
		else if (userGroup.id == this.id) 
			return EQUAL;
		else if (this.id > userGroup.id)
			return AFTER;
		return EQUAL;		
	}
	
}
