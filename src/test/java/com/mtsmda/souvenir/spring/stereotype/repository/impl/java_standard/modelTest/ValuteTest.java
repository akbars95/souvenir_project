package com.mtsmda.souvenir.spring.stereotype.repository.impl.java_standard.modelTest;

import com.mtsmda.souvenir.model.Valute;
import com.mtsmda.souvenir.spring.validation.validators.sequence.SouvenirSequence;
import com.mtsmda.souvenir.valute.ValuteBorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static com.mtsmda.souvenir.spring.stereotype.repository.impl.java_standard.constants.TestConstants.*;
import static org.testng.Assert.*;

/**
 * Created by dminzat on 5/17/2016.
 */
@Test
@ContextConfiguration(locations = "classpath:/text-mvc-dispatcher-servlet.xml")
public class ValuteTest  extends AbstractTransactionalTestNGSpringContextTests {
    private Validator validator;

    @Autowired
    @Qualifier("valuteBorder")
    private ValuteBorder valuteBorder;

    @BeforeClass
    public void test1000SetUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test(priority = 0)
    public void test1001ValuteName(){
        Valute valute = new Valute();
        valute.setDefaultValuesForFields();
        valute.setValuteName(null);
        assertNull(valute.getValuteName());

        Set<ConstraintViolation<Valute>> constraintViolations = validator.validate(valute, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(NOT_NULL, constraintViolations.iterator().next().getMessage());

        valute.setValuteName("1");
        constraintViolations = validator.validate(valute, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(SIZE_MIN_2_AND_MAX_50, constraintViolations.iterator().next().getMessage());

        valute.setValuteName("123456789012345678901234567890123456789012345678901234567890");
        constraintViolations = validator.validate(valute, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(SIZE_MIN_2_AND_MAX_50, constraintViolations.iterator().next().getMessage());

        valute.setValuteName("123456789012345678901234567890123456789012345678901234567890");
        constraintViolations = validator.validate(valute, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(SIZE_MIN_2_AND_MAX_50, constraintViolations.iterator().next().getMessage());
    }

    @Test(priority = 1)
    public void test1002ValuteCharCode(){
        Valute valute = new Valute();
        valute.setDefaultValuesForFields();
        valute.setValuteCharCode(null);
        assertNull(valute.getValuteCharCode());

        Set<ConstraintViolation<Valute>> constraintViolations = validator.validate(valute, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(NOT_NULL, constraintViolations.iterator().next().getMessage());

        valute.setValuteCharCode("");
        constraintViolations = validator.validate(valute, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(SIZE_MIN_1_AND_MAX_50, constraintViolations.iterator().next().getMessage());

        valute.setValuteName("123456789012345678901234567890123456789012345678901234567890");
        constraintViolations = validator.validate(valute, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(SIZE_MIN_1_AND_MAX_50, constraintViolations.iterator().next().getMessage());

        valute.setValuteName("1234567890123456789012345678901234567");
        constraintViolations = validator.validate(valute, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(SIZE_MIN_1_AND_MAX_50, constraintViolations.iterator().next().getMessage());
    }
}