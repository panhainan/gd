package com.gd.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gd.entity.Discuss;
import com.gd.entity.User;
import com.gd.service.DiscussService;

/**
 * 
 * @author hrz
 * @date 2015-3-18
 */
@Controller
@RequestMapping(value = "/discuss")
public class DiscussController {
	@Autowired
	private DiscussService discussService;

	/**
	 * 
	 * @author hrz
	 * @date 2015-3-18
	 * @return User TODO 用于控制层测试
	 */
	@RequestMapping(value = "/test.do", method = RequestMethod.POST)
	@ResponseBody
	public String discussTest(User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		/*res.setHeader("Access-Control-Allow-Origin", "*");*/
		map.put("123", "123");
		/*User user = new User();
		user.setUser_university("123");*/
		System.out.print(user.getUser_password());
		List<User> userList = new ArrayList<User>();
		userList.add(user);
		userList.add(user);
		return user.getUser_password();
	}

	/**
	 * 
	 * @author hrz
	 * @date 2015-3-18
	 * @param disc_acti_id
	 * @param disc_user_send_id
	 * @param disc_user_rece_id
	 * @param disc_user_area_id
	 * @param disc_rped_disc_id
	 * @param disc_content
	 * @return boolean TODO 添加评论
	 */
	@RequestMapping(value = "/publish.do", method = RequestMethod.POST)
	@ResponseBody
	public boolean addDiscuss(long disc_acti_id, long disc_user_send_id,
			long disc_user_rece_id, long disc_user_area_id,
			long disc_rped_disc_id, String disc_content) {
		int result;
		result = discussService.addDiscuss(disc_acti_id, disc_user_send_id,
				disc_user_rece_id, disc_user_area_id, disc_rped_disc_id,
				disc_content);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @author hrz
	 * @date 2015-3-18
	 * @param disc_user_rece_id
	 * @param page
	 * @param pageSize
	 * @return List<Discuss> TODO
	 */
	@RequestMapping(value = "userreceid/list.do", method = RequestMethod.GET)
	@ResponseBody
	public List<Discuss> listDiscussByUserReceId(long disc_user_rece_id,
			int page, int pageSize) {

		List<Discuss> discussList = discussService.listDiscussByUserReceId(
				disc_user_rece_id, page, pageSize);
		return discussList;
	}

	/**
	 * 
	 * @author hrz
	 * @date 2015-3-18
	 * @param disc_user_send_id
	 * @param page
	 * @param pageSize
	 * @return List<Discuss> TODO
	 */
	@RequestMapping(value = "usersendid/list.do", method = RequestMethod.GET)
	@ResponseBody
	public List<Discuss> listDiscussByUserSendId(long disc_user_send_id,
			int page, int pageSize) {

		List<Discuss> discussList = discussService.listDiscussByUserSendId(
				disc_user_send_id, page, pageSize);
		return discussList;

	}

	/**
	 * 
	 * @author hrz
	 * @date 2015-3-18
	 * @param disc_acti_id
	 * @param page
	 * @param pageSize
	 * @return List<Discuss> TODO
	 */
	@RequestMapping(value = "activityid/list.do", method = RequestMethod.GET)
	@ResponseBody
	public List<Discuss> listDiscussByActiID(long disc_acti_id, int page,
			int pageSize) {
		List<Discuss> discussList = discussService.listDiscussByActiId(
				disc_acti_id, page, pageSize);
		return discussList;

	}
}
