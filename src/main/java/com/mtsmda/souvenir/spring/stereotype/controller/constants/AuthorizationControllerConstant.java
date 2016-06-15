package com.mtsmda.souvenir.spring.stereotype.controller.constants;

import static com.mtsmda.souvenir.spring.stereotype.controller.constants.StaticPageConstants.ROOT;

/**
 * Created by dminzat on 6/15/2016.
 */
public interface AuthorizationControllerConstant {

    //internal
    public static final String LOGIN_PAGE_INTERNAL_FILE = "login";
    public static final String ACCESS_DENIED_PAGE_INTERNAL_FILE = "access_denied";

    //external URL
    public static final String LOGIN_PAGE_URL = ROOT + LOGIN_PAGE_INTERNAL_FILE;
    public static final String ACCESS_DENIED_PAGE_URL = ROOT + ACCESS_DENIED_PAGE_INTERNAL_FILE;

}