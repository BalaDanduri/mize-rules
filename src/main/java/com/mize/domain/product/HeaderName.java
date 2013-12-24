package com.mize.domain.product;

import com.mize.domain.common.MizeEntity;


public class HeaderName extends MizeEntity implements Comparable<HeaderName>{

	private static final long serialVersionUID = -632231234234531123L;
	private Long headerId;
	private String name;
	private Long localeId;	
		
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Long getHeaderId() {
		return headerId;
	}

	public void setHeaderId(Long headerId) {
		this.headerId = headerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getLocaleId() {
		return localeId;
	}

	public void setLocaleId(Long localeId) {
		this.localeId = localeId;
	}

	@Override
	public String toString() {
		return "HeaderName [headerId=" + headerId + ", name=" + name
				+ ", localeId=" + localeId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((headerId == null) ? 0 : headerId.hashCode());
		result = prime * result
				+ ((localeId == null) ? 0 : localeId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		HeaderName other = (HeaderName) obj;
		if (headerId == null) {
			if (other.headerId != null)
				return false;
		} else if (!headerId.equals(other.headerId))
			return false;
		if (localeId == null) {
			if (other.localeId != null)
				return false;
		} else if (!localeId.equals(other.localeId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(HeaderName o) {
		return 0;
	}


}
