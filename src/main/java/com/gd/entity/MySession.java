package com.gd.entity;
/**
 * 
 * @author hrz
 * @date 2015-3-24
 */
public class MySession {
	private long id;
	private String sessionId;
	private String session;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	@Override
	public String toString() {
		return "MySession [id=" + id + ", sessionId=" + sessionId
				+ ", session=" + session + "]";
	}
	
}
