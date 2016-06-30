package com.mtsmda.souvenir.spring.stereotype.controller.restController.constants;

import static com.mtsmda.souvenir.spring.stereotype.controller.constants.StaticPageConstants.ROOT;

/**
 * Created by dminzat on 6/27/2016.
 */
public interface EmailSenderRestControllerConstants {

    public static final String SEND_EMAIL_PIECE = "sendemail";
    public static final String SEND_EMAIL_WITH_FILE_PIECE = SEND_EMAIL_PIECE + "WithFile";


    public static final String SEND_EMAIL_PIECE_URL = ROOT + SEND_EMAIL_PIECE;
    public static final String SEND_EMAIL_WITH_FILE_PIECE_URL = ROOT + SEND_EMAIL_WITH_FILE_PIECE;

}