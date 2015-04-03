package com.mize.domain.part;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.MizeSceEntity;

@Entity
@Inheritance
@DiscriminatorColumn(name = "discriminator")
@DiscriminatorValue("PartAttribute")
@Table(name = "part_attribute")
public class PartAttribute extends MizeSceEntity implements Comparable<PartAttribute>{

	private static final long serialVersionUID = 5827509183800749241L;
	private Part part;
	private String code;
	private String value;
	private String uom;


	public PartAttribute(){
	}

	public PartAttribute(Part part,String code, String value, String uom) {
		super();
		this.part = part;
		this.code = code;
		this.value = value;
		this.uom = uom;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Override
	public Long getId() {
		return id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "part_id")
	@JsonBackReference(value="partAttribute")
	public Part getPart() {
		return part;
	}

	@Column(name = "attribute_value")
	public String getValue() {
		return value;
	}

	@Column(name = "attribute_uom")
	public String getUom() {
		return uom;
	}
	
	@Column(name = "attribute_code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((uom == null) ? 0 : uom.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (uom == null) {
			if (other.uom != null)
				return false;
		} else if (!uom.equals(other.uom))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PartAttribute [code=" + code + ", value="
				+ value + ", uom=" + uom + "]";
	}

	@Override
	public int compareTo(PartAttribute o) {
		return 0;
	}

}
