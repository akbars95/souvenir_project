package com.mtsmda.souvenir.spring.stereotype.controller.restController;

import com.mtsmda.souvenir.spring.stereotype.controller.constants.StaticPageConstants;
import com.mtsmda.souvenir.spring.stereotype.object.request.RegistrationRO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MTSMDA on 11.06.2016.
 */
@RestController
public class RegistrationRestController {

    @RequestMapping(value = StaticPageConstants.REGISTRATION_US_URL, method = RequestMethod.POST)
    public String registration(@RequestBody RegistrationRO registrationRO){
        System.out.println("registrationRO - " + registrationRO);
        return "";
    }

}