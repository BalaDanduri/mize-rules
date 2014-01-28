package com.mize.domain.util;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
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
@Target({METHOD,FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidateWhen.class)
@Documented
public @interface ValidateFieldDependsOn {

    String fieldName();
    String fieldValue();
    String dependFieldName();

    String message() default "{message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Target({FIELD, ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @Documented
    @interface List {
    	ValidateFieldDependsOn[] value();
    }

}
