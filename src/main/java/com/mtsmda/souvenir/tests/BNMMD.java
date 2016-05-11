package com.mtsmda.souvenir.tests;

import org.springframework.web.client.RestTemplate;

/**
 * Created by MTSMDA on 10.05.2016.
 */
public class BNMMD {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("http://bnm.md/ro/official_exchange_rates?get_xml=1&date=10.05.2016", String.class);
        System.out.println(forObject);
    }

}