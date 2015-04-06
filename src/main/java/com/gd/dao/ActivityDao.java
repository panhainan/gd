/**
 * 
 */
package com.gd.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gd.entity.Activity;
import com.gd.entity.User;

/**
 * @author phn
 * @date 2014-12-9
 * @TODO
 */
public interface ActivityDao {

	/**
	 * @author phn
	 * @date   2015-3-29
	 * @TODO 模糊查询获取总的记录数
	 * @param fuzzyQueryPagingParamsMap
	 * @return allRowCount
	 */
	public int getFuzzyQueryPagingAcitivityAllRowCount(
			Map<String, Object> getAllRecordFuzzyQueryPagingParamsMap);

	/**
	 * @author phn
	 * @date   2015-3-29
	 * @TODO 模糊查询
	 * @param fuzzyQueryPagingParamsMap
	 * @return List<Activity>
	 */
	public List<Activity> fuzzyQueryPagingAcitivity(
			Map<String, Object> fuzzyQueryPagingParamsMap);
	/**
	 * @author phn
	 * @date   2015-3-29
	 * @TODO 多条件查询获取总的记录数
	 * @param multiConditionParamsMap
	 * @return allRowCount
	 */
	public int getMultiConditionFindPagingActivityAllRowCount(
			Map<String, Object> getAllRecordMultiConditionParamsMap);

	/**
	 * @author phn
	 * @date   2015-3-29
	 * @TODO 分页多条件查询
	 * @param multiConditionParamsMap
	 * @return List<Activity>
	 */
	public List<Activity> queryMultiConditionFindPagingActivity(
			Map<String, Object> multiConditionParamsMap);
	/**
	 * @author phn
	 * @date   2015-3-21
	 * @TODO 获取热门活动，通过点赞数判断，这里暂时是用来测试的
	 * @param hotRows
	 * @return
	 */
	public List<Activity> testGetHotActivity(byte hotRows);

	/**
	 * @author phn
	 * @date   2014-12-20
	 * @TODO 用于Android测试，查询前10条记录
	 * @return
	 */
	public List<Activity> getLastTen();
	/**
	 * @author phn
	 * @date 2014-12-16
	 * @TODO 添加活动(待优化)
	 * @param acti
	 * @return
	 */
	public long addActivity(Activity acti);

	/**
	 * @author phn
	 * @date   2015-3-14
	 * @TODO 通过ID修改一个活动
	 * @param acti
	 * @return 
	 */
	public long updateActivity(Activity acti);
	
	/**
	 * @author phn
	 * @date   2015-3-14
	 * @TODO 通过删除活动
	 * @param acti_id
	 */
	public void deleteActivity(long acti_id);

	
	/**
	 * @author phn
	 * @date 2014-12-9
	 * @TODO 通过活动id搜索活动
	 * @param acti_id
	 * @return
	 */
	public Activity findById(long acti_id);

	/**
	 * @author phn
	 * @date 2014-12-9
	 * @TODO 通过活动名称来模糊搜索活动
	 * @param acti_name
	 * @return
	 */
	public List<Activity> findByName(
			@Param(value = "acti_name") String acti_name);

	/**
	 * @author phn
	 * @date 2014-12-9
	 * @TODO 通过活动类型名称来搜索活动
	 * @param acti_type
	 * @return
	 */
	public List<Activity> findByType(
			@Param(value = "acti_type") String acti_type);

	/**
	 * @author phn
	 * @date 2014-12-9
	 * @TODO 通过活动举办地址来模糊搜索活动
	 * @param acti_address
	 * @return
	 */
	public List<Activity> findByAddr(
			@Param(value = "acti_address") String acti_address);

	/**
	 * @author phn
	 * @date 2014-12-10
	 * @TODO 通过活动开始时间和结束时间来搜索活动
	 * @param acti_starttime
	 * @param acti_endtime
	 * @return
	 */
	public List<Activity> findByStartEndTime(
			@Param(value = "acti_starttime") Date acti_starttime,
			@Param(value = "acti_endtime") Date acti_endtime);

	/**
	 * @author phn
	 * @date 2014-12-10
	 * @TODO 通过活动发布时间来搜索活动
	 * @param acti_newtime
	 * @return
	 */
	public List<Activity> findByNewTime(
			@Param(value = "acti_newtime") Date acti_newtime);

	/**
	 * @author phn
	 * @date 2014-12-10
	 * @TODO 通过团体组织id搜索发布的活动
	 * @param team_id
	 * @return
	 */
	public List<Activity> findByTeamId(@Param(value = "team_id") long team_id);

	/**
	 * @author phn
	 * @date 2014-12-10
	 * @TODO 通过个人用户id搜索发布的活动
	 * @param stu_id
	 * @return
	 */
	public List<Activity> finbByStuId(@Param(value = "stu_id") long stu_id);

	/**
	 * @author phn
	 * @date 2014-12-11
	 * @TODO 通过活动的二维码来搜索活动
	 * @param activity_twocode
	 * @return
	 */

	public Activity findByTwoCodeForArrive(
			@Param(value = "activity_twocode") String activity_twocode);
	/**
	 * @author phn
	 * @date   2015-3-21
	 * @TODO 点赞后活动点赞数增加，更新数据库
	 * @param paramsMap
	 */
	public void updateActivitySupport(Map<String,Object> paramsMap);
	/**
	 * @author phn
	 * @date   2015-3-21
	 * @TODO 参加活动后，参加人数应该增加，更新数据库
	 * @param paramsMap
	 */
	public void updateActivityJoin(Map<String, Object> paramsMap);

	/**
	 * @author phn
	 * @date   2015-4-5
	 * @TODO 
	 * @param userId
	 * @return
	 */
	public List<Activity> findByUserId(@Param(value="userId")long userId);


	
	
	

}
