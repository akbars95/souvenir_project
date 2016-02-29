package com.mtsmda.souvenir.controller.constants;

import static com.mtsmda.souvenir.controller.constants.StaticPageConstants.ROOT;
import static com.mtsmda.souvenir.controller.constants.StaticPageConstants.OPEN_BRACE;
import static com.mtsmda.souvenir.controller.constants.StaticPageConstants.CLOSE_BRACE;

public class SouvenirConstants {

    public static final String SOUVENIR_ID_FIELD_NAME = "souvenirId";

    public static final String GET_SOUVENIR_BY_ID_INTERNAL_FILE = "get_souvenir_by_id";

    public static final String GET_SOUVENIR_BY_ID_PIECE_URL = ROOT + "get_souvenir_by_id/souvenir/" + OPEN_BRACE + SOUVENIR_ID_FIELD_NAME + CLOSE_BRACE;
    
    public static final String CURRENT_SOUVENIR_MODEL = "currentSouvenir";

	
}