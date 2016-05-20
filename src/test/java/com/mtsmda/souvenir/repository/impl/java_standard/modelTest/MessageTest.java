package com.mtsmda.souvenir.repository.impl.java_standard.modelTest;

import com.mtsmda.souvenir.model.Message;
import com.mtsmda.souvenir.validation.validators.sequence.SouvenirSequence;
import org.junit.Assert;
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
 * Created by dminzat on 3/21/2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MessageTest {

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
    public void test1002MessageNameNullValidation() {
        Message message = new Message(null, "ion.ionuta@mail.md", "simple Text", 2);
        assertNotNull(message);
        Set<ConstraintViolation<Message>> constraintViolations = validator.validate(message, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(NOT_NULL, constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void test1003MessageNameMinSizeValidation() {
        Message message = new Message("ms", "ion.ionuta@mail.md", "simple Text", 2);
        assertNotNull(message);
        Set<ConstraintViolation<Message>> constraintViolations = validator.validate(message, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(SIZE_MIN_3_AND_MAX_50, constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void test1003MessageNameMaxSizeValidation() {
        Message message = new Message("t123456789t123456789t123456789t123456789t1234567890", "ion.ionuta@mail.md", "simple Text", 2);
        assertNotNull(message);
        Set<ConstraintViolation<Message>> constraintViolations = validator.validate(message, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(SIZE_MIN_3_AND_MAX_50, constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void test1004MessageEmailNullValidation() {
        Message message = new Message("t123456789t12345678", null, "simple Text", 2);
        assertNotNull(message);
        Set<ConstraintViolation<Message>> constraintViolations = validator.validate(message, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(NOT_NULL, constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void test1005MessageEmailMinSizeValidation() {
        Message message = new Message("t123456789t12345678", "2@m.r", "simple Text", 2);
        assertNotNull(message);
        Set<ConstraintViolation<Message>> constraintViolations = validator.validate(message, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(SIZE_MIN_6_AND_MAX_50, constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void test1006MessageEmailMaxSizeValidation() {
        Message message = new Message("t123456789t12345678", "ion.ionutaionutaionutadion.ionuta.ionuta.ionuta@mail.md", "simple Text", 2);
        assertNotNull(message);
        Set<ConstraintViolation<Message>> constraintViolations = validator.validate(message, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(SIZE_MIN_6_AND_MAX_50, constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void test1007MessageEmailEmailValidation() {
        Message message = new Message("t123456789t12345678", "ion..ionuta.ionutamail.md", "simple Text", 2);
        assertNotNull(message);
        Set<ConstraintViolation<Message>> constraintViolations = validator.validate(message, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(EMAIL, constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void test1008MessageTextNullValidation() {
        Message message = new Message("t123456789t12345678", "iononuta.ionut@amail.md", null, 2);
        assertNotNull(message);
        Set<ConstraintViolation<Message>> constraintViolations = validator.validate(message, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(NOT_NULL, constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void test1009MessageTextMinSizeValidation() {
        Message message = new Message("t123456789t12345678", "ionionuta.ionut@amail.md", "d1", 2);
        assertNotNull(message);
        Set<ConstraintViolation<Message>> constraintViolations = validator.validate(message, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(SIZE_MIN_3_AND_MAX_1000, constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void test1010MessageTextMaxSizeValidation() {
        String text = "ion.ionutaionutaionutadion.ionuta.ionuta.ionuta@mail.mdion.ionutaionutaionutadion.ionuta.ionuta.ionsion.ionutaionutaionutadion.ionuta.ionuta.ionuta@mail.mdion.ionutaionutaionutadion.ionuta.ionuta.ionsion.ionutaionutaionutadion.ionuta.ionuta.ionuta@mail.mdion.ionutaionutaionutadion.ionuta.ionuta.ionsion.ionutaionutaionutadion.ionuta.ionuta.ionuta@mail.mdion.ionutaionutaionutadion.ionuta.ionuta.ionsion.ionutaionutaionutadion.ionuta.ionuta.ionuta@mail.mdion.ionutaionutaionutadion.ionuta.ionuta.ionsion.ionutaionutaionutadion.ionuta.ionuta.ionuta@mail.mdion.ionutaionutaionutadion.ionuta.ionuta.ionsion.ionutaionutaionutadion.ionuta.ionuta.ionuta@mail.mdion.ionutaionutaionutadion.ionuta.ionuta.ionsion.ionutaionutaionutadion.ionuta.ionuta.ionuta@mail.mdion.ionutaionutaionutadion.ionuta.ionuta.ionsion.ionutaionutaionutadion.ionuta.ionuta.ionuta@mail.mdion.ionutaionutaionutadion.ionuta.ionuta.ionsion.ionutaionutaionutadion.ionuta.ionuta.ionuta@mail.mdion.ionutaionutaionutadion.ionuta.ionuta.ions1";
        Message message = new Message("t123456789t12345678", "ionionuta.ionut@amail.md", text, 2);
        assertNotNull(message);
        Set<ConstraintViolation<Message>> constraintViolations = validator.validate(message, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(SIZE_MIN_3_AND_MAX_1000, constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void test1011MessageCaptchaIdNullValidation(){
        String text = "ion.ionu";
        Message message = new Message("t123456789t12345678", "ionionuta.ionut@amail.md", text, null);
        assertNotNull(message);
        Set<ConstraintViolation<Message>> constraintViolations = validator.validate(message, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(NOT_NULL, constraintViolations.iterator().next().getMessage());
    }



}