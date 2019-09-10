package com.siukee.demo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.siukee.demo.annotation.PasswordEquals;
import com.siukee.demo.model.RegisterDto;

public class PasswordEqualsValidator implements ConstraintValidator<PasswordEquals, RegisterDto> {

    @Override
    public void initialize(PasswordEquals anno) {
    }

    @Override
    public boolean isValid(RegisterDto form, ConstraintValidatorContext context) {
        String passwordConfirm = form.getPasswordConfirm();
        String password = form.getPassword();

        boolean match = passwordConfirm != null ? passwordConfirm.equals(password) : false;
        if (match) {
            return true;
        }

        String messageTemplate = context.getDefaultConstraintMessageTemplate();
        
        // disable default violation rule
        context.disableDefaultConstraintViolation();

        // assign error on password Confirm field
        context.buildConstraintViolationWithTemplate(messageTemplate).addPropertyNode("passwordConfirm")
                .addConstraintViolation();
        return false;

    }
}