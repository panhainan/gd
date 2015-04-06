package com.gd.dto;

public class MailType {
	public final static byte REGISTER_TYPE_MAIL = 1;
	public final static byte RESET_PASSWORD_TYPE_MAIL = 2;
	private String email;
	private String username;
	private byte type;
	private String url;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public byte getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "MailType [email=" + email + ", username=" + username
				+ ", type=" + type + ", url=" + url + "]";
	}
	
}
