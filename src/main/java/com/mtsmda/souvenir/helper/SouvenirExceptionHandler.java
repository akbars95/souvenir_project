package com.mtsmda.souvenir.helper;

import com.mtsmda.souvenir.exception.SouvenirRuntimeException;

/**
 * Created by dminzat on 3/7/2016.
 */
public class SouvenirExceptionHandler {

    public static void handle(String text, Exception e){
        throw new SouvenirRuntimeException(text + " - " + e.getMessage() + "( " + e.getClass().getCanonicalName() + ")");
    }

}