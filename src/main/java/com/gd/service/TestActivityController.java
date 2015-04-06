/**
 * 
 */
package com.gd.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gd.controller.ActivityController;
import com.gd.entity.Activity;

/**
 * @author phn
 * @date   2015-3-21
 * @TODO 
 */
@ContextConfiguration(locations = { "classpath:conf/spring-mybatis-shiro.xml",
"classpath:conf/spring-mvc.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestActivityController {
	@Autowired
	private ActivityController activityController;
	@Test
	public void testTestGetHotActivity() {
		System.out.println("testTestGetHotActivity 开始:");
		List<Activity> listActivity = null;
		listActivity = activityController.TestGetHotActivity();
		for (Activity acti : listActivity) {
			System.out.println(acti.toString());
		}
		System.out.println("testTestGetHotActivity 结束！");
	}

}
