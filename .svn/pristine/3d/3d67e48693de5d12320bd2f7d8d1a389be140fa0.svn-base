package com.gd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gd.entity.Question;
import com.gd.service.QuestionService;
@Controller
@RequestMapping(value = "/question")
public class QuestionController {
	@Autowired
    private QuestionService questionService;
	/**
	 * 
	 * @author hrz
	 * @date 2015-3-18
	 * @param ques_user_send_id
	 * @param ques_user_rece_id
	 * @param ques_idea_id
	 * @param ques_rped_ques_id
	 * @param ques_content
	 * @return
	 * boolean
	 * TODO
	 */
	@RequestMapping(value = "/publish.do",method=RequestMethod.POST)
	@ResponseBody
	public boolean addQuestion(long ques_user_send_id,long ques_user_rece_id,long ques_idea_id,
			long ques_rped_ques_id,String ques_content){
			int result = questionService.addQuestion(ques_user_send_id, ques_user_rece_id, ques_idea_id, ques_rped_ques_id, ques_content);
			if(result>0){
				return true;
			}else{
				return false;
			}
	}
	/**
	 * 
	 * @author hrz
	 * @date 2015-3-18
	 * @param ques_user_rece_id
	 * @param page
	 * @param pageSize
	 * @return
	 * List<Question>
	 * TODO
	 */
	@RequestMapping(value = "/userreceid/list.do",method=RequestMethod.GET)
	@ResponseBody
	public List<Question> listQuestionByUserReceId(long ques_user_rece_id,int page,int pageSize){
		List<Question> result = questionService.listQuestionByUserReceId(ques_user_rece_id, page, pageSize);
			return result;
	}
	/**
	 * 
	 * @author hrz
	 * @date 2015-3-18
	 * @param ques_user_send_id
	 * @param page
	 * @param pageSize
	 * @return
	 * List<Question>
	 * TODO
	 */
	@RequestMapping(value = "/usersendid/list.do",method=RequestMethod.GET)
	@ResponseBody
	public List<Question> listQuestionByUserSendId(long ques_user_send_id,int page,int pageSize){
		List<Question> result = questionService.listQuestionByUserSendId(ques_user_send_id, page, pageSize);
			return result;
	}
	/**
	 * 
	 * @author hrz
	 * @date 2015-3-18
	 * @param ques_idea_id
	 * @param page
	 * @param pageSize
	 * @return
	 * List<Question>
	 * TODO
	 */
	@RequestMapping(value = "/ideaid/list.do",method=RequestMethod.GET)
	@ResponseBody
	public List<Question> listQuestionByIdeaId(long ques_idea_id,int page,int pageSize){
		List<Question> result = questionService.listQuestionByIdeaId(ques_idea_id, page, pageSize);
			return result;
	}
}
