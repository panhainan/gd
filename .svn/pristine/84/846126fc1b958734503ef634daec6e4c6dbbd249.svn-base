package com.gd.service;

import java.util.List;

import com.gd.entity.Partner;

/**
 * 
 * @author hrz
 * @date 2014-12-9
 */
public interface PartnerService {
	/**
	 * 
	 * @author hrz
	 * @date 2014-12-9
	 * @param part_ider_id
	 * @param part_user_id
	 * @return
	 * int
	 * TODO 添加意向书参与者
	 */
		public int addPartner(long part_idea_id,long part_user_id);
		/**
		 * 
		 * @author hrz
		 * @date 2014-12-9
		 * @param part_idea_id
		 * @return
		 * List<Partner>
		 * TODO 根据意向书的id 查出申请者
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
}
