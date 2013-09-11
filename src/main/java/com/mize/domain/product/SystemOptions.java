package com.mize.domain.product;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class SystemOptions extends MizeEntity implements Comparable<SystemOptions>{

	private static final long serialVersionUID = -8578576996983187261L;
	private String forceLogin;
	private String displayProdContent;
	
	public String getForceLogin() {
		return forceLogin;
	}

	public void setForceLogin(String forceLogin) {
		this.forceLogin = forceLogin;
	}

	public String getDisplayProdContent() {
		return displayProdContent;
	}

	public void setDisplayProdContent(String displayProdContent) {
		this.displayProdContent = displayProdContent;
	}
	
	@JsonIgnore(value=false)
	public Long getCreatedBy() {
		return createdBy;
	}

	@JsonIgnore(value=false)
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)	
	@JsonIgnore(value=false)
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@JsonIgnore(value=false)
	public Long getUpdatedBy() {
		return updatedBy;
	}

	@JsonIgnore(value=false)
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	@JsonIgnore(value=false)
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
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
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((displayProdContent == null) ? 0 : displayProdContent.hashCode());
		result = prime * result + ((forceLogin == null) ? 0 : forceLogin.hashCode());
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
		SystemOptions other = (SystemOptions) obj;
		if (displayProdContent == null) {
			if (other.displayProdContent != null)
				return false;
		} else if (!displayProdContent.equals(other.displayProdContent))
			return false;
		if (forceLogin == null) {
			if (other.forceLogin != null)
				return false;
		} else if (!forceLogin.equals(other.forceLogin))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "SystemOptions [forceLogin=" + forceLogin + ", displayProdContent=" + displayProdContent + "]";
	}

	@Override
	public int compareTo(SystemOptions o) {
		return 0;
	}

	
	

}
