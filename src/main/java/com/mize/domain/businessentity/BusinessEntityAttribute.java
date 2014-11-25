package com.mize.domain.businessentity;

import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mize.domain.common.MizeSceEntity;
/**
 * @author Raghavendra Serikar
 * @version 1.0
*/
@Entity
@Inheritance
@DiscriminatorColumn(name = "discriminator")
@DiscriminatorValue("BusinessEntityAttribute")
@Table(name="business_entity_attribute")
public class BusinessEntityAttribute extends MizeSceEntity implements Comparable<BusinessEntityAttribute>{
	private static final long serialVersionUID = 7270726663818044384L;
	 private BusinessEntity businessEntity;
	 private String url;
	 private String toolTipLogo;
	 private String icon;
	 private String hoursOfOp;
	 private String creditOnHold;
	 private String isPromoted;
	 private String isServiceProvider;
	 private String region;
	
	 
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
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="be_id")
	@JsonBackReference(value="be_attribute")
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
	
	@Column(name="is_promoted", length = 1)
	public String getIsPromoted() {
		return isPromoted;
	}
	
	public void setIsPromoted(String isPromoted) {
		this.isPromoted = isPromoted;
	}
	
	@Column(name="is_service_provider", length = 1)
	public String getIsServiceProvider() {
		return isServiceProvider;
	}
	
	public void setIsServiceProvider(String isServiceProvider) {
		this.isServiceProvider = isServiceProvider;
	}
	
	@Column(name="region", length = 50)
	public String getRegion() {
		return region;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((creditOnHold == null) ? 0 : creditOnHold.hashCode());
		result = prime * result
				+ ((hoursOfOp == null) ? 0 : hoursOfOp.hashCode());
		result = prime * result + ((icon == null) ? 0 : icon.hashCode());
		result = prime * result
				+ ((isPromoted == null) ? 0 : isPromoted.hashCode());
		result = prime
				* result
				+ ((isServiceProvider == null) ? 0 : isServiceProvider
						.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
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
		if (isPromoted == null) {
			if (other.isPromoted != null)
				return false;
		} else if (!isPromoted.equals(other.isPromoted))
			return false;
		if (isServiceProvider == null) {
			if (other.isServiceProvider != null)
				return false;
		} else if (!isServiceProvider.equals(other.isServiceProvider))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
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
	public String toString() {
		return "BusinessEntityAttribute [businessEntity=" + businessEntity
				+ ", url=" + url + ", toolTipLogo=" + toolTipLogo + ", icon="
				+ icon + ", hoursOfOp=" + hoursOfOp + ", creditOnHold="
				+ creditOnHold + ", isPromoted=" + isPromoted
				+ ", isServiceProvider=" + isServiceProvider + ", region="
				+ region + ", id=" + id + "]";
	}

	@Override
	public int compareTo(BusinessEntityAttribute o) {
		return 0;
	}
	
	@JsonIgnore
	public static Comparator<BusinessEntityAttribute> PromotedComparator = new  Comparator<BusinessEntityAttribute>() {
		public int compare(BusinessEntityAttribute beAttr1, BusinessEntityAttribute beAttr2) {
			if(beAttr1 != null && beAttr2 != null) {				
				if( beAttr1.getIsPromoted().compareToIgnoreCase(beAttr2.getIsPromoted()) > 0) {
					return -1;
				}else if( beAttr1.getIsPromoted().compareToIgnoreCase(beAttr2.getIsPromoted()) < 0) {
					return 1;
				} else {
					return 0;
				}
			}else {
				return 0;
			}
		}
	};
}
