package com.gd.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gd.entity.Activity;
import com.gd.service.ActivityService;

/**
 * @author phn
 * @date 2014-12-16
 * @TODO
 */
@Controller("activityController")
@RequestMapping(value = "/activity")
public class ActivityController {
	@Autowired
	private ActivityService activityService;

	/**
	 * @author phn
	 * @date 2015-3-29
	 * @TODO 模糊查询并分页
	 * @param searchTxt
	 * @param currentPage
	 * @return Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping(value = "/searchtxt/list.do", method = RequestMethod.POST)
	public Map<String, Object> fuzzyQueryPagingActivity(String searchTxt,
			int currentPage) {
		int pageSize = 4;
		Map<String, Object> map = new HashMap<String, Object>();
		map = activityService.fuzzyQueryPagingAcitivity(searchTxt, currentPage,
				pageSize);
		return map;
	}

	/**
	 * @author phn
	 * @date 2015-3-29
	 * @TODO 多条件筛选活动并分页显示
	 * @param userUniversity
	 * @param activityType
	 * @param lastTime
	 * @param currentPage
	 * @return Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping(value = "/school/type/lasttime/list.do", method = RequestMethod.POST)
	public Map<String, Object> multiConditionFindPagingActivity(
			String userUniversity,
			String activityType,
			String lastTime,
			int currentPage) {
		int pageSize = 4;
		if ("allSchool".equals(userUniversity)) {
			userUniversity = "";
		}
		if ("allType".equals(activityType)) {
			activityType = "";
		}
		Date acti_workingTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar rightNow = Calendar.getInstance();
		switch (lastTime) {
		case "oneDay":
			acti_workingTime.setTime(rightNow.getTimeInMillis() + 1000L * 60
					* 60 * 24);
			break;
		case "threeDay":
			acti_workingTime.setTime(rightNow.getTimeInMillis() + 1000L * 60
					* 60 * 24 * 3);
			break;
		case "oneWeek":
			acti_workingTime.setTime(rightNow.getTimeInMillis() + 1000L * 60
					* 60 * 24 * 7);
			break;
		case "halfMonth":
			acti_workingTime.setTime(rightNow.getTimeInMillis() + 1000L * 60
					* 60 * 24 * 15);
			break;
		case "oneMonth":
			acti_workingTime.setTime(rightNow.getTimeInMillis() + 1000L * 60
					* 60 * 24 * 30);
			break;
		default:
			try {
				acti_workingTime = sdf.parse(lastTime);
			} catch (ParseException e) {
				acti_workingTime.setTime(rightNow.getTimeInMillis() + 1000L
						* 60 * 60 * 24);
				e.printStackTrace();
			}
			break;
		}
		Map<String, Object> map = new HashMap<String, Object>();
//		System.out.println("userUniversity:"+userUniversity);
		map = activityService.multiConditionFindPagingActivity(userUniversity,
				activityType, acti_workingTime, pageSize, currentPage);
		System.out.println(map);
		return map;
	}

	/**
	 * @author phn
	 * @date 2015-3-21
	 * @TODO 获取热门活动，通过点赞数判断，这里暂时是用来测试的
	 * @return List<Activity>
	 */
	@ResponseBody
	@RequestMapping(value = "/test/hot/list.do", method = RequestMethod.GET)
	public List<Activity> TestGetHotActivity() {
		byte hotRows = 8;
		List<Activity> listActivity = activityService
				.testGetHotActivity(hotRows);
		return listActivity;
	}

	/**
	 * @author phn
	 * @date 2015-3-13
	 * @TODO 此方法用来测试
	 * @return
	 */
	@RequestMapping(value = "/test/last/ten.do", method = RequestMethod.GET)
	@ResponseBody
	public List<Activity> findLastTenActivity() {
		List<Activity> listActivity = activityService.getLastTen();
		return listActivity;
	}

	@RequestMapping(value = "/id/details.do", method = RequestMethod.GET)
	@ResponseBody
	public Activity findActivityByActivityId(
			@RequestParam("activity_id") long activity_id) {
		Activity activity = null;
		activity = activityService.findById(activity_id);
		return activity;
	}

	@RequestMapping(value = "/name/list.do", method = RequestMethod.GET)
	@ResponseBody
	public List<Activity> findActivityByActivityName(
			@RequestParam("activity_name") String activity_name) {
		// 这里url如果传的值为中文的话，会出现乱码现象，因为url的传的编码是iso8859-1，所以需要转码接收处理
//		String acti_name = null;
//		try {
//			acti_name = new String(activity_name.getBytes("iso8859-1"), "utf-8");
//		} catch (UnsupportedEncodingException e) {
//			System.out.println("传参中文乱码处理抛出异常：" + e.getMessage());
//		}
		List<Activity> listActivity = null;
		listActivity = activityService.findByName(activity_name);
		return listActivity;
	}

	@RequestMapping(value = "/type/list.do", method = RequestMethod.GET)
	@ResponseBody
	public List<Activity> findActivityByActivityType(
			@RequestParam("activity_type") String activity_type) {
//		String acti_type = null;
//		try {
//			acti_type = new String(activity_type.getBytes("iso8859-1"), "utf-8");
//		} catch (UnsupportedEncodingException e) {
//			System.out.println("传参中文乱码处理抛出异常：" + e.getMessage());
//		}
		System.out.println(activity_type);
//		System.out.println(acti_type);
		List<Activity> listActivity = null;
		listActivity = activityService.findByType(activity_type);
		return listActivity;
	}

	@RequestMapping(value = "/address/list.do", method = RequestMethod.GET)
	@ResponseBody
	public List<Activity> findActivityByActivityAddr(
			@RequestParam("activity_address") String activity_address) {
//		String acti_addr = null;
//		try {
//			acti_addr = new String(activity_address.getBytes("iso8859-1"),
//					"utf-8");
//		} catch (UnsupportedEncodingException e) {
//			System.out.println("传参中文乱码处理抛出异常：" + e.getMessage());
//		}
		List<Activity> listActivity = null;
		listActivity = activityService.findByAddr(activity_address);
		return listActivity;
	}

	@RequestMapping(value = "/time/start/to/end/list.do", method = RequestMethod.GET)
	@ResponseBody
	public List<Activity> findActivityByActivityStartEndTime(
			@RequestParam("activity_starttime") String activity_starttime,
			@RequestParam("activity_endtime") String activity_endtime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date acti_starttime = null;
		Date acti_endtime = null;
		try {
			acti_starttime = sdf.parse(activity_starttime);
			acti_endtime = sdf.parse(activity_endtime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<Activity> listActivity = null;
		listActivity = activityService.findByStartEndTime(acti_starttime,
				acti_endtime);
		return listActivity;
	}

	@RequestMapping(value = "/time/publish/list.do", method = RequestMethod.GET)
	@ResponseBody
	public List<Activity> findActivityByActivityNewTime(
			@RequestParam("activity_newtime") String activity_newtime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date acti_newtime = null;
		try {
			acti_newtime = sdf.parse(activity_newtime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<Activity> listActivity = null;
		listActivity = activityService.findByNewTime(acti_newtime);
		return listActivity;
	}

//	@RequestMapping(value = "/team/id/list.do", method = RequestMethod.GET)
//	@ResponseBody
//	public List<Activity> findActivityByTeamId(
//			@RequestParam("activity_team_id") long activity_team_id) {
//		List<Activity> listActivity = null;
//		listActivity = activityService.findByTeamId(activity_team_id);
//		return listActivity;
//	}

//	@RequestMapping(value = "/student/id/list.do", method = RequestMethod.GET)
//	@ResponseBody
//	public List<Activity> findActivityByStuId(
//			@RequestParam("activity_stud_id") long activity_stud_id) {
//		List<Activity> listActivity = null;
//		listActivity = activityService.findByStuId(activity_stud_id);
//		return listActivity;
//	}

}
