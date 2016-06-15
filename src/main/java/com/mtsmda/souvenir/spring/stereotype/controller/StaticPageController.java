package com.mtsmda.souvenir.spring.stereotype.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.mtsmda.souvenir.spring.stereotype.controller.constants.StaticPageConstants.*;

@Controller
public class StaticPageController {

    private static final Logger logger = Logger.getLogger(StaticPageController.class);

    /*@Autowired
    @Qualifier("appConfig")
    private AppConfig appConfig;*/

    @RequestMapping(value = {ROOT, HOME_URL, INDEX_URL}, method = RequestMethod.GET)
    public String indexPage() {
        logger.info("get " + INDEX_INTERNAL_FILE + " page");
/*

        if (MyFeatures.FEATURE_ONE.isActive()) {
            System.out.println("HERE IS - " + MyFeatures.FEATURE_ONE.isActive());
        } else {
            System.out.println("NO!");
        }

        if (MyFeatures.FEATURE_TWO.isActive()) {
            System.out.println("HERE IS - " + MyFeatures.FEATURE_TWO.isActive());
        } else {
            System.out.println("NO!");
        }

        System.out.println(appConfig.isFeatureOne());
        System.out.println(appConfig.isFeatureTwo());*/

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