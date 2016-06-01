package com.mtsmda.souvenir.spring.stereotype.repository.impl.java_standard.modelTest;

import com.mtsmda.souvenir.model.Souvenir;
import com.mtsmda.souvenir.validation.validators.sequence.SouvenirSequence;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.Assert.*;
import static com.mtsmda.souvenir.spring.stereotype.repository.impl.java_standard.constants.TestConstants.*;

/**
 * Created by dminzat on 3/22/2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SouvenirTest {

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
    public void test1002SouvenirNameValidation() {
        Souvenir souvenir = new Souvenir();
        souvenir.setSouvenirDescription("123");
        souvenir.setSouvenirShow(false);
        souvenir.setSouvenirPrice(12.1);
        souvenir.setSouvenirCountOfDaysForOrder(1);
        assertNotNull(souvenir);
        Set<ConstraintViolation<Souvenir>> constraintViolations = validator.validate(souvenir, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(NOT_NULL, constraintViolations.iterator().next().getMessage());
        souvenir.setSouvenirName("12");
        constraintViolations = validator.validate(souvenir, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(SIZE_MIN_3_AND_MAX_50, constraintViolations.iterator().next().getMessage());
        souvenir.setSouvenirName("12345678901234567890123456789012345678901234567890B");
        constraintViolations = validator.validate(souvenir, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(SIZE_MIN_3_AND_MAX_50, constraintViolations.iterator().next().getMessage());
        souvenir.setSouvenirName("12345678901234567890123456789012345678901234567890");
        constraintViolations = validator.validate(souvenir, SouvenirSequence.class);
        assertEquals(0, constraintViolations.size());
        assertTrue(constraintViolations.isEmpty());
    }

    @Test
    public void test1003SouvenirDescriptionValidation() {
        Souvenir souvenir = new Souvenir();
        souvenir.setSouvenirDescription(null);
        souvenir.setSouvenirShow(false);
        souvenir.setSouvenirPrice(12.1);
        souvenir.setSouvenirName("123456789012345670");
        souvenir.setSouvenirCountOfDaysForOrder(1);
        assertNotNull(souvenir);
        Set<ConstraintViolation<Souvenir>> constraintViolations = validator.validate(souvenir, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(NOT_NULL, constraintViolations.iterator().next().getMessage());
        souvenir.setSouvenirDescription("12");
        constraintViolations = validator.validate(souvenir, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(SIZE_MIN_3_AND_MAX_255, constraintViolations.iterator().next().getMessage());
        souvenir.setSouvenirDescription("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890fhgfkhgkdfhj");
        constraintViolations = validator.validate(souvenir, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(SIZE_MIN_3_AND_MAX_255, constraintViolations.iterator().next().getMessage());
        souvenir.setSouvenirDescription("12345");
        constraintViolations = validator.validate(souvenir, SouvenirSequence.class);
        assertEquals(0, constraintViolations.size());
        assertTrue(constraintViolations.isEmpty());
    }

    @Test
    public void test1004SouvenirShowValidation() {
        Souvenir souvenir = new Souvenir();
        souvenir.setSouvenirDescription("12345");
        souvenir.setSouvenirShow(null);
        souvenir.setSouvenirPrice(12.1);
        souvenir.setSouvenirName("123456789012345670");
        souvenir.setSouvenirCountOfDaysForOrder(1);
        assertNotNull(souvenir);
        Set<ConstraintViolation<Souvenir>> constraintViolations = validator.validate(souvenir, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(NOT_NULL, constraintViolations.iterator().next().getMessage());
        souvenir.setSouvenirShow(true);
        constraintViolations = validator.validate(souvenir, SouvenirSequence.class);
        assertEquals(0, constraintViolations.size());
        assertTrue(constraintViolations.isEmpty());
    }

    @Test
    public void test1006SouvenirPriceValidation() {
        Souvenir souvenir = new Souvenir();
        souvenir.setSouvenirDescription("12345");
        souvenir.setSouvenirShow(false);
        souvenir.setSouvenirPrice(null);
        souvenir.setSouvenirName("123456789012345670");
        souvenir.setSouvenirCountOfDaysForOrder(1);
        assertNotNull(souvenir);
        Set<ConstraintViolation<Souvenir>> constraintViolations = validator.validate(souvenir, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(NOT_NULL, constraintViolations.iterator().next().getMessage());
        souvenir.setSouvenirPrice(new Double(15.96));
        constraintViolations = validator.validate(souvenir, SouvenirSequence.class);
        assertEquals(0, constraintViolations.size());
        assertTrue(constraintViolations.isEmpty());
    }

    @Test
    public void test1006SouvenirCountOfDaysForOrderValidation() {
        Souvenir souvenir = new Souvenir();
        souvenir.setSouvenirDescription("12345");
        souvenir.setSouvenirShow(false);
        souvenir.setSouvenirPrice(new Double(19.));
        souvenir.setSouvenirName("123456789012345670");
        souvenir.setSouvenirCountOfDaysForOrder(null);
        assertNotNull(souvenir);
        Set<ConstraintViolation<Souvenir>> constraintViolations = validator.validate(souvenir, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());

        souvenir.setSouvenirCountOfDaysForOrder(0);
        constraintViolations = validator.validate(souvenir, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(MIN_VALUE_1, constraintViolations.iterator().next().getMessage());

        souvenir.setSouvenirCountOfDaysForOrder(100);
        constraintViolations = validator.validate(souvenir, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(MAX_VALUE_50, constraintViolations.iterator().next().getMessage());

        souvenir.setSouvenirCountOfDaysForOrder(2);
        constraintViolations = validator.validate(souvenir, SouvenirSequence.class);
        assertEquals(0, constraintViolations.size());
        assertTrue(constraintViolations.isEmpty());
    }

}