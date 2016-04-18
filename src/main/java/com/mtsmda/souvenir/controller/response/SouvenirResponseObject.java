package com.mtsmda.souvenir.controller.response;

/**
 * Created by MTSMDA on 16.04.2016.
 */
public class SouvenirResponseObject {

    private ResponseCode responseCode;
    private Object object;

    public SouvenirResponseObject() {}

    public SouvenirResponseObject(ResponseCode responseCode, Object object) {
        this.responseCode = responseCode;
        this.object = object;
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}