package com.mtsmda.souvenir.testNG.test.validation.structural;

import com.mtsmda.souvenir.spring.validation.structural.StructuralValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * Created by dminzat on 6/14/2016.
 */
@Test
@ContextConfiguration(classes = {})
public class StructuralValidationImplTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    @Qualifier(value = "structuralValidationImpl")
    private StructuralValidation structuralValidation;

}