package com.pengyue.ipo.dao.system;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.pengyue.ipo.bean.TbXtCollect;
import com.pengyue.ipo.util.DateUtil;

@Repository
public class TbXtFourmCollectImpl implements TbXtFourmCollectDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int savePost(TbXtCollect tbXtCollect) {
		int x = 0;
		try {
			x=sqlSessionTemplate.insert("savePost", tbXtCollect);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage()+"====="+tbXtCollect.getUrl());
		}
		return x;
	}

	@Override
	public int count(String url) {
		int total=0;
		try {
			total=sqlSessionTemplate.selectOne("count",url);
		} catch (Exception e) {
			e.printStackTrace();
			total=1;
		}
		return total;
	}

	
}
