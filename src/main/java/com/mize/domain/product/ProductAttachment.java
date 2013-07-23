package com.mize.domain.product;

import com.mize.domain.common.MizeEntity;

public class ProductAttachment extends MizeEntity{
	private static final long serialVersionUID = -6722341511569003526L;	
	
	private String name;
	private String url;
	private String type;
	private Long prodRegnId;
	
	public Long getProdRegnId() {
		return prodRegnId;
	}
	public void setProdRegnId(Long prodId) {
		this.prodRegnId = prodId;
	}
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ProductAttachment [id=" + id + ", name=" + name + ", url=" + url + ", type=" + type + ", prodRegnId="
				+ prodRegnId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ProductAttachment other = (ProductAttachment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
