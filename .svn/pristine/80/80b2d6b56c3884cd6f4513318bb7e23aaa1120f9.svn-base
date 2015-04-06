/**
 * 
 */
package com.gd.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.dao.ActivityDao;
import com.gd.dao.AuDao;
import com.gd.entity.Activity;
import com.gd.entity.Au;
import com.gd.entity.User;
import com.gd.service.AuService;

/**
 * @author phn
 * @date 2014-12-10
 * @TODO
 */
@Service
public class AuServiceImpl implements AuService {

	@Autowired
	private AuDao auDao;
	@Autowired
	private ActivityDao actiDao;

	@Override
	public List<Au> findCommentedByActiId(long acti_id) {
		List<Au> listAu = null;
		try {
			listAu = auDao.findCommentedByActiId(acti_id);
			return listAu;
		} catch (Exception e) {
			e.printStackTrace();
			//这里需要注意，防止服务器出错后不知道
			System.out.println("查找失败");
			return null;
		}
	}

	@Override
	public Au findByTCodeAndUserId(String activity_twocode, long user_id) {
		Activity acti = null;
		Au au = null;
		try {
			acti = actiDao.findByTwoCodeForArrive(activity_twocode);
			au = auDao.findByActiIdAndUserId(acti.getActi_id(), user_id);
			au.setAu_acti(acti);
			return au;
		} catch (Exception e) {
			e.printStackTrace();
			//这里需要注意，防止服务器出错后不知道
			System.out.println("查找失败");
			return null;
		}
	}

	@Override
	public byte validActivityIsJoined(long acti_id, long user_id) {
		Au au = null;
		au = auDao.findByActiIdAndUserId(acti_id, user_id);
		if (au == null) {//数据库中不存在记录，表示没有参加，返回0
			return 0;
		} else if (au.isAu_join() == false) {//数据库中存在记录，但是没有参加，是由于点赞产生，返回-1
			return -1;
		}
		return 1;//数据库中有记录，并且已经参加，返回1
	}

	@Override
	public long joinActivity(long acti_id, long user_id) {
		Au au = new Au();

		Activity acti = new Activity();
		acti.setActi_id(acti_id);

		User user = new User();
		user.setUser_id(user_id);

		au.setAu_acti(acti);
		au.setAu_user(user);
		Map<String ,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("activity_id", acti.getActi_id());
		int joinValue = 1;//这里留着如果以后更改需求存在取消参加这个活动时进行
		paramsMap.put("updateValue",joinValue);
		// 这里需要进行事务处理
		try {
			au.setAu_join(true);
			auDao.addAuByJoin(au);
			actiDao.updateActivityJoin(paramsMap);
			// System.out.println(au.getAu_id());
			return au.getAu_id();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public boolean joinActivity(long activity_id, long user_id,
			boolean auIsExist) {
		Au au = new Au();

		Activity acti = new Activity();
		acti.setActi_id(activity_id);

		User user = new User();
		user.setUser_id(user_id);

		au.setAu_acti(acti);
		au.setAu_user(user);
		Map<String ,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("activity_id", acti.getActi_id());
		int joinValue = 1;//这里留着如果以后更改需求存在取消参加这个活动时进行
		paramsMap.put("updateValue",joinValue);
		try {
			au.setAu_join(true);
			auDao.updateAuJoined(au);
			actiDao.updateActivityJoin(paramsMap);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public byte validActivityIsSigned(long acti_id, long user_id) {
		Au au = null;
		au = auDao.findByActiIdAndUserId(acti_id, user_id);
		if (au != null) {//数据库中存在此记录
			if(au.isAu_join()==false){//没有参加，记录是由点赞生成
				return -1;
			}
			if (au.isAu_arrive()==false) {//已经参加但是没有签到，则返回0
				return 0;
			}
			return 1;//已经参加并且已经签到，返回1
		}
		return -1;//数据库中不存在此记录，返回-1
	}

	@Override
	public boolean signActivity(long activity_id, long user_id) {
		Au au = new Au();

		Activity acti = new Activity();
		acti.setActi_id(activity_id);

		User user = new User();
		user.setUser_id(user_id);

		au.setAu_acti(acti);
		au.setAu_user(user);

		
		// 这里需要进行事务处理
		try {
			au.setAu_arrive(true);// 确认签到
			auDao.updateAuArrived(au);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Au evaluateActivity(Au au, long activity_id, long user_id) {
		Activity acti = new Activity();
		acti.setActi_id(activity_id);
		
		User user = new User();
		user.setUser_id(user_id);
		
		au.setAu_acti(acti);
		au.setAu_user(user);
		try {
			au.setAu_comment(true);
			auDao.updateAuCommented(au);
			return au;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public Au findById(long au_id) {
		Au au = null;
		au = auDao.findById(au_id);
		return au;
	}

	@Override
	public Au findByActiIdAndUserId(long activity_id, long user_id) {
		Au au = null;
		au = auDao.findByActiIdAndUserId(activity_id, user_id);
		return au;
	}

	@Override
	public byte validActivityIsEvaluated(long activity_id, long user_id) {
		Au au = null;
		au = auDao.findByActiIdAndUserId(activity_id, user_id);
		if (au == null) {// 如果数据库中不存在此记录，表示没有参加或者没有点赞此活动，返回表示没有参加此活动的值-1
			return -1;
		} else if (au.isAu_join()) {
			if (au.isAu_arrive()) {
				if (au.isAu_comment()) {// 已经参加此活动并且已经签到评价，返回表示已评价的值2
						return 2;
					} 
				return 1;// 已经参加此活动并签到但是没有评价，返回表示没有评价的值1
			}
			return 0;// 已经参加此活动而没有签到，同样返回表示没有签到活动的值0
		} else {//如果数据库中存在此记录，但是是由于点赞产生的，没有参加，返回-1
			return -1;
		}
	}
	@Override
	public byte validActivityIsSupported(long activity_id, long user_id) {
		Au au = null;
		au = auDao.findByActiIdAndUserId(activity_id, user_id);
		if(au==null){//数据库中不存在此记录
			return 0;
		}else if(au.isAu_eval_support()){//数据库中存在此记录,已点赞
			return 1;
		}
		return -1;//数据库中已经存在被点赞的此记录
	}
	@Override
	public boolean supportActivity(long activity_id, long user_id) {
		Au au = new Au();
		Activity acti = new Activity();
		acti.setActi_id(activity_id);
		
		User user = new User();
		user.setUser_id(user_id);
		
		au.setAu_acti(acti);
		au.setAu_user(user);
		Map<String ,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("activity_id", acti.getActi_id());
		paramsMap.put("updateValue",1);//点赞加一
		try {
			au.setAu_eval_support(true);
			auDao.addAuBySupport(au);
			//没有进行事务处理，后面需要修改
			actiDao.updateActivitySupport(paramsMap);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean supportActivity(long activity_id, long user_id,
			boolean activityIsSupported) {
		Au au = new Au();
		Activity acti = new Activity();
		acti.setActi_id(activity_id);
		
		User user = new User();
		user.setUser_id(user_id);
		
		au.setAu_acti(acti);
		au.setAu_user(user);
		Map<String ,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("activity_id", acti.getActi_id());
		int supportValue = -1;//默认取消赞,取消赞减一
		if(activityIsSupported){
			supportValue = 1; //点赞加一
		}
		paramsMap.put("updateValue",supportValue);
		try {
			au.setAu_eval_support(activityIsSupported);
			auDao.updateAuSupported(au);
			//没有进行事务处理，后面需要修改
			actiDao.updateActivitySupport(paramsMap);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Activity> getJoinedUnArrivedActivity(boolean isJoined, boolean isArrived,
			long userId) {
		return auDao.getJoinedUnArrivedActivity(isJoined,isArrived,userId);
	}

	@Override
	public List<Activity> getArrivedActivity(boolean isJoined,
			boolean isArrived, long userId) {
		return auDao.getArrivedActivty(isJoined,isArrived,userId);
	}

	@Override
	public List<Activity> getAllJoinedActivity(boolean isJoined, long userId) {
		return auDao.getAllJoinedActivity(isJoined,userId);
	}



}
