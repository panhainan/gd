package com.gd.util;

import java.net.URL;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import com.gd.entity.User;
/**
 * 
 * @author hrz
 * @date 2015-4-2
 */
public class CacheUtils {
	private URL url = CacheManager.class.getClassLoader().getResource("conf/ehcache.xml");
	private CacheManager cacheManager = CacheManager.create(url);
	
	public User findUserInfoCache(String email){
		Ehcache userInfoCache =cacheManager.getCache("userInfoCache");
		Element element = userInfoCache.get(email);
		if(element!=null){
			User user = (User) element.getObjectValue();
			return user;
		}
		else{
			return null;
		}
	}
	
	public User addUserInCache(User user,String email){
		Ehcache userInfoCache = cacheManager.getCache("userInfoCache");
		Element element = userInfoCache.get(email);
			if(element == null){
				userInfoCache.put(new Element(email,user));
			}
			return user;
		}
		
	public void deleteUserinCache(String  email){
		Ehcache userInfoCache = cacheManager.getCache("userInfoCache");
		userInfoCache.remove(email);
	}
}
	

