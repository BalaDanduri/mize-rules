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

import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import com.mize.domain.common.EntityComment;
import com.mize.domain.common.MizeEntity;

@Entity
@Table(name = "discount_comment", uniqueConstraints = { @UniqueConstraint(columnNames = {"id"}) })
public class DiscountComment extends MizeEntity {

	private static final long serialVersionUID = -867858860499195762L;
	private Discount discount;
	private EntityComment entityComment;
	
	public DiscountComment() {
		super();
	}
	
	public DiscountComment(Discount discount, EntityComment entityComment) {
		super();
		this.discount = discount;
		this.entityComment = entityComment;
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
		return entityComment;
	}

	public void setEntityComment(EntityComment entityComment) {
		this.entityComment = entityComment;
	}

	@Override
	public String toString() {
		return "DiscountComment [entityComment=" + entityComment + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((entityComment == null) ? 0 : entityComment.hashCode());
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
		if (entityComment == null) {
			if (other.entityComment != null)
				return false;
		} else if (!entityComment.equals(other.entityComment))
			return false;	
		return true;
	}

}
