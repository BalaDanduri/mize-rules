package com.mize.domain.purchaseorder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.EntityAttachment;
import com.mize.domain.common.MizeSceEntity;

@Entity
@Table(name = "purchase_order_attach")
public class PurchaseOrderAttachment extends MizeSceEntity implements Comparable<PurchaseOrderAttachment>{	

	private static final long serialVersionUID = 261638805962518728L;
	private PurchaseOrder purchaseOrder;
	private EntityAttachment attachment = new EntityAttachment();

	public  PurchaseOrderAttachment(){
		
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
		this.id = id;		
	}	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="order_id")
	@JsonBackReference(value="purchaseOrder_attachment")
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	@ManyToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="attach_id")
	public EntityAttachment getAttachment() {
		return attachment;
	}

	public void setAttachment(EntityAttachment attachment) {
		this.attachment = attachment;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
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
		return true;
	}

	@Override
	public int compareTo(PurchaseOrderAttachment o) {
		return 0;
	}

}
