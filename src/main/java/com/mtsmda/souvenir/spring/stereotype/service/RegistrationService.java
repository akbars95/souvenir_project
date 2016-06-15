package com.mtsmda.souvenir.spring.stereotype.service;

import com.mtsmda.souvenir.spring.stereotype.object.request.RegistrationRO;

/**
 * Created by dminzat on 6/15/2016.
 */
public interface RegistrationService {

    boolean registration(RegistrationRO registrationRO);

}