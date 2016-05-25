package com.mtsmda.souvenir.model.sp;

import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;

import static com.mtsmda.souvenir.model.sp.SPConstant.IN;

/**
 * Created by MTSMDA on 19.11.2015.
 */
public class ValuteSP {

	/* stored procedure name */
	public static final String INSERT_VALUTE_SP_NAME = "insertValute";
	public static final String UPDATE_VALUTE_SP_NAME = "updateValute";
	public static final String DELETE_VALUTE = "deleteValute";
	public static final String GET_VALUTE_BY_ID_SP_NAME = "getValuteById";
	public static final String GET_ALL_VALUTES_SP_NAME = "getAllValutes";

	/* function name */

	/* column name */
	public static final String VALUTE_ID =  "valute_id";
	public static final String VALUTE_NAME =  "valute_name";
	public static final String VALUTE_CODE =  "valute_code";
	public static final String VALUTE_CHAR_CODE =  "valute_char_code";
	public static final String VALUTE_NOMINAL =  "valute_nominal";
	public static final String VALUTE_SYMBOL =  "valute_symbol";

	/* stored procedure parameter name */
	public static final String VALUTE_ID_IN_SP_PARAM_NAME = VALUTE_ID + IN;
	public static final String VALUTE_NAME_IN_SP_PARAM_NAME = VALUTE_NAME + IN;
	public static final String VALUTE_CODE_IN_SP_PARAM_NAME = VALUTE_CODE + IN;
	public static final String VALUTE_CHAR_CODE_IN_SP_PARAM_NAME = VALUTE_CHAR_CODE + IN;
	public static final String VALUTE_NOMINAL_IN_SP_PARAM_NAME = VALUTE_NOMINAL + IN;
	public static final String VALUTE_SYMBOL_IN_SP_PARAM_NAME = VALUTE_SYMBOL + IN;

}