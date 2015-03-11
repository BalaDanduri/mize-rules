package com.mize.domain.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.datetime.DateTime;

@Entity
@Table(name = "system_options")
public class SystemOptions extends MizeSceEntity implements Comparable<SystemOptions>{

	private static final long serialVersionUID = -8578576996983187261L;
	private String forceLogin;
	private String displayProdContent;
	
	@Column(name = "force_login",  nullable = true)
	public String getForceLogin() {
		return forceLogin;
	}

	public void setForceLogin(String forceLogin) {
		this.forceLogin = forceLogin;
	}

	@Column(name = "display_prod_content",  nullable = true)
	public String getDisplayProdContent() {
		return displayProdContent;
	}

	public void setDisplayProdContent(String displayProdContent) {
		this.displayProdContent = displayProdContent;
	}
	
	@Column(name = "created_by",  nullable = true, length = 20)
	@JsonIgnore(value=false)
	public Long getCreatedBy() {
		return createdBy;
	}

	@JsonIgnore(value=false)
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name = "created_date",  nullable = true)
	@JsonIgnore(value=false)
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@JsonIgnore(false)
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name = "updated_by",  nullable = true, length = 20)
	@JsonIgnore(value=false)
	public Long getUpdatedBy() {
		return updatedBy;
	}

	@JsonIgnore(value=false)
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Column(name = "updated_date",  nullable = true)
	@JsonIgnore(false)
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@JsonIgnore(false)
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Id
	@GenericGenerator(name="id" , strategy="increment")
	@GeneratedValue(generator="id")
	@Column(name="id",unique=true,nullable=false,length=20)
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
