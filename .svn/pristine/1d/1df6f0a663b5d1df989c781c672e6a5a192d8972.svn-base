/**
 * 
 */
package com.gd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gd.entity.Activity;
import com.gd.entity.Au;

/**
 * @author phn
 * @date 2014-12-10
 * @TODO
 */
public interface AuDao {
	/**
	 * @author phn
	 * @date 2014-12-10
	 * @TODO 通过活动id搜索活动的评价以及评论等信息
	 * @param acti_id
	 * @return
	 */
	public List<Au> findCommentedByActiId(long acti_id);

	/**
	 * @author phn
	 * @date 2014-12-10
	 * @TODO 通过活动id和用户id来搜索活动.
	 * @param acti_id
	 * @param user_id
	 * @return
	 */
	public Au findByActiIdAndUserId(@Param(value = "acti_id") long acti_id,
			@Param(value = "user_id") long user_id);

	/**
	 * @author phn
	 * @date 2015-3-18
	 * @TODO 用户参加活动，由于在表中没有记录，所以在活动中间表建立一条记录
	 * @param au
	 * @return au_id
	 */
	public long addAuByJoin(Au au);

	/**
	 * @author phn
	 * @date 2015-3-18
	 * @TODO 用户参加活动，由于在表中已有记录，所以更新数据库
	 * @param au
	 */
	public void updateAuJoined(Au au);

	/**
	 * @author phn
	 * @date 2015-3-18
	 * @TODO 通过ID查找活动中间表的记录
	 * @param au_id
	 * @return Au
	 */
	public Au findById(long au_id);

	/**
	 * @author phn
	 * @date 2015-3-18
	 * @TODO 活动签到，数据库更新
	 * @param au
	 */
	public void updateAuArrived(Au au);

	/**
	 * @author phn
	 * @date 2015-3-19
	 * @TODO 活动评价，数据库更新
	 * @param au
	 */
	public void updateAuCommented(Au au);

	/**
	 * @author phn
	 * @date 2015-3-19
	 * @TODO 活动点赞，数据库中不存在记录，添加一条记录，重载
	 * @param au
	 */
	public void addAuBySupport(Au au);

	/**
	 * @author phn
	 * @date 2015-3-19
	 * @TODO 活动点赞，数据库中已存在记录，更新记录，重载
	 * @param au
	 */
	public void updateAuSupported(Au au);

	/**
	 * @author phn
	 * @date 2015-4-5
	 * @TODO 获取当前用户的所有已报名但是未参加的活动
	 * @param isJoined
	 * @param isArrived
	 * @param userId
	 * @return
	 */
	public List<Activity> getJoinedUnArrivedActivity(
			@Param(value = "isJoined") boolean isJoined,
			@Param(value = "isArrived") boolean isArrived,
			@Param(value = "userId") long userId);

	/**
	 * @author phn
	 * @date   2015-4-5
	 * @TODO 获取当前用户的所有已签到的活动,查询结构与上述方法类似，但是为了便于以后修改，没有共用。
	 * @param isJoined
	 * @param isArrived
	 * @param userId
	 * @return
	 */
	public List<Activity> getArrivedActivty(@Param(value = "isJoined") boolean isJoined,
			@Param(value = "isArrived") boolean isArrived,
			@Param(value = "userId") long userId);

	/**
	 * @author phn
	 * @date   2015-4-5
	 * @TODO  获取当前用户所有已报名的活动
	 * @param isJoined
	 * @param userId
	 * @return
	 */
	public List<Activity> getAllJoinedActivity(boolean isJoined, long userId);

}
