package com.mize.domain.sce.ServiceEntity;

import java.io.Serializable;
import java.math.BigDecimal;

public class ServiceEntity implements Serializable{

	private static final long serialVersionUID = 7163244554562841569L;
	private int severity;
	private String entityStatus;
	private BigDecimal totalAmout;
	public ServiceEntity(){
		super();
	}
	
	public int getSeverity() {
		return severity;
	}
	public void setSeverity(int severity) {
		this.severity = severity;
	}
	public String getEntityStatus() {
		return entityStatus;
	}
	public void setEntityStatus(String entityStatus) {
		this.entityStatus = entityStatus;
	}
	public BigDecimal getTotalAmout() {
		return totalAmout;
	}
	public void setTotalAmout(BigDecimal totalAmout) {
		this.totalAmout = totalAmout;
	}
	@Override
	public String toString() {
		return "ServiceEntity [severity=" + severity + ", entityStatus="
				+ entityStatus + ", totalAmout=" + totalAmout + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((entityStatus == null) ? 0 : entityStatus.hashCode());
		result = prime * result + severity;
		result = prime * result
				+ ((totalAmout == null) ? 0 : totalAmout.hashCode());
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
		ServiceEntity other = (ServiceEntity) obj;
		if (entityStatus == null) {
			if (other.entityStatus != null)
				return false;
		} else if (!entityStatus.equals(other.entityStatus))
			return false;
		if (severity != other.severity)
			return false;
		if (totalAmout == null) {
			if (other.totalAmout != null)
				return false;
		} else if (!totalAmout.equals(other.totalAmout))
			return false;
		return true;
	}
	

}
