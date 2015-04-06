package com.gd.entity;
/**
 * 
 * @author hrz
 * @date 2015-3-21
 */
public class UserRole {
	private long id;
	private long userId;
	private long roleId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "UserRole [id=" + id + ", userId=" + userId + ", roleId="
				+ roleId + "]";
	}
	
}
