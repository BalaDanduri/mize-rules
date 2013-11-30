package com.mize.domain.part;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.joda.time.DateTime;

import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeEntity;

@Entity
@Table(name = "part_intl", uniqueConstraints = {@UniqueConstraint (columnNames = {"part_id", "locale_id"})})
public class PartIntl extends MizeEntity {	
	
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
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {		
		return id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "part_id")
	@JsonBackReference
	public Part getPart() {
		return part;
	}
	

	@ManyToOne(fetch = FetchType.EAGER ,optional = true)
	@JoinColumn(name = "locale_id")
	public Locale getLocale() {
		return locale;
	}

	@Column(name = "part_name", length = 100, nullable = true)
	public String getName() {
		return name;
	}
	
	@Column(name = "part_description", length = 500, nullable = true)
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
	

	@PrePersist
	@PreUpdate
	public void auditFields(){
		if(createdDate==null && id==null){
			setCreatedDate(DateTime.now());
		}
		setUpdatedDate(DateTime.now());		
	}
	

	@Override
	public String toString() {
		return "PartIntl [part=" + part + ", locale=" + locale + ", name="
				+ name + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((part == null) ? 0 : part.hashCode());
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
		if (part == null) {
			if (other.part != null)
				return false;
		} else if (!part.equals(other.part))
			return false;
		return true;
	}
	
	

}
