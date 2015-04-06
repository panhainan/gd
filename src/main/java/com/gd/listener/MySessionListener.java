package com.gd.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

public class MySessionListener implements SessionListener{

	@Override
	public void onStart(Session session) {
		// TODO Auto-generated method stub
		System.out.println("Session:onStart");
	}

	@Override
	public void onStop(Session session) {
		// TODO Auto-generated method stub
		System.out.println("Session:onStop");
	}

	@Override
	public void onExpiration(Session session) {
		// TODO Auto-generated method stub
		System.out.println("Session:onExpiration");
	}

	

	
	
}
