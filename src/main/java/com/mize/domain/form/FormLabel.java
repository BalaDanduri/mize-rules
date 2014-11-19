package com.mize.domain.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mize.domain.common.MizeSceEntity;

public class FormLabel extends MizeSceEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 650988974672502526L;
	
	private String code;
	private List<LabelIntl> intl;
	
	public FormLabel() {
		super();
		intl = new ArrayList<LabelIntl>();
	}
			
	public FormLabel(String code) {
		this.code = code;
	}	
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<LabelIntl> getIntl() {
		return intl;
	}
	public void setIntl(List<LabelIntl> intl) {
		this.intl = intl;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((intl == null) ? 0 : intl.hashCode());
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
		FormLabel other = (FormLabel) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (intl == null) {
			if (other.intl != null)
				return false;
		} else if (!intl.equals(other.intl))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FormLabel [id=" + id + ", code=" + code + ", intl=" + intl + "]";
	}
	
}
