package com.mtsmda.souvenir.testNG.test.spring;

import com.mtsmda.souvenir.spring.stereotype.repository.CaptchaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by dminzat on 5/7/2016.
 */
@Test
@ContextConfiguration(locations = "classpath:/text-mvc-dispatcher-servlet.xml")
public class SpringTestNGTest extends AbstractTransactionalTestNGSpringContextTests{

    @Autowired
    @Qualifier(value = "captchaRepositoryImplSPJavaStandard")
    private CaptchaRepository captchaRepository;

    @Test
    public void test1001(){
        System.out.println(captchaRepository == null);
        Assert.assertNotNull(captchaRepository);
    }

}