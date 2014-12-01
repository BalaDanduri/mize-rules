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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.MizeSceEntity;

@Entity
@Table(name = "part_kit_item")
public class PartKitItem extends MizeSceEntity implements Comparable<PartKitItem>{

	private static final long serialVersionUID = 1L;
	private Part part;
	private PartKit partKit;
	private BigDecimal partQty;
	@Transient
	private BigDecimal partPrice;
	
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
	@Column(name = "id")
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
	@JsonBackReference(value="partKits")
	public PartKit getPartKit() {
		return partKit;
	}
	
	@Column(name = "part_qty")
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

	@Transient
	public BigDecimal getPartPrice() {
		return partPrice;
	}

	public void setPartPrice(BigDecimal partPrice) {
		this.partPrice = partPrice;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
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
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();		
		builder.append(", partQty=");
		builder.append(partQty);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(PartKitItem o) {
		return 0;
	}

	

}
