package com.ttm.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StoreValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^StoreValidator supports");
		return false;
	}

	public void validate(Object target, Errors errors) {
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^StoreValidator validate");
	}

}
