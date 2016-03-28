package com.mtsmda.souvenir.controller;

import com.mtsmda.souvenir.toggleFeature.AppConfig;
import com.mtsmda.souvenir.toggleFeature.MyFeatures;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.mtsmda.souvenir.controller.constants.StaticPageConstants.*;

@Controller
public class StaticPageController {

    private static final Logger logger = Logger.getLogger(StaticPageController.class);

    /*@Autowired
    @Qualifier("appConfig")
    private AppConfig appConfig;*/

    @RequestMapping(value = {ROOT, HOME_URL, INDEX_URL}, method = RequestMethod.GET)
    public String indexPage() {
        logger.info("get " + INDEX + " page");
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

        return INDEX;
    }

    @RequestMapping(value = {CATALOG_URL}, method = RequestMethod.GET)
    public String catalogPage() {
        logger.info("get " + CATALOG + " page");
        return CATALOG;
    }

    @RequestMapping(value = {ABOUT_US_URL}, method = RequestMethod.GET)
    public String aboutUsPage() {
        logger.info("get " + ABOUT_US + " page");
        return ABOUT_US;
    }

    @RequestMapping(value = {CONTACT_US_URL}, method = RequestMethod.GET)
    public String contactUsPage() {
        logger.info("get " + CONTACT_US + " page");
        return CONTACT_US;
    }

}