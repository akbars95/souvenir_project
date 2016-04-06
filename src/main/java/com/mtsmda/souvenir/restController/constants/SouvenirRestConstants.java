package com.mtsmda.souvenir.restController.constants;

import static com.mtsmda.souvenir.controller.constants.StaticPageConstants.CLOSE_BRACE;
import static com.mtsmda.souvenir.controller.constants.StaticPageConstants.OPEN_BRACE;
import static com.mtsmda.souvenir.controller.constants.StaticPageConstants.ROOT;

public class SouvenirRestConstants {

    public static final String INSERT_SOUVENIR_PIECE = "insert_souvenir";
    public static final String DELETE_SOUVENIR_PIECE = "delete_souvenir";
    public static final String SHOW_HIDE_SOUVENIR_PIECE = "show_hide_souvenir";

    public static final String SOUVENIR_ID_REQUEST_PARAM = "souvenirId";
    public static final String SOUVENIR_NAME_REQUEST_PARAM = "souvenirName";
    public static final String SOUVENIR_DESCRIPTION_REQUEST_PARAM = "souvenirDescription";
    public static final String SOUVENIR_SHOW_REQUEST_PARAM = "souvenirShow";
    public static final String SOUVENIR_PRICE_REQUEST_PARAM = "souvenirPrice";
    public static final String SOUVENIR_COUNT_OF_DAYS_FOR_ORDER_REQUEST_PARAM = "souvenirCountOfDaysForOrder";
    public static final String SOUVENIR_CATEGORY_ID_REQUEST_PARAM = "souvenirCategoryId";
    public static final String SOUVENIR_FILES_REQUEST_PARAM = "souvenirFiles";

    public static final String INSERT_SOUVENIR_PIECE_URL = ROOT + INSERT_SOUVENIR_PIECE;
    public static final String DELETE_SOUVENIR_PIECE_URL = ROOT + DELETE_SOUVENIR_PIECE + ROOT + OPEN_BRACE + SOUVENIR_ID_REQUEST_PARAM + CLOSE_BRACE;
    public static final String SHOW_HIDE_SOUVENIR_PIECE_URL = ROOT + SHOW_HIDE_SOUVENIR_PIECE + ROOT + OPEN_BRACE + SOUVENIR_ID_REQUEST_PARAM + CLOSE_BRACE;

}