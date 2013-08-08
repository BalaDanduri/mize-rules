package com.mize.domain.test;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

public abstract class ValidationUtil {
	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	public <T> Set<ConstraintViolation<T>> validate(T object, Class<?>... groups){
		return validate(object, false,groups);
	}
	
	public <T> Set<ConstraintViolation<T>> validate(T object, boolean isprint,Class<?>... groups){
		Set<ConstraintViolation<T>> validations = validator.validate(object);
		if(isprint){
			for (ConstraintViolation<T> validation : validations) {
				System.out.println(validation.getPropertyPath() + " -> "
						+ validation.getMessage());
			}
		}
		return validations;
	}
}
