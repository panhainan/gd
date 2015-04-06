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

import com.gd.entity.Idea;
import com.gd.service.IdeaService;

/**
 * @author phn
 * @date   2014-12-11
 * @TODO 
 */
public class TestIdeaService {

	@Autowired
	private IdeaService ideaService;

	@Before
	public void before() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:conf/spring-mybatis-shiro.xml" });
		ideaService = (IdeaService) context.getBean("ideaServiceImpl");
	}
	//@Test
	public void testFindById(){
		long idea_id = 1;
		System.out.println(ideaService.findById(idea_id));
	}
	@Test
	public void testFindBySendUserId(){
		long idea_user_id =2;
		List<Idea> listIdea = ideaService.findBySendUserId(idea_user_id);
		for(Idea idea : listIdea){
			System.out.println(idea.toString());
		}
	}
}
