package com.gd.entity;
/**
 * 
 * @author hrz
 * @date 2015-3-21
 */
public class Role {
	/**
	 * TODO 未经验证的用户
	 */
	public final static long FalseUserRoleId = 2;
	/**
	 * 经过验证的普通用户
	 */
	public final static long NormalUserRoleId = 1;
	private long id;
	private String role;
	private String description;
	private boolean available;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + ", description="
				+ description + ", available=" + available + "]";
	}

}
