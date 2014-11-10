package com.mize.domain.part;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name="PartIntlExt")
public class PartIntlExt extends PartIntl{
	private static final long serialVersionUID = 304834525354792709L;
}
