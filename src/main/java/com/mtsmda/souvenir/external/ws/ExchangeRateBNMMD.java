package com.mtsmda.souvenir.external.ws;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by dminzat on 5/13/2016.
 */
@Component("exchangeRateBNMMD")
public class ExchangeRateBNMMD {

    private static final StringBuilder RATE_URL_BNM = new StringBuilder("http://bnm.md/ro/official_exchange_rates?get_xml=1&date=");//10.05.2016

    public String getActualRateFromBNM(){
        LocalDate localDate = LocalDate.now();
        if(localDate.getDayOfWeek().equals(DayOfWeek.FRIDAY)){
            localDate = localDate.plusDays(3);
//            System.out.println(localDate.getDayOfWeek());
        }
        StringBuilder todayDate = new StringBuilder().append(localDate.getDayOfMonth() < 10 ? "0" + localDate.getDayOfMonth() : localDate.getDayOfMonth())
                .append(".").append(localDate.getMonth().getValue() < 10 ? "0" + localDate.getMonth().getValue() : localDate.getMonth().getValue()).append(".").append(localDate.getYear());
//        System.out.println(todayDate);
        String forObject = null;
        try{
            forObject = new RestTemplate().getForObject(RATE_URL_BNM.append(todayDate).toString(), String.class);
        }catch (HttpClientErrorException e){
            System.out.println(e.getMessage());
        }/*
        System.out.println(forObject);
        System.out.println("URL - " + RATE_URL_BNM.toString());*/
        return forObject;
    }

    /*public static void main(String[] args) {
        System.out.println(new ExchangeRateBNMMD().getActualRateFromBNM());
        *//*List<String> strings = new LinkedList<>();
        strings.add(null);
        System.out.println(strings.size());

        Set<String> strings1 = new HashSet<>();
        strings1.add(null);
        System.out.println(strings1.size());*//*
    }*/

}