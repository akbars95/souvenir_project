package com.mtsmda.souvenir.spring.config.interceptors.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by dminzat on 6/1/2016.
 */
/*@ResponseStatus(HttpStatus.NOT_FOUND)*/
public class ResourceNotFoundException extends RuntimeException {
}
