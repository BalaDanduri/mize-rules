package com.mize.domain.businessentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnore;
import com.mize.domain.common.MizeEntity;

@Entity
@Table(name="business_entity_attribute")
public class BusinessEntityAttribute extends MizeEntity implements Comparable<BusinessEntityAttribute>{
	private static final long serialVersionUID = 7270726663818044384L;
	 private BusinessEntity businessEntity;
	 private String url;
	 private String toolTipLogo;
	 private String icon;
	 private String hoursOfOp;
	 private String creditOnHold;
	
	 @Id
	 @Column(name="id",nullable=false,unique=true)
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="be_id")
	@JsonIgnore
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

	@Column(name="url",nullable=true)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name="tool_tip_logo",nullable=true)
	public String getToolTipLogo() {
		return toolTipLogo;
	}

	public void setToolTipLogo(String toolTipLogo) {
		this.toolTipLogo = toolTipLogo;
	}

	@Column(name="icon",nullable=true)
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Column(name="hours_of_op",nullable=true)
	public String getHoursOfOp() {
		return hoursOfOp;
	}

	public void setHoursOfOp(String hoursOfOp) {
		this.hoursOfOp = hoursOfOp;
	}

	@Column(name="is_credit_onhold",nullable=true)
	public String getCreditOnHold() {
		return creditOnHold;
	}

	public void setCreditOnHold(String creditOnHold) {
		this.creditOnHold = creditOnHold;
	}
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((businessEntity == null) ? 0 : businessEntity.hashCode());
		result = prime * result
				+ ((creditOnHold == null) ? 0 : creditOnHold.hashCode());
		result = prime * result
				+ ((hoursOfOp == null) ? 0 : hoursOfOp.hashCode());
		result = prime * result + ((icon == null) ? 0 : icon.hashCode());
		result = prime * result
				+ ((toolTipLogo == null) ? 0 : toolTipLogo.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		BusinessEntityAttribute other = (BusinessEntityAttribute) obj;
		if (businessEntity == null) {
			if (other.businessEntity != null)
				return false;
		} else if (!businessEntity.equals(other.businessEntity))
			return false;
		if (creditOnHold == null) {
			if (other.creditOnHold != null)
				return false;
		} else if (!creditOnHold.equals(other.creditOnHold))
			return false;
		if (hoursOfOp == null) {
			if (other.hoursOfOp != null)
				return false;
		} else if (!hoursOfOp.equals(other.hoursOfOp))
			return false;
		if (icon == null) {
			if (other.icon != null)
				return false;
		} else if (!icon.equals(other.icon))
			return false;
		if (toolTipLogo == null) {
			if (other.toolTipLogo != null)
				return false;
		} else if (!toolTipLogo.equals(other.toolTipLogo))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
	
	@Override
	public int compareTo(BusinessEntityAttribute o) {
		return 0;
	}
}
