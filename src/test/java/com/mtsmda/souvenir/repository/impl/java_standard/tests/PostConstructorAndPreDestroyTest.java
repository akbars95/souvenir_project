package com.mtsmda.souvenir.repository.impl.java_standard.tests;

import com.mtsmda.souvenir.controller.restController.TestRestController;
import com.mtsmda.souvenir.repository.impl.java_standard.ParentTest;
import com.mtsmda.souvenir.tests.PostConstructorAndPreDestroy;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dminzat on 4/25/2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Component
public class PostConstructorAndPreDestroyTest extends ParentTest {

    private List<PostConstructorAndPreDestroy> postConstructorAndPreDestroys = new ArrayList<>();

    @Autowired
    private TestRestController testRestController;

    @Ignore
    @Test
    public void test100Init() {
        for (int i = 0; i < 5; i++) {
            PostConstructorAndPreDestroy postConstructorAndPreDestroy = new PostConstructorAndPreDestroy();
            postConstructorAndPreDestroys.add(postConstructorAndPreDestroy);
        }
    }

    @Ignore
    @Test
    public void test101Destroy() {
        for (PostConstructorAndPreDestroy postConstructorAndPreDestroy : postConstructorAndPreDestroys) {

        }
    }

    @PostConstruct
    public void init() {
        System.out.println("initPostConstruct@PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroyPreDestroy@PreDestroy");
    }

    @Test
    public void test102() {
//        Assert.assertNotNull(testRestController);
    }
}