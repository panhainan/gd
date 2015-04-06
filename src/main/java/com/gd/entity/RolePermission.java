package com.gd.entity;
/**
 * 
 * @author hrz
 * @date 2015-3-21
 */
public class RolePermission {
	private long id;
	private long roleId;
	private long permissionId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public long getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(long permissionId) {
		this.permissionId = permissionId;
	}
	@Override
	public String toString() {
		return "RolePermission [id=" + id + ", roleId=" + roleId
				+ ", permissionId=" + permissionId + "]";
	}
	
}
