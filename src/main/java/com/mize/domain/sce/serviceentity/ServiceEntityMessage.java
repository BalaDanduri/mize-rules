package com.mize.domain.sce.serviceentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;


/**
 * @author HarishBurra
 * @version 1.0
 */
@Entity
@Table(name = "srvc_enty_msg")
public class ServiceEntityMessage extends MizeEntity {

	
	private static final long serialVersionUID = 8878621032671945424L;
	
	private ServiceEntity serviceEntity;
	private Long messageId;
	private Long messageSeverity;
	private String messageField;
	private String messageUiReference;
	private String messageValue;
	

	public ServiceEntityMessage() {
		
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
	@JoinColumn(name = "service_entity_id")
	@JsonBackReference(value="service_entity_messages")
	@JsonSerialize(using=JPASerializer.class)
	public ServiceEntity getServiceEntity() {
		return serviceEntity;
	}

	public void setServiceEntity(ServiceEntity serviceEntity) {
		this.serviceEntity = serviceEntity;
	}
	
	@Column(name = "message_id")
	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	@Column(name = "message_severity")
	public Long getMessageSeverity() {
		return messageSeverity;
	}

	public void setMessageSeverity(Long messageSeverity) {
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
				+ ((serviceEntity == null) ? 0 : serviceEntity.hashCode());
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
		ServiceEntityMessage other = (ServiceEntityMessage) obj;
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
		if (serviceEntity == null) {
			if (other.serviceEntity != null)
				return false;
		} else {
			if(serviceEntity.getId() == null) {
				if(other.serviceEntity.getId() != null)
					return false;
			} else if(!serviceEntity.getId().equals(other.serviceEntity.getId()))
				return false;
		}
		return true;
	}
	

}
