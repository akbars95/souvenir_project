package com.mtsmda.souvenir.repository.impl.java_standard.test;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration( "file:src/main/webapp/WEB-INF/spring/spring-datasource.xml")
//@WebAppConfiguration
public class CaptchaRepositoryImplSPJavaStandardTest {
	
	@Autowired
	@Qualifier(value = "mySqlDataSource")
	private DataSource dataSource;
	
	@Test
	public void test(){
//		Assert.assertNull(dataSource);
//		Assert.assertNotNull(dataSource);
	}
	
}