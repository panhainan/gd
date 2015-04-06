/**
 * 
 */
package com.gd.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.dao.IdeaDao;
import com.gd.dao.PartnerDao;
import com.gd.dao.QuestionDao;
import com.gd.entity.Idea;
import com.gd.service.IdeaService;

/**
 * @author phn
 * @date 2014-12-11
 * @TODO
 */
@Service
public class IdeaServiceImpl implements IdeaService {

	@Autowired
	private IdeaDao ideaDao;
	@Autowired
	private PartnerDao partnerDao;
	@Autowired
	private QuestionDao questionDao;
	@Override
	public Idea findById(long idea_id) {
		Idea idea = null;
		try {
			idea = ideaDao.findById(idea_id);
			return idea;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Idea> findBySendUserId(long idea_user_id) {
		List<Idea> listIdea = null;
		try {
			listIdea = ideaDao.findBySendUserId(idea_user_id);
			return listIdea;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
/**
 * 
 * @author hrz
 * @date 2015-3-14
 * @param idea_user_id
 * @param idea_title
 * @param idea_content
 * @return
 * TODO
 */
	@Override
	public int addIdea(long idea_user_id, String idea_title, String idea_content) {
		// TODO Auto-generated method stub
		try {
			Date date = new Date();
			//当意向书终止时为true，字段可以理解为:是否终止
			boolean status = false;
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("idea_user_id", idea_user_id);
			map.put("idea_title", idea_title);
			map.put("idea_content", idea_content);
			map.put("idea_time", date);
			map.put("idea_status", status);
			return ideaDao.addIdea(map);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
/**
 * 
 * @author hrz
 * @date 2015-3-14
 * @param idea_id
 * @return
 * TODO 停止意向书
 */
	@Override
	public int stopIdea(long idea_id) {
		// TODO Auto-generated method stub
		try {
			return ideaDao.stopIdea( idea_id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		
	}

@Override
public int deleteIdea(long idea_id) {
	// TODO Auto-generated method stub
	try {
		int deleteQuestion = questionDao.deleteQuestionByIdeaId(idea_id);
		System.out.println(deleteQuestion);
		int deletePartner = partnerDao.deletePartnerByIdeaId(idea_id);
		System.out.println(deletePartner);
		return ideaDao.deleteIdea(idea_id);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return 0;
	}
}
		
	
}
