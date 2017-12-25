package com.pengyue.ipo.dao.collectionclass;

import java.util.List;

import com.pengyue.ipo.bean.CollectionClass;
/**
 * 新闻采集类dao
 * @author wanlongquan
 *
 */
public interface CollectionClassDao {
	
	public List<CollectionClass> findAllEnable();
	
}
