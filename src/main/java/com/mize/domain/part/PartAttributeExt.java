package com.mize.domain.part;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name="PartAttributeExt")
public class PartAttributeExt extends PartAttribute{
	private static final long serialVersionUID = 4526687314523032896L;

}
