package com.mize.domain.service.schedule;

import com.mize.domain.common.MizeEntity;

public class ActivitiModel  extends MizeEntity  implements Comparable<ActivitiModel> {	
	
	private static final long serialVersionUID = -5351211947355990640L;

	private String name;
	private String deploymentId;
	private String processUrl;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeploymentId() {
		return deploymentId;
	}

	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}

	public String getProcessUrl() {
		return processUrl;
	}

	public void setProcessUrl(String processUrl) {
		this.processUrl = processUrl;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}	
	
	@Override
	public int compareTo(ActivitiModel arg0) {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((deploymentId == null) ? 0 : deploymentId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((processUrl == null) ? 0 : processUrl.hashCode());
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
		ActivitiModel other = (ActivitiModel) obj;
		if (deploymentId == null) {
			if (other.deploymentId != null)
				return false;
		} else if (!deploymentId.equals(other.deploymentId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (processUrl == null) {
			if (other.processUrl != null)
				return false;
		} else if (!processUrl.equals(other.processUrl))
			return false;
		return true;
	}
	
	
	
}
