package com.gd.service;

import java.util.List;

import com.gd.entity.Question;

public interface QuestionService {
	/**
	 * 
	 * @author hrz
	 * @date 2014-11-25
	 * @param ques_user_send_id
	 * @param ques_user_rece_id
	 * @param ques_idea_id
	 * @param ques_content
	 * @return
	 * int
	 * TODO 添加意向问题
	 */
	public int addQuestion(long ques_user_send_id,long ques_user_rece_id,long ques_idea_id,long ques_rped_ques_id,String ques_content);
	
	/**
	 * 
	 * @author hrz
	 * @date 2014-12-4
	 * @param ques_user_rece_id
	 * @param page
	 * @param pageSize
	 * @return
	 * List<Question>
	 * TODO 通过接受者id查询意向评论
	 */
	public List<Question> listQuestionByUserReceId(long ques_user_rece_id,int page,int pageSize);
	/**
	 * 
	 * @author hrz
	 * @date 2014-12-4
	 * @param ques_user_send_id
	 * @param page
	 * @param pageSize
	 * @return 
	 * List<Question>
	 * TODO 通过发送者id查询意向评论
	 */
	public List<Question> listQuestionByUserSendId(long ques_user_send_id,int page,int pageSize);
	
	/**
	 * 
	 * @author hrz
	 * @date 2014-12-4
	 * @param ques_acti_id
	 * @param page
	 * @param pageSize
	 * @return
	 * List<Question>
	 * TODO 通过意向书id查询意向书提问
	 */
	public List<Question> listQuestionByIdeaId(long ques_idea_id,int page,int pageSize);
	
	
}
