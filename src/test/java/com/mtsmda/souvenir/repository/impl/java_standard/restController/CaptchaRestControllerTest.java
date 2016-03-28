package com.mtsmda.souvenir.repository.impl.java_standard.restController;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by MTSMDA on 28.03.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:text-mvc-dispatcher-servlet.xml")
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CaptchaRestControllerTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private MockHttpSession mockHttpSession;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc =
                MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void read_method_should_return_correct_cart_Json_object()
            throws Exception {
        //Arrange
        this.mockMvc.perform(put("/rest/cart/add/P1234").session(mockHttpSession))
                .andExpect(status().is(204));
        //Act
        this.mockMvc.perform(get("/rest/cart/").session(mockHttpSession))
                .andExpect(status().isOk()).andExpect(jsonPath("$.cartItems.P1234.product.productId").value("P1234"));
    }


}