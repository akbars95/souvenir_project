package com.mtsmda.souvenir.spring.validation.structural;

import java.util.Set;

/**
 * Created by dminzat on 6/14/2016.
 */
public interface StructuralValidationResult {

    public void setResult(boolean success);

    public boolean isSuccess();

    public Set<StructuralValidationResultObject> getErrors();

}