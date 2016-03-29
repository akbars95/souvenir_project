package com.mtsmda.souvenir.model.sp;

import static com.mtsmda.souvenir.model.sp.SPConstant.IN;

public class SouvenirPhotoSP {
	
	/* stored procedure name */
	public static final String INSERT_SOUVENIR_PHOTO_SP_NAME = "insertSouvenirPhoto";
	public static final String UPDATE_SOUVENIR_PHOTO_SP_NAME = "updateSouvenirPhoto";
	public static final String DELETE_SOUVENIR_PHOTO_SP_NAME = "deleteSouvenirPhoto";
	public static final String GET_SOUVENIR_PHOTO_BY_ID_SP_NAME = "getSouvenirPhotoById";
	public static final String GET_SOUVENIR_PHOTOS_SP_NAME = "getSouvenirPhotos";

	/* function name */

	/* column name */
	public static final String SOUVENIR_PHOTO_ID =  "souvenir_photo_id";
	public static final String SOUVENIR_PHOTO_PATH =  "souvenir_photo_path";
	public static final String SOUVENIR_PHOTO_SOUVENIR_ID =  "souvenir_photo_souvenir_id";

	/* stored procedure parameter name */
	public static final String SOUVENIR_PHOTO_ID_IN_SP_PARAM_NAME = SOUVENIR_PHOTO_ID + IN;
	public static final String SOUVENIR_PHOTO_PATH_IN_SP_PARAM_NAME = SOUVENIR_PHOTO_PATH + IN;
	public static final String SOUVENIR_PHOTO_SOUVENIR_ID_IN_SP_PARAM_NAME = SOUVENIR_PHOTO_SOUVENIR_ID + IN;
	/* stored procedure parameter name java code*/
	
}