package com.gd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gd.entity.User;
import com.gd.entity.VerifiedTeam;
import com.gd.service.UserService;
import com.gd.service.VerifiedTeamService;
/**
 * 
 * @author hrz
 * @date 2015-3-31
 */
@Controller
@RequestMapping(value ="/verifiedteam")
public class VerifiedTeamController {
	@Autowired
	private UserService userService;
	@Autowired
	private VerifiedTeamService verifiedTeamService;
	
	/**
	 * 
	 * @author hrz
	 * @date 2015-4-1
	 * @param vari_teamName
	 * @param vari_email
	 * @param vari_password
	 * @param vari_authUser1
	 * @param vari_authUser2
	 * @param vari_authUser3
	 * @param vari_intruduction
	 * @return
	 * boolean
	 * TODO
	 */
	@RequestMapping(value="/add.do",method = RequestMethod.POST)
	@ResponseBody
	public boolean addVerifiedTeam(String vari_teamName,String vari_email,
			String vari_password,String vari_authUser1,
			String vari_authUser2,String vari_authUser3,String vari_intruduction){
		boolean result =verifiedTeamService.addVerifiedTeam(vari_teamName, vari_email, vari_password, vari_authUser1, vari_authUser2, vari_authUser3,vari_intruduction);
		return result;
	}
	/**
	 * 
	 * @author hrz
	 * @date 2015-4-1
	 * @param email
	 * @param password
	 * @return
	 * VerifiedTeam
	 * TODO
	 */
	@RequestMapping(value="/check.do",method = RequestMethod.POST)
	@ResponseBody
	public VerifiedTeam checkAuthResult(String email,String password){
		VerifiedTeam verifiedTeam = verifiedTeamService.checkAuthResult(email, password);
		return verifiedTeam;
	}
	/**
	 * 
	 * @author hrz
	 * @date 2015-4-1
	 * @param email
	 * @return
	 * boolean
	 * TODO 验证邮箱是否被使用若为true则邮箱被使用，否则未被使用
	 */
	@RequestMapping(value="/checkemail.do",method = RequestMethod.GET)
	@ResponseBody
	public boolean checkEmali(String email){
		boolean result = verifiedTeamService.checkEmali(email);
		return result;
	}
	
	/**
	 * 
	 * @author hrz
	 * @date 2015-4-1
	 * @param email
	 * @return
	 * String
	 * TODO 当用户填写验证人时要访问此接口检查邮箱是否可用
	 * 此接口有三个返回值分别是"该邮箱未注册"、"用户未激活"、"验证成功"
	 */
	@RequestMapping(value="/checkauthuser.do",method = RequestMethod.GET)
	@ResponseBody
	public String  checkAuthUserEmail(String email){
		User user = userService.findByCardId(email);
		String resultInfo ="";
		if(user == null ){
			resultInfo="该邮箱未注册";
		}else{
			if(!user.isActive_status()){
				resultInfo="用户未激活";
			}else{
				resultInfo="验证成功";
			}
		}
		return resultInfo;
	}
}

