package com.mtsmda.souvenir.spring.stereotype.repository.impl.java_standard.modelTest;


import com.mtsmda.souvenir.model.SouvenirCategory;
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
 * Created by dminzat on 3/28/2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SouvenirCategoryTest {

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
    public void test1002SouvenirCategoryCreatedDatetimeValidation() {
        SouvenirCategory souvenirCategory = new SouvenirCategory();
        souvenirCategory.setSouvenirCategory(null);
        assertNotNull(souvenirCategory);
        Set<ConstraintViolation<SouvenirCategory>> constraintViolations = validator.validate(souvenirCategory, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(NOT_NULL, constraintViolations.iterator().next().getMessage());

        souvenirCategory.setSouvenirCategory("12");
        constraintViolations = validator.validate(souvenirCategory, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(SIZE_MIN_3_AND_MAX_50, constraintViolations.iterator().next().getMessage());

        souvenirCategory.setSouvenirCategory("123456789012345678901234567890123456789012345678900");
        constraintViolations = validator.validate(souvenirCategory, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(SIZE_MIN_3_AND_MAX_50, constraintViolations.iterator().next().getMessage());

        souvenirCategory.setSouvenirCategory("12345678901234567890123456789012345678901234567890");
        constraintViolations = validator.validate(souvenirCategory, SouvenirSequence.class);
        assertEquals(0, constraintViolations.size());
        assertTrue(constraintViolations.isEmpty());
    }

}