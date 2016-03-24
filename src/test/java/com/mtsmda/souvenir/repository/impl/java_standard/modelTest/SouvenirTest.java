package com.mtsmda.souvenir.repository.impl.java_standard.modelTest;

import com.mtsmda.souvenir.model.Souvenir;
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
        Set<ConstraintViolation<Souvenir>> constraintViolations = validator.validate(souvenir);
        assertEquals(1, constraintViolations.size());
    }

}