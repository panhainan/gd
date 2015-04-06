/**
 * 
 */
package com.gd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gd.entity.Au;
import com.gd.entity.User;
import com.gd.service.AuService;
import com.gd.service.UserService;

/**
 * @author phn
 * @date 2014-12-20
 * @TODO
 */
@Controller("auController")
@RequestMapping(value = "/evaluate")
public class AuController {
	@Autowired
	private AuService auService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/activity/list.do",method=RequestMethod.GET)
	@ResponseBody
	public List<Au> findCommentedByActiId(long activity_id) {
		List<Au> listAu = null;
		listAu = auService.findCommentedByActiId(activity_id);
		return listAu;
	}
	
	@RequestMapping(value = "/activity/twocode/search.do",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findByTCodeAndUserId(String activity_twocode) {
		Au au = null;
		Subject subject = SecurityUtils.getSubject();
		String email = (String) subject.getPrincipal();
		User user = userService.findByCardId(email);
		boolean findAuStatusByTCodeResult = false; 
		au = auService.findByTCodeAndUserId(activity_twocode,user.getUser_id());
		Map<String, Object> map = new HashMap<String, Object>();
		if(au!=null){
			findAuStatusByTCodeResult = true;
			map.put("au",au);
		}
		map.put("findAuStatusByTCodeResult",findAuStatusByTCodeResult);
		return map;
	}
	
	/**
	 * @author phn
	 * @date 2015-3-17
	 * @TODO 报名参加活动
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/activity/join.do", method = RequestMethod.POST)
	public Map<String, Object> joinActivity(long activity_id) {
		/**
		 * 1：判断用户是否已经参加活动或者已经点赞导致数据库已经存在一条记录，但不属于已参加的记录
		 * 2：如果没有参加，则可以进行参加操作，在数据库中进行添加一条记录
		 * 3；如果已经参加，则不能进行再次参加操作；如果已经点赞，则在数据库对应的是否报名参加的字段进行修改
		 * 4：参加成功则返回成功的提示，失败则返回失败的提示
		 * **/
		// System.out.println("activity_id:"+activity_id);
		Map<String, Object> map = new HashMap<String, Object>();
		boolean joinActivityResult = false;
		Subject subject = SecurityUtils.getSubject();
		String email = (String) subject.getPrincipal();
		User user = userService.findByCardId(email);
		byte userIsJoinedActivity = 0; // 0表示没有参加并且数据库没有记录,-1表示没有参加但是数据库已有记录,1表示已参加
		userIsJoinedActivity = auService.validActivityIsJoined(activity_id,
				user.getUser_id());
		if (userIsJoinedActivity == -1) {
			boolean auIsExist = true;// 用于标记重载,由于数据库已存在记录，所以只需更新即可
			boolean updateJoinActivity = false;
			updateJoinActivity = auService.joinActivity(activity_id, user.getUser_id(),
					auIsExist);
			if (updateJoinActivity == true) {
				joinActivityResult = true;
				userIsJoinedActivity=1;
				Au au = null;
				au = auService.findByActiIdAndUserId(activity_id, user.getUser_id());
				map.put("au", au);
			}
		} else if (userIsJoinedActivity == 0) {
			// 重载,由于数据库不存在记录，所以需添加
			long au_id = auService.joinActivity(activity_id, user.getUser_id());
			if (au_id > 0) {
				joinActivityResult = true;
				userIsJoinedActivity=1;
				Au au = null;
				au = auService.findById(au_id);
				map.put("au", au);
			}
		}
		map.put("userIsJoinedActivity", userIsJoinedActivity);
		map.put("joinActivityResult", joinActivityResult);
		return map;
	}

	/**
	 * @author phn
	 * @date 2015-3-17
	 * @TODO 活动现场签到
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/activity/sign.do", method = RequestMethod.POST)
	public Map<String, Object> signActivity(long activity_id) {
		/**
		 * 1：判断用户是否已经参加活动或者已经签到 
		 * 2：如果已经参加，则可以继续参与签到；如果没有参加或者已经签到，则不能进行签到
		 * 3：签到成功则返回成功的提示，失败则返回失败的提示
		 * **/
		Map<String, Object> map = new HashMap<String, Object>();
		boolean signActivityResult = false;
		Subject subject = SecurityUtils.getSubject();
		String email = (String) subject.getPrincipal();
		User user = userService.findByCardId(email);
		byte userIsSignedActivity = 0;// -1表示没有参加, 0表示没有签到,1表示已签到
		userIsSignedActivity = auService.validActivityIsSigned(activity_id,
				user.getUser_id());
		if (userIsSignedActivity == 0) {
			boolean  signResult = auService.signActivity(activity_id, user.getUser_id());
			if (signResult) {
				Au au = null;
				au = auService.findByActiIdAndUserId(activity_id, user.getUser_id());
				signActivityResult = true;// 成功
				userIsSignedActivity = 1;// 表示以签到成功
				if (au != null) {
					map.put("au", au);
				}
			}
		}
		map.put("userIsSignedActivity", userIsSignedActivity); // 0表示没有签到,-1表示没有参加,1表示已签到
		map.put("signActivityResult", signActivityResult);
		return map;
	}

	/**
	 * @author phn
	 * @date 2015-3-17
	 * @TODO 提出对活动的疑问，discuss
	 * @return 备注：侯哥已写
	 */
	//@ResponseBody
	//@RequestMapping(value = "/activity/question.do", method = RequestMethod.POST)
	public Map<String, Object> askQuestionForActivity() {

		Map<String, Object> map = new HashMap<String, Object>();
		return map;
	}

	/**
	 * @author phn
	 * @date 2015-3-17
	 * @TODO 参加活动完成评价打分
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/activity/evaluate.do", method = RequestMethod.POST)
	public Map<String, Object> evaluateSignedInActivity(long activity_id, Au au/*au包含评论内容，评分*/) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean evaluateActivityResult = false;
		/**
		 * 1：判断用户是否已经参加活动并签到或者已经评价
		 * 2：如果已经参加并签到，则可以继续参与评价；
		 * 3:如果没有参加或者签到或者已经评价，则不能进行评价
		 * 4：评价成功则返回成功的提示，失败则返回失败的提示
		 * **/
		Subject subject = SecurityUtils.getSubject();
		String email = (String) subject.getPrincipal();
		User user = userService.findByCardId(email);
		byte userIsEvaluatedActivity = 0;// -1表示没有参加, 0表示没有签到，1表示已签到没有评价,2表示已评价
		userIsEvaluatedActivity = auService.validActivityIsEvaluated(
				activity_id, user.getUser_id());
		if (userIsEvaluatedActivity == 1) {
			Au evaluateResultAu = null;
			evaluateResultAu = auService.evaluateActivity(au, activity_id,
					user.getUser_id());
			if (evaluateResultAu != null) {
				evaluateActivityResult = true;
				map.put("au", au);
				userIsEvaluatedActivity = 2;
			}
		}
		// -1表示没有参加, 0表示没有签到，1表示已签到没有评价,2表示已评价
		map.put("userIsEvaluatedActivity", userIsEvaluatedActivity);
		map.put("evaluateActivityResult", evaluateActivityResult);
		return map;
	}

	/**
	 * @author phn
	 * @date 2015-3-17
	 * @TODO 对活动点赞支持
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/activity/support.do", method = RequestMethod.POST)
	public Map<String, Object> supportToActivity(long activity_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean supportActivityResult = false;
		/**
		 * 1:判断数据库中是否存在记录，不存在则继续操作点赞
		 * 2：存在则判断数据库记录是否标志为已点赞，是则直接进行取消赞，否则继续进行点赞操作。
		 * **/
		Subject subject = SecurityUtils.getSubject();
		String email = (String) subject.getPrincipal();
		User user = userService.findByCardId(email);
		byte validActivityIsSupported = 0;// -1表示数据库有记录即已经参加了但是没有点赞，0表示数据库没有记录,1表示已点赞
		validActivityIsSupported = auService.validActivityIsSupported(
				activity_id, user.getUser_id());
//		System.out.println("是否点赞:"+validActivityIsSupported);
		if (validActivityIsSupported == 0) {//点赞
			supportActivityResult = auService.supportActivity(activity_id,
					user.getUser_id());
		} else if (validActivityIsSupported == -1) {//点赞
			supportActivityResult = auService.supportActivity(activity_id,
					user.getUser_id(), true);
		} else if (validActivityIsSupported == 1) {//取消赞
			supportActivityResult = auService.supportActivity(activity_id,
					user.getUser_id(), false);
		}
		map.put("supportActivityResult", supportActivityResult);
		return map;
	}
}
