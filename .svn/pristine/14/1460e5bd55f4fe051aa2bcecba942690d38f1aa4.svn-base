package com.gd.service.impl;

import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.dao.UserDao;
import com.gd.dto.MailType;
import com.gd.entity.Role;
import com.gd.entity.User;
import com.gd.service.MailService;
import com.gd.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	private PasswordHelper passwordHelper = new PasswordHelper();
	@Autowired
	private MailService mailService;

	// public User findByUsername(String name){
	// return userDao.findByUsername(name);
	// }
	
	@Override
	public boolean register(User user, String userEmail, String registerURL) {
		try {
			passwordHelper.encryptPassword(user);
			userDao.register(user);
			long [] roleId = new long[1];
			roleId[0] = Role.FalseUserRoleId; 
			correlationRoles(user.getUser_id(), roleId);
			MailType mailType = new MailType();
			mailType.setEmail(userEmail);
			String mailUrl = registerURL+"?userEmail="+userEmail+"&validateRegisterCode="+user.getValidate_code();
			mailType.setUrl(mailUrl);
			mailType.setType(MailType.REGISTER_TYPE_MAIL);
			mailType.setUsername(user.getUser_nickname());
			// 发送邮件
			mailService.sendSingleMail(mailType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean activeRegister(long userId,String email, boolean activeStatus) {
		try {
			userDao.activeRegister(email,activeStatus);
			long [] roleId = new long[1];
			roleId[0] = Role.FalseUserRoleId;
			uncorrelationRoles(userId, roleId);
			roleId[0] = Role.NormalUserRoleId;
			correlationRoles(userId, roleId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean resetvalidateCode(User user, String email, String registerURL) {
		try {
			userDao.resetvalidateCode(email,user.getValidate_code());
			MailType mailType = new MailType();
			mailType.setEmail(email);
			String mailUrl = registerURL+"?userEmail="+email+"&validateRegisterCode="+user.getValidate_code();
			mailType.setUrl(mailUrl);
			mailType.setType(MailType.REGISTER_TYPE_MAIL);
			mailType.setUsername(user.getUser_nickname());
			// 重新发送邮件
			mailService.sendSingleMail(mailType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean findPass(User user, String userEmail, String registerURL) {
		try {
			userDao.updateByFindPass(userEmail,user.getPassword_validate_code(),user.getPassword_validate_time(),user.isPassword_validate_status());
//		long [] roleId = new long[1];
//		roleId[0] = Role.FalseUserRoleId; 
//		correlationRoles(user.getUser_id(), roleId);
			MailType mailType = new MailType();
			mailType.setEmail(userEmail);
			String mailUrl = registerURL+"?userEmail="+userEmail+"&validatePassCode="+user.getValidate_code();
			mailType.setUrl(mailUrl);
			mailType.setType(MailType.RESET_PASSWORD_TYPE_MAIL);
			mailType.setUsername(user.getUser_nickname());
			System.out.println(mailType);
			// 发送邮件
			mailService.sendSingleMail(mailType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public byte resetFindPass(User user) {
		passwordHelper.encryptPassword(user);
		try {
			userDao.resetFindPass(user.getUser_cardid(),user.getUser_password(),user.isPassword_validate_status());
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 2;
	}
	@Override
	public boolean updateEmail(String resetEmail, String currentEmail) {
		try {
			userDao.updateCardid(resetEmail,currentEmail);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User findById(long user_id) {
		User user = null;
		try {
			user = userDao.findById(user_id);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User testIsExist(User user) {
		return userDao.testIsExist(user);
	}

	public int createUser(User user) {
		// 加密密码
		passwordHelper.encryptPassword(user);
		return userDao.createUser(user);
	}

	public void changePassword(String email, String newPassword) {
		User user = userDao.findByCardId(email);
		user.setUser_password(newPassword);
		passwordHelper.encryptPassword(user);
		userDao.updateUser(user);
	}

	public void correlationRoles(long userId, long[] roleIds) {
		userDao.correlationRoles(userId, roleIds);
	}

	public void uncorrelationRoles(long userId, long[] roleIds) {
		userDao.uncorrelationRoles(userId, roleIds);
	}

	public User findByCardId(String cardId) {
		return userDao.findByCardId(cardId);
	}

	public Set<String> findRoles(String cardId) {
		return userDao.findRoles(cardId);
	}

	public Set<String> findPermissions(String cardId) {
		return userDao.findPermissions(cardId);
	}
	@Override
	public boolean update(User user) {
		
		try {
			Subject subject = SecurityUtils.getSubject();
			String email = (String) subject.getPrincipal();
			int result = userDao.update(user,email);
			if(result ==0){
				return false;
			}else{
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}



}
