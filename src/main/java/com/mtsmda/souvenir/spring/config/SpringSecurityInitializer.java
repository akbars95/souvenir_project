package com.mtsmda.souvenir.spring.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by dminzat on 5/31/2016.
 *
 *
 * <br>
 *     <filter><br>
 <filter-name>springSecurityFilterChain</filter-name><br>
 <filter-class>org.springframework.web.filter.DelegatingFilterProxy<br>
 </filter-class><br>
 </filter><br>
 <br><br>
 <filter-mapping><br>
 <filter-name>springSecurityFilterChain</filter-name><br>
 <url-pattern>/*</url-pattern><br>
 </filter-mapping><br>
 */
public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {

}