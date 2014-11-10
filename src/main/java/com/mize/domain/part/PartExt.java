package com.mize.domain.part;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@DiscriminatorColumn(name="PartExt")
@Table(name = "part", uniqueConstraints = {@UniqueConstraint (columnNames = {"tenant_id", "part_code"})})
public class PartExt extends Part{
	
	private static final long serialVersionUID = 5539962338371311743L;

	public PartExt() {
		super();
	}

	public PartExt(Long id, String partCode, String partType, String isActive, String isKit, String isSerialized,
			String isReturnable, String uom) {
		super(id, partCode, partType, isActive, isKit, isSerialized, isReturnable, uom);
	}

}
