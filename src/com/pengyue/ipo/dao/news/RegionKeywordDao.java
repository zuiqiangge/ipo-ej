package com.pengyue.ipo.dao.news;

import java.util.List;

import com.pengyue.ipo.bean.RegionKeyword;

public interface RegionKeywordDao {
	
	public List<RegionKeyword> findRegionKeyWords();
	
	public RegionKeyword findRegionKeyWordsBySsdq(String ssdq);
	
	public void updateRegionKeyWords(RegionKeyword keyword);
	
}
