package com.siukee.demo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.siukee.demo.validator.PasswordEqualsValidator;

@Documented
@Constraint(validatedBy = { PasswordEqualsValidator.class })
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordEquals {

	String message() default "Password is not the same";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}