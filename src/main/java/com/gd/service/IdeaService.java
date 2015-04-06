/**
 * 
 */
package com.gd.service;

import java.util.List;

import com.gd.entity.Idea;

/**
 * @author phn
 * @date 2014-12-11
 * @TODO
 */
public interface IdeaService {

	/**
	 * @author phn
	 * @date 2014-12-11
	 * @TODO 通过意向id搜索意向
	 * @param idea_id
	 * @return
	 */
	public Idea findById(long idea_id);

	/**
	 * @author phn
	 * @date 2014-12-11
	 * @TODO 通过意向发起人id搜索意向
	 * @param idea_user_id
	 * @return
	 */
	public List<Idea> findBySendUserId(long idea_user_id);
	/**
	 * 
	 * @author hrz
	 * @date 2015-3-14
	 * @param idea_user_id
	 * @param idea_title
	 * @param idea_content
	 * @return
	 * int
	 * TODO 添加意向
	 */
	public int addIdea(long idea_user_id,String idea_title,String idea_content);
   /**
    * 
    * @author hrz
    * @date 2015-3-14
    * @param idea_id
    * @return
    * int
    * TODO 停止意向书
    */
	public int stopIdea(long idea_id);
	/**
	 * 
	 * @author hrz
	 * @date 2015-3-14
	 * @param idea_id
	 * @return
	 * int
	 * TODO 删除意向
	 */
	public int deleteIdea(long idea_id);
}
