package com.gd.entity;

import java.util.Date;

public class User {
	
	private long user_id;//用户id
	private String user_university;//所在大学=====共
	private String user_academy;//学院======个
	private String user_cardid;//邮箱=======共
	private String user_password;//密码=====共
	private String user_startyear;//入学年份=====个
	private String user_nickname;//昵称=====共
	private String user_truename;//真实姓名=====个
	private String user_identitycard;//身份证=====个
	private String user_phone;//联系电话=====共
	private String user_picture;//头像=====共
	private String user_intruduction;//简介=====共
	private boolean user_locked = Boolean.FALSE;//
	private String user_salt;//
	private boolean active_status;//状态，false-未激活；true-已激活
	private String validate_code;//激活码
	private Date register_time;//注册时间
	private String password_validate_code;
	private Date password_validate_time;
	private boolean password_validate_status;//状态，true-未点击验证链接进行验证并修改密码；false-已验证并修改
	/**
	 * @means 0为学生，1为团队组织
	 */
	private int user_property;
	private String user_anno_unread;
	
	public User() {
		super();
		this.user_property =0;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getUser_university() {
		return user_university;
	}
	public void setUser_university(String user_university) {
		this.user_university = user_university;
	}
	public String getUser_academy() {
		return user_academy;
	}
	public void setUser_academy(String user_academy) {
		this.user_academy = user_academy;
	}
	public String getUser_cardid() {
		return user_cardid;
	}
	public void setUser_cardid(String user_cardid) {
		this.user_cardid = user_cardid;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_startyear() {
		return user_startyear;
	}
	public void setUser_startyear(String user_startyear) {
		this.user_startyear = user_startyear;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public String getUser_truename() {
		return user_truename;
	}
	public void setUser_truename(String user_truename) {
		this.user_truename = user_truename;
	}
	public String getUser_identitycard() {
		return user_identitycard;
	}
	public void setUser_identitycard(String user_identitycard) {
		this.user_identitycard = user_identitycard;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_picture() {
		return user_picture;
	}
	public void setUser_picture(String user_picture) {
		this.user_picture = user_picture;
	}
	public int getUser_property() {
		return user_property;
	}
	public void setUser_property(int user_property) {
		this.user_property = user_property;
	}
	public String getUser_anno_unread() {
		return user_anno_unread;
	}
	public void setUser_anno_unread(String user_anno_unread) {
		this.user_anno_unread = user_anno_unread;
	}
	//以下为shiro必要的方法
	public boolean isUser_locked() {
		return user_locked;
	}
	public void setUser_locked(boolean user_locked) {
		this.user_locked = user_locked;
	}
	public String getUser_salt() {
		return user_salt;
	}
	public void setUser_salt(String user_salt) {
		this.user_salt = user_salt;
	}
	public String getCredentialsSalt() {
        return user_cardid + user_salt;
    }
	public boolean isActive_status() {
		return active_status;
	}
	public void setActive_status(boolean active_status) {
		this.active_status = active_status;
	}
	
	public String getValidate_code() {
		return validate_code;
	}
	public void setValidate_code(String validate_code) {
		this.validate_code = validate_code;
	}
	public Date getRegister_time() {
		return register_time;
	}
	public void setRegister_time(Date register_time) {
		this.register_time = register_time;
	}
	
	public String getPassword_validate_code() {
		return password_validate_code;
	}
	public void setPassword_validate_code(String password_validate_code) {
		this.password_validate_code = password_validate_code;
	}
	public Date getPassword_validate_time() {
		return password_validate_time;
	}
	public void setPassword_validate_time(Date password_validate_time) {
		this.password_validate_time = password_validate_time;
	}
	
	public boolean isPassword_validate_status() {
		return password_validate_status;
	}
	public void setPassword_validate_status(boolean password_validate_status) {
		this.password_validate_status = password_validate_status;
	}
	
	public String getUser_intruduction() {
		return user_intruduction;
	}
	public void setUser_intruduction(String user_intruduction) {
		this.user_intruduction = user_intruduction;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_university="
				+ user_university + ", user_academy=" + user_academy
				+ ", user_cardid=" + user_cardid + ", user_password="
				+ user_password + ", user_startyear=" + user_startyear
				+ ", user_nickname=" + user_nickname + ", user_truename="
				+ user_truename + ", user_identitycard=" + user_identitycard
				+ ", user_phone=" + user_phone + ", user_picture="
				+ user_picture + ", user_locked=" + user_locked
				+ ", user_salt=" + user_salt + ", active_status="
				+ active_status + ", validate_code=" + validate_code
				+ ", register_time=" + register_time
				+ ", password_validate_code=" + password_validate_code
				+ ", password_validate_time=" + password_validate_time
				+ ", password_validate_status=" + password_validate_status
				+ ", user_property=" + user_property + ", user_anno_unread="
				+ user_anno_unread + "]";
	}
	
	
}
