package com.mtsmda.souvenir.spring.stereotype.repository.impl.java_standard.restController;

import com.mtsmda.souvenir.spring.stereotype.repository.impl.java_standard.ParentTest;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by dminzat on 3/29/2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CatalogRestControllerTest extends ParentTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private MockHttpSession mockHttpSession;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void test1000GetAllSouvenirs() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("/get_all_souvenirs", String.class);
        System.out.println(forObject);
        this.mockMvc.perform(get("/get_all_souvenirs"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON + ";charset=UTF-8"))
                .andExpect(jsonPath("[0]['souvenirId']").value(1))
                .andExpect(jsonPath("[0]['souvenirMainPhotoId'].souvenirPhotoId").value(0))
                .andExpect(jsonPath("$.length()").value(20));
    }

    @PostConstruct
    public void init(){
        System.out.println("init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy");
    }

}