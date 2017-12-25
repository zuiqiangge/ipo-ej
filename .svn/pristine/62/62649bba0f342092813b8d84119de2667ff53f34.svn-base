package com.pengyue.ipo.service.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pengyue.ipo.bean.RegionKeyword;
import com.pengyue.ipo.dao.news.RegionKeywordDao;

@Service("regionKeywordService")
@Transactional
public class RegionKeywordService {
	
	@Autowired
	private RegionKeywordDao regionKeywordDao;
	
	public List<RegionKeyword> findRegionKeyWords() {
		return regionKeywordDao.findRegionKeyWords();
	}

	public RegionKeyword findRegionKeyWordsBySsdq(String ssdq) {
		return regionKeywordDao.findRegionKeyWordsBySsdq(ssdq);
	}

	public void updateRegionKeyWords(RegionKeyword keyword) {
		regionKeywordDao.updateRegionKeyWords(keyword);
	}
	
}
