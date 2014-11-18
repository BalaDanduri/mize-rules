package com.mize.domain.labor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mize.domain.util.MizeDateTime;

@Entity
@DiscriminatorColumn(name="LaborHourExt")
@Table(name = "labor_hour", uniqueConstraints = {@UniqueConstraint (columnNames = {"tenant_id", "labor_code"})})
public class LaborHourExt extends LaborHour {

	private static final long serialVersionUID = 81846948813348698L;
	
	private String isActive;
	
	public LaborHourExt(){
		super();
	}
	
	public LaborHourExt(Long id , String code, String type, MizeDateTime startDate,	MizeDateTime endDate, BigDecimal hours, String isActive) {		
		super(id, code, type, startDate, endDate, hours);
		this.isActive = isActive;
	}
	
	@Column(name = "is_active")
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	@JsonProperty(value="intls")
	public void setIntlsExt(List<LaborHourIntlExt> intlsExts) {
		List<LaborHourIntl> intls = null;
		if(intlsExts != null){
			intls = new ArrayList<LaborHourIntl>();
			for(LaborHourIntl intl : intlsExts){
				intls.add(intl);
			}
		}
		super.setIntls(intls);
	}
	
}
