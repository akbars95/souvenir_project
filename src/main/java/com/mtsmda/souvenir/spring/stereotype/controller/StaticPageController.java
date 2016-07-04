package com.mtsmda.souvenir.spring.stereotype.controller;

import com.mtsmda.souvenir.spring.stereotype.DefaultTransactionTimeOut;
import com.mtsmda.souvenir.spring.stereotype.DefaultTransactionTimeOut2;
import com.mtsmda.souvenir.spring.stereotype.controller.constants.StaticPageConstants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StaticPageController implements StaticPageConstants{

    @Autowired
    @Qualifier("defaultTransactionTimeOut2")
    private DefaultTransactionTimeOut2 defaultTransactionTimeOut2;

    private static final Logger logger = Logger.getLogger(StaticPageController.class);

    @RequestMapping(value = {ROOT, HOME_URL, INDEX_URL}, method = RequestMethod.GET)
    public String indexPage() {
        logger.info("get " + INDEX_INTERNAL_FILE + " page");
        System.out.println("small - " + DefaultTransactionTimeOut.small);
        System.out.println("medium - " + DefaultTransactionTimeOut.medium);

        System.out.println("small - " + defaultTransactionTimeOut2.getSmall());
        System.out.println("medium - " + defaultTransactionTimeOut2.getMedium());

        return INDEX_INTERNAL_FILE;
    }

    @RequestMapping(value = {CATALOG_URL}, method = RequestMethod.GET)
    public String catalogPage() {
        logger.info("get " + CATALOG_INTERNAL_FILE + " page");
        return CATALOG_INTERNAL_FILE;
    }

    @RequestMapping(value = {ABOUT_US_URL}, method = RequestMethod.GET)
    public String aboutUsPage() {
        logger.info("get " + ABOUT_US_INTERNAL_FILE + " page");
        return ABOUT_US_INTERNAL_FILE;
    }

    @RequestMapping(value = {CONTACT_US_URL}, method = RequestMethod.GET)
    public String contactUsPage() {
        logger.info("get " + CONTACT_US_INTERNAL_FILE + " page");
        return CONTACT_US_INTERNAL_FILE;
    }

    @RequestMapping(value = {REGISTRATION_URL}, method = RequestMethod.GET)
    public String registrationPage() {
        logger.info("get " + REGISTRATION_INTERNAL_FILE + " page");
        return REGISTRATION_INTERNAL_FILE;
    }

}