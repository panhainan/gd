package com.gd.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gd.dao.DiscussDao;
import com.gd.entity.Discuss;
import com.gd.service.DiscussService;
/**
 * @author hrz
 * @date 2014-12-8
 */
@Component
public class DiscussServiceImpl implements DiscussService{
	@Autowired
	private DiscussDao discussDao;
	private Map<String,Object> pageMap = new HashMap<String, Object>();
	@Override
	public int addDiscuss(long disc_acti_id, long disc_user_send_id,
			long disc_user_rece_id, long disc_user_area_id,long disc_rped_disc_id,
			String disc_content) {
		try {
			Date disc_time  = new Date();
			Map<String,Object> map=new HashMap<String, Object>(); 
			boolean disc_rece_read = false;
			map.put("disc_acti_id", disc_acti_id);
			map.put("disc_user_send_id", disc_user_send_id);
			map.put("disc_user_rece_id", disc_user_rece_id);
			map.put("disc_user_area_id", disc_user_area_id);
			map.put("disc_rped_disc_id", disc_rped_disc_id);
			map.put("disc_content", disc_content);
			map.put("disc_time", disc_time);
			map.put("disc_rece_read", disc_rece_read);
			discussDao.addDiscuss(map);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Discuss> listDiscussByUserReceId(long disc_user_rece_id,int page,int pageSize) {
		// TODO Auto-generated method stub
		try {
			int count = discussDao.discussByReceIdCount(disc_user_rece_id);
			int pageCount = (int)Math.ceil((double)count/pageSize);
			if(pageCount == 0){
			 return null;
			}else {
				if(page <= 0){
					page = 1;
				}
				if(page > pageCount){
					page = pageCount;
				}
			}
			pageMap.put("id", disc_user_rece_id);
			pageMap.put("first", (page-1)*pageSize);
			pageMap.put("pageSize", pageSize);
			List<Discuss> discusses;
			discusses = discussDao.listDiscussByUserReceId(pageMap);
			return discusses;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Discuss> listDiscussByUserSendId(long disc_user_send_id,int page,int pageSize) {
		// TODO Auto-generated method stub
		try {
			int count = discussDao.discussBySendIdCount(disc_user_send_id);
			int pageCount = (int)Math.ceil((double)count/pageSize);
			if(pageCount == 0){
			 return null;
			}else {
				if(page <= 0){
					page = 1;
				}
				if(page > pageCount){
					page = pageCount;
				}
			}
			pageMap.put("id", disc_user_send_id);
			pageMap.put("first", (page-1)*pageSize);
			pageMap.put("pageSize", pageSize);
			List<Discuss> discusses;
			discusses = discussDao.listDiscussByUserSendId(pageMap);
			return discusses;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Discuss> listDiscussByActiId(long disc_acti_id,int page,int pageSize) {
		// TODO Auto-generated method stub
		try {
			int count = discussDao.discussByActiIdCount(disc_acti_id);
			int pageCount = (int)Math.ceil((double)count/pageSize);
			if(pageCount == 0){
			 return null;
			}else {
				if(page <= 0){
					page = 1;
				}
				if(page > pageCount){
					page = pageCount;
				}
			}
			pageMap.put("id", disc_acti_id);
			pageMap.put("first", (page-1)*pageSize);
			pageMap.put("pageSize", pageSize);
			List<Discuss> discusses;
			discusses = discussDao.listDiscussByActiID(pageMap);
			return discusses;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	
	
	
}
