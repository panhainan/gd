package com.gd.service;

import java.util.Set;

import com.gd.entity.User;


public interface UserService {
	public User findById(long user_id);
//	public User findByUsername(String name);

	/**
	 * @author phn
	 * @date   2015-3-30
	 * @TODO 用户注册
	 * @param user
	 * @param userEmail 
	 * @param registerURL
	 * @return true or false
	 */
	public boolean register(User user, String userEmail, String registerURL);

	/**
	 * @author phn
	 * @param userId 
	 * @date   2015-3-31
	 * @TODO 激活
	 * @param email
	 * @param activeStatus
	 * @return true or false 成功或者服务器故障
	 */
	public boolean activeRegister(long userId, String email, boolean activeStatus);
	/**
	 * @author phn
	 * @date   2015-3-31
	 * @TODO 重发激活邮件
	 * @param user
	 * @param email
	 * @param registerURL
	 * @return
	 */
	public boolean resetvalidateCode(User user, String email, String registerURL);
	
	/**
	 * @author phn
	 * @date   2015-4-1
	 * @TODO 用户找回密码，发送找回密码邮件
	 * @param user
	 * @param email
	 * @param replace
	 * @return
	 */
	public boolean findPass(User user, String email, String replace);
	/**
	 * @author phn
	 * @date   2015-4-1
	 * @TODO 重新找回设置密码
	 * @param userEmail
	 * @param userPass
	 * @param isPassword_validate_status
	 * @return 
	 */
	public byte resetFindPass(User user);

	/**
	 * @author phn
	 * @date   2015-3-21
	 * @TODO 测试方法，用来进行暂时登录
	 * @param user
	 * @return user
	 */
	public User testIsExist(User user);
	/**
	 * @author phn
	 * @date   2015-4-2
	 * @TODO 修改登录用户名即邮箱，cardid
	 * @param resetEmail
	 * @param currentEmail
	 */
	public boolean updateEmail(String resetEmail, String currentEmail);

	/**
     * 
     * @author hrz
     * @date 2015-3-21
     * @param user
     * @return
     * User
     * TODO 创建用户
     */
    public int createUser(User user);

    /**
     * 
     * @author hrz
     * @date 2015-3-21
     * @param userId
     * @param newPassword
     * void
     * TODO 修改密码
     */
    public void changePassword(String email, String newPassword);

    /**
     * 
     * @author hrz
     * @date 2015-3-21
     * @param userId
     * @param roleIds
     * void
     * TODO 添加用户-角色关系
     */
    public void correlationRoles(long userId, long[] roleIds);


    /**
     * 
     * @author hrz
     * @date 2015-3-21
     * @param userId
     * @param roleIds
     * void
     * TODO 移除用户-角色关系
     */
    public void uncorrelationRoles(long userId, long[] roleIds);

  /**
   * 
   * @author hrz
   * @date 2015-3-21
   * @param username
   * @return
   * User
   * TODO 根据用户名查找用户
   */
    public User findByCardId(String cardId);

    /**
     * 
     * @author hrz
     * @date 2015-3-21
     * @param username
     * @return
     * Set<String>
     * TODO 根据用户名查找其角色
     */
    public Set<String> findRoles(String cardId);
    
    /**
     * 
     * @author hrz
     * @date 2015-3-21
     * @param username
     * @return
     * Set<String>
     * TODO 根据用户名查找其权限
     */
    public Set<String> findPermissions(String cardId);

    /**
     * 
     * @author hrz
     * @date 2015-4-1
     * @param user
     * @return
     * boolean
     * TODO
     */
    public boolean update(User user);

	

	
}
