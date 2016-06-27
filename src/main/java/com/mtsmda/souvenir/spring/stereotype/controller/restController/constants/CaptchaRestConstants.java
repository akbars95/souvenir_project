package com.mtsmda.souvenir.spring.stereotype.controller.restController.constants;

import static com.mtsmda.souvenir.spring.stereotype.controller.constants.StaticPageConstants.ROOT;

public interface CaptchaRestConstants {

	public static final String UPDATE_CAPTCHA_PIECE = "update_captcha";
	public static final String CHECK_CAPTCHA_PIECE = "check_captcha";
	public static final String INIT_CAPTCHA_PIECE = "init_captcha";

	public static final String UPDATE_CAPTCHA_PIECE_URL = ROOT + UPDATE_CAPTCHA_PIECE;
	public static final String CHECK_CAPTCHA_PIECE_URL = ROOT + CHECK_CAPTCHA_PIECE;
	public static final String INIT_CAPTCHA_PIECE_URL = ROOT + INIT_CAPTCHA_PIECE;

}