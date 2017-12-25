package com.pengyue.ipo.service.news;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pengyue.ipo.dao.news.NewsSsdqDao;

@Service
@Transactional
public class NewsSsdqService {
	
	@Autowired
	private NewsSsdqDao newsSsdqDao;
	
	public List<Map<String, Object>> findNewsSsdq() {
		return newsSsdqDao.findNewsSsdq();
	}
	
}
