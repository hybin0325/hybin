package com.edas.business.byrobot.annotation;

import java.util.Objects;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * <p>
 * File Name: PhoneValidator.java
 * </p>
 * <p>
 * Description: 手机校验类
 * </p>
 * <p>
 * Date：2019年5月16日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public class PhoneValidator implements ConstraintValidator<Phone, Object> {
    
	private static final String PHONE_REGEX = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {        
    	if (Objects.isNull(value) || !Pattern.compile(PHONE_REGEX).matcher(value.toString()).find()) {
    		return false;
		}
    	return true;
    }
}