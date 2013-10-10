package com.mize.domain.sce.part;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeEntity;

@Entity
@Table(name = "part_intl", uniqueConstraints = {@UniqueConstraint (columnNames = {"part_id", "locale_id"})})
public class PartIntl extends MizeEntity {	
	
	private static final long serialVersionUID = -1164448119809296797L;
	private Part part;
	private Locale locale;
	private String partName;
	private String partDescription;
	
	public PartIntl() {
		super();
	}

	public PartIntl(Part part, Locale locale, String partName,
			String partDescription) {
		this.part = part;
		this.locale = locale;
		this.partName = partName;
		this.partDescription = partDescription;
	}

	
	@Id
	@GenericGenerator(name = "partIntlId", strategy = "increment")
	@GeneratedValue(generator = "partIntlId")
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {		
		return id;
	}

	@Override
	public void setId(Long id) {
		super.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "part_id")
	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "locale_id")
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	@Column(name = "part_name", length = 100, nullable = true)
	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}
	
	@Column(name = "part_desc", length = 500, nullable = true)
	public String getPartDescription() {
		return partDescription;
	}

	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result + ((part == null) ? 0 : part.hashCode());
		result = prime * result
				+ ((partDescription == null) ? 0 : partDescription.hashCode());
		result = prime * result
				+ ((partName == null) ? 0 : partName.hashCode());
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
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		if (part == null) {
			if (other.part != null)
				return false;
		} else if (!part.equals(other.part))
			return false;
		if (partDescription == null) {
			if (other.partDescription != null)
				return false;
		} else if (!partDescription.equals(other.partDescription))
			return false;
		if (partName == null) {
			if (other.partName != null)
				return false;
		} else if (!partName.equals(other.partName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuffer builder = new StringBuffer();
		builder.append("PartIntl [part=");
		builder.append(part);
		builder.append(", locale=");
		builder.append(locale);
		builder.append(", partName=");
		builder.append(partName);
		builder.append(", partDescription=");
		builder.append(partDescription);		
		builder.append("]");		
		return builder.toString();
	}	
	

}
