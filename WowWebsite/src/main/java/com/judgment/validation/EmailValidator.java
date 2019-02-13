/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judgment.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author gsnurr3
 */
public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}";

    @Override
    public boolean isValid(final String email, final ConstraintValidatorContext context) {

        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile(EMAIL_PATTERN);
        if (email == null) {
            return false;
        }
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
