package com.mtsmda.souvenir.spring.stereotype.controller.response;

/**
 * Created by MTSMDA on 16.04.2016.
 */
public class ResponseCode {
    private Integer code;
    private String description;

    private static final Integer OK_CODE = 100;
    private static final Integer ERROR_CODE = 101;
    private static final Integer INSERT_OK_CODE = 102;
    private static final Integer INSERT_ERROR_CODE = 103;
    private static final Integer UPDATE_OK_CODE = 104;
    private static final Integer UPDATE_ERROR_CODE = 105;
    private static final Integer DELETE_OK_CODE = 106;
    private static final Integer DELETE_ERROR_CODE = 107;
    private static final Integer GET_OK_CODE = 108;
    private static final Integer GET_ERROR_CODE = 109;
    private static final Integer REGISTRATION_OK_CODE = 110;
    private static final Integer REGISTRATION_ERROR_CODE = 111;

    public static final ResponseCode RESPONSE_OK_CODE = new ResponseCode(OK_CODE, "OK");
    public static final ResponseCode RESPONSE_ERROR_CODE = new ResponseCode(ERROR_CODE, "ERROR");
    public static final ResponseCode RESPONSE_INSERT_OK_CODE = new ResponseCode(INSERT_OK_CODE, "INSERT_OK_CODE");
    public static final ResponseCode RESPONSE_INSERT_ERROR_CODE = new ResponseCode(INSERT_ERROR_CODE, "INSERT_ERROR_CODE");
    public static final ResponseCode RESPONSE_UPDATE_OK_CODE = new ResponseCode(UPDATE_OK_CODE, "UPDATE_OK_CODE");
    public static final ResponseCode RESPONSE_UPDATE_ERROR_CODE = new ResponseCode(UPDATE_ERROR_CODE, "UPDATE_ERROR_CODE");
    public static final ResponseCode RESPONSE_DELETE_OK_CODE = new ResponseCode(DELETE_OK_CODE, "DELETE_OK_CODE");
    public static final ResponseCode RESPONSE_DELETE_ERROR_CODE = new ResponseCode(DELETE_ERROR_CODE, "DELETE_ERROR_CODE");
    public static final ResponseCode RESPONSE_GET_OK_CODE = new ResponseCode(GET_OK_CODE, "GET_OK_CODE");
    public static final ResponseCode RESPONSE_GET_ERROR_CODE = new ResponseCode(GET_ERROR_CODE, "GET_ERROR_CODE");
    public static final ResponseCode RESPONSE_REGISTRATION_OK_CODE = new ResponseCode(REGISTRATION_OK_CODE, "REGISTRATION_OK_CODE");
    public static final ResponseCode RESPONSE_REGISTRATION_ERROR_CODE = new ResponseCode(REGISTRATION_ERROR_CODE, "REGISTRATION_ERROR_CODE");


    private ResponseCode(){}

    private ResponseCode(Integer code, String description){
        setCode(code);
        setDescription(description);
    }

    public Integer getCode() {
        return code;
    }

    public ResponseCode setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ResponseCode setDescription(String description) {
        this.description = description;
        return this;
    }
}