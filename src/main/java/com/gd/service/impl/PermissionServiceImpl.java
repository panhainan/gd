package com.gd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.dao.PermissionDao;
import com.gd.entity.Permission;
import com.gd.service.PermissionService;

/**
 * 
 * @author hrz
 * @date 2015-3-21
 */
@Service
public class PermissionServiceImpl implements PermissionService{
	@Autowired
	private PermissionDao permissionDao ;

    public int  createPermission(Permission permission) {
        return permissionDao.createPermission(permission);
    }

    public void deletePermission(long permissionId) {
    	permissionDao.deleteRolePermission(permissionId);
        permissionDao.deletePermission(permissionId);
    }
}
