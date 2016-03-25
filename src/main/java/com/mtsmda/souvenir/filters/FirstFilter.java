package com.mtsmda.souvenir.filters;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by dminzat on 3/25/2016.
 */
public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(filterConfig.getFilterName());
        Enumeration<String> initParameterNames = filterConfig.getServletContext().getInitParameterNames();

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
