package com.mize.domain.form;

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
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeSceEntityIntl;
import com.mize.domain.util.JPASerializer;

@Entity
@Inheritance
@DiscriminatorColumn(name = "discriminator")
@DiscriminatorValue("FormDefinitionIntl")
@Table(name = "form_defn_intl")
public class FormDefinitionIntl extends MizeSceEntityIntl implements Comparable<FormDefinitionIntl> {

	private static final long serialVersionUID = 1899101185232987319L;
	
	private FormDefinition formDefinition;
	
	private String name;
	
	private String description;
	
	public FormDefinitionIntl() {
		super();
		super.locale = new Locale();
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	public Long getId() {
		return super.id;
	}
	
	@Override
	public void setId(Long id) {
		super.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "form_defn_id")
	@JsonBackReference(value="form_intls")
	@JsonSerialize(using=JPASerializer.class)
	public FormDefinition getFormDefinition() {
		return formDefinition;
	}

	public void setFormDefinition(FormDefinition formDefinition) {
		this.formDefinition = formDefinition;
	}

	@Column(name = "form_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "form_description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((super.locale == null) ? 0 : super.locale.hashCode());
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
		FormDefinitionIntl other = (FormDefinitionIntl) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (super.locale == null) {
			if (other.locale != null)
				return false;
		} else if (!super.locale.equals(other.locale))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FormDefinitionIntl [name=" + name + ", description=" + description + ", locale=" + super.locale + "]";
	}

	@Override
	public int compareTo(FormDefinitionIntl o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
