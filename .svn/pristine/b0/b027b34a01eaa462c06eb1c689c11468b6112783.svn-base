package com.pengyue.ipo.service.collectionclass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pengyue.ipo.bean.CollectionClass;
import com.pengyue.ipo.dao.collectionclass.CollectionClassDao;

/**
 * 新闻采集类service
 * @author wanlongquan
 *
 */
@Service("collectionClassService")
public class CollectionClassServiceImpl implements CollectionClassService {
	
	@Autowired
	private CollectionClassDao collectionClassDao;

	@Override
	public List<CollectionClass> findAllEnable() {
		return collectionClassDao.findAllEnable();
	}

}
