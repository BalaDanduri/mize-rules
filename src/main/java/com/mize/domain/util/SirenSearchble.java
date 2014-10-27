package com.mize.domain.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SirenSearchble {
	public static final String SELF = "self";
	public static final String NO = "no";
	public static final String YES = "yes";
	
    public String value();
}
