package com.gd.dao;

import com.gd.entity.Role;

/**
 * 
 * @author hrz
 * @date 2015-3-21
 */
public interface RoleDao {
	public int createRole(Role role);
    public void deleteRole(long roleId);
    public void deleteRolePermission(long roleId);
	public void deleteUserRole(long roleId);
    public void correlationPermissions(long roleId, long[] permissionIds);
    public void uncorrelationPermissions(long roleId, long[] permissionIds);
	
}
