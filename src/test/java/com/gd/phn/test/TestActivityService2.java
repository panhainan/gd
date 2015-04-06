/**
 * 
 */
package com.gd.phn.test;

import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gd.entity.Activity;
import com.gd.service.ActivityService;

/**
 * @author phn
 * @date 2014-12-10
 * @TODO
 */
public class TestActivityService2 extends TestCase{

	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public TestActivityService2(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(TestActivityService2.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testMethod() {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:conf/spring-mybatis-shiro.xml" });
		ActivityService activityService = (ActivityService) context
				.getBean("activityServiceImpl");
		List<Activity> listActi = null;
		listActi = activityService.findByUserId(1);
		for(Activity acti:listActi){
			System.out.println(acti.toString());
		}

	}

}
