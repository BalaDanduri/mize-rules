package com.mize.domain.labor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name="LaborHourIntlExt")
public class LaborHourIntlExt extends LaborHourIntl{

	private static final long serialVersionUID = -1342266220815979799L;
	
	private String isActive;
	
	@Column(name = "is_active")
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
}
