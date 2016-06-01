package com.mtsmda.souvenir.validation.validators;

import com.mtsmda.souvenir.spring.stereotype.service.SouvenirService;
import com.mtsmda.souvenir.validation.validators.constraints.ValuteCodeConstraint;
import com.mtsmda.souvenir.valute.ValuteBorder;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by dminzat on 5/17/2016.
 */
public class ValuteCodeValidator implements ConstraintValidator<ValuteCodeConstraint, Object> {
    private String fieldNameCode;
    private String fieldNameCharCode;

    private boolean isTest;

    @Autowired
    @Qualifier("valuteBorder")
    private ValuteBorder valuteBorder;

    @Autowired
    @Qualifier("souvenirService")
    private SouvenirService souvenirService;

    @Override
    public void initialize(ValuteCodeConstraint valuteCodeConstraint) {
        this.fieldNameCode = valuteCodeConstraint.fieldNameCode();
        this.fieldNameCharCode = valuteCodeConstraint.fieldNameCharCode();
        this.isTest = valuteCodeConstraint.isTest();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        try {
            Object fieldNameCode = PropertyUtils.getProperty(object, this.fieldNameCode);
            Object fieldNameCharCode = PropertyUtils.getProperty(object, this.fieldNameCharCode);
            if (!this.isTest) {
                String property = this.valuteBorder.getValuteProperties().getProperty(fieldNameCharCode.toString());
                if (property == null) {
                    return false;
                }
                if (!property.equals(fieldNameCode)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
