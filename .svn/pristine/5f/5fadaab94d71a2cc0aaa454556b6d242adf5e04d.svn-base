package com.gd.service.impl;

import java.util.HashMap;
/**
 * @author hrz
 * @date 2014-12-8
 */
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gd.dao.PartnerDao;
import com.gd.entity.Partner;
import com.gd.service.PartnerService;
@Component
public class PartnerServiceImpl implements PartnerService{
	@Autowired
	private PartnerDao partnerDao;
	@Override
	public int addPartner(long part_idea_id, long part_user_id) {
	
		// TODO Auto-generated method stub
		try {
			List<Partner> partners = partnerDao.findPartnerByUserId(part_user_id);
			if(partners.size()>0){
				throw new Exception("已经申请过伙伴");
			}
			Map<String,Object>  partnerMap = new HashMap<String,Object>();
			partnerMap.put("part_idea_id", part_idea_id);
			partnerMap.put("part_user_id", part_user_id);
			partnerMap.put("part_user_success", false);
			return partnerDao.addPartner( partnerMap);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		
	}
	@Override
	public List<Partner> findPartnerByIdeaId(long part_idea_id) {
		// TODO Auto-generated method stub
		try {
			List<Partner> partners = partnerDao.findPartnerByIdeaId(part_idea_id);
			return partners;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
	@Override
	public int choosePartner(long part_id) {
		// TODO Auto-generated method stub
		try {
			return partnerDao.choosePartner(part_id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		
	}
	
	
}
