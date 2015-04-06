package com.gd.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.dao.UserDao;
import com.gd.dao.VerifiedTeamDao;
import com.gd.entity.User;
import com.gd.entity.VerifiedTeam;
import com.gd.service.VerifiedTeamService;
@Service
public class VerifiedTeamServiceImpl implements VerifiedTeamService{
	@Autowired
	private VerifiedTeamDao verifiedTeamDao;
	@Autowired
	private UserDao userDao;
	/**
	 * 
	 * @author hrz
	 * @date 2015-4-1
	 * @param vari_teamName
	 * @param vari_email
	 * @param vari_password
	 * @param vari_authUser1
	 * @param vari_authUser2
	 * @param vari_authUser3
	 * @param vari_intruduction
	 * @return
	 * TODO
	 */
	@Override
	public boolean addVerifiedTeam(String vari_teamName, String vari_email,
			String vari_password, String vari_authUser1, String vari_authUser2,
			String vari_authUser3,String vari_intruduction) {
		// TODO Auto-generated method stub
			VerifiedTeam team = new VerifiedTeam();
			team.setVari_authUser1(vari_authUser1);
			team.setVari_authUser2(vari_authUser2);
			team.setVari_authUser3(vari_authUser3);
			team.setVari_date(new Date());
			team.setVari_email(vari_email);
			team.setVari_password(vari_password);
			team.setVari_teamName(vari_teamName);
			team.setVari_intruduction(vari_intruduction);
			PasswordHelper helper = new PasswordHelper();
			helper.encryptPasswordForTeam(team);
			try {
				int result = verifiedTeamDao.addVerifiedTeam(team);
				if(result==0)
					return false;
				else 
					return true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
		
	}
	/**
	 * 
	 * @author hrz
	 * @date 2015-4-1
	 * @param email
	 * @param password
	 * @return
	 * TODO
	 */
	@Override
	public VerifiedTeam checkAuthResult(String email, String password) {
		// TODO Auto-generated method stub
		try {
			VerifiedTeam  team = verifiedTeamDao.findTeam(email);
			PasswordHelper helper = new PasswordHelper();
			 password = helper.checkPassword(team.getCredentialsSalt(), password);
			 if(password.equals(team.getVari_password())){
				 return team;
			 }
			return null;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

	}
	/**
	 * 
	 * @author hrz
	 * @date 2015-4-1
	 * @param email
	 * @return
	 * TODO
	 */
	@Override
	public boolean checkEmali(String email) {
		// TODO Auto-generated method stub
		try {
			VerifiedTeam  team = verifiedTeamDao.findTeam(email);
			if(team == null){
				User user =  userDao.findByCardId(email);
				if(user==null){
					return false;
				}
				return true;
			}
			else{
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return true;
		}
	}
	
	
}
