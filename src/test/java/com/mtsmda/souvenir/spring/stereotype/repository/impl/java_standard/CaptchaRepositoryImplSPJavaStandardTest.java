package com.mtsmda.souvenir.spring.stereotype.repository.impl.java_standard;

import com.mtsmda.souvenir.exception.SouvenirRuntimeException;
import com.mtsmda.souvenir.model.Captcha;
import com.mtsmda.souvenir.spring.stereotype.repository.CaptchaRepository;
import com.mtsmda.souvenir.spring.stereotype.repository.impl.java_standard.ParentTest;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

import static org.junit.Assert.*;


/**
 * Created by dminzat on 3/16/2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CaptchaRepositoryImplSPJavaStandardTest extends ParentTest {

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
        assertEquals("test insert captcha normal", true, resultInsertCaptcha);
    }

    @Test(expected = SouvenirRuntimeException.class)
    public void test2InsertCaptchaException() {
        Captcha captcha = null;
        assertNull("test insert captcha null", captcha);
        captchaRepository.insertCaptcha(captcha);
    }

    @Test(timeout = 900)
    public void test3GetMaxIdCaptcha() {
        assertNull(this.currentCaptchaId);
        this.currentCaptchaId = captchaRepository.getMaxIdCaptcha();
        assertNotNull(this.currentCaptchaId);
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
        assertTrue("update last added captcha", b);
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
        assertFalse("captchaId field is NULL", b);
    }

    @Test(timeout = 2500)
    public void test8DeleteCaptchaNormal() {
        Captcha captcha = new Captcha(null, "img");
        captcha.setCaptchaId(currentCaptchaId);
        boolean b = captchaRepository.deleteCaptcha(captcha);
        assertTrue("normal delete", b);
    }

    @Test(timeout = 2500)
    public void test91DeleteCaptchaCaptchaIdNotFound() {
        Captcha captcha = new Captcha(null, "img");
        captcha.setCaptchaId(currentCaptchaId + 1000);
        boolean b = captchaRepository.deleteCaptcha(captcha);
        assertFalse("captchaId is not exists", b);
    }

    @Test(timeout = 2000)
    public void test92GetAllCaptchaNormal() {
        List<Captcha> allCaptcha = captchaRepository.getAllCaptcha();
        assertNotNull("all captchas", allCaptcha);
        assertTrue("captchas size > 0", allCaptcha.size() > 0);
        Captcha captchaLocal = allCaptcha.get(0);
        assertNotNull("captcha index 0 is not null", captchaLocal);
        captcha = captchaLocal;
    }

    @Test(timeout = 500)
    public void test93GetCaptchaById(){
        Captcha captchaById = captchaRepository.getCaptchaById(captcha.getCaptchaId());
        assertNotNull(captchaById);
        assertNotNull(captchaById.getCaptchaId());
        assertNotNull(captchaById.getCaptchaValue());
        assertNotNull(captchaById.getCaptchaUrlFile());
        assertEquals(captchaById, captcha);
    }

    @Test()
    public void test94GetRandomCaptcha(){
        Captcha randomCaptcha = captchaRepository.getRandomCaptcha(captcha);
        assertNotNull(randomCaptcha);
        assertNotNull(randomCaptcha.getCaptchaId());
        assertNull(randomCaptcha.getCaptchaValue());
        assertNotNull(randomCaptcha.getCaptchaUrlFile());
        assertNotEquals(randomCaptcha, captcha);
    }

    @Test()
    public void test95CheckCaptcha(){
        assertNotNull(captchaRepository.checkCaptcha(captcha));
    }

    @Test(expected = SouvenirRuntimeException.class)
    public void test96CheckCaptchaException(){
        Captcha captcha = null;
        assertNotNull(captchaRepository.checkCaptcha(captcha));
    }

    @Test()
    public void test97CheckCaptchaException(){
        captcha.setCaptchaId(null);
        assertNotNull(captchaRepository.checkCaptcha(captcha));
    }


}