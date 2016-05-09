package com.mtsmda.souvenir.controller.restController.locale;

import org.springframework.web.bind.annotation.*;

import java.util.Properties;

/**
 * Created by MTSMDA on 03.05.2016.
 */
//@RestController
public class LocaleRestController {

    @RequestMapping(value = "/a", method = RequestMethod.GET)
    public Properties getLocale(@RequestParam("lang") String language){
        Properties properties = new Properties();
        properties.put("name", "Ivan");
        System.out.println(language);
        return properties;
    }

    @RequestMapping(value = "/{lang}", method = RequestMethod.GET)
    public Properties getLocale2(@PathVariable("lang") String language){
        Properties properties = new Properties();
        properties.put("name", "Ivan");
        System.out.println(language);
        return properties;
    }


}