package com.mize.domain.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.auth.User;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;

@Entity
@Table(name = "form_instance")
public class FormInstance extends MizeEntity {
	
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
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="form_defn_id", nullable = false)
	public FormDefinition getFormDefinition() {
		return formDefinition;
	}

	public void setFormDefinition(FormDefinition formDefinition) {
		this.formDefinition = formDefinition;
	}
	
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
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "created_date")
	public DateTime getCreatedDate() {
		return createdDate;
	}
	
	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore
	public void setCreatedDate(DateTime createdDate) {
		super.createdDate = createdDate;
	}
	
	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "updated_date")
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore
	public void setUpdatedDate(DateTime updatedDate) {
		super.updatedDate = updatedDate;
	}
	
	@Override
	@JsonIgnore
	@Column(name = "created_by", nullable = true, length = 20)
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
		result = prime * result
				+ ((formInstanceData == null) ? 0 : formInstanceData.hashCode());
		result = prime * result
				+ ((formDefinition == null) ? 0 : formDefinition.hashCode());
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
		FormInstance other = (FormInstance) obj;
		if(id == null) {
			if(other.id != null)
				return false;
		} else if(!id.equals(other.id))
			return false;
		if (formInstanceData == null) {
			if (other.formInstanceData != null)
				return false;
		} else if (!formInstanceData.equals(other.formInstanceData))
			return false;
		if (formDefinition == null) {
			if (other.formDefinition != null)
				return false;
		} else if (!formDefinition.getId().equals(other.formDefinition.getId()))
			return false;
		return true;
	}
	
	

}
