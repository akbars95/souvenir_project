package com.mtsmda.souvenir.spring.stereotype.exception;

import org.openqa.selenium.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Created by dminzat on 6/6/2016.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {NoHandlerFoundException.class})
    public ModelAndView notFound404(Exception e){
        ModelAndView modelAndView = new ModelAndView("404");
        System.out.println(e.getClass().toString());
        return modelAndView;
    }

}