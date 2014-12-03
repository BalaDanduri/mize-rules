package com.mize.domain.upload;

import com.mize.domain.auth.User;
import com.mize.domain.common.MizeSceEntity;

public class ExtractData extends MizeSceEntity implements Comparable<ExtractData>{

	private static final long serialVersionUID = -1474522071819508558L;
	private String jobName;
	private User user;
	private String selectSql;
	
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getSelectSql() {
		return selectSql;
	}
	public void setSelectSql(String selectSql) {
		this.selectSql = selectSql;
	}
	
	@Override
	public int compareTo(ExtractData arg0) {
		return 0;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((jobName == null) ? 0 : jobName.hashCode());
		result = prime * result
				+ ((selectSql == null) ? 0 : selectSql.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		ExtractData other = (ExtractData) obj;
		if (jobName == null) {
			if (other.jobName != null)
				return false;
		} else if (!jobName.equals(other.jobName))
			return false;
		if (selectSql == null) {
			if (other.selectSql != null)
				return false;
		} else if (!selectSql.equals(other.selectSql))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "ExtractFile [jobName=" + jobName + ", user=" + user
				+ ", selectSql=" + selectSql + "]";
	}
		
}
