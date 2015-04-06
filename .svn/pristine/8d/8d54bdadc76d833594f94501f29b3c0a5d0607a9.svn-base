package com.gd.shiro;

import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

public class MyCredentialsMatcher extends HashedCredentialsMatcher{
	private Ehcache passwordRetryCache;
	
	/*/shiro/src/main/java/com/hrz/shiro/MyCredentialsMatcher.java
	/shiro/src/main/resource/conf/ehcache.xml*/
	public MyCredentialsMatcher() {
		super();
		
		URL url = CacheManager.class.getClassLoader().getResource("conf/ehcache.xml");
		CacheManager cacheManager = CacheManager.create(url);
		passwordRetryCache =cacheManager.getCache("passwordRetryCache");
		
	}


	@Override
	public boolean doCredentialsMatch(AuthenticationToken token,
			AuthenticationInfo info) {
		// TODO Auto-generated method stub
		String username = (String)token.getPrincipal();  
        //retry count + 1  
		
        Element element = passwordRetryCache.get(username);  
        
        if(element ==null){
        	passwordRetryCache.put(new Element(username,new AtomicInteger(0)));
        	element = passwordRetryCache.get(username);  
        	System.out.println(element.toString());
        }
        AtomicInteger retryCount = (AtomicInteger) element.getObjectValue();
        if(retryCount.incrementAndGet()>5){
        	throw new ExcessiveAttemptsException();
        }
        boolean result = super.doCredentialsMatch(token, info);
        System.out.println("result:"+result);
        if(result){
        	passwordRetryCache.remove(username);
        }
        return result;
	}
	
}
