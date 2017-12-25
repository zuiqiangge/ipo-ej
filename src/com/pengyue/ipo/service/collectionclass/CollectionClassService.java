package com.pengyue.ipo.service.collectionclass;

import java.util.List;

import com.pengyue.ipo.bean.CollectionClass;
/**
 * 新闻采集类service
 * @author wanlongquan
 *
 */
public interface CollectionClassService {
	
	public List<CollectionClass> findAllEnable();
}
