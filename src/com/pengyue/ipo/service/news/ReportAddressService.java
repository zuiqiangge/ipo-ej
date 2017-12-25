package com.pengyue.ipo.service.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pengyue.ipo.bean.ReportAddress;
import com.pengyue.ipo.dao.news.ReportAddressDao;

@Service
@Transactional
public class ReportAddressService {
	
	@Autowired
	private ReportAddressDao reportAddressDao;
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<ReportAddress> findAll() {
		return reportAddressDao.findAll();
	}
	
}
