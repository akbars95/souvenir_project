package com.mtsmda.souvenir.spring.stereotype.controller.constants;

public interface StaticPageConstants {

	public static final String OPEN_BRACE = "{";
	public static final String CLOSE_BRACE = "}";

	public static final String ROOT = "/";

	public static final String ROOT_CATALOG = "*";

	public static final String ROOT_SUB_CATALOG = ROOT_CATALOG + ROOT_CATALOG;

	public static final String INDEX_INTERNAL_FILE = "index";
	public static final String INDEX_URL = ROOT + INDEX_INTERNAL_FILE;
	public static final String HOME_URL = ROOT + "home";

	public static final String CATALOG_INTERNAL_FILE = "catalog";
	public static final String CATALOG_URL = ROOT + CATALOG_INTERNAL_FILE;

	public static final String ABOUT_US_INTERNAL_FILE = "about_us";
	public static final String ABOUT_US_URL = ROOT + ABOUT_US_INTERNAL_FILE;

	public static final String CONTACT_US_INTERNAL_FILE = "contact_us";
	public static final String CONTACT_US_URL = ROOT + CONTACT_US_INTERNAL_FILE;

	public static final String REGISTRATION_INTERNAL_FILE = "registration";
	public static final String REGISTRATION_URL = ROOT + REGISTRATION_INTERNAL_FILE;

	public static final String REST_PATH_URL = ROOT + "rest";

}