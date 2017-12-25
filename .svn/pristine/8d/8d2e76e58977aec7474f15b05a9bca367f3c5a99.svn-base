package com.pengyue.ipo.dao.news;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pengyue.ipo.bean.ReportAddress;

@Repository("reportAddressDao")
public class ReportAddressDaoImpl implements ReportAddressDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<ReportAddress> findAll() {
		return sqlSessionTemplate.selectList("FindAllReportAddress");
	}

}
