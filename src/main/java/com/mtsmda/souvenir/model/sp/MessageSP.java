package com.mtsmda.souvenir.model.sp;

import static com.mtsmda.souvenir.model.sp.SPConstant.IN;

import java.sql.Types;

import org.springframework.jdbc.core.SqlParameter;

public class MessageSP {

	/* stored procedure name */
	public static final String INSERT_MESSAGE_SP_NAME = "insertMessage";

	/* function name */

	/* column name */
	public static final String MESSAGE_ID = "message_id";
	public static final String MESSAGE_NAME = "message_name";
	public static final String MESSAGE_EMAIL = "message_email";
	public static final String MESSAGE_TEXT_M = "message_text_m";
	public static final String MESSAGE_CAPTCHA_ID = "message_captcha_id";

	/* stored procedure parameter name */
	public static final String MESSAGE_ID_IN_SP_PARAM_NAME = MESSAGE_ID + IN;
	public static final String MESSAGE_NAME_IN_SP_PARAM_NAME = MESSAGE_NAME + IN;
	public static final String MESSAGE_EMAIL_IN_SP_PARAM_NAME = MESSAGE_EMAIL + IN;
	public static final String MESSAGE_TEXT_M_IN_SP_PARAM_NAME = MESSAGE_TEXT_M + IN;
	public static final String MESSAGE_CAPTCHA_ID_IN_SP_PARAM_NAME = MESSAGE_CAPTCHA_ID + IN;

	/* stored procedure parameter name java code*/
	public static final SqlParameter MESSAGE_ID_IN_SP_SQL_PARAM = new SqlParameter(MESSAGE_ID_IN_SP_PARAM_NAME,
			Types.INTEGER);
	public static final SqlParameter MESSAGE_NAME_IN_SP_SQL_PARAM = new SqlParameter(MESSAGE_NAME_IN_SP_PARAM_NAME,
			Types.VARCHAR);
	public static final SqlParameter MESSAGE_EMAIL_IN_SP_SQL_PARAM = new SqlParameter(MESSAGE_EMAIL_IN_SP_PARAM_NAME,
			Types.VARCHAR);
	public static final SqlParameter MESSAGE_TEXT_M_IN_SP_SQL_PARAM = new SqlParameter(MESSAGE_TEXT_M_IN_SP_PARAM_NAME,
			Types.VARCHAR);
	public static final SqlParameter MESSAGE_CAPTCHA_ID_IN_SP_SQL_PARAM = new SqlParameter(
			MESSAGE_CAPTCHA_ID_IN_SP_PARAM_NAME, Types.INTEGER);

}