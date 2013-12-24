package com.mize.domain.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmptyValidator implements ConstraintValidator<EmptyOrAlpha,String> {
	Pattern pattern = Pattern.compile("^[0-9a-zA-Z-:.,_ ]+$");
	@Override
	public void initialize(EmptyOrAlpha constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(Formatter.isNull(value)){
			return true;
		}else{
			Matcher m = pattern.matcher(value);
			return m.matches();
		}
	}
}
