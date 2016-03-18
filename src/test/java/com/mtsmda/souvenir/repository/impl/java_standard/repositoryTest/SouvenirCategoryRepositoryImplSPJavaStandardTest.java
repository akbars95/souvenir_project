package com.mtsmda.souvenir.repository.impl.java_standard.repositoryTest;

import com.mtsmda.souvenir.exception.SouvenirRuntimeException;
import com.mtsmda.souvenir.model.SouvenirCategory;
import com.mtsmda.souvenir.repository.SouvenirCategoryRepository;
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

/**
 * Created by dminzat on 3/17/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:text-mvc-dispatcher-servlet.xml")
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SouvenirCategoryRepositoryImplSPJavaStandardTest {

    @Autowired
    @Qualifier("souvenirCategoryRepositoryImplSPJavaStandard")
    private SouvenirCategoryRepository souvenirCategoryRepository;

    private static SouvenirCategory souvenirCategory = new SouvenirCategory();

    @BeforeClass
    public static void initSouvenirCategory(){
        souvenirCategory.setSouvenirCategory("thisIsTestCategory");
    }

    @Test
    public void test1000Init(){
        Assert.assertNotNull(souvenirCategoryRepository);
    }

    @Test
    public void test1001InsertSouvenirCategoryNormal(){
        Assert.assertNotNull(souvenirCategory);
        Assert.assertNull(souvenirCategory.getSouvenirCategoryId());
        Assert.assertNotNull(souvenirCategory.getSouvenirCategory());
        boolean b = souvenirCategoryRepository.insertSouvenirCategory(souvenirCategory);
        Assert.assertTrue(b);
    }

    @Test(expected = SouvenirRuntimeException.class)
    public void test1002InsertSouvenirCategoryException(){
        Assert.assertNotNull(souvenirCategory);
        Assert.assertNull(souvenirCategory.getSouvenirCategoryId());
        Assert.assertNotNull(souvenirCategory.getSouvenirCategory());
        SouvenirCategory local = souvenirCategory;
        local.setSouvenirCategory(null);
        boolean b = souvenirCategoryRepository.insertSouvenirCategory(local);
        Assert.assertTrue(b);
    }

}