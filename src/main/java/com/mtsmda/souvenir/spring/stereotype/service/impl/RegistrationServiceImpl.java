package com.mtsmda.souvenir.spring.stereotype.service.impl;

import com.mtsmda.souvenir.spring.stereotype.object.request.RegistrationRO;
import com.mtsmda.souvenir.spring.stereotype.service.RegistrationService;
import com.mtsmda.souvenir.spring.validation.structural.StructuralValidation;
import com.mtsmda.souvenir.spring.validation.structural.StructuralValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by dminzat on 6/15/2016.
 */
@Service("registrationService")
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    @Qualifier("structuralValidationImpl")
    private StructuralValidation structuralValidation;

    @Override
    public boolean registration(RegistrationRO registrationRO) {
        StructuralValidationResult validate = structuralValidation.validate(registrationRO);
        if(!validate.isSuccess()){
            return false;
        }
        return true;
    }

}
