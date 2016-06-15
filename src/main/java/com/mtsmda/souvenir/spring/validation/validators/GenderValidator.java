package com.mtsmda.souvenir.spring.validation.validators;

import com.mtsmda.souvenir.model.constant.Gender;
import com.mtsmda.souvenir.spring.validation.validators.constraints.GenderConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by dminzat on 5/17/2016.
 */
public class GenderValidator implements ConstraintValidator<GenderConstraint, Object> {

    @Override
    public void initialize(GenderConstraint genderConstraint) {

    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        if (object == null) {
            return false;
        }
        Gender gender = null;
        try {
            gender = Gender.valueOf(object.toString());
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
