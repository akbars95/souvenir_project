package com.mtsmda.souvenir.model.sp;

import static com.mtsmda.souvenir.model.sp.SPConstant.*;

import java.sql.Types;

import org.springframework.jdbc.core.SqlParameter;

public class CaptchaSP {

	/* stored procedure name */
	public static final String INSERT_CAPTCHA_SP_NAME = "insertCaptcha";
	public static final String UPDATE_CAPTCHA_SP_NAME = "updateCaptcha";
	public static final String DELETE_CAPTCHA_SP_NAME = "deleteCaptcha";
	public static final String GET_CAPTCHA_BY_ID_SP_NAME = "getCaptchaById";
	public static final String GET_ALL_CAPTCHA_SP_NAME = "getAllCaptcha";
	public static final String GET_RANDOM_CAPTCHA_SP_NAME = "getRandomCaptcha";
	public static final String CHECK_CAPTCHA_SP_NAME = "checkCaptcha";

	/* function name */
	public static final String GET_MAX_ID_CAPTCHA_FN_NAME = "getMaxIdCaptcha";

	/* column name */
	public static final String CAPTCHA_ID = "captcha_id";
	public static final String CAPTCHA_VALUE = "captcha_value";
	public static final String CAPTCHA_URL_FILE = "captcha_url_file";

	/* stored procedure parameter name */
	public static final String CAPTCHA_ID_IN_SP_PARAM_NAME = CAPTCHA_ID + IN;
	public static final String CAPTCHA_VALUE_IN_SP_PARAM_NAME = CAPTCHA_VALUE + IN;
	public static final String CAPTCHA_URL_FILE_IN_SP_PARAM_NAME = CAPTCHA_URL_FILE + IN;

	/* stored procedure parameter name java code*/
	public static final SqlParameter CAPTCHA_ID_IN_SP_SQL_PARAM = new SqlParameter(CAPTCHA_ID_IN_SP_PARAM_NAME,
			Types.INTEGER);
	public static final SqlParameter CAPTCHA_VALUE_IN_SP_SQL_PARAM = new SqlParameter(CAPTCHA_VALUE_IN_SP_PARAM_NAME,
			Types.VARCHAR);
	public static final SqlParameter CAPTCHA_URL_FILE_IN_SP_SQL_PARAM = new SqlParameter(
			CAPTCHA_URL_FILE_IN_SP_PARAM_NAME, Types.VARCHAR);

}