package com.gd.dao;

import com.gd.entity.VerifiedTeam;

public interface VerifiedTeamDao {
	/**
	 * 
	 * @author hrz
	 * @date 2015-3-31
	 * @param team
	 * @return
	 * int
	 * TODO
	 */
	public int addVerifiedTeam(VerifiedTeam team);
	/**
	 * 
	 * @author hrz
	 * @date 2015-4-1
	 * @param email
	 * @return
	 * VerifiedTeam
	 * TODO 通过邮箱查找待验证的团队
	 */
	public VerifiedTeam findTeam(String email);
}
