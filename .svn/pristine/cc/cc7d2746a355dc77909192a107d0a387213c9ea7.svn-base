package com.gd.dao;

import java.util.List;
import java.util.Map;

import com.gd.entity.Partner;
/**
 * 
 * @author hrz
 * @date 2014-12-9
 */
public interface PartnerDao {
	/**
	 * 
	 * @author hrz
	 * @date 2014-12-9
	 * @param partnerMap
	 * @return
	 * int
	 * TODO 添加意向书参与者
	 */
	public int addPartner(Map<String,Object> partnerMap); 
	/**
	 * 
	 * @author hrz
	 * @date 2014-12-9
	 * @param part_user_id
	 * @return
	 * List<Partner>
	 * TODO 通过user 的id 查出意向书的申请者
	 */
	public List<Partner> findPartnerByUserId(long part_user_id);
	/**
	 * 
	 * @author hrz
	 * @date 2014-12-9
	 * @param part_idea_id
	 * @return
	 * List<Partner>
	 * TODO 通过意向书id 查询申请者
	 */
	public List<Partner> findPartnerByIdeaId(long part_idea_id);
	/**
	 * 
	 * @author hrz
	 * @date 2014-12-9
	 * @param part_id
	 * @return
	 * int
	 * TODO 选择合作伙伴
	 */
	public int choosePartner(long part_id);
	/**
	 * 
	 * @author hrz
	 * @date 2015-3-14
	 * @param idea_id
	 * @return
	 * int
	 * TODO 通过意向书id删除伙伴
	 */
	public int deletePartnerByIdeaId(long idea_id);
}
