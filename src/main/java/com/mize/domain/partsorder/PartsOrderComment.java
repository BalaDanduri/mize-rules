package com.mize.domain.partsorder;


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
import javax.persistence.Transient;

import com.mize.domain.common.MizeEntity;

@Entity
@Table(name = "parts_order_comment")
public class PartsOrderComment extends MizeEntity implements Comparable<PartsOrderComment>{	

	private static final long serialVersionUID = 268638805962518728L;
	private Long orderId;
	private String type;
	private String comments;
	private PartsOrder partsOrder;
	
	public PartsOrderComment(){
		super();
	}
			
	public PartsOrderComment(String type, String comments) {
		super();
		this.type = type;
		this.comments = comments;
	}
	
	public PartsOrderComment(Long id,String type, String comments) {
		super();
		this.id = id;
		this.type = type;
		this.comments = comments;
	}
	
	public enum Type{
		Internal,External;
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
	
	@Column(name="comment_type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name="comments")
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	@ManyToOne(fetch=FetchType.LAZY,cascade =CascadeType.ALL)
	@JoinColumn(name="order_id")
	public PartsOrder getPartsOrder() {
		return partsOrder;
	}

	public void setPartsOrder(PartsOrder partsOrder) {
		this.partsOrder = partsOrder;
	}
	
	@Transient
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		PartsOrderComment other = (PartsOrderComment) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PartsOrderComment [type=" + type + ", comments=" + comments
				+ "]";
	}
	
	@Override
	public int compareTo(PartsOrderComment o) {
		return 0;
	}

}
