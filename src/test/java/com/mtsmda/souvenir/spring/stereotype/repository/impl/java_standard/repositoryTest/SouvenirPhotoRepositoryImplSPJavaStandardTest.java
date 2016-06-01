package com.mtsmda.souvenir.spring.stereotype.repository.impl.java_standard.repositoryTest;

import com.mtsmda.souvenir.exception.SouvenirRuntimeException;
import com.mtsmda.souvenir.model.Souvenir;
import com.mtsmda.souvenir.model.SouvenirPhoto;
import com.mtsmda.souvenir.spring.stereotype.repository.SouvenirPhotoRepository;
import com.mtsmda.souvenir.spring.stereotype.repository.SouvenirRepository;
import com.mtsmda.souvenir.spring.stereotype.repository.impl.java_standard.ParentTest;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by dminzat on 3/29/2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SouvenirPhotoRepositoryImplSPJavaStandardTest extends ParentTest {

    @Autowired
    @Qualifier("SouvenirPhotoRepositoryImplSPJavaStandard")
    private SouvenirPhotoRepository souvenirPhotoRepository;

    @Autowired
    @Qualifier("souvenirRepositoryImplSPJavaStandard")
    private SouvenirRepository souvenirRepository;

    private static SouvenirPhoto souvenirPhoto = new SouvenirPhoto();
    private static Souvenir souvenir;

    @BeforeClass
    public static void initSouvenirPhoto() {
        souvenirPhoto.setSouvenirPhotoPath("/img/new1/srg.jpg");
    }

    @Test
    public void test1000Init() {
        assertNotNull(souvenirPhotoRepository);
        assertNotNull(souvenirRepository);
        List<Souvenir> allSouvenir = souvenirRepository.getAllSouvenir();
        assertNotNull(allSouvenir);
        assertFalse(allSouvenir.isEmpty());
        assertTrue(allSouvenir.size() > 0);
        assertNull(souvenir);
        souvenir = allSouvenir.get(0);
        assertNotNull(souvenir);
        assertNotNull(souvenir.getSouvenirId());
    }

    @Ignore
    @Test
    public void test1001InsertSouvenirPhoto() {
        assertNotNull(souvenirPhoto);
        assertNotNull(souvenirPhoto.getSouvenirPhotoPath());
        souvenirPhoto.setSouvenir(souvenir);
        boolean b = souvenirPhotoRepository.insertSouvenirPhoto(souvenirPhoto);
        assertTrue(b);
    }

    @Ignore
    @Test(expected = SouvenirRuntimeException.class)
    public void test1002InsertSouvenirPhotoException() {
        assertNotNull(souvenirPhoto);
        assertNotNull(souvenirPhoto.getSouvenirPhotoPath());
        souvenirPhoto.setSouvenir(null);
        souvenirPhotoRepository.insertSouvenirPhoto(souvenirPhoto);
    }

}