package com.gd.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.gd.service.UserService;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	@ResponseBody
	public String longin() {
		String error = "success";
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("1213", "123");
		token.setRememberMe(true);
		try {
			subject.login(token);
		} catch (UnknownAccountException e) {
			error = "用户名/密码错误";
		} catch (IncorrectCredentialsException e) {
			error = "用户名/密码错误";
		} catch (LockedAccountException e) {
			error = "用户被锁定";
		} catch (ExcessiveAttemptsException e) {
			error = "重复次数过多";
		} catch (AuthenticationException e) {
			// 其他错误，比如锁定，如果想单独处理请单独catch处理
			error = "其他错误：" + e.getMessage();
		}
		System.out.println(error);
		System.out.println(subject.hasRole("user:delete"));
		return error;
	}
//	@RequestMapping(value = "/regist.do")
//	@ResponseBody
//	public String regist() {
//		User user = new User();
//		user.setUser_cardid("1213");
//		user.setUser_password("123");
//		userService.createUser(user);
//		System.out.println("regist");
//		return "success";
//	}

	@RequestMapping(value = "/logout.do")
	@ResponseBody
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		String string = (String)subject.getPrincipal();
		subject.logout();
		return "success";
	}
}
