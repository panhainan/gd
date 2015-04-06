package com.gd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.dao.RoleDao;
import com.gd.entity.Role;
import com.gd.service.RoleService;
/**
 * 
 * @author hrz
 * @date 2015-3-21
 */
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao ;


    public int createRole(Role role) {
        return roleDao.createRole(role);
    }

    public void deleteRole(Long roleId) {
    	roleDao.deleteRolePermission( roleId);
    	roleDao.deleteUserRole( roleId);
        roleDao.deleteRole(roleId);
    }
    
    /**
     * 
     * @author hrz
     * @date 2015-3-21
     * @param roleId
     * @param permissionIds
     * void
     * TODO 添加角色-权限之间关系
     */
    public void correlationPermissions(long roleId, long[] permissionIds) {
        roleDao.correlationPermissions(roleId, permissionIds);
    }

    /**
     * 
     * @author hrz
     * @date 2015-3-21
     * @param roleId
     * @param permissionIds
     * void
     * TODO 添加角色-权限之间关系
     */
    public void uncorrelationPermissions(long roleId, long[] permissionIds) {
        roleDao.uncorrelationPermissions(roleId, permissionIds);
    }
}
