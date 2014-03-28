package com.mize.domain.discount;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.MizeEntity;

@Entity
@Table(name = "discount_comment", uniqueConstraints = { @UniqueConstraint(columnNames = {"id"}) })
public class DiscountComment extends MizeEntity {

	private static final long serialVersionUID = -867858860499195762L;
	private Discount discount;
	private EntityComment comment;
	
	public DiscountComment() {
		super();
	}
	
	public DiscountComment(Discount discount, EntityComment comment) {
		super();
		this.discount = discount;
		this.comment = comment;
	}

	@Id
	@GenericGenerator(name="id",strategy="increment")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToOne(fetch = FetchType.LAZY ,cascade=CascadeType.ALL)
	@JoinColumn(name = "discount_id")
	@JsonBackReference(value="discountComment")	
	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "comment_id")
	public EntityComment getEntityComment() {
		return comment;
	}

	public void setEntityComment(EntityComment comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "DiscountComment [comment=" + comment + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((comment == null) ? 0 : comment.hashCode());
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
		DiscountComment other = (DiscountComment) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;	
		return true;
	}

}
