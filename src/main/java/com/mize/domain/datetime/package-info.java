@TypeDefs(
		{
			@TypeDef(
					name = "dateTime",
					defaultForType = com.mize.domain.datetime.DateTime.class,
					typeClass = com.mize.domain.datetime.DateTimeJPA.class
					)
		}
		)
	
  
package com.mize.domain.datetime;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

