package com.mize.domain.part;

import java.math.BigDecimal;

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
import javax.persistence.UniqueConstraint;

import com.mize.domain.common.MizeEntity;

@Entity
@Table(name = "part_kit_item", uniqueConstraints = {@UniqueConstraint (columnNames = {"part_id", "part_kit_id"})})
public class PartKitItem extends MizeEntity{

	private static final long serialVersionUID = 1L;
	private Part part;
	private PartKit partKit;
	private BigDecimal partQty;
	
	public PartKitItem(){
		super();
	}
	
	public PartKitItem(Part part, PartKit partKit, BigDecimal partQty) {
		super();
		this.part = part;
		this.partKit = partKit;
		this.partQty = partQty;
	}
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "part_id")
	public Part getPart() {
		return part;
	}
    
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "part_kit_id")
	public PartKit getPartKit() {
		return partKit;
	}
	
	@Column(name = "part_qty", nullable = true, length = 30)
	public BigDecimal getPartQty() {
		return partQty;
	}
	
	
	@Override
	public void setId(Long id) {
		this.id = id;
		
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public void setPartKit(PartKit partKit) {
		this.partKit = partKit;
	}

	public void setPartQty(BigDecimal partQty) {
		this.partQty = partQty;
	}

	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((part == null) ? 0 : part.hashCode());
		result = prime * result + ((partKit == null) ? 0 : partKit.hashCode());
		result = prime * result + ((partQty == null) ? 0 : partQty.hashCode());
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
		PartKitItem other = (PartKitItem) obj;
		if (part == null) {
			if (other.part != null)
				return false;
		}if (part.getCode() == null ||other.part.getCode() == null) {
				return false;
		} else if (part.getCode() != null && other.part.getCode() != null && !part.getCode().equals(other.part.getCode()))
			return true; 
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PartKitItems [part=");
		builder.append(part);
		builder.append(", partKit=");
		builder.append(partKit);
		builder.append(", partQty=");
		builder.append(partQty);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}

	

}
