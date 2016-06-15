package com.mtsmda.souvenir.spring.validation.validators;

import com.mtsmda.souvenir.spring.validation.validators.constraints.IfNotNullConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by dminzat on 6/14/2016.
 */
public class IfNotNullValidator implements ConstraintValidator<IfNotNullConstraint, Object> {

    private int minValue;
    private int maxValue;

    @Override
    public void initialize(IfNotNullConstraint ifNotNullConstraint) {
        this.minValue = ifNotNullConstraint.min();
        this.maxValue = ifNotNullConstraint.max();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        if (null != object && null != object.toString()) {
            String value = object.toString();
            if (value.length() > this.maxValue || value.length() < minValue) {
                return false;
            }
        }
        return true;
    }
}