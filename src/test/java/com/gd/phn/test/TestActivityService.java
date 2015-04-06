/**
 * 
 */
package com.gd.phn.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gd.entity.Activity;
import com.gd.entity.User;
import com.gd.service.ActivityService;

/**
 * @author phn
 * @date 2014-12-10
 * @TODO
 */
@ContextConfiguration(locations= {"classpath:conf/spring-mybatis-shiro.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestActivityService {

	@Autowired
	private ActivityService activityService;

//	@Test
	public void testGetLastTen(){
		List<Activity> listActi = null;
		listActi = activityService.getLastTen();
		for(Activity acti:listActi){
			System.out.println(acti.toString());
		}
	}
	@Test
	public void testFindByUserId(){
		List<Activity> listActi = null;
		listActi = activityService.findByUserId(1);
		for(Activity acti:listActi){
			System.out.println(acti.toString());
		}
	}
	
	
//	@Test
	public void testAddActivity(){
		Activity acti= new Activity();
		acti.setActi_name("这里是活动名称这里是活活动名称这里是活动名称");
		acti.setActi_summary("这里是活动摘要");
		acti.setActi_newtime(new Date());
		acti.setActi_content("这里是活动内容");
		User acti_user = new User();
//		acti_user.setUser_id(1);
		acti.setActi_user(acti_user);
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		acti.setActi_fath(null);
		try {
			acti.setActi_starttime(dateformat.parse("2014-12-16"));
			acti.setActi_endtime(dateformat.parse("2014-12-26"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		acti.setActi_address("这里是地址");
		acti.setActi_poster("这里是海报");
		acti.setActi_otherpic1("");
		acti.setActi_otherpic2("");
		acti.setActi_otherpic3("");
		acti.setActi_type("这里是类型");
		long result  = activityService.addActivity(acti);
		System.out.println("0000");
		System.out.println(result);
	}
//	@Test
	public void testUpdateActivity(){
		Activity acti = activityService.findById(8);
		acti.setActi_address("地址地址");
		long result = activityService.updateActivity(acti);
		System.out.println(result);
	}
//	@Test
	public void testDeleteActivity(){
		activityService.deleteActivity(11);
	}
	
//	@Test
	public void testFindById() {
		long acti_id = 3;
		Activity acti = activityService.findById(acti_id);
		System.out.println(acti.toString());
	}

//	@Test
	public void testFindByName() {
		String acti_name = "辩论";
		List<Activity> listActi = activityService.findByName(acti_name);
		for (Activity acti : listActi) {
			System.out.println(acti.toString());
		}
	}

//	 @Test
	public void testFindByType() {
		String acti_type = "辩论";
		List<Activity> listActi = activityService.findByType(acti_type);
		for (Activity acti : listActi) {
			System.out.println(acti.toString());
		}
	}

//	 @Test
	public void testFindByAddress() {
		String acti_addr = "地址";
		List<Activity> listActi = activityService.findByAddr(acti_addr);
		for (Activity acti : listActi) {
			System.out.println(acti.toString());
		}
	}

//	 @Test
	public void testFindByStartEndTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String startStr = "20141212";
		String endStr = "20141230";
		Date starttime;
		Date endtime;
		try {
			starttime = sdf.parse(startStr);
			endtime = sdf.parse(endStr);
			List<Activity> listActi = activityService.findByStartEndTime(
					starttime, endtime);
			for (Activity acti : listActi) {
				System.out.println(acti.toString());
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

//	 @Test
	public void testFindByNewTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String startStr = "20141210";
		Date newtime;
		try {
			newtime = sdf.parse(startStr);
			List<Activity> listActi = activityService.findByNewTime(newtime);
			for (Activity acti : listActi) {
				System.out.println(acti.toString());
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

//	@Test
	public void testFindByTeamId() {
		long team_id = 1;
		List<Activity> listActi = activityService.findByTeamId(team_id);
		for (Activity acti : listActi) {
			System.out.println(acti.toString());
		}
	}

//	@Test
	public void testFindByStuId() {
		long stu_id = 2;
		List<Activity> listActi = activityService.findByStuId(stu_id);
		for (Activity acti : listActi) {
			System.out.println(acti.toString());
		}
	}

}
