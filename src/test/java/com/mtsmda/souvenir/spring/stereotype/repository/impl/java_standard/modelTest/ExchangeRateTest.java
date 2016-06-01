package com.mtsmda.souvenir.spring.stereotype.repository.impl.java_standard.modelTest;

import com.mtsmda.souvenir.model.ExchangeRate;

import static com.mtsmda.souvenir.spring.stereotype.repository.impl.java_standard.constants.TestConstants.DIGITS_CONSTRAINT_5_4;
import static com.mtsmda.souvenir.spring.stereotype.repository.impl.java_standard.constants.TestConstants.NOT_NULL;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.*;

import com.mtsmda.souvenir.validation.validators.sequence.SouvenirSequence;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.time.Month;
import java.util.Set;

/**
 * Created by dminzat on 5/12/2016.
 */
public class ExchangeRateTest {

    private Validator validator;

    @BeforeClass
    public void test1000SetUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test(priority = 0)
    public void test1001ExchangeRateDate(){
        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setExchangeRate(15.22);
        assertNull(exchangeRate.getExchangeRateDate());

        Set<ConstraintViolation<ExchangeRate>> constraintViolations = validator.validate(exchangeRate, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(NOT_NULL, constraintViolations.iterator().next().getMessage());

        exchangeRate.setExchangeRateDate(LocalDate.of(2015, Month.FEBRUARY, 28));
        assertNotNull(exchangeRate.getExchangeRateDate());

        constraintViolations = validator.validate(exchangeRate, SouvenirSequence.class);
        assertEquals(0, constraintViolations.size());
    }

    @Test(priority = 1)
    public void test1002ExchangeRate(){
        ExchangeRate exchangeRate = new ExchangeRate();
        assertNull(exchangeRate.getExchangeRateDate());

        exchangeRate.setExchangeRateDate(LocalDate.of(2015,Month.FEBRUARY, 20));

        Set<ConstraintViolation<ExchangeRate>> constraintViolations = validator.validate(exchangeRate, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(NOT_NULL, constraintViolations.iterator().next().getMessage());

        exchangeRate.setExchangeRate(123456.1234);
        assertNotNull(exchangeRate.getExchangeRateDate());

        constraintViolations = validator.validate(exchangeRate, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(DIGITS_CONSTRAINT_5_4, constraintViolations.iterator().next().getMessage());

        exchangeRate.setExchangeRate(12345.12345);
        assertNotNull(exchangeRate.getExchangeRateDate());

        constraintViolations = validator.validate(exchangeRate, SouvenirSequence.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(DIGITS_CONSTRAINT_5_4, constraintViolations.iterator().next().getMessage());

        exchangeRate.setExchangeRate(12345.1234);
        assertNotNull(exchangeRate.getExchangeRateDate());

        constraintViolations = validator.validate(exchangeRate, SouvenirSequence.class);
        assertEquals(0, constraintViolations.size());
    }

}