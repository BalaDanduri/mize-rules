package com.mize.domain.reason;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name="reason_intl")
public class ReasonIntl extends MizeEntity {

	private static final long serialVersionUID = 3605561224344122428L;
	private Reason reason;
	private String description;
	private Locale locale = new Locale();
	
	public ReasonIntl(){
		super();
	}
	
	
	public ReasonIntl(Reason reason, String desc, Locale locale) {
		super();
		this.reason = reason;
		this.description = desc;
		this.locale = locale;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		super.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reason_id")
	@JsonBackReference(value="intl")
	public Reason getReason() {
		return reason;
	}

	public void setReason(Reason reason) {
		this.reason = reason;
	}

	@Column(name = "reason_description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "locale_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		
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
		ReasonIntl other = (ReasonIntl) obj;		
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		
		return true;
	}


	@Override
	public String toString() {
		return "ReasonIntl [desc=" + description + ", locale=" + locale + "]";
	}
	
}
