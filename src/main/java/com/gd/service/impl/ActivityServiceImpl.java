/**
 * 
 */
package com.gd.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.dao.ActivityDao;
import com.gd.dao.UserDao;
import com.gd.dto.Pages;
import com.gd.entity.Activity;
import com.gd.entity.User;
import com.gd.service.ActivityService;

/**
 * @author phn
 * @date 2014-12-9
 * @TODO
 */
@Transactional
@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityDao activityDao;

	@Autowired
	private UserDao userDao;

	@Override
	public Map<String, Object> fuzzyQueryPagingAcitivity(String searchTxt,
			int currentPage, int pageSize) {
		Map<String, Object> fuzzyQueryPagingParamsMap = new HashMap<String, Object>();
		fuzzyQueryPagingParamsMap.put("searchTxt", searchTxt);
		int allRecords = this.activityDao
				.getFuzzyQueryPagingAcitivityAllRowCount(fuzzyQueryPagingParamsMap);
		int totalPages = Pages.calculateTotalPage(pageSize, allRecords);// 总页数
		final int judgedCurrentPage = Pages.judgeCurrentPage(currentPage,
				totalPages);
		Pages pageBean = null;
		List<Activity> listActivity  = null;
		if (judgedCurrentPage != 0) {
			pageBean =  new Pages(allRecords, judgedCurrentPage, pageSize,
					totalPages);
			final int currentPageOffset = Pages.currentPage_startRecord(
					pageSize, judgedCurrentPage);// 当前页的开始记录
			fuzzyQueryPagingParamsMap.put("currentPageOffset",
					currentPageOffset);
			fuzzyQueryPagingParamsMap.put("pageSize", pageSize);
			listActivity = this.activityDao
					.fuzzyQueryPagingAcitivity(fuzzyQueryPagingParamsMap);
		}
		Map<String, Object> pagedMap = new HashMap<String, Object>();
		pagedMap.put("pageBean", pageBean);
		pagedMap.put("listActivity", listActivity);
		return pagedMap;
	}

	@Override
	public Map<String, Object> multiConditionFindPagingActivity(
			String userUniversity, String activityType, Date acti_workingTime,
			int pageSize, int currentPage) {
		Map<String, Object> multiConditionParamsMap = new HashMap<String, Object>();
		multiConditionParamsMap.put("userUniversity", userUniversity);
		multiConditionParamsMap.put("activityType", activityType);
		multiConditionParamsMap.put("workingTime", acti_workingTime);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		multiConditionParamsMap.put("currentTime", sdf.format(new Date()));
		int allRecords = this.activityDao
				.getMultiConditionFindPagingActivityAllRowCount(multiConditionParamsMap);
		int totalPages = Pages.calculateTotalPage(pageSize, allRecords);// 总页数
		final int judgedCurrentPage = Pages.judgeCurrentPage(currentPage,
				totalPages);
		Pages pageBean = null;
		List<Activity> listActivity = null;
		Map<String, Object> pagedMap = new HashMap<String, Object>();
		if (judgedCurrentPage != 0) {
			pageBean = new Pages(allRecords, judgedCurrentPage, pageSize,
					totalPages);
			final int currentPageOffset = Pages.currentPage_startRecord(
					pageSize, judgedCurrentPage);// 当前页的开始记录
			multiConditionParamsMap.put("currentPageOffset", currentPageOffset);
			multiConditionParamsMap.put("pageSize", pageSize);
			listActivity = this.activityDao
					.queryMultiConditionFindPagingActivity(multiConditionParamsMap);
		}
		pagedMap.put("listActivity", listActivity);
		pagedMap.put("pageBean", pageBean);
		return pagedMap;
	}

	@Override
	public List<Activity> testGetHotActivity(byte hotRows) {
		return activityDao.testGetHotActivity(hotRows);
	}

	@Override
	public List<Activity> getLastTen() {
		List<Activity> listActi = null;
		try {
			listActi = activityDao.getLastTen();
			return listActi;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public long addActivity(Activity acti) {
		long acti_result_id = 0;
		try {
			activityDao.addActivity(acti);
			acti_result_id = acti.getActi_id();
			return acti_result_id;
		} catch (Exception e) {
			e.printStackTrace();
			return acti_result_id;
		}
	}

	@Override
	public Activity findById(long activity_id) {
		Activity acti = null;
		try {
			acti = activityDao.findById(activity_id);
			return acti;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Activity> findByName(String activity_name) {
		List<Activity> listActi = null;
		try {
			listActi = activityDao.findByName(activity_name);
			return listActi;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Activity> findByType(String activity_type) {
		List<Activity> listActi = null;
		try {
			listActi = activityDao.findByType(activity_type);
			return listActi;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Activity> findByAddr(String activity_address) {
		List<Activity> listActi = null;
		try {
			listActi = activityDao.findByAddr(activity_address);
			return listActi;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Activity> findByStartEndTime(Date acti_starttime,
			Date acti_endtime) {
		List<Activity> listActi = null;
		try {
			listActi = activityDao.findByStartEndTime(acti_starttime,
					acti_endtime);
			return listActi;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Activity> findByNewTime(Date acti_newtime) {
		List<Activity> listActi = null;
		try {
			listActi = activityDao.findByNewTime(acti_newtime);
			return listActi;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Activity> findByTeamId(long team_id) {
		List<Activity> listActi = null;
		User user = null;
		try {
			user = userDao.findByIdAndProperty(team_id, 1);
			if (user == null) {
				return null;
			}
			listActi = activityDao.findByTeamId(team_id);
			return listActi;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Activity> findByStuId(long stu_id) {
		List<Activity> listActi = null;
		User user = null;
		try {
			user = userDao.findByIdAndProperty(stu_id, 0);
			if (user == null) {
				return null;
			}
			listActi = activityDao.finbByStuId(stu_id);
			return listActi;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void deleteActivity(long acti_id) {
		try {
			activityDao.deleteActivity(acti_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public long updateActivity(Activity acti) {
		long resultId = 0;
		try {
			resultId = activityDao.updateActivity(acti);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultId;
	}

	@Override
	public List<Activity> findByUserId(long userId) {
		return activityDao.findByUserId(userId);
	}

}
