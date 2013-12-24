package com.mize.domain.user;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.common.MizeEntity;

public class Account extends MizeEntity implements Comparable<Account>{

	private static final long serialVersionUID = -1260385580583739007L;
	private String type;
	private List<Privilege> privileges = new ArrayList<Privilege>();
	
	public Account() {
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
	
	public int compareTo(Account  account) {
		if ( this == account ) 
			return EQUAL;
		else if (this.id < account.id) 
			return BEFORE;
		else if (account.id == this.id) 
			return EQUAL;
		else if (this.id > account.id)
			return AFTER;
		return EQUAL;		
	}

	@Override
	public String toString() {
		return "Account [type=" + type + ", privileges=" + privileges + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = PRIME * result + ((type == null) ? 0 : type.hashCode());
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
		Account other = (Account) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}	
	
	
}
