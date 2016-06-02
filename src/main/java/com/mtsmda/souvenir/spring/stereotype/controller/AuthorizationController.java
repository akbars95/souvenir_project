package com.mtsmda.souvenir.spring.stereotype.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by MTSMDA on 28.05.2016.
 */
@Controller
public class AuthorizationController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/access_denied", method = RequestMethod.GET)
    public String getAccessDeniedPage() {
        return "access_denied";
    }

   /* @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String getLogoutPage() {
        return "logout";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String getLogoutPagePOST() {
        return "logout";
    }*/

}