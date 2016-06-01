package com.mtsmda.souvenir.spring.config.interceptors;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dminzat on 6/1/2016.
 */
public class NotFound404Interceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("");
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        /*super.postHandle(request, response, handler, modelAndView);
        System.out.println(modelAndView.getView() != null);
        response.sendRedirect(request.getContextPath() + "/404.jsp");*/
    }
}