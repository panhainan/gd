package com.gd.service;

import java.util.List;

import com.gd.entity.Discuss;
	/**
	 * 
	 * @author hrz
	 * @date 2014-11-18
	 */
public interface DiscussService {
	/**
	 * 
	 * @author hrz
	 * @date 2014-12-4
	 * @param disc_acti_id
	 * @param disc_user_send_id
	 * @param disc_user_rece_id
	 * @param disc_user_area_id
	 * @param disc_rped_disc_id
	 * @param disc_content
	 * @param disc_time
	 * @return
	 * int
	 * TODO
	 */
	public int addDiscuss(long disc_acti_id,long disc_user_send_id,long disc_user_rece_id,long disc_user_area_id,long disc_rped_disc_id,String disc_content);
	/**
	 * 
	 * @author hrz
	 * @date 2014-11-22
	 * @param disc_user_rece_id
	 * @param page
	 * @param pageSize
	 * @return
	 * List<Discuss>
	 * TODO
	 */
	public List<Discuss> listDiscussByUserReceId(long disc_user_rece_id,int page,int pageSize);
	/**
	 * 
	 * @author hrz
	 * @date 2014-11-22
	 * @param disc_user_send_id
	 * @param page
	 * @param pageSize
	 * @return
	 * List<Discuss>
	 * TODO
	 */
	public List<Discuss> listDiscussByUserSendId(long disc_user_send_id,int page,int pageSize);
	
	/**
	 * 
	 * @author hrz
	 * @date 2014-11-22
	 * @param disc_acti_id
	 * @param page
	 * @param pageSize
	 * @return
	 * List<Discuss>
	 * TODO
	 */
	public List<Discuss> listDiscussByActiId(long disc_acti_id,int page,int pageSize);
	
}
