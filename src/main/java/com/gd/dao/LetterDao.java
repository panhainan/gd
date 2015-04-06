package com.gd.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.gd.entity.Letter;
/**
 * 
 * @author hrz
 * @date 2014-12-8
 */
@Component
public interface LetterDao {
	/**
	 * 
	 * @author hrz
	 * @date 2015-3-14
	 * @param letterMap
	 * @return
	 * int
	 * TODO
	 */
	public int addLetter(Map<String,Object> letterMap);
	/**
	 * 
	 * @author hrz
	 * @date 2015-3-14
	 * @param peopleMap
	 * @return
	 * List<Letter>
	 * TODO
	 */
	public List<Letter> checkLetterHistory(Map<String,Object> peopleMap);
}
