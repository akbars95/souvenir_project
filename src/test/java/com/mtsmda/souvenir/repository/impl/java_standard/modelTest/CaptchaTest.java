package com.mtsmda.souvenir.repository.impl.java_standard.modelTest;

import com.mtsmda.souvenir.model.Captcha;
import com.mtsmda.souvenir.model.Message;
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

import static com.mtsmda.souvenir.repository.impl.java_standard.constants.TestConstants.NOT_NULL;
import static com.mtsmda.souvenir.repository.impl.java_standard.constants.TestConstants.SIZE_MIN_10_AND_MAX_255;
import static com.mtsmda.souvenir.repository.impl.java_standard.constants.TestConstants.SIZE_MIN_5_AND_MAX_10;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by dminzat on 3/22/2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CaptchaTest{

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
    public void test1002CaptchaFieldsNullValidation() {
        Captcha captcha = new Captcha(null, null);
        assertNotNull(captcha);
        Set<ConstraintViolation<Captcha>> constraintViolations = validator.validate(captcha, SouvenirSequence.class);
        assertEquals(2, constraintViolations.size());
        assertEquals(NOT_NULL, constraintViolations.iterator().next().getMessage());
        assertEquals(NOT_NULL, constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void test1003CaptchaFieldsNotNullValidation() {
        Captcha captcha = new Captcha("f", "gf");
        assertNotNull(captcha);
        Set<ConstraintViolation<Captcha>> constraintViolations = validator.validate(captcha, SouvenirSequence.class);
        assertEquals(2, constraintViolations.size());
    }

    @Test
    public void test1004CaptchaValueValidation() {
        Captcha captcha = new Captcha(null, "/dfmdfgdfg.jpg");
        assertNotNull(captcha);
        Set<ConstraintViolation<Captcha>> constraintViolations = validator.validate(captcha, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(NOT_NULL, constraintViolations.iterator().next().getMessage());
        captcha.setCaptchaValue("12");
        constraintViolations = validator.validate(captcha, SouvenirSequence.class);
        assertEquals(SIZE_MIN_5_AND_MAX_10, constraintViolations.iterator().next().getMessage());
        captcha.setCaptchaValue("12345678901");
        constraintViolations = validator.validate(captcha, SouvenirSequence.class);
        assertEquals(SIZE_MIN_5_AND_MAX_10, constraintViolations.iterator().next().getMessage());
        captcha.setCaptchaValue("1234567890");
        constraintViolations = validator.validate(captcha, SouvenirSequence.class);
        assertEquals(0, constraintViolations.size());
    }

    @Test
    public void test1005CaptchaUrlFileValidation() {
        Captcha captcha = new Captcha("1234567890", null);
        assertNotNull(captcha);
        Set<ConstraintViolation<Captcha>> constraintViolations = validator.validate(captcha, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(NOT_NULL, constraintViolations.iterator().next().getMessage());
        captcha.setCaptchaUrlFile("/dl.jpg");
        constraintViolations = validator.validate(captcha, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(SIZE_MIN_10_AND_MAX_255, constraintViolations.iterator().next().getMessage());
        captcha.setCaptchaUrlFile("/12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890.jpg");
        constraintViolations = validator.validate(captcha, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(SIZE_MIN_10_AND_MAX_255, constraintViolations.iterator().next().getMessage());
        captcha.setCaptchaUrlFile("/1234567890.jpg");
        constraintViolations = validator.validate(captcha, SouvenirSequence.class);
        assertEquals(0, constraintViolations.size());
    }

}