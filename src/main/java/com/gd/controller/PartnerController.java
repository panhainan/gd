package com.gd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gd.entity.Partner;
import com.gd.service.PartnerService;

@Controller
@RequestMapping(value = "/partner")
public class PartnerController {
	@Autowired
	private PartnerService partnerService;
	/**
	 * 
	 * @author hrz
	 * @date 2015-3-18
	 * @param part_idea_id
	 * @param part_user_id
	 * @return
	 * boolean
	 * TODO
	 */
	@RequestMapping(value = "/add.do",method=RequestMethod.POST)
	@ResponseBody
	public boolean addPartner(long part_idea_id,long part_user_id){

			int result = partnerService.addPartner(part_idea_id, part_user_id);
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
	 * @param part_idea_id
	 * @return
	 * List<Partner>
	 * TODO
	 */
	@RequestMapping(value = "/ideaid/list.do",method=RequestMethod.GET)
	@ResponseBody
	public List<Partner> findPartnerByIdeaId(long part_idea_id){

			List<Partner> partnerList = partnerService.findPartnerByIdeaId(part_idea_id);
			return partnerList;
	}
	/**
	 * 
	 * @author hrz
	 * @date 2015-3-18
	 * @param part_id
	 * @return
	 * boolean
	 * TODO
	 */
	@RequestMapping(value = "/choose.do",method=RequestMethod.POST)
	@ResponseBody
			public boolean choosePartner(long part_id){

			int result = partnerService.choosePartner(part_id);
			if(result>0){
				return true;
			}else{
				return false;
			}
			
	}
	
}
