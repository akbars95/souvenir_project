package com.mtsmda.souvenir.spring.config;

import org.springframework.security.web.FilterChainProxy;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by dminzat on 5/31/2016.
 */
public class WebXml implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //spring context
        AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
        annotationConfigWebApplicationContext.register(SpringMVCConfig.class, SpringSecurityConfig.class, SpringTransaction.class, RunScheduling.class);
        annotationConfigWebApplicationContext.register(SpringBeans.class, SpringDataSource.class, SpringEmail.class);
        servletContext.addListener(new ContextLoaderListener(annotationConfigWebApplicationContext));
        annotationConfigWebApplicationContext.setServletContext(servletContext);

        //servlets
        DispatcherServlet dispatcherServlet = new DispatcherServlet(annotationConfigWebApplicationContext);
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(Boolean.TRUE);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("mvc-dispatcher", dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

        //filters
        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.addMappingForUrlPatterns(null, false, "/*");

        /*FilterRegistration.Dynamic springSecurityFilterChain = servletContext.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class);
        springSecurityFilterChain.addMappingForUrlPatterns(null, false, "*//*");*/
    }
}