package com.mize.domain.part;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.CachedEntity;

@Entity
@Table(name = "picklist_item")
public class PickListItem extends MizeSceEntity implements Comparable<PickListItem> {
	private static final long serialVersionUID = 7119442643057089063L;
	@CachedEntity
	private Part part;
	private PickList pickList;
	private BigDecimal partQty;

	public PickListItem() {
		super();
	}

	public PickListItem(Part part, PickList pickList, BigDecimal partQty) {
		super();
		this.part = part;
		this.pickList = pickList;
		this.partQty = partQty;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	@Override
	public Long getId() {
		return id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "part_id")
	public Part getPart() {
		return part;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "picklist_id")
	@JsonBackReference(value="pickListItem")
	public PickList getPickList() {
		return pickList;
	}

	@Column(name = "part_qty", nullable = true)
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

	public void setPickList(PickList pickList) {
		this.pickList = pickList;
	}

	public void setPartQty(BigDecimal partQty) {
		this.partQty = partQty;
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
		PickListItem other = (PickListItem) obj;
		if (partQty == null) {
			if (other.partQty != null)
				return false;
		} else if (!partQty.equals(other.partQty))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PickListItems [part=");
		builder.append(part);
		builder.append(", pickList=");
		builder.append(pickList);
		builder.append(", partQty=");
		builder.append(partQty);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(PickListItem o) {
		return 0;
	}
}
