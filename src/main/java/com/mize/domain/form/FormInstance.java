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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mize.domain.auth.User;
import com.mize.domain.common.MizeSceEntityAudit;

@Entity
@Inheritance
@DiscriminatorColumn(name = "discriminator")
@DiscriminatorValue("FormInstance")
@Table(name = "form_instance")
public class FormInstance extends MizeSceEntityAudit implements Comparable<FormInstance> {
	
	private static final long serialVersionUID = 4640430501517031791L;
	
	private FormDefinition formDefinition;
	private String formInstanceData;
	private User user;
	
	
	public FormInstance() {
		formDefinition = new FormDefinition();
	}

	public FormInstance(FormDefinition formDefinition, String formInstanceData) {
		super();
		this.formDefinition = formDefinition;
		this.formInstanceData = formInstanceData;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Override
	public Long getId() {
		return super.id;
	}

	@Override
	public void setId(Long id) {
		super.id = id;
	}
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="form_defn_id")
	public FormDefinition getFormDefinition() {
		return formDefinition;
	}

	public void setFormDefinition(FormDefinition formDefinition) {
		this.formDefinition = formDefinition;
	}
	
	@JsonIgnore
	@Column(name = "form_instance_data")
	public String getFormInstanceData() {
		return formInstanceData;
	}

	
	public void setFormInstanceData(String formInstanceData) {
		this.formInstanceData = formInstanceData;
	}
	
	@Transient
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((formDefinition == null) ? 0 : formDefinition.hashCode());
		result = prime * result + ((formInstanceData == null) ? 0 : formInstanceData.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof FormInstance)) {
			return false;
		}
		FormInstance other = (FormInstance) obj;
		if (formDefinition == null) {
			if (other.formDefinition != null) {
				return false;
			}
		} else if (!formDefinition.equals(other.formDefinition)) {
			return false;
		}
		if (formInstanceData == null) {
			if (other.formInstanceData != null) {
				return false;
			}
		} else if (!formInstanceData.equals(other.formInstanceData)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "FormInstance [id=" + id + ", formDefinition=" + formDefinition
				+ ", formInstanceData=" + formInstanceData + "]";
	}

	@Override
	public int compareTo(FormInstance arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	

}
