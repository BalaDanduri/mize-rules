package com.mize.domain.util;

import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;



public class ValidateRegex implements ConstraintValidator<ValidateOnDependentFeild, Object> {

	private String fieldName;
    private String dependedFieldValue;
    private String dependFieldName;
    private boolean regex;
    Pattern pattern;
    Matcher matcher;
    @Override
    public void initialize(final ValidateOnDependentFeild annotation) {
        fieldName          = annotation.fieldName();
        dependFieldName    = annotation.dependFieldName();
        dependedFieldValue = annotation.dependedFieldValue(); 
        regex = annotation.regex();
        if(Formatter.isNotNull(annotation.regexValue()) && regex){
        	pattern =Pattern.compile(annotation.regexValue());
        }
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext ctx) {
    	
        if (value == null) {
            return true;
        }
        try {
            final String dependFieldValue = BeanUtils.getProperty(value, dependFieldName);
            final String fieldValue       = BeanUtils.getProperty(value, fieldName);
            if(dependedFieldValue.equals(dependFieldValue)){
            	if(Formatter.isNull(fieldValue)){
            		ctx.disableDefaultConstraintViolation();
            		ctx.buildConstraintViolationWithTemplate(ctx.getDefaultConstraintMessageTemplate())
            		.addNode(fieldName)
            		.addConstraintViolation();
            		return false;
            	}else{
            		if(regex){
            			matcher = pattern.matcher(fieldValue);
            			return matcher.matches();
            		}
            	}
            }

        } catch (final NoSuchMethodException ex) {
            throw new RuntimeException(ex);

        } catch (final InvocationTargetException ex) {
            throw new RuntimeException(ex);

        } catch (final IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }

        return true;
    }





}
