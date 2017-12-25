package com.pengyue.ipo.dao.news;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pengyue.ipo.bean.RegionKeyword;

@Repository("regionKeywordDao")
public class RegionKeywordDaoImpl implements RegionKeywordDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<RegionKeyword> findRegionKeyWords() {
		return sqlSessionTemplate.selectList("findRegionKeyWords");
	}

	@Override
	public RegionKeyword findRegionKeyWordsBySsdq(String ssdq) {
		return sqlSessionTemplate.selectOne("findRegionKeyWordsBySsdq",ssdq);
	}

	@Override
	public void updateRegionKeyWords(RegionKeyword keyword) {
		sqlSessionTemplate.update("updateRegionKeyWords",keyword);
	}

}
