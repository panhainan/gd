package com.gd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gd.entity.Idea;
import com.gd.service.IdeaService;

@Controller
@RequestMapping(value = "/idea")
public class IdeaController {
		@Autowired
		private IdeaService ideaService;
		/**
		 * 
		 * @author hrz
		 * @date 2015-3-18
		 * @param idea_id
		 * @return
		 * Idea
		 * TODO
		 */
		@RequestMapping(value = "/id/list.do",method=RequestMethod.GET)
		@ResponseBody
		public Idea findById(long idea_id){
			Idea idea = ideaService.findById(idea_id);
			return idea;
		}
		/**
		 * 
		 * @author hrz
		 * @date 2015-3-18
		 * @param idea_user_id
		 * @return
		 * List<Idea>
		 * TODO
		 */
		@RequestMapping(value = "/senduserid/list.do",method=RequestMethod.GET)
		@ResponseBody
		public List<Idea> findBySendUserId(long idea_user_id){
			List<Idea> ideaList = ideaService.findBySendUserId(idea_user_id);
			return ideaList;
		}
		/**
		 * 
		 * @author hrz
		 * @date 2015-3-18
		 * @param idea_user_id
		 * @param idea_title
		 * @param idea_content
		 * @return
		 * boolean
		 * TODO
		 */
		@RequestMapping(value = "/add.do",method=RequestMethod.POST)
		@ResponseBody
		public boolean addIdea(long idea_user_id,String idea_title,String idea_content){
			int  result = ideaService.addIdea(idea_user_id, idea_title, idea_content);
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
		 * @param idea_id
		 * @return
		 * boolean
		 * TODO
		 */
		@RequestMapping(value = "/stop.do",method=RequestMethod.POST)
		@ResponseBody
		public boolean stopIdea(long idea_id){
			int  result = ideaService.stopIdea(idea_id);
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
		 * @param idea_id
		 * @return
		 * boolean
		 * TODO
		 */
		@RequestMapping(value = "/delete.do",method=RequestMethod.POST)
		@ResponseBody
		public boolean deleteIdea(long idea_id){
			int  result = ideaService.deleteIdea(idea_id); 
			if(result>0){
				return true;
			}else{
				return false;
			}

		}
}
