package com.mize.domain.util;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
/**
 * Validates that field {@code dependFieldName} is not null if
 * field {@code fieldName} has value {@code fieldValue}.
 **/
@Target({TYPE,METHOD,FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidateRegex.class)
@Documented
public @interface ValidateOnDependentFeild {
	final String EMPTY ="";
    String fieldName() default EMPTY;
    String dependFieldName() default EMPTY;
    String dependedFieldValue() default EMPTY;
    String regexValue() default EMPTY;
    boolean regex() default false;

    String message() default "{message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Target({TYPE,FIELD, ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @Documented
    @interface List {
    	ValidateOnDependentFeild[] value();
    }

}
