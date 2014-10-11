package com.mize.domain.util;

import org.joda.time.DateTime;

import com.mize.domain.common.MizeSceEntity;

public class Employee extends MizeSceEntity implements Comparable<Employee>{
	
	private static final long serialVersionUID = -4960359255473053939L;
	private String name;
	private Long id;
	private DateTime joinDate;
	private MizeDateTime mizeDateTime;
	
	public Employee(){			
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public DateTime getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(DateTime joinDate) {
		this.joinDate = joinDate;
	}

	public MizeDateTime getMizeDateTime() {
		return mizeDateTime;
	}

	public void setMizeDateTime(MizeDateTime mizeDateTime) {
		this.mizeDateTime = mizeDateTime;
	}

	@Override
	public int compareTo(Employee o) {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((joinDate == null) ? 0 : joinDate.hashCode());
		result = prime * result
				+ ((mizeDateTime == null) ? 0 : mizeDateTime.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (joinDate == null) {
			if (other.joinDate != null)
				return false;
		} else if (!joinDate.equals(other.joinDate))
			return false;
		if (mizeDateTime == null) {
			if (other.mizeDateTime != null)
				return false;
		} else if (!mizeDateTime.equals(other.mizeDateTime))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", joinDate="
				+ joinDate + ", mizeDateTime=" + mizeDateTime + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + ", updatedBy="
				+ updatedBy + ", updatedDate=" + updatedDate + "]";
	}
	
	
	
}
