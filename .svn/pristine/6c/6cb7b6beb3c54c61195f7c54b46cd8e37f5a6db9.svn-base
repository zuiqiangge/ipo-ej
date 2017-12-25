package com.pengyue.ipo.dao.news;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("newsSsdqDao")
public class NewsSsdqDaoImpl implements NewsSsdqDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<Map<String, Object>> findNewsSsdq() {
		try {
			return sqlSessionTemplate.selectList("findNewsSsdq");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
