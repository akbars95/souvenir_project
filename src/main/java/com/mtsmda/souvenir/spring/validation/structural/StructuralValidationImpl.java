package com.mtsmda.souvenir.spring.validation.structural;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by dminzat on 6/14/2016.
 */
@Component(value = "structuralValidationImpl")
public class StructuralValidationImpl implements StructuralValidation{

    private ValidatorFactory validatorFactory;

    @Override
    public <T> StructuralValidationResult validate(T validatableObject, Class<?>... groups) {
        DefaultStructuralValidationResultImpl structuralValidationResult = new DefaultStructuralValidationResultImpl();
        Validator validator = getValidatorFactory().getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(validatableObject, groups);
        if(constraintViolations.isEmpty()){
            structuralValidationResult = new DefaultStructuralValidationResultImpl(constraintViolations.isEmpty());
        }else{
            Iterator<ConstraintViolation<T>> iterator = constraintViolations.iterator();
            Set<StructuralValidationResultObject> structuralValidationResultObjects = null;
            if(!constraintViolations.isEmpty()){
                structuralValidationResultObjects = new HashSet<>();
            }
            while(iterator.hasNext()){
                ConstraintViolation<T> next = iterator.next();
                structuralValidationResultObjects.add(new StructuralValidationResultObject(next.getMessage(), next.getInvalidValue(), next.getPropertyPath().toString()));
            }
            structuralValidationResult = new DefaultStructuralValidationResultImpl(structuralValidationResultObjects);
        }
        return structuralValidationResult;
    }

    private ValidatorFactory getValidatorFactory(){
        if(null == this.validatorFactory){
            this.validatorFactory = Validation.buildDefaultValidatorFactory();
        }
        return validatorFactory;
    }
/*
    public static void main(String[] args) {
        RegistrationRO registrationRO = new RegistrationRO();
        StructuralValidationResult validate = new StructuralValidationImpl().validate(registrationRO);
        System.out.println(validate);
    }*/
}