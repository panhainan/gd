package com.gd.service;

import com.gd.entity.Role;

/**
 * 
 * @author hrz
 * @date 2015-3-21
 */
public interface RoleService {
	public int createRole(Role role);
    public void deleteRole(Long roleId);

  /**
   * 
   * @author hrz
   * @date 2015-3-21
   * @param roleId
   * @param permissionIds
   * void
   * TODO 添加角色-权限之间关系
   */
    public void correlationPermissions(long roleId, long[] permissionIds);


/**
 * 
 * @author hrz
 * @date 2015-3-21
 * @param roleId
 * @param permissionIds
 * void
 * TODO 移除角色-权限之间关系
 */
    public void uncorrelationPermissions(long roleId, long[] permissionIds);
}
