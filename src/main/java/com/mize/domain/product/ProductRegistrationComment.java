package com.mize.domain.product;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.MizeEntity;

@Entity
@Table(name = "prod_regn_comment", uniqueConstraints = {@UniqueConstraint (columnNames = {"id"})})
public class ProductRegistrationComment extends MizeEntity implements Comparable<ProductRegistrationComment>{
	
	private static final long serialVersionUID = -6797108962212048999L;
	
	private ProductRegistration productRegistration;
	private EntityComment comment = new EntityComment();


	public ProductRegistrationComment(){
		super();
	}
	
	public ProductRegistrationComment(EntityComment comment){
		super();
		this.comment = comment;
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

	@OneToOne(cascade={CascadeType.ALL},fetch = FetchType.LAZY)
	@JoinColumn(name="prod_regn_id")
	@JsonBackReference(value="comments_productRegistration")
	public ProductRegistration getProductRegistration() {
		return productRegistration;
	}


	@OneToOne(cascade={CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name="comment_id")
	public EntityComment getComment() {
		return comment;
	}



	public void setProductRegistration(ProductRegistration productRegistration) {
		this.productRegistration = productRegistration;
	}

	public void setComment(EntityComment comment) {
		this.comment = comment;
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
		ProductRegistrationComment other = (ProductRegistrationComment) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		return true;
	}

	

	@Override
	public String toString() {
		return "ProductRegistrationComment [productRegistration="
				+ productRegistration + ", comment=" + comment + "]";
	}

	@Override
	public int compareTo(ProductRegistrationComment arg0) {
		return 0;
	}


}
