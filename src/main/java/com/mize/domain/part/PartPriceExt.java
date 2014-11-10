package com.mize.domain.part;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name="PartPriceExt")
public class PartPriceExt extends PartPrice{
	private static final long serialVersionUID = 3437386575873893867L;

}
