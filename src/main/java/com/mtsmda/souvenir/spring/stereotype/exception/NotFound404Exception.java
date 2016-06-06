package com.mtsmda.souvenir.spring.stereotype.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by dminzat on 6/6/2016.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "not found resource!")
public class NotFound404Exception extends RuntimeException{

    public NotFound404Exception(String message) {
        super("Not found! " + message);
    }
}