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

import com.mize.domain.common.EntityComment;
import com.mize.domain.common.MizeEntity;

@Entity
@Table(name = "prod_serial_comment", uniqueConstraints = {@UniqueConstraint (columnNames = {"id"})})
public class ProductSerialComment extends MizeEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4772128184803476915L;
	private ProductSerial prodSerial;
	private EntityComment comment;


	public ProductSerialComment(){
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

	@OneToOne(cascade={CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name="prod_srl_id")
	public ProductSerial getProductSerial() {
		return prodSerial;
	}

	public void setProductSerial(ProductSerial prodSerial) {
		this.prodSerial = prodSerial;
	}

	@OneToOne(cascade={CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name="comment_id")
	public EntityComment getComment() {
		return comment;
	}

	public void setComment(EntityComment comment) {
		this.comment = comment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result
				+ ((prodSerial == null) ? 0 : prodSerial.hashCode());
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
		ProductSerialComment other = (ProductSerialComment) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (prodSerial == null) {
			if (other.prodSerial != null)
				return false;
		} else if (!prodSerial.equals(other.prodSerial))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductSerialComment [id=" +id + ", prodSerial=" + prodSerial + ", comment="
				+ comment + "]";
	}

}
