/**
 * 
 */
package com.gd.phn.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gd.service.UserService;

/**
 * @means
 * @author phn
 * @date 2014-12-5
 */
public class TestUserService {
	private UserService userService;

	@Before
	public void before() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:conf/spring-mybatis-shiro.xml" });
		userService = (UserService) context.getBean("userServiceImpl");
	}

	@Test
	public void testFindById() {
		long user_id = 1;
		System.out.println(userService.findById(user_id));
	}

}
