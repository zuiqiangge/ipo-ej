package com.pengyue.ipo.dao.collectionclass;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pengyue.ipo.bean.CollectionClass;

/**
 * 新闻采集类dao
 * @author wanlongquan
 *
 */
@Repository("collectionClassDao")
public class CollectionClassDaoImpl implements CollectionClassDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 查询所有
	 */
	@Override
	public List<CollectionClass> findAllEnable() {
		return sqlSessionTemplate.selectList("FindAllEnable");
	}

}
