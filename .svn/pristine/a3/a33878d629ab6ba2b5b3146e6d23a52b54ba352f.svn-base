package com.gd.dao;

import java.util.List;
import java.util.Map;

import com.gd.entity.Discuss;
/**
 * 
 * @author hrz
 * @date 2014-11-18
 */
public interface DiscussDao {
	/**
	 * 
	 * @author hrz
	 * @date 2014-11-18
	 * @param disc_acti_id
	 * @param disc_user_send_id
	 * @param disc_user_rece_id
	 * @param disc_user_area_id
	 * @param disc_content
	 * @param disc_time
	 * @return
	 * void
	 * TODO 添加评论内容
	 */
	public int addDiscuss(Map<String,Object> DiscussMap);
	/**
	 * 
	 * @author hrz
	 * @date 2014-11-18
	 * @param disc_user_rece_id
	 * @return List<Discuss>
	 * TODO 通过接受者的ID列出评论内容
	 */
	public List<Discuss> listDiscussByUserReceId(Map<String,Object> pageMap);
	/**
	 * 
	 * @author hrz
	 * @date 2014-11-18
	 * @param disc_user_send_id
	 * @return List<Discuss>
	 * TODO 通过发送者列出评论
	 */
	public List<Discuss> listDiscussByUserSendId(Map<String,Object> pageMap);
	
	/**
	 * 
	 * @author hrz
	 * @date 2014-11-22
	 * @param pageMap
	 * @return
	 * List<Discuss>
	 * TODO
	 */
	public List<Discuss> listDiscussByActiID(Map<String,Object> pageMap);
	/**
	 * 
	 * @author hrz
	 * @date 2014-11-21
	 * @param disc_user_area_id
	 * @return
	 * List<Discuss>
	 * TODO
	 */
	public List<Discuss> listDiscussByAreaId(long disc_user_area_id);
	
	/**
	 * 
	 * @author hrz
	 * @date 2014-11-22
	 * @param disc_acti_id
	 * @return
	 * int
	 * TODO 查出该活动的评论总数，用于分页计算总页数
	 */
	public int discussByActiIdCount(long disc_acti_id);
	/**
	 * 
	 * @author hrz
	 * @date 2014-11-22
	 * @param disc_user_rece_id
	 * @return
	 * int
	 * TODO 根据接受者id查出评论总数，用于分页计算总页数
	 */
	public int discussByReceIdCount(long disc_user_rece_id);
	/**
	 * 
	 * @author hrz
	 * @date 2014-11-22
	 * @param disc_user_send_id
	 * @return
	 * int
	 * TODO 根据发送者查出评论总数，用于分页计算总页数
	 */
	public int discussBySendIdCount(long disc_user_send_id);
}
