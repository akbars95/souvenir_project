package com.mtsmda.souvenir.repository.impl.java_standard.modelTest;

import com.mtsmda.souvenir.model.SouvenirCategory;
import com.mtsmda.souvenir.model.SouvenirPhoto;
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
import static com.mtsmda.souvenir.repository.impl.java_standard.constants.TestConstants.*;
/**
 * Created by dminzat on 3/28/2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SouvenirPhotoTest {

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
    public void test1002SouvenirPhotoSouvenirPhotoPathValidation() {
        SouvenirPhoto souvenirPhoto = new SouvenirPhoto();
        souvenirPhoto.setSouvenirPhotoPath(null);
        assertNotNull(souvenirPhoto);
        Set<ConstraintViolation<SouvenirPhoto>> constraintViolations = validator.validate(souvenirPhoto);
        assertEquals(1, constraintViolations.size());
        assertEquals(NOT_NULL, constraintViolations.iterator().next().getMessage());

        souvenirPhoto.setSouvenirPhotoPath("12");
        constraintViolations = validator.validate(souvenirPhoto);
        assertEquals(1, constraintViolations.size());
        assertEquals(SIZE_MIN_3_AND_MAX_255, constraintViolations.iterator().next().getMessage());

        souvenirPhoto.setSouvenirPhotoPath("123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
        constraintViolations = validator.validate(souvenirPhoto);
        assertEquals(1, constraintViolations.size());
        assertEquals(SIZE_MIN_3_AND_MAX_255, constraintViolations.iterator().next().getMessage());

        souvenirPhoto.setSouvenirPhotoPath("12345678901234567890123456789012345678901234567890");
        constraintViolations = validator.validate(souvenirPhoto);
        assertEquals(0, constraintViolations.size());
        assertTrue(constraintViolations.isEmpty());
    }

}