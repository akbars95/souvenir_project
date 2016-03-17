package com.mtsmda.souvenir.repository.impl.java_standard.repositoryTest;

import com.mtsmda.souvenir.exception.SouvenirRuntimeException;
import com.mtsmda.souvenir.model.Captcha;
import com.mtsmda.souvenir.repository.CaptchaRepository;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by dminzat on 3/16/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:text-mvc-dispatcher-servlet.xml")
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CaptchaRepositoryImplSPJavaStandardTest {

    @Autowired
    @Qualifier(value = "mySqlDataSource")
    private DataSource dataSource;

    @Autowired
    @Qualifier(value = "captchaRepositoryImplSPJavaStandard")
    private CaptchaRepository captchaRepository;

    private static Captcha captcha;

    private static Integer currentCaptchaId;

    @BeforeClass
    public static void initCaptcha() {
        captcha = new Captcha("cofdld", "/resources/img/image10.png");
    }

    @Test
    public void test1InsertCaptchaNormal() {
        boolean resultInsertCaptcha = captchaRepository.insertCaptcha(captcha);
        Assert.assertEquals("test insert captcha normal", true, resultInsertCaptcha);
    }

    @Test(expected = SouvenirRuntimeException.class)
    public void test2InsertCaptchaException() {
        Captcha captcha = null;
        Assert.assertNull("test insert captcha null", captcha);
        captchaRepository.insertCaptcha(captcha);
    }

    @Test(timeout = 900)
    public void test3GetMaxIdCaptcha() {
        Assert.assertNull(this.currentCaptchaId);
        this.currentCaptchaId = captchaRepository.getMaxIdCaptcha();
        Assert.assertNotNull(this.currentCaptchaId);
    }

    @Test(expected = SouvenirRuntimeException.class)
    public void test4UpdateCaptchaException() {
        captchaRepository.updateCaptcha(null);
    }

    @Test()
    public void test5UpdateCaptchaNormal() {
        Captcha captcha = new Captcha("gg", "img");
        captcha.setCaptchaId(this.currentCaptchaId);
        boolean b = captchaRepository.updateCaptcha(captcha);
        Assert.assertTrue("update last added captcha", b);
    }

    @Test(expected = SouvenirRuntimeException.class, timeout = 2500)
    public void test6UpdateCaptchaNullOneOfRequiredFiledsException() {
        Captcha captcha = new Captcha(null, "img");
        captcha.setCaptchaId(this.currentCaptchaId);
        boolean b = captchaRepository.updateCaptcha(captcha);
    }

    @Test(timeout = 2500)
    public void test7DeleteCaptchaNullIdFieldException() {
        Captcha captcha = new Captcha(null, "img");
        boolean b = captchaRepository.deleteCaptcha(captcha);
        Assert.assertFalse("captchaId field is NULL", b);
    }

    @Test(timeout = 2500)
    public void test8DeleteCaptchaNormal() {
        Captcha captcha = new Captcha(null, "img");
        captcha.setCaptchaId(currentCaptchaId);
        boolean b = captchaRepository.deleteCaptcha(captcha);
        Assert.assertTrue("normal delete", b);
    }

    @Test(timeout = 2500)
    public void test91DeleteCaptchaCaptchaIdNotFound() {
        Captcha captcha = new Captcha(null, "img");
        captcha.setCaptchaId(currentCaptchaId + 1000);
        boolean b = captchaRepository.deleteCaptcha(captcha);
        Assert.assertFalse("captchaId is not exists", b);
    }

    @Test(timeout = 2000)
    public void test92GetAllCaptchaNormal() {
        List<Captcha> allCaptcha = captchaRepository.getAllCaptcha();
        Assert.assertNotNull("all captchas", allCaptcha);
        Assert.assertTrue("captchas size > 0", allCaptcha.size() > 0);
        Captcha captchaLocal = allCaptcha.get(0);
        Assert.assertNotNull("captcha index 0 is not null", captchaLocal);
        captcha = captchaLocal;
    }

    @Test(timeout = 500)
    public void test93GetCaptchaById(){
        Captcha captchaById = captchaRepository.getCaptchaById(captcha.getCaptchaId());
        Assert.assertNotNull(captchaById);
        Assert.assertNotNull(captchaById.getCaptchaId());
        Assert.assertNotNull(captchaById.getCaptchaValue());
        Assert.assertNotNull(captchaById.getCaptchaUrlFile());
        Assert.assertEquals(captchaById, captcha);
    }

    @Test()
    public void test94GetRandomCaptcha(){
        Captcha randomCaptcha = captchaRepository.getRandomCaptcha(captcha);
        Assert.assertNotNull(randomCaptcha);
        Assert.assertNotNull(randomCaptcha.getCaptchaId());
        Assert.assertNull(randomCaptcha.getCaptchaValue());
        Assert.assertNotNull(randomCaptcha.getCaptchaUrlFile());
        Assert.assertNotEquals(randomCaptcha, captcha);
    }

    @Test()
    public void test95CheckCaptcha(){
        boolean b = captchaRepository.checkCaptcha(captcha);
        Assert.assertTrue(b);
    }

    @Test(expected = SouvenirRuntimeException.class)
    public void test96CheckCaptchaException(){
        Captcha captcha = null;
        boolean b = captchaRepository.checkCaptcha(captcha);
    }

    @Test()
    public void test97CheckCaptchaException(){
        captcha.setCaptchaId(null);
        boolean b = captchaRepository.checkCaptcha(captcha);
        Assert.assertFalse(b);
    }


}