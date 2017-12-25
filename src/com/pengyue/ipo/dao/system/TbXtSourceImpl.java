package com.pengyue.ipo.dao.system;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.pengyue.ipo.bean.TbXtSource;

@Repository
public class TbXtSourceImpl implements TbXtSourceDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<TbXtSource> queryFidIsNull(){
		List<TbXtSource> list=null;
		try {
			list=sqlSessionTemplate.selectList("queryFidIsNull");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
