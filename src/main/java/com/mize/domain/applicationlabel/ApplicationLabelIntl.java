package com.mize.domain.applicationlabel;

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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name="application_labels_intl")
public class ApplicationLabelIntl extends MizeSceEntityAudit implements Comparable<ApplicationLabelIntl> {

	private static final long serialVersionUID = -263130079219969843L;
	private ApplicationLabel applicationLabel;
	private String name;
	private String description;
	private Locale locale = new Locale();
	
	public ApplicationLabelIntl(){
		super();
	}
	
	public ApplicationLabelIntl(ApplicationLabel applicationLabel, String name,
			String description, Locale locale) {
		super();
		this.applicationLabel = applicationLabel;
		this.name = name;
		this.description = description;
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
	@JoinColumn(name = "label_id")
	@JsonBackReference(value="appLabel_intl")
	public ApplicationLabel getApplicationLabel() {
		return applicationLabel;
	}

	public void setApplicationLabel(ApplicationLabel applicationLabel) {
		this.applicationLabel = applicationLabel;
	}

	@Column(name="label_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="label_description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT) 
	@JoinColumn(name = "locale_id")
	@JsonSerialize(using=JPASerializer.class)
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	@Override
	public String toString() {
		return "ApplicationLabelIntl [name=" + name + ", description="
				+ description + ", locale=" + locale + "]";
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
		ApplicationLabelIntl other = (ApplicationLabelIntl) obj;
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
	public int compareTo(ApplicationLabelIntl o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
