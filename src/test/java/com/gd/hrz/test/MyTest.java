package com.gd.hrz.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gd.entity.User;
import com.gd.service.UserService;

/**
 * Unit test for simple App.
 */
public class MyTest extends TestCase {
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public MyTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(MyTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testMethod() {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:conf/spring-mybatis-shiro.xml" });
		UserService ideaService = (UserService) context
				.getBean("userServiceImpl");
		User user = new User();
		user.setUser_nickname("123");
		boolean result = ideaService.update(user);
		System.out.println(result);

	}

}
