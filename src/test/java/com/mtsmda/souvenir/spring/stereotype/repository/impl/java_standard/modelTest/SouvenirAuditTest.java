package com.mtsmda.souvenir.spring.stereotype.repository.impl.java_standard.modelTest;


import com.mtsmda.souvenir.model.SouvenirAudit;
import com.mtsmda.souvenir.validation.validators.sequence.SouvenirSequence;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

import static org.junit.Assert.*;
import static com.mtsmda.souvenir.spring.stereotype.repository.impl.java_standard.constants.TestConstants.*;

/**
 * Created by dminzat on 3/28/2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SouvenirAuditTest {

    private static Validator validator;

    @BeforeClass
    public static void test1000SetUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void test1001ValidatorNotNull() {
        assertNotNull(validator);
    }

    @Test
    public void test1002SouvenirAuditCreatedDatetimeValidation() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(2015, 1, 1);
        SouvenirAudit souvenirAudit = new SouvenirAudit();
        souvenirAudit.setLastUpdateDatetime(new Date());
        assertNotNull(souvenirAudit);
        Set<ConstraintViolation<SouvenirAudit>> constraintViolations = validator.validate(souvenirAudit, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(NOT_NULL, constraintViolations.iterator().next().getMessage());

        souvenirAudit.setCreatedDatetime(new GregorianCalendar(gregorianCalendar.get(GregorianCalendar.YEAR) + 5, 1, 1).getTime());
        constraintViolations = validator.validate(souvenirAudit, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(DATE_PAST, constraintViolations.iterator().next().getMessage());

        souvenirAudit.setCreatedDatetime(gregorianCalendar.getTime());
        constraintViolations = validator.validate(souvenirAudit, SouvenirSequence.class);
        assertEquals(0, constraintViolations.size());
        assertTrue(constraintViolations.isEmpty());
    }

    @Test
    public void test1003SouvenirAuditLastUpdateDatetimeValidation() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(2015, 1, 1);
        SouvenirAudit souvenirAudit = new SouvenirAudit();
        souvenirAudit.setLastUpdateDatetime(null);
        souvenirAudit.setCreatedDatetime(gregorianCalendar.getTime());
        assertNotNull(souvenirAudit);
        Set<ConstraintViolation<SouvenirAudit>> constraintViolations = validator.validate(souvenirAudit, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(NOT_NULL, constraintViolations.iterator().next().getMessage());

        souvenirAudit.setLastUpdateDatetime(new GregorianCalendar(gregorianCalendar.get(GregorianCalendar.YEAR) + 5, 1, 1).getTime());
        constraintViolations = validator.validate(souvenirAudit, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(DATE_PAST, constraintViolations.iterator().next().getMessage());

        souvenirAudit.setLastUpdateDatetime(gregorianCalendar.getTime());
        constraintViolations = validator.validate(souvenirAudit, SouvenirSequence.class);
        assertEquals(0, constraintViolations.size());
        assertTrue(constraintViolations.isEmpty());
    }

}