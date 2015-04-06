/**
 * 
 */
package com.gd.phn.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gd.entity.Au;
import com.gd.service.AuService;

/**
 * @author phn
 * @date 2014-12-10
 * @TODO
 */
public class TestAuService {

	@Autowired
	private AuService auService;

	@Before
	public void before() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:conf/spring-mybatis-shiro.xml" });
		auService = (AuService) context.getBean("auServiceImpl");
	}

//	 @Test
//	public void testFindByActiId() {
//		long acti_id = 5;
//		List<Au> listAu = auService.findByActiId(acti_id);
//		for (Au au : listAu) {
//			System.out.println(au.toString());
//		}
//	}

	// @Test
	public void testFindByTCodeAndUserId() {
		String two_code = "gsdfgas345";
		long user_id = 1;
		Au au = auService.findByTCodeAndUserId(two_code, user_id);
		System.out.println(au.toString());
	}

}
