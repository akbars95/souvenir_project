package com.mtsmda.souvenir.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.mtsmda.souvenir.controller.constants.StaticPageConstants.*;

@Controller
public class StaticPageController {

	private static final Logger logger = Logger.getLogger(StaticPageController.class);

	@RequestMapping(value = { ROOT, HOME_URL, INDEX_URL }, method = RequestMethod.GET)
	public String indexPage() {
		logger.info("get " + INDEX + " page");
		return INDEX;
	}

	@RequestMapping(value = { CATALOG_URL }, method = RequestMethod.GET)
	public String catalogPage() {
		logger.info("get " + CATALOG + " page");
		return CATALOG;
	}

	@RequestMapping(value = { ABOUT_US_URL }, method = RequestMethod.GET)
	public String aboutUsPage() {
		logger.info("get " + ABOUT_US + " page");
		return ABOUT_US;
	}

	@RequestMapping(value = { CONTACT_US_URL }, method = RequestMethod.GET)
	public String contactUsPage() {
		logger.info("get " + CONTACT_US + " page");
		return CONTACT_US;
	}

}