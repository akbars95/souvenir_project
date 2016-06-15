package com.mtsmda.souvenir.spring.validation.structural;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dminzat on 6/14/2016.
 */
public class DefaultStructuralValidationResultImpl implements StructuralValidationResult{

    private boolean isSuccess;
    private Set<StructuralValidationResultObject> structuralValidationResultObjects;

    public DefaultStructuralValidationResultImpl() {
        structuralValidationResultObjects = new HashSet<>();
    }

    public DefaultStructuralValidationResultImpl(boolean isSuccess) {
        this();
        this.isSuccess = isSuccess;
    }

    public DefaultStructuralValidationResultImpl(Set<StructuralValidationResultObject> structuralValidationResultObjects) {
        this.structuralValidationResultObjects = structuralValidationResultObjects;
        setResult(this.structuralValidationResultObjects.isEmpty());
    }

    @Override
    public void setResult(boolean success) {
        isSuccess = success;
    }

    @Override
    public boolean isSuccess() {
        return isSuccess;
    }

    @Override
    public Set<StructuralValidationResultObject> getErrors() {
        return structuralValidationResultObjects;
    }
}