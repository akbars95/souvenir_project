package com.mtsmda.souvenir.spring.stereotype.repository.impl.java_standard.repositoryTest;

import com.mtsmda.souvenir.exception.SouvenirRuntimeException;
import com.mtsmda.souvenir.model.SouvenirCategory;
import com.mtsmda.souvenir.spring.stereotype.repository.SouvenirCategoryRepository;
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
 * Created by dminzat on 3/17/2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SouvenirCategoryRepositoryImplSPJavaStandardTest extends ParentTest {

    @Autowired
    @Qualifier("souvenirCategoryRepositoryImplSPJavaStandard")
    private SouvenirCategoryRepository souvenirCategoryRepository;

    private static SouvenirCategory souvenirCategory = new SouvenirCategory();

    private static Integer index = -1;

    @BeforeClass
    public static void initSouvenirCategory(){
        souvenirCategory.setSouvenirCategory("thisIsTestCategory");
    }

    @Test
    public void test1000Init(){
        assertNotNull(souvenirCategoryRepository);
    }

    @Test
    public void test1001InsertSouvenirCategoryNormal(){
        assertNotNull(souvenirCategory);
        assertNull(souvenirCategory.getSouvenirCategoryId());
        assertNotNull(souvenirCategory.getSouvenirCategory());
        boolean b = souvenirCategoryRepository.insertSouvenirCategory(souvenirCategory);
        assertTrue(b);
    }

    @Test(expected = SouvenirRuntimeException.class)
    public void test1002InsertSouvenirCategoryException(){
        assertNotNull(souvenirCategory);
        assertNull(souvenirCategory.getSouvenirCategoryId());
        assertNotNull(souvenirCategory.getSouvenirCategory());
        SouvenirCategory local = souvenirCategory;
        local.setSouvenirCategory(null);
        boolean b = souvenirCategoryRepository.insertSouvenirCategory(local);
        assertTrue(b);
    }

    @Test()
    public void test1003GetAllSouvenirCategoryException(){
        List<SouvenirCategory> souvenirCategories = null;
        souvenirCategories = souvenirCategoryRepository.getAllSouvenirCategories();
        assertFalse(souvenirCategories.isEmpty());
        assertTrue(souvenirCategories.size() > 0);
        souvenirCategory = souvenirCategories.get(souvenirCategories.size() - 1);
        assertNotNull(souvenirCategory);
    }

    @Test()
    public void test1004UpdateSouvenirCategoryException(){
        assertNotNull(souvenirCategory);
        souvenirCategory.setSouvenirCategory("test1004");
        boolean b = souvenirCategoryRepository.updateSouvenirCategory(souvenirCategory);
        assertTrue(b);
        assertTrue(index.equals(-1));
        index = souvenirCategory.getSouvenirCategoryId();
        assertFalse(index.equals(-1));
    }

    @Test()
    public void test1005GetByIdSouvenirCategoryException(){
        assertNotNull(index);
        assertTrue(!index.equals(-1));
        souvenirCategory = souvenirCategoryRepository.getSouvenirCategory(index);
        assertNotNull(souvenirCategory);
    }

    @Test()
    public void test1006DeleteSouvenirCategoryException(){
        assertNotNull(souvenirCategory);
        assertTrue(index.equals(souvenirCategory.getSouvenirCategoryId()));
        boolean b = souvenirCategoryRepository.deleteSouvenirCategory(souvenirCategory);
        assertTrue(b);
    }

}