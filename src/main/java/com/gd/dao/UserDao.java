package com.gd.dao;

import java.util.Date;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.gd.entity.User;

public interface UserDao {
	/**
	 * @author phn
	 * @date 2015-3-30
	 * @TODO 用户注册
	 * @param user
	 */
	public int register(User user);

	/**
	 * @author phn
	 * @date 2015-3-31
	 * @TODO 用户注册激活
	 * @param email
	 * @param activeStatus
	 */
	public void activeRegister(@Param(value = "email") String email,
			@Param(value = "activeStatus") boolean activeStatus);

	/**
	 * @author phn
	 * @date 2015-3-31
	 * @TODO 重新设置激活验证码
	 * @param email
	 * @param validate_code
	 */
	public void resetvalidateCode(@Param(value = "email") String email,
			@Param(value = "validatecode") String validate_code);

	/**
	 * @author phn
	 * @date 2015-4-1
	 * @TODO 更新用户信息设置找回密码的相关验证信息
	 * @param userEmail
	 * @param password_validate_code
	 * @param password_validate_time
	 * @param password_validate_status
	 */
	public void updateByFindPass(
			@Param(value = "email") String userEmail,
			@Param(value = "password_validate_code") String password_validate_code,
			@Param(value = "password_validate_time") Date password_validate_time,
			@Param(value = "password_validate_status") boolean password_validate_status);

	/**
	 * @author phn
	 * @date 2015-4-1
	 * @TODO 重新找回设置密码
	 * @param user_cardid
	 * @param user_password
	 * @param password_validate_status
	 */
	public void resetFindPass(
			@Param(value = "email") String user_cardid,
			@Param(value = "user_password") String user_password,
			@Param(value = "password_validate_status") boolean password_validate_status);

	/**
	 * @author phn
	 * @date 2014-12-11
	 * @TODO 通过用户id搜索用户
	 * @param user_id
	 * @return
	 */
	public User findById(@Param(value = "user_id") long user_id);

	// public User findByUsername(String name);
	public User findByIdAndProperty(@Param(value = "user_id") long user_id,
			@Param(value = "user_property") long user_property);
	/**
	 * @author phn
	 * @date   2015-4-2
	 * @TODO 修改登录用户名即邮箱，cardid
	 * @param resetEmail
	 * @param currentEmail
	 */
	public void updateCardid(@Param(value = "resetEmail")String resetEmail, @Param(value = "currentEmail")String currentEmail);
	
	/**
	 * @author phn
	 * @date 2015-3-21
	 * @TODO 测试方法，用来进行暂时登录
	 * @param user
	 * @return user
	 */
	public User testIsExist(User user);

	/**
	 * 
	 * @author hrz
	 * @date 2015-3-28
	 * @param user
	 * @return int TODO
	 */
	public int createUser(User user);

	/**
	 * 
	 * @author hrz
	 * @date 2015-3-28
	 * @param user
	 *            void TODO
	 */
    public void updateUser(User user);
    /**
     * 
     * @author hrz
     * @date 2015-3-28
     * @param userId
     * void
     * TODO
     */
    public void deleteUser(long userId);
    /**
     * 
     * @author hrz
     * @date 2015-3-28
     * @param userId
     * @param roleIds
     * void
     * TODO
     */
    public void correlationRoles(@Param(value = "userId") long userId,@Param(value = "roleIds")long[] roleIds);
    /**
     * 
     * @author hrz
     * @date 2015-3-28
     * @param userId
     * @param roleIds
     * void
     * TODO
     */
    public void uncorrelationRoles(@Param(value = "userId")long userId, @Param(value = "roleIds")long[] roleIds);
    /**
     * 
     * @author hrz
     * @date 2015-3-28
     * @param userId
     * @return
     * User
     * TODO
     */
    public User findOne(Long userId);
    /**
     * 
     * @author hrz
     * @date 2015-3-28
     * @param username
     * @return
     * User
     * TODO
     */
    public User findByCardId(String cardid);
    /**
     * 
     * @author hrz
     * @date 2015-3-28
     * @param username
     * @return
     * Set<String>
     * TODO
     */
    public Set<String> findRoles(String cardid);
    /**
     * 
     * @author hrz
     * @date 2015-3-28
     * @param username
     * @return
     * Set<String>
     * TODO
     */
    public Set<String> findPermissions(String cardid);
	/**
	 * 
	 * @author hrz
	 * @date 2015-4-1
	 * @param user
	 * @param email
	 * @return
	 * int
	 * TODO
	 */
    public int  update(@Param(value = "user")User user,@Param(value = "email")String email);

	


}
