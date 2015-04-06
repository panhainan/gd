package com.gd.service.impl;

import java.util.Date;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gd.dao.QuestionDao;
import com.gd.entity.Question;
import com.gd.service.QuestionService;

/**
 * @author hrz
 * @date 2014-12-8
 */
@Component
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionDao questionDao;
	private Map<String, Object> pageMap = new HashMap<String, Object>();

	@Override
	public int addQuestion(long ques_user_send_id, long ques_user_rece_id,
			long ques_idea_id, long ques_rped_ques_id, String ques_content) {
		// TODO Auto-generated method stub
		try {
			Map<String, Object> questionMap = new HashMap<String, Object>();
			questionMap.put("ques_user_send_id", ques_user_send_id);
			questionMap.put("ques_user_rece_id", ques_user_rece_id);
			questionMap.put("ques_idea_id", ques_idea_id);
			questionMap.put("ques_rped_ques_id", ques_rped_ques_id);
			questionMap.put("ques_content", ques_content);
			Date date = new Date();
			questionMap.put("ques_time", date);
			questionMap.put("ques_rece_read", false);

			return questionDao.addQuestion(questionMap);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public List<Question> listQuestionByUserReceId(long ques_user_rece_id,
			int page, int pageSize) {
		// TODO Auto-generated method stub
		try {
			int count = questionDao.questionByReceIdCount(ques_user_rece_id);
			System.out.println(count);
			int pageCount = (int) Math.ceil((double) count / pageSize);
			if (pageCount == 0) {
				return null;
			} else {
				if (page <= 0) {
					page = 1;
				}
				if (page > pageCount) {
					page = pageCount;
				}
			}
			pageMap.put("id", ques_user_rece_id);
			pageMap.put("first", (page - 1) * pageSize);
			pageMap.put("pageSize", pageSize);
			List<Question> questions = questionDao
					.listQuestionByUserReceId(pageMap);
			return questions;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Question> listQuestionByUserSendId(long ques_user_send_id,
			int page, int pageSize) {
		// TODO Auto-generated method stub
		try {
			int count = questionDao.questionBySendIdCount(ques_user_send_id);
			int pageCount = (int) Math.ceil((double) count / pageSize);
			if (pageCount == 0) {
				return null;
			} else {
				if (page <= 0) {
					page = 1;
				}
				if (page > pageCount) {
					page = pageCount;
				}
			}
			pageMap.put("id", ques_user_send_id);
			pageMap.put("first", (page - 1) * pageSize);
			pageMap.put("pageSize", pageSize);
			List<Question> questions = questionDao
					.listQuestionByUserSendId(pageMap);
			return questions;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Question> listQuestionByIdeaId(long ques_idea_id, int page,
			int pageSize) {
		// TODO Auto-generated method stub
		try {
			int count = questionDao.questionByIdeaIdCount(ques_idea_id);
			int pageCount = (int) Math.ceil((double) count / pageSize);
			if (pageCount == 0) {
				return null;
			} else {
				if (page <= 0) {
					page = 1;
				}
				if (page > pageCount) {
					page = pageCount;
				}
			}
			pageMap.put("id", ques_idea_id);
			pageMap.put("first", (page - 1) * pageSize);
			pageMap.put("pageSize", pageSize);
			List<Question> questions = questionDao
					.listQuestionByIdeaId(pageMap);
			return questions;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

}
