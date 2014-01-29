package com.mize.domain.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NonEmptyValidator implements ConstraintValidator<NonEmpty, Object> {

    public void initialize(NonEmpty constraintAnnotation) {
    }

    public boolean isValid(Object object, ConstraintValidatorContext constraintContext) {

        if (object == null)
            return false;
        if(object instanceof String){
        	return Formatter.isNotNull((String)object);
        }
        return true;
    }
}

