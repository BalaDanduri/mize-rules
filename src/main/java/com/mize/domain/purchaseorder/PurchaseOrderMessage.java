package com.mize.domain.purchaseorder;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.MizeEntity;

@Entity
@Table(name = "purchase_order_message")
public class PurchaseOrderMessage extends MizeEntity implements Comparable<PurchaseOrderMessage>{	

	private static final long serialVersionUID = 261638805962518728L;
	private PurchaseOrder purchaseOrder;
	private Long appMessageId;
	private Integer severity;
	private String field;
	private String uiReference;
	private String hotSpotValue;
	private String shortDescription;
	private String code;
	private String msgType;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;		
	}	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="order_id")
	@JsonBackReference(value="message_purchaseOrder")
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	
	@Column(name = "message_id")
	public Long getAppMessageId() {
		return appMessageId;
	}

	public void setAppMessageId(Long appMessageId) {
		this.appMessageId = appMessageId;
	}

	@Column(name = "message_severity")
	public Integer getSeverity() {
		return severity;
	}

	public void setSeverity(Integer severity) {
		this.severity = severity;
	}

	@Column(name = "message_field")
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Column(name = "message_uireference")
	public String getUiReference() {
		return uiReference;
	}

	public void setUiReference(String uiReference) {
		this.uiReference = uiReference;
	}

	@Column(name = "message_value")
	public String getHotSpotValue() {
		return hotSpotValue;
	}

	public void setHotSpotValue(String hotSpotValue) {
		this.hotSpotValue = hotSpotValue;
	}

	@Transient
	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	
	@Transient
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Transient
	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((appMessageId == null) ? 0 : appMessageId.hashCode());
		result = prime * result + ((field == null) ? 0 : field.hashCode());
		result = prime * result
				+ ((hotSpotValue == null) ? 0 : hotSpotValue.hashCode());
		result = prime * result
				+ ((severity == null) ? 0 : severity.hashCode());
		result = prime * result
				+ ((uiReference == null) ? 0 : uiReference.hashCode());
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
		PurchaseOrderMessage other = (PurchaseOrderMessage) obj;
		if (appMessageId == null) {
			if (other.appMessageId != null)
				return false;
		} else if (!appMessageId.equals(other.appMessageId))
			return false;
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (!field.equals(other.field))
			return false;
		if (hotSpotValue == null) {
			if (other.hotSpotValue != null)
				return false;
		} else if (!hotSpotValue.equals(other.hotSpotValue))
			return false;
		if (severity == null) {
			if (other.severity != null)
				return false;
		} else if (!severity.equals(other.severity))
			return false;
		if (uiReference == null) {
			if (other.uiReference != null)
				return false;
		} else if (!uiReference.equals(other.uiReference))
			return false;
		return true;
	}

	@Override
	public int compareTo(PurchaseOrderMessage o) {
		return 0;
	}

}
