package com.gd.entity;

import java.util.Date;

/**
 * 
 * @author hrz
 * @date 2015-3-31
 */
public class VerifiedTeam {
	
	private long vari_id;
	private String vari_email;
	private String vari_teamName;
	private String vari_password;
	private String vari_authUser1;
	private String vari_authUser2;
	private String vari_authUser3;
	private String vari_salt;
	private String vari_intruduction;
	private boolean vari_authResult1;
	private boolean vari_authResult2;
	private boolean vari_authResult3;
	private Date vari_date;
	public VerifiedTeam() {
		super();
		this.vari_authResult1 = false;
		this.vari_authResult2 = false;
		this.vari_authResult3 = false;
	}
	public long getVari_id() {
		return vari_id;
	}
	public void setVari_id(long vari_id) {
		this.vari_id = vari_id;
	}
	public String getVari_email() {
		return vari_email;
	}
	public void setVari_email(String vari_email) {
		this.vari_email = vari_email;
	}
	public String getVari_teamName() {
		return vari_teamName;
	}
	public void setVari_teamName(String vari_teamName) {
		this.vari_teamName = vari_teamName;
	}
	public String getVari_password() {
		return vari_password;
	}
	public void setVari_password(String vari_password) {
		this.vari_password = vari_password;
	}
	public String getVari_authUser1() {
		return vari_authUser1;
	}
	public void setVari_authUser1(String vari_authUser1) {
		this.vari_authUser1 = vari_authUser1;
	}
	public String getVari_authUser2() {
		return vari_authUser2;
	}
	public void setVari_authUser2(String vari_authUser2) {
		this.vari_authUser2 = vari_authUser2;
	}
	public String getVari_authUser3() {
		return vari_authUser3;
	}
	public void setVari_authUser3(String vari_authUser3) {
		this.vari_authUser3 = vari_authUser3;
	}
	public boolean isVari_authResult1() {
		return vari_authResult1;
	}
	public void setVari_authResult1(boolean vari_authResult1) {
		this.vari_authResult1 = vari_authResult1;
	}
	public boolean isVari_authResult2() {
		return vari_authResult2;
	}
	public void setVari_authResult2(boolean vari_authResult2) {
		this.vari_authResult2 = vari_authResult2;
	}
	public boolean isVari_authResult3() {
		return vari_authResult3;
	}
	public void setVari_authResult3(boolean vari_authResult3) {
		this.vari_authResult3 = vari_authResult3;
	}
	public Date getVari_date() {
		return vari_date;
	}
	public void setVari_date(Date vari_date) {
		this.vari_date = vari_date;
	}
	
	public String getVari_salt() {
		return vari_salt;
	}
	public void setVari_salt(String vari_salt) {
		this.vari_salt = vari_salt;
	}
	public String getCredentialsSalt(){
		return this.vari_email+this.vari_salt;
	}
	
	public String getVari_intruduction() {
		return vari_intruduction;
	}
	public void setVari_intruduction(String vari_intruduction) {
		this.vari_intruduction = vari_intruduction;
	}
	@Override
	public String toString() {
		return "VerifiedTeam [vari_id=" + vari_id + ", vari_email="
				+ vari_email + ", vari_teamName=" + vari_teamName
				+ ", vari_password=" + vari_password + ", vari_authUser1="
				+ vari_authUser1 + ", vari_authUser2=" + vari_authUser2
				+ ", vari_authUser3=" + vari_authUser3 + ", vari_authResult1="
				+ vari_authResult1 + ", vari_authResult2=" + vari_authResult2
				+ ", vari_authResult3=" + vari_authResult3 + ", vari_date="
				+ vari_date + "]";
	}
	
	
}
