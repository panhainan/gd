package com.gd.dao;

import java.util.List;
import java.util.Map;

import com.gd.entity.Question;

public interface QuestionDao {
	/**
	 * 
	 * @author hrz
	 * @date 2014-12-4
	 * @param questionMap
	 * @return
	 * int
	 * TODO 添加意向书评论
	 */
	public int  addQuestion(Map<String,Object> questionMap);
	
	/**
	 * 
	 * @author hrz
	 * @date 2014-12-4
	 * @param pageMap
	 * @return
	 * List<Question>
	 * TODO 根据接收者id 列出意向书评论
	 */
	public List<Question> listQuestionByUserReceId(Map<String,Object> pageMap);

	/**
	 * 
	 * @author hrz
	 * @date 2014-12-4
	 * @param pageMap
	 * @return
	 * List<Question>
	 * TODO 根据发送者id李处意向书评论
	 */
	public List<Question> listQuestionByUserSendId(Map<String,Object> pageMap);
	
	/**
	 * 
	 * @author hrz
	 * @date 2014-12-4
	 * @param pageMap
	 * @return
	 * List<Question>
	 * TODO 通过意向书id列出意向书评论
	 */
	public List<Question> listQuestionByIdeaId(Map<String,Object> pageMap);
	
	/**
	 * 
	 * @author hrz
	 * @date 2014-12-4
	 * @param ques_idea_id
	 * @return
	 * int
	 * TODO 通过意向书id查出评论数总数用于分页
	 */

	public int questionByIdeaIdCount(long ques_idea_id);
	/**
	 * 
	 * @author hrz
	 * @date 2014-12-4
	 * @param ques_user_rece_id
	 * @return
	 * int
	 * TODO 通过接受者id查出评论数总数用于分页
	 */
	public int questionByReceIdCount(long ques_user_rece_id);
 
	/**
	 * 
	 * @author hrz
	 * @date 2014-12-4
	 * @param ques_user_send_id
	 * @return
	 * int
	 * TODO 通过发送者id查出评论数总数用于分页
	 */
	public int questionBySendIdCount(long ques_user_send_id);
	/**
	 * 
	 * @author hrz
	 * @date 2015-3-14
	 * @param idea_id
	 * @return
	 * int
	 * TODO
	 */
	public int deleteQuestionByIdeaId(long idea_id);
}
