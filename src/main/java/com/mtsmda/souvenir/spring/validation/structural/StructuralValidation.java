package com.mtsmda.souvenir.spring.validation.structural;

/**
 * Created by dminzat on 6/14/2016.
 */
public interface StructuralValidation {

    public <T> StructuralValidationResult validate(T validatableObject, Class<?> ... groups);

}