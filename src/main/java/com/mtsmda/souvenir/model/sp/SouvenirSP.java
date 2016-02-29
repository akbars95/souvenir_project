package com.mtsmda.souvenir.model.sp;

import org.springframework.jdbc.core.SqlParameter;

import java.sql.Types;

import static com.mtsmda.souvenir.model.sp.SPConstant.*;

/**
 * Created by MTSMDA on 19.11.2015.
 */
public class SouvenirSP {

	/* stored procedure name */
	public static final String GET_ALL_SOUVENIRS_SP_NAME = "getAllSouvenirs";
	public static final String SELECT_SOUVENIR_SP_NAME = "selectSouvenir";
	public static final String SELECT_FULL_SOUVENIR_WITH_CATEGORY_AND_AUDIT_SP_NAME = "selectFullSouvenirWithCategoryAndAudit";

	/* function name */

	/* column name */
	public static final String SOUVENIR_ID =  "souvenir_id";
	public static final String SOUVENIR_NAME =  "souvenir_name";
	public static final String SOUVENIR_DESCRIPTION =  "souvenir_description";
	public static final String SOUVENIR_SHOW =  "souvenir_show";
	public static final String SOUVENIR_PATH =  "souvenir_path";
	public static final String SOUVENIR_CATEGORY_ID =  "souvenir_category_id";
	public static final String SOUVENIR_PRICE =  "souvenir_price";
	public static final String SOUVENIR_COUNT_OF_DAYS_FOR_ORDER =  "souvenir_count_of_days_for_order";

	/* stored procedure parameter name */
	public static final String SOUVENIR_ID_IN_SP_PARAM_NAME = SOUVENIR_ID + IN;
	public static final String SOUVENIR_NAME_IN_SP_PARAM_NAME = SOUVENIR_NAME + IN;
	public static final String SOUVENIR_DESCRIPTION_IN_SP_PARAM_NAME = SOUVENIR_DESCRIPTION + IN;
	public static final String SOUVENIR_SHOW_IN_SP_PARAM_NAME = SOUVENIR_SHOW + IN;
	public static final String SOUVENIR_PATH_IN_SP_PARAM_NAME = SOUVENIR_PATH + IN;
	public static final String SOUVENIR_CATEGORY_ID_IN_SP_PARAM_NAME = SOUVENIR_CATEGORY_ID + IN;
	public static final String SOUVENIR_PRICE_IN_SP_PARAM_NAME = SOUVENIR_PRICE + IN;
	public static final String SOUVENIR_COUNT_OF_DAYS_FOR_ORDER_IN_SP_PARAM_NAME = SOUVENIR_COUNT_OF_DAYS_FOR_ORDER + IN;

	/* stored procedure parameter name java code*/
	public static final SqlParameter SOUVENIR_ID_IN_SP_SQL_PARAM = new SqlParameter(SOUVENIR_ID_IN_SP_PARAM_NAME,
			Types.INTEGER);

}