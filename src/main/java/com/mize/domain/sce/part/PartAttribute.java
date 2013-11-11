package com.mize.domain.sce.part;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.joda.time.DateTime;

import com.mize.domain.common.MizeEntity;

@Entity
@Table(name = "part_attribute", uniqueConstraints = {@UniqueConstraint (columnNames = {"part_id"})})
public class PartAttribute extends MizeEntity{

	private static final long serialVersionUID = 5827509183800749241L;
	private Part part;
	private String attributeCode;
	private String attributeValue;
	private String attributeUOM;


	public PartAttribute(){
	}

	public PartAttribute(Part part,String attributeCode, String attributeValue, String attributeUOM) {
		super();
		this.part = part;
		this.attributeCode = attributeCode;
		this.attributeValue = attributeValue;
		this.attributeUOM = attributeUOM;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "part_id")
	public Part getPart() {
		return part;
	}

	@Column(name = "attribute_value", length = 100, nullable = true)
	public String getAttributeValue() {
		return attributeValue;
	}

	@Column(name = "attribute_uom", length = 30, nullable = true)
	public String getAttributeUOM() {
		return attributeUOM;
	}
	
	@Column(name = "attribute_code", length = 30, nullable = true)
	public String getAttributeCode() {
		return attributeCode;
	}

	public void setAttributeCode(String attributeCode) {
		this.attributeCode = attributeCode;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	public void setAttributeUOM(String attribute_uom) {
		this.attributeUOM = attribute_uom;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((attributeCode == null) ? 0 : attributeCode.hashCode());
		result = prime * result
				+ ((attributeValue == null) ? 0 : attributeValue.hashCode());
		result = prime * result
				+ ((attributeUOM == null) ? 0 : attributeUOM.hashCode());
		result = prime * result + ((part == null) ? 0 : part.hashCode());
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
		PartAttribute other = (PartAttribute) obj;
		if (attributeCode == null) {
			if (other.attributeCode != null)
				return false;
		} else if (!attributeCode.equals(other.attributeCode))
			return false;
		if (attributeValue == null) {
			if (other.attributeValue != null)
				return false;
		} else if (!attributeValue.equals(other.attributeValue))
			return false;
		if (attributeUOM == null) {
			if (other.attributeUOM != null)
				return false;
		} else if (!attributeUOM.equals(other.attributeUOM))
			return false;
		if (part == null) {
			if (other.part != null)
				return false;
		} else if (!part.equals(other.part))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PartAttribute [part=");
		builder.append(part);
		builder.append(", attributeCode=");
		builder.append(attributeCode);
		builder.append(", attributeValue=");
		builder.append(attributeValue);
		builder.append(", attribute_uom=");
		builder.append(attributeUOM);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}


	@PrePersist
	@PreUpdate
	public void auditFields(){
		if(createdDate==null && id==null){
			setCreatedDate(DateTime.now());
		}
		setUpdatedDate(DateTime.now());
		
	}


}
