package com.mize.domain.sce.part;

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
import javax.persistence.UniqueConstraint;

import com.mize.domain.common.MizeEntity;

@Entity
@Table(name = "picklist_item", uniqueConstraints = {@UniqueConstraint (columnNames = {"part_id", "picklist_id"})})
public class PickListItem extends MizeEntity {
	private static final long serialVersionUID = 7119442643057089063L;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "picklist_id")
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
		result = prime * result + ((part == null) ? 0 : part.hashCode());
		result = prime * result + ((partQty == null) ? 0 : partQty.hashCode());
		result = prime * result
				+ ((pickList == null) ? 0 : pickList.hashCode());
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
		if (part == null) {
			if (other.part != null)
				return false;
		} else if (!part.equals(other.part))
			return false;
		if (partQty == null) {
			if (other.partQty != null)
				return false;
		} else if (!partQty.equals(other.partQty))
			return false;
		if (pickList == null) {
			if (other.pickList != null)
				return false;
		} else if (!pickList.equals(other.pickList))
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
}
