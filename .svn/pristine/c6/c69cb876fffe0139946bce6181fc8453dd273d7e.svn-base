package com.gd.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gd.entity.Activity;
import com.gd.entity.User;
import com.gd.service.ActivityService;
import com.gd.service.AuService;
import com.gd.service.UserService;
import com.gd.util.CacheUtils;
import com.gd.util.MD5Util;

@Controller("userController")
@RequestMapping("/user")
public class UserController {
	/**
	 * 邮箱注册激活最迟时间
	 */
	private final long ACTIVE_LAST_DATE = 1000L * 60 * 60 * 24 * 2;// 两天
	/**
	 * 找回密码最迟时间
	 */
	private final long RESET_FIND_PASS_LAST_DATE = 1000L * 60 * 60 * 2;// 两个小时
	@Autowired
	private ActivityService activityService;
	@Autowired
	private UserService userService;

	@Autowired
	private AuService auService;

	/**
	 * @author phn
	 * @date 2015-3-31
	 * @TODO 用户注册验证邮箱是否已经被注册过了 侯哥已写
	 * @param email
	 * @return map：registerValidEmailResult
	 */
	// @ResponseBody
	// @RequestMapping(value = "/registerValidEmail.do", method =
	// RequestMethod.POST)
	// public Map<String, Object> registerValidEmail(String email) {
	// boolean registerValidEmailResult = false;
	// User user = null;
	// user = userService.findByCardId(email);
	// if (user != null) {
	// registerValidEmailResult = true;
	// }
	// Map<String, Object> map = new HashMap<String, Object>();
	// map.put("registerValidEmailResult", registerValidEmailResult);
	// return map;
	// }

	/**
	 * @author phn
	 * @date 2015-3-31
	 * @TODO 注册并发送验证码，还有注册后相关跳转登录等
	 * @param userEmail
	 * @param userPass
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public Map<String, Object> register(String userEmail, String userPass,
			String nickName, HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		String registerURL = req.getRequestURL().toString();
		User user = new User();
		if ("".equals(nickName)) {
			user.setUser_nickname(userEmail);
		} else {
			user.setUser_nickname(nickName);
		}
		user.setRegister_time(new Date());
		user.setUser_cardid(userEmail);
		user.setActive_status(false);
		user.setUser_locked(false);
		user.setUser_password(userPass);
		user.setUser_property(0);
		user.setValidate_code(MD5Util.encode2hex(userEmail
				+ (int) (Math.random() * 100000)));
		boolean registerResult = false;
		registerResult = userService.register(user, userEmail,
				registerURL.replace("register.do", "activeRegister.do"));
		map.put("registerResult", registerResult);
		map.put("user_cardid", userEmail);
		return map;
	}

	/**
	 * @author phn
	 * @date 2015-3-31
	 * @TODO 激活账号
	 * @param email
	 * @param validateCode
	 * @return
	 */
	@RequestMapping(value = "/activeRegister.do", method = RequestMethod.GET)
	public ModelAndView activeRegister(String userEmail,
			String validateRegisterCode) {
		User user = userService.findByCardId(userEmail);
		if (user.getValidate_code().equals(validateRegisterCode)) {
			Date registerTime = user.getRegister_time();
			Calendar rightNow = Calendar.getInstance();
			Date activeTime = new Date();
			activeTime.setTime(rightNow.getTimeInMillis());
			if (rightNow.getTimeInMillis() - registerTime.getTime() <= ACTIVE_LAST_DATE) {
				if (!user.isActive_status()) {
					// 前往激活
					// activeResult=1;
					boolean activeStatus = true;
					boolean activeResult = userService.activeRegister(
							user.getUser_id(), userEmail, activeStatus);
					// 1：激活成功 2：服务器故障
					if (activeResult) {
						return new ModelAndView(
								"redirect:/html/activeSuccess.html");
					} else {
						return new ModelAndView(
								"redirect:/html/serverBreakdown.html");
					}
				} else {
					// 已激活
					return new ModelAndView("redirect:/html/isActived.html");
				}
			} else {
				// 链接已过期
				return new ModelAndView("redirect:/html/inefficacyLink.html");
			}

		}
		return new ModelAndView("redirect:/html/errorLink.html");
	}

	/**
	 * @author phn
	 * @date 2015-3-31
	 * @TODO 重发验证码
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/resetvalidateCode.do", method = RequestMethod.GET)
	public Map<String, Object> resetvalidateCode(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		Subject subject = SecurityUtils.getSubject();
		String email = (String) subject.getPrincipal();
		User user = userService.findByCardId(email);
		user.setValidate_code(MD5Util.encode2hex(email
				+ (int) (Math.random() * 100000)));
		boolean resetvalidateCodeResult = false;
		String registerURL = req.getRequestURL().toString();
		resetvalidateCodeResult = userService.resetvalidateCode(user, email,
				registerURL
						.replace("resetvalidateCode.do", "activeRegister.do"));
		map.put("resetvalidateCodeResult", resetvalidateCodeResult);
		map.put("user_cardid", email);
		return map;
	}

	/**
	 * @author phn
	 * @date 2015-3-31
	 * @TODO 找回密码
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findPass.do", method = RequestMethod.POST)
	public Map<String, Object> getBackPass(String userEmail,
			HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = userService.findByCardId(userEmail);
		user.setPassword_validate_code(MD5Util.encode2hex(userEmail
				+ (int) (Math.random() * 100000)));
		user.setPassword_validate_time(new Date());
		user.setPassword_validate_status(true);// 状态，true-未点击验证链接进行验证并修改密码；false-已验证并修改
		boolean findPassResult = false;
		String registerURL = req.getRequestURL().toString();
		findPassResult = userService.findPass(user, userEmail,
				registerURL.replace("findPass.do", "goResetFindPass.do"));
		map.put("findPassResult", findPassResult);
		return map;
	}

	/**
	 * @author phn
	 * @date 2015-4-2
	 * @TODO 前往找回密码
	 * @param userEmail
	 * @param validatePassCode
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/goResetFindPass.do", method = RequestMethod.GET)
	public ModelAndView goResetFindPass(String userEmail,
			String validatePassCode, HttpServletRequest req) {
		User user = userService.findByCardId(userEmail);
		if (user.getValidate_code().equals(validatePassCode)) {
			Date password_validate_time = user.getPassword_validate_time();
			Calendar rightNow = Calendar.getInstance();
			Date goResetFindPassTime = new Date();
			goResetFindPassTime.setTime(rightNow.getTimeInMillis());
			if (rightNow.getTimeInMillis() - password_validate_time.getTime() <= RESET_FIND_PASS_LAST_DATE) {
				if (user.isPassword_validate_status()) {
					// user.isPassword_validate_status()状态，true-未点击验证链接进行验证并修改密码；false-已验证并修改
					// 前往修改密码页面
					// 需要传参数userEmail，validatePassCode
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("validatePassCode", validatePassCode);
					map.put("userEmail", userEmail);
					// 暂时这么写
					return new ModelAndView("/html/resetPass.jsp", map);
				}
			} else {
				// 链接已失效
				return new ModelAndView("redirect:/html/inefficacyLink.html");
			}
		}
		return new ModelAndView("redirect:/html/errorLink.html");
	}

	/**
	 * @author phn
	 * @date 2015-4-1
	 * @TODO 找回重设密码
	 * @param userEmail
	 * @param validatePassCode
	 * @param userPass
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/resetFindPass.do", method = RequestMethod.POST)
	public Map<String, Object> resetFindPass(String userEmail,
			String validatePassCode, String userPass, HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		// System.out.println(userEmail+"   "+validatePassCode+"   "+userPass);
		User user = userService.findByCardId(userEmail);
		byte resetFindPassResult = 0; // 0无效链接 1激活成功 2服务器故障 -1错误链接
		if (user.getValidate_code().equals(validatePassCode)) {
			Date password_validate_time = user.getPassword_validate_time();
			Calendar rightNow = Calendar.getInstance();
			Date goResetFindPassTime = new Date();
			goResetFindPassTime.setTime(rightNow.getTimeInMillis());
			if (rightNow.getTimeInMillis() - password_validate_time.getTime() <= RESET_FIND_PASS_LAST_DATE) {
				if (user.isPassword_validate_status()) {
					// user.isPassword_validate_status()状态，true-未点击验证链接进行验证并修改密码；false-已验证并修改
					// 前往修改密码页面
					user.setPassword_validate_status(false);
					user.setUser_password(userPass);
					resetFindPassResult = userService.resetFindPass(user);
				}
			}
		} else {
			resetFindPassResult = -1;// 错误链接
		}
		map.put("resetFindPassResult", resetFindPassResult);
		return map;
	}

	/**
	 * @author phn
	 * @date 2015-3-31
	 * @TODO 重新修改登录邮箱
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/resetEmail.do", method = RequestMethod.POST)
	public Map<String, Object> resetEmail(String resetEmail) {
		Map<String, Object> map = new HashMap<String, Object>();
		Subject subject = SecurityUtils.getSubject();
		String currentEmail = (String) subject.getPrincipal();
		boolean resetEmailResult = userService.updateEmail(resetEmail,
				currentEmail);
		map.put("resetEmailResult", resetEmailResult);
		return map;
	}

	/**
	 * @author hrz
	 * @date 2015-4-1
	 * @TODO 用户登录
	 * @param cardId
	 * @param password
	 */
	@ResponseBody
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String longin(String cardId, String password) {
		String longinInfo = "success";
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(cardId,
				password);
		token.setRememberMe(true);
		try {
			subject.login(token);
		} catch (UnknownAccountException e) {
			longinInfo = "用户名/密码错误";
		} catch (IncorrectCredentialsException e) {
			longinInfo = "用户名/密码错误";
		} catch (LockedAccountException e) {
			longinInfo = "用户被锁定";
		} catch (ExcessiveAttemptsException e) {
			longinInfo = "重复次数过多";
		} catch (AuthenticationException e) {
			// 其他错误，比如锁定，如果想单独处理请单独catch处理
			longinInfo = "其他错误：" + e.getMessage();
		}
		if (subject.hasRole("falseUser")) {
			longinInfo = "用户未经过验证";
		}
		return longinInfo;
	}

	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	@ResponseBody
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		// String string = (String)subject.getPrincipal();
		subject.logout();
		return "success";
	}

	/**
	 * 
	 * @author hrz
	 * @date 2015-4-1
	 * @return User TODO 当前台要求访当前用户信息时可调用该接口返回user对象
	 */
	@ResponseBody
	@RequestMapping(value = "/getcurrentuser.do", method = RequestMethod.GET)
	public User getUser() {
		Subject subject = SecurityUtils.getSubject();
		String email = (String) subject.getPrincipal();
		System.out.println("email:" + email);
		CacheUtils cache = new CacheUtils();
		User user = cache.findUserInfoCache(email);
		if (user == null) {
			user = userService.findByCardId(email);
			if (user != null) {
				cache.addUserInCache(user, email);
			}
		}
		return user;
	}

	/**
	 * 
	 * @author hrz
	 * @date 2015-4-2
	 * @param password
	 * @return boolean TODO
	 */
	@ResponseBody
	@RequestMapping(value = "/changepassword.do", method = RequestMethod.POST)
	public boolean changePassword(String password) {
		Subject subject = SecurityUtils.getSubject();
		String email = (String) subject.getPrincipal();
		userService.changePassword(email, password);
		CacheUtils cache = new CacheUtils();
		cache.deleteUserinCache(email);
		return true;
	}

	/**
	 * 
	 * @author hrz
	 * @date 2015-4-1
	 * @param user
	 * @return boolean TODO 更新用户信息，每次传过来的参数都一样
	 */
	@ResponseBody
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public boolean update(User user) {
		boolean result = userService.update(user);
		CacheUtils cache = new CacheUtils();
		cache.deleteUserinCache(user.getUser_cardid());
		return result;
	}

	/**
	 * @author phn
	 * @date 2015-3-17
	 * @TODO 发布活动
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/activity/publish.do", method = RequestMethod.POST)
	public Map<String, Object> publishStuActivity(Activity activity) {
		System.out.println(activity.toString());
		boolean publishStuActivityResult = false;
		Map<String, Object> map = new HashMap<String, Object>();
		Subject subject = SecurityUtils.getSubject();
		String email = (String) subject.getPrincipal();
		User user = userService.findByCardId(email);
		activity.setActi_user(user);
		activity.setActi_join(0);
		activity.setActi_support(0);
		long activityId = activityService.addActivity(activity);
		if (activityId != 0) {
			publishStuActivityResult = true;
			map.put("activityId", activityId);
		}
		map.put("publishStuActivityResult", publishStuActivityResult);
		return map;
	}

	/**
	 * @author phn
	 * @date 2015-4-5
	 * @TODO 获取当前用户的所有已报名但是未参加的活动
	 * @return List<Activity>
	 */
	@ResponseBody
	@RequestMapping(value = "/activity/joined/unarrived/list.do", method = RequestMethod.GET)
	public List<Activity> getJoinedUnArrivedActivity() {
		boolean joined = true;
		boolean arrived = false;
		Subject subject = SecurityUtils.getSubject();
		String email = (String) subject.getPrincipal();
		User user = userService.findByCardId(email);
		List<Activity> listActivity = auService.getJoinedUnArrivedActivity(
				joined, arrived, user.getUser_id());
		return listActivity;
	}

	/**
	 * @author phn
	 * @date 2015-4-5
	 * @TODO 获取当前用户的所有已签到的活动,查询结构与上述方法类似，但是为了便于以后修改，没有共用。
	 * @return List<Activity>
	 */
	@ResponseBody
	@RequestMapping(value = "/activity/joined/arrived/list.do", method = RequestMethod.GET)
	public List<Activity> getArrivedActivity() {
		boolean arrived = true;
		boolean joined = true;
		Subject subject = SecurityUtils.getSubject();
		String email = (String) subject.getPrincipal();
		User user = userService.findByCardId(email);
		List<Activity> listActivity = auService.getArrivedActivity(joined,
				arrived, user.getUser_id());
		return listActivity;
	}

	/**
	 * @author phn
	 * @date 2015-4-5
	 * @TODO 获取当前用户所有已报名的活动
	 * @return List<Activity>
	 */
	@ResponseBody
	@RequestMapping(value = "/activity/joined/list.do", method = RequestMethod.GET)
	public List<Activity> getAllJoinedActivity() {
		boolean joined = true;
		Subject subject = SecurityUtils.getSubject();
		String email = (String) subject.getPrincipal();
		User user = userService.findByCardId(email);
		List<Activity> listActivity = auService.getAllJoinedActivity(joined,
				user.getUser_id());
		return listActivity;
	}

	/**
	 * @author phn
	 * @date 2015-4-5
	 * @TODO 用户获取自己已经发布的活动
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/activity/published/list.do", method = RequestMethod.GET)
	public List<Activity> getActivityByUserSelfId() {
		Subject subject = SecurityUtils.getSubject();
		String email = (String) subject.getPrincipal();
		User user = userService.findByCardId(email);
		List<Activity> listActivity = activityService.findByUserId(user
				.getUser_id());
		return listActivity;
	}

}
