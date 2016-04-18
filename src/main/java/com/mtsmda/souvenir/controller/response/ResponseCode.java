package com.mtsmda.souvenir.controller.response;

/**
 * Created by MTSMDA on 16.04.2016.
 */
public class ResponseCode {
    private Integer code;
    private String description;

    private static final Integer OK_CODE = 100;
    private static final Integer ERROR_CODE = 101;

    public static final ResponseCode RESPONSE_CODE_OK = new ResponseCode(OK_CODE, "OK");
    public static final ResponseCode RESPONSE_CODE_ERROR = new ResponseCode(ERROR_CODE, "ERROR");


    private ResponseCode(){}

    private ResponseCode(Integer code, String description){
        setCode(code);
        setDescription(description);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}