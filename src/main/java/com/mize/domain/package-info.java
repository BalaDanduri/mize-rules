@MappedSuperclass // HACK TO CAUSE HIBERNATE TO NOTICE THESE TYPE DEFS
@TypeDefs(
		{
			@TypeDef(
					name = "dateTime",
					defaultForType = com.mize.domain.datetime.DateTime.class,
					typeClass = com.mize.domain.datetime.DateTimeJPA.class
					),
			@TypeDef(
					name = "date",
					defaultForType = com.mize.domain.datetime.Date.class,
					typeClass = com.mize.domain.datetime.DateJPA.class
					)
		}
		)
	
  
package com.mize.domain;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

