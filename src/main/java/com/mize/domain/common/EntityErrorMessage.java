package com.mize.domain.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "entity_error_message", uniqueConstraints = {@UniqueConstraint (columnNames = {"id"})})
public class EntityErrorMessage extends MizeSceEntity implements Comparable<EntityErrorMessage>{	
	private static final long serialVersionUID = -8053834691293067517L;
	private Integer severity;
	private String field;
	private String code;
	private String type;
	private String shortDescription;
	private String longDescription;
	private String uiReference;
	private String value;

	public EntityErrorMessage(){
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "message_severity")
	public Integer getSeverity() {
		return severity;
	}

	public void setSeverity(Integer severity) {
		this.severity = severity;
	}

	@Column(name = "message_field", nullable = true, length = 250)
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Column(name = "message_code", nullable = true, length = 100)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "message_type", nullable = true, length = 100)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "short_description", nullable = true, length = 250)
	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	@Column(name = "long_description", nullable = true, length = 500)
	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	
	@Column(name = "message_ui_reference", nullable = true, length = 100)
	public String getUiReference() {
		return uiReference;
	}

	public void setUiReference(String uiReference) {
		this.uiReference = uiReference;
	}

	@Column(name = "message_value", nullable = true, length = 5000)
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((field == null) ? 0 : field.hashCode());
		result = prime * result + ((longDescription == null) ? 0 : longDescription.hashCode());
		result = prime * result + ((severity == null) ? 0 : severity.hashCode());
		result = prime * result + ((shortDescription == null) ? 0 : shortDescription.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((uiReference == null) ? 0 : uiReference.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		EntityErrorMessage other = (EntityErrorMessage) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (!field.equals(other.field))
			return false;
		if (longDescription == null) {
			if (other.longDescription != null)
				return false;
		} else if (!longDescription.equals(other.longDescription))
			return false;
		if (severity == null) {
			if (other.severity != null)
				return false;
		} else if (!severity.equals(other.severity))
			return false;
		if (shortDescription == null) {
			if (other.shortDescription != null)
				return false;
		} else if (!shortDescription.equals(other.shortDescription))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (uiReference == null) {
			if (other.uiReference != null)
				return false;
		} else if (!uiReference.equals(other.uiReference))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EntityErrorMessage [severity=" + severity + ", field=" + field + ", code=" + code + ", type=" + type 
				+ ", shortDescription=" + shortDescription + ", longDescription=" + longDescription + ", uiReference=" + uiReference 
				+ ", value=" + value + "]";
	}

	@Override
	public int compareTo(EntityErrorMessage o) {
		return 0;
	}

	
}
