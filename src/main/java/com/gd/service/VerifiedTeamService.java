package com.gd.service;

import com.gd.entity.VerifiedTeam;


/**
 * 
 * @author hrz
 * @date 2015-3-31
 */
public interface VerifiedTeamService {
	/**
	 * 
	 * @author hrz
	 * @date 2015-3-31
	 * @param vari_teamName
	 * @param vari_email
	 * @param vari_password
	 * @param vari_authUser1
	 * @param vari_authUser2
	 * @param vari_authUser3
	 * @return
	 * boolean
	 * TODO
	 */
	public boolean addVerifiedTeam(String vari_teamName,String vari_email,
			String vari_password,String vari_authUser1,
			String vari_authUser2,String vari_authUser3,String vari_intruduction);
	/**
	 * 
	 * @author hrz
	 * @date 2015-4-1
	 * @param email
	 * @param password
	 * @return
	 * VerifiedTeam
	 * TODO
	 */
	   public VerifiedTeam checkAuthResult(String email,String password);
	   /**
	    * 
	    * @author hrz
	    * @date 2015-4-1
	    * @param email
	    * @return
	    * String
	    * TODO 验证邮箱是否已经被验证过
	    */
	   public boolean checkEmali(String email);
}

