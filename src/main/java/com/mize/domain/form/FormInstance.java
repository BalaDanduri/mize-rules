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

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mize.domain.auth.User;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.MizeDateTime;

@Entity
@Inheritance
@DiscriminatorColumn(name = "discriminator")
@DiscriminatorValue("FormInstance")
@Table(name = "form_instance")
public class FormInstance extends MizeSceEntity implements Comparable<FormInstance> {
	
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
	@Column(name = "id", unique = true, nullable = false, length = 20)
	@Override
	public Long getId() {
		return super.id;
	}

	@Override
	public void setId(Long id) {
		super.id=id;
	}
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="form_defn_id", nullable = false)
	public FormDefinition getFormDefinition() {
		return formDefinition;
	}

	public void setFormDefinition(FormDefinition formDefinition) {
		this.formDefinition = formDefinition;
	}
	
	@JsonIgnore
	@Column(name = "form_instance_data", nullable = true)
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
	@Column(name = "created_date", updatable = false)
	@Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@JsonInclude(Include.NON_DEFAULT)
	@JsonIgnore(value=false)
	public MizeDateTime getCreatedDate() {
		return createdDate;
	}
	
	@Override
	@JsonIgnore(value=false)
	public void setCreatedDate(MizeDateTime createdDate) {
		super.createdDate = createdDate;
	}
	
	
	@Column(name = "updated_date", nullable = true)
	@Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@JsonInclude(Include.NON_DEFAULT)
	@JsonIgnore(value=false)
	public MizeDateTime getUpdatedDate() {
		return updatedDate;
	}
	
	
	@JsonIgnore(value=false)
	public void setUpdatedDate(MizeDateTime updatedDate) {
		super.updatedDate = updatedDate;
	}
	
	@Override
	@JsonIgnore
	@Column(name = "created_by", nullable = true, length = 20, updatable = false)
	public Long getCreatedBy() {		
		return super.getCreatedBy();
	}
	
	@Override
	@JsonIgnore
	public void setCreatedBy(Long createdBy) {		
		super.setCreatedBy(createdBy);
	}
	
	@Override
	@JsonIgnore
	@Column(name = "updated_by", nullable = true, length = 20)
	public Long getUpdatedBy() {		
		return super.getUpdatedBy();
	}
	
	@Override
	@JsonIgnore
	public void setUpdatedBy(Long updatedBy) {		
		super.setUpdatedBy(updatedBy);
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
