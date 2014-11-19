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
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.part.PartSubstitute;

@Entity
@Table(name = "part_substitute_comment", uniqueConstraints = {@UniqueConstraint (columnNames = {"id"})})
public class PartSubstituteComment extends MizeSceEntity implements Comparable<PartSubstituteComment>{
	
	private static final long serialVersionUID = -4772128184803476915L;
	private PartSubstitute partSubstitute;
	private EntityComment comment = new EntityComment();


	public PartSubstituteComment(){
		super();
	}
	
	public PartSubstituteComment(EntityComment comment){
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

	/*@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="prod_srl_id")
	@JsonBackReference(value="comments_productSerial")
	public ProductSerial getProductSerial() {
		return productSerial;
	}

	public void setProductSerial(ProductSerial productSerial) {
		this.productSerial = productSerial;
	}
*/
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="part_substitute_id")
	@JsonBackReference(value="comments_partSubstitute")
	public PartSubstitute getPartSubstitute() {
		return partSubstitute;
	}

	public void setPartSubstitute(PartSubstitute partSubstitute) {
		this.partSubstitute = partSubstitute;
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
		PartSubstituteComment other = (PartSubstituteComment) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PartSubstituteComment [comment=" + comment + "]";
	}

	@Override
	public int compareTo(PartSubstituteComment arg0) {
		return 0;
	}


}
