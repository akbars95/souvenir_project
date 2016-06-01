package com.mtsmda.souvenir.spring.stereotype.repository.impl.java_standard.restController;

import com.mtsmda.souvenir.spring.stereotype.repository.impl.java_standard.ParentTest;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by MTSMDA on 28.03.2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CaptchaRestControllerTest extends ParentTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private MockHttpSession mockHttpSession;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    /*@PostConstruct
    public void init(){
        System.out.println("init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy");
    }*/




}