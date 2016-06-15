package com.mtsmda.souvenir.spring.stereotype.controller;

import com.mtsmda.souvenir.spring.stereotype.controller.constants.AuthorizationControllerConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by MTSMDA on 28.05.2016.
 */
@Controller
public class AuthorizationController implements AuthorizationControllerConstant{

    @RequestMapping(value = LOGIN_PAGE_URL, method = RequestMethod.GET)
    public String getLoginPage() {
        return LOGIN_PAGE_INTERNAL_FILE;
    }

    @RequestMapping(value = ACCESS_DENIED_PAGE_URL, method = RequestMethod.GET)
    public String getAccessDeniedPage() {
        return ACCESS_DENIED_PAGE_INTERNAL_FILE;
    }

}