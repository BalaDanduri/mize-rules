package com.mize.domain.form;

import javax.persistence.CascadeType;
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

import com.mize.domain.common.EntityErrorMessage;
import com.mize.domain.common.MizeSceEntity;

@Entity
@Table(name = "form_defn_msg")
public class FormDefinitionMessage extends MizeSceEntity implements Comparable<FormDefinitionMessage> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 105329366148077072L;

	private FormDefinition formDefinition;
	private EntityErrorMessage entityErrorMessage;

	public FormDefinitionMessage() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {		
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "form_defn_id")
	public FormDefinition getFormDefinition() {
		return formDefinition;
	}

	public void setFormDefinition(FormDefinition formDefinition) {
		this.formDefinition = formDefinition;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "error_message_id")
	public EntityErrorMessage getEntityErrorMessage() {
		return entityErrorMessage;
	}

	public void setEntityErrorMessage(EntityErrorMessage entityErrorMessage) {
		this.entityErrorMessage = entityErrorMessage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((entityErrorMessage == null) ? 0 : entityErrorMessage.hashCode());
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
		FormDefinitionMessage other = (FormDefinitionMessage) obj;
		if (entityErrorMessage == null) {
			if (other.entityErrorMessage != null)
				return false;
		} else if (!entityErrorMessage.equals(other.entityErrorMessage))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FormDefinitionMessage [entityErrorMessage=" + entityErrorMessage + "]";
	}

	@Override
	public int compareTo(FormDefinitionMessage o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
