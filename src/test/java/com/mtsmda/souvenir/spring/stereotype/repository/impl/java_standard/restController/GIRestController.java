package com.mtsmda.souvenir.spring.stereotype.repository.impl.java_standard.restController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Created by dminzat on 4/11/2016.
 */
public class GIRestController {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        int responceCode200 = 0;
        for (int i = 0; i < 1_000; i++) {
            System.out.println("loop# " + i);
            ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://gagauzinfo.md/index.php?do=search", null, String.class);
//            System.out.println(stringResponseEntity.getStatusCode().value());
            if(stringResponseEntity.getStatusCode().value() == 200){
                responceCode200++;
            }
        /*for (String key : stringResponseEntity.getHeaders().keySet()){
            System.out.println("Key - " + key + " _____ ");
            System.out.print("\t\tValues - ");
            for(String s : stringResponseEntity.getHeaders().get(key)){
                System.out.print(s + ";\t");
            }
            System.out.println();
        }*/
        }
        System.out.println("responceCode200 - " + responceCode200);
    }

}