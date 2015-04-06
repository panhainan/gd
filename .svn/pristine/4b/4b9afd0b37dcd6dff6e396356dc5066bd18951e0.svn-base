package com.gd.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.gd.entity.User;
import com.gd.service.UserService;


public class MyRealm extends AuthorizingRealm{
	@Autowired
	private UserService userService;
	//获取授权信息
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		String idcard = (String)arg0.getPrimaryPrincipal();  
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();  
        authorizationInfo.setRoles(userService.findRoles(idcard));  
        authorizationInfo.setStringPermissions(userService.findPermissions(idcard));  
        return authorizationInfo;  
	}
	//获取身份验证相关信息
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		System.out.println("doGetAuthenticationInfo");
		 String cardid = (String)arg0.getPrincipal();  
	        User user = userService.findByCardId(cardid);
	        if(user == null) {  
	            throw new UnknownAccountException();//没找到帐号  
	        }  
	        System.out.println("id:"+user.getUser_id());
	        if(Boolean.TRUE.equals(user.isUser_locked())) {  
	            throw new LockedAccountException(); //帐号锁定  
	        }  
	        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以在此判断或自定义实现  
	        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(  
	                user.getUser_cardid(), //用户名  
	                user.getUser_password(), //密码  
	                ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt  
	                getName()  //realm name  
	        );  
	        return authenticationInfo;  
	}


	
}
