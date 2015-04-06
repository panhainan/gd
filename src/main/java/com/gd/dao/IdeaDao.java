/**
 * 
 */
package com.gd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gd.entity.Idea;

/**
 * @author phn
 * @date 2014-12-11
 * @TODO
 */
public interface IdeaDao {

	/**
	 * @author phn
	 * @date 2014-12-11
	 * @TODO 通过意向id搜索意向
	 * @param idea_id
	 * @return
	 */
	public Idea findById(@Param(value = "idea_id") long idea_id);

	/**
	 * @author phn
	 * @date 2014-12-11
	 * @TODO 通过意向发起人id搜索意向
	 * @param idea_user_id
	 * @return
	 */
	public List<Idea> findBySendUserId(
			@Param(value = "idea_user_id") long idea_user_id);
	/**
	 * 
	 * @author hrz
	 * @date 2015-3-14
	 * @param map
	 * @return
	 * int 
	 * TODO 添加意向
	 */
	public int addIdea(Map<String,Object> map);
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
