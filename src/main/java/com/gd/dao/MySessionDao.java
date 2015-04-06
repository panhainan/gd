package com.gd.dao;

import java.io.Serializable;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;

import com.gd.entity.MySession;
import com.gd.util.SerializableUtils;

public class MySessionDao extends CachingSessionDAO{
	@Autowired
	private DataSessionDao dataSessionDao;
	@Override
	protected void doUpdate(Session session) {
		// TODO Auto-generated method stub
		System.out.println("Dao:doUpdate");
		 if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()) {  
		        return; //如果会话过期/停止 没必要再更新了  
		    } else{
		    	dataSessionDao.doUpdate(session.getId(), SerializableUtils.sessionToString(session));
		    }
	}

	@Override
	protected void doDelete(Session session) {
		// TODO Auto-generated method stub
		System.out.println("Dao:doDelete");
		dataSessionDao.doDelete(session.getId());
	}

	@Override
	protected Serializable doCreate(Session session) {
		// TODO Auto-generated method stub
		System.out.println("Dao:doCreate");
		Serializable sessionId = generateSessionId(session); 
		assignSessionId(session, sessionId); 
		int result =dataSessionDao.doCreate(sessionId, SerializableUtils.sessionToString(session));
		System.out.println(result);
		return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		// TODO Auto-generated method stub
		System.out.println("Dao:doReadSession");
		MySession mySession =dataSessionDao.doReadSession(sessionId);
		if(mySession ==null){
		return null;
		}else{
			return SerializableUtils.stringToSession(mySession.getSession());
		}
	}

}
