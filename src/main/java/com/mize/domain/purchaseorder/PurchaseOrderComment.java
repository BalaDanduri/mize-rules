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

import org.codehaus.jackson.annotate.JsonBackReference;

import com.mize.domain.common.EntityComment;
import com.mize.domain.common.MizeEntity;

@Entity
@Table(name = "purchase_order_comment")
public class PurchaseOrderComment extends MizeEntity implements Comparable<PurchaseOrderComment>{	

	private static final long serialVersionUID = 268638805962518728L;
	private PurchaseOrder purchaseOrder;
	private EntityComment comment = new EntityComment();
	
	public PurchaseOrderComment(){
		super();
	}
	
	public PurchaseOrderComment(EntityComment comment){
		super();
		 this.comment =  comment; 
	}
	
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
	
	
	@ManyToOne(fetch=FetchType.LAZY,cascade =CascadeType.ALL)
	@JoinColumn(name="order_id")
	@JsonBackReference(value="comment_purchaseOrder")
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	
	@ManyToOne(fetch=FetchType.EAGER,cascade =CascadeType.ALL)
	@JoinColumn(name="comment_id")
	public EntityComment getComment() {
		return comment;
	}

	public void setComment(EntityComment comment) {
		this.comment = comment;
	}

	@Override
	public int compareTo(PurchaseOrderComment o) {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
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
		PurchaseOrderComment other = (PurchaseOrderComment) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PurchaseOrderComment [comment=" + comment + "]";
	}

	
}
