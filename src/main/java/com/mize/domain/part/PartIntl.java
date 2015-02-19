package com.mize.domain.part;

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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeSceEntity;

@Entity
@Inheritance
@DiscriminatorColumn(name = "discriminator")
@DiscriminatorValue("PartIntl")
@Table(name = "part_intl")
public class PartIntl extends MizeSceEntity implements Comparable<PartIntl> {	
	
	private static final long serialVersionUID = -1164448119809296797L;
	private Part part;
	private Locale locale;
	private String name;
	private String description;
	
	public PartIntl() {
		super();
	}

	public PartIntl(Part part, Locale locale, String partName,
			String partDescription) {
		this.part = part;
		this.locale = locale;
		this.name = partName;
		this.description = partDescription;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Override
	public Long getId() {		
		return id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "part_id")
	@JsonBackReference(value ="partIntl")
	public Part getPart() {
		return part;
	}
	

	@ManyToOne(fetch = FetchType.LAZY ,optional = true)
	@JoinColumn(name = "locale_id")
	public Locale getLocale() {
		return locale;
	}

	@Column(name = "part_name")
	public String getName() {
		return name;
	}
	
	@Column(name = "part_description")
	public String getDescription() {
		return description;
	}
	
	
	@Override
	public void setId(Long id) {
		super.id = id;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "PartIntl [part=" + part + ", locale=" + locale + ", name="
				+ name + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
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
		PartIntl other = (PartIntl) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(PartIntl arg0) {
		return 0;
	}
	
	

}
