package com.mize.domain.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.mize.domain.auth.User;
import com.mize.domain.brand.Brand;
import com.mize.domain.common.MizeEntity;

@Entity
@Table(name = "prod_list")
public class ProdList extends MizeEntity implements Comparable<ProdList>{

	private static final long serialVersionUID = -2714713561037519108L;
	private String listName;
	private Brand brand; 
	private User user; 
	private String active;
	private Integer privacyLevel;
	
	@Column(name = "list_name",  nullable = true, length = 100)
	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id", nullable = true)
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = true)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@Column(name = "is_active",  nullable = true)
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	
	@Column(name = "privacy_level",  nullable = true, length = 11)
	public Integer getPrivacyLevel() {
		return privacyLevel;
	}

	public void setPrivacyLevel(Integer privacyLevel) {
		this.privacyLevel = privacyLevel;
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
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((listName == null) ? 0 : listName.hashCode());
		result = prime * result + ((privacyLevel == null) ? 0 : privacyLevel.hashCode());
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
		ProdList other = (ProdList) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (listName == null) {
			if (other.listName != null)
				return false;
		} else if (!listName.equals(other.listName))
			return false;
		if (privacyLevel == null) {
			if (other.privacyLevel != null)
				return false;
		} else if (!privacyLevel.equals(other.privacyLevel))
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
		return "ProdList [listName=" + listName + ", brand=" + brand + ", user=" + user + ", active=" + active
				+ ", privacyLevel=" + privacyLevel + "]";
	}

	@Override
	public int compareTo(ProdList o) {
		return 0;
	}


}
