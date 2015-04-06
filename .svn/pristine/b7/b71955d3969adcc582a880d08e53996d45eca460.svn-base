package com.gd.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gd.dao.LetterDao;
import com.gd.entity.Letter;
import com.gd.service.LetterService;
/**
 * @author hrz
 * @date 2014-12-8
 */
@Component
public class LetterServiceImpl implements LetterService{
	@Autowired
	private LetterDao letterDao;
	@Override
	public int addLetter(long lett_user_send_id, long lett_user_rece_id,
			String lett_content) {
		// TODO Auto-generated method stub
		try {
			Date date = new Date();
			Map<String,Object> letterMap = new HashMap<String,Object>();
			letterMap.put("lett_user_send_id", lett_user_send_id);
			letterMap.put("lett_user_rece_id",lett_user_rece_id);
			letterMap.put("lett_content",lett_content);
			letterMap.put("lett_time",date);
			letterMap.put("lett_rece_read",false);
			return letterDao.addLetter(letterMap);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		
	}
	@Override
	public List<Letter> checkLetterHistory(long people1_id, long people2_id) {
		// TODO Auto-generated method stub
		try {
			Map<String,Object> peopleMap = new HashMap<String,Object>();
			peopleMap.put("people1_id", people1_id);
			peopleMap.put("people2_id", people2_id);
			List<Letter> letters = letterDao.checkLetterHistory(peopleMap);
			return letters;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
}
