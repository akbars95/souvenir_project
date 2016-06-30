package com.mtsmda.souvenir.spring.stereotype.controller.restController;

import com.mtsmda.souvenir.spring.stereotype.controller.constants.StaticPageConstants;
import com.mtsmda.souvenir.spring.stereotype.controller.response.ResponseCode;
import com.mtsmda.souvenir.spring.stereotype.controller.response.SouvenirResponseObject;
import com.mtsmda.souvenir.spring.stereotype.object.request.RegistrationRO;
import com.mtsmda.souvenir.spring.stereotype.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MTSMDA on 11.06.2016.
 */
@RestController
@RequestMapping(value = StaticPageConstants.REST_PATH_URL)
public class RegistrationRestController {

    @Autowired
    @Qualifier("registrationService")
    private RegistrationService registrationService;

    @RequestMapping(value = StaticPageConstants.REGISTRATION_URL, method = RequestMethod.POST)
    public SouvenirResponseObject registration(@RequestBody RegistrationRO registrationRO){
        System.out.println("registrationRO - " + registrationRO);
        boolean registration = registrationService.registration(registrationRO);
        if(!registration){
            return new SouvenirResponseObject(ResponseCode.RESPONSE_REGISTRATION_ERROR_CODE, null);
        }
        return new SouvenirResponseObject(ResponseCode.RESPONSE_REGISTRATION_OK_CODE, null);
    }

}