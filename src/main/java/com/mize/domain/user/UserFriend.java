package com.mize.domain.user;

import com.mize.domain.auth.User;
import com.mize.domain.common.Entity;

public class UserFriend extends Entity{

	private static final long serialVersionUID = 3254042268089215302L;
	private User user;
	private User friendUser;
	private Long groupId;
	
	public UserFriend(){
		
	}

	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public User getFriendUser() {
		return friendUser;
	}


	public void setFriendUser(User friendUser) {
		this.friendUser = friendUser;
	}


	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	@Override
	public String toString() {
		return "UserFriend [user=" + user + ", friendUser=" + friendUser
				+ ", groupId=" + groupId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((friendUser == null) ? 0 : friendUser.hashCode());
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		UserFriend other = (UserFriend) obj;
		if (friendUser == null) {
			if (other.friendUser != null)
				return false;
		} else if (!friendUser.equals(other.friendUser))
			return false;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}


}
