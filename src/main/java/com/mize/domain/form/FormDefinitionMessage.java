package com.mize.domain.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mize.domain.common.MizeEntity;

@Entity
@Table(name = "form_defn_msg")
public class FormDefinitionMessage extends MizeEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 105329366148077072L;

	private FormDefinition formDefinition;
	private Long messageId;
	private Integer messageSeverity;
	private String messageField;
	private String messageUiReference;
	private String messageValue;

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

	@Column(name = "message_id")
	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}
	
	@Column(name = "message_severity")
	public Integer getMessageSeverity() {
		return messageSeverity;
	}
	
	public void setMessageSeverity(Integer messageSeverity) {
		this.messageSeverity = messageSeverity;
	}
	
	@Column(name = "message_field", length = 250)
	public String getMessageField() {
		return messageField;
	}

	public void setMessageField(String messageField) {
		this.messageField = messageField;
	}
	
	@Column(name = "message_ui_reference", length = 100)
	public String getMessageUiReference() {
		return messageUiReference;
	}

	public void setMessageUiReference(String messageUiReference) {
		this.messageUiReference = messageUiReference;
	}
	
	@Column(name = "message_value", length = 5000)
	public String getMessageValue() {
		return messageValue;
	}

	public void setMessageValue(String messageValue) {
		this.messageValue = messageValue;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((messageField == null) ? 0 : messageField.hashCode());
		result = prime * result
				+ ((messageId == null) ? 0 : messageId.hashCode());
		result = prime * result
				+ ((messageSeverity == null) ? 0 : messageSeverity.hashCode());
		result = prime
				* result
				+ ((messageUiReference == null) ? 0 : messageUiReference
						.hashCode());
		result = prime * result
				+ ((messageValue == null) ? 0 : messageValue.hashCode());
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
		FormDefinitionMessage other = (FormDefinitionMessage) obj;
		if (messageField == null) {
			if (other.messageField != null)
				return false;
		} else if (!messageField.equals(other.messageField))
			return false;
		if (messageId == null) {
			if (other.messageId != null)
				return false;
		} else if (!messageId.equals(other.messageId))
			return false;
		if (messageSeverity == null) {
			if (other.messageSeverity != null)
				return false;
		} else if (!messageSeverity.equals(other.messageSeverity))
			return false;
		if (messageUiReference == null) {
			if (other.messageUiReference != null)
				return false;
		} else if (!messageUiReference.equals(other.messageUiReference))
			return false;
		if (messageValue == null) {
			if (other.messageValue != null)
				return false;
		} else if (!messageValue.equals(other.messageValue))
			return false;
		if (formDefinition == null) {
			if (other.formDefinition != null)
				return false;
		} else {
			if(formDefinition.getId() == null) {
				if(other.formDefinition.getId() != null)
					return false;
			} else if(!formDefinition.getId().equals(other.formDefinition.getId()))
				return false;
		}
		return true;
	}

}
