package com.pengyue.ipo.service.news;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pengyue.ipo.bean.ReportRecord;
import com.pengyue.ipo.dao.news.ReportRecordDao;

@Service
@Transactional
public class ReportRecordService {
	
	@Autowired
	private ReportRecordDao reportRecordDao;
	
	/**
	 * 保存
	 * @param record
	 */
	public void saveReportRecord(ReportRecord record){
		reportRecordDao.saveReportRecord(record);
	}
	
	/**
	 * 指定的新闻在指定板块是否存在
	 * @param params
	 * @return
	 */
	public boolean existsInThePlate(Map<String,Object> params){
		int result = reportRecordDao.findCountByNewsIdAndAddrCode(params);
		if(result > 0)
			return true;
		return false;
	}
	/**
	 * 根据板块和时间段查询
	 * @param params
	 * @return
	 */
	public List<ReportRecord> findByCodeAndTime(Map<String,Object> params) {
		return reportRecordDao.findByCodeAndTime(params);
	}
	/**
	 * 香港社交网站舆情热点
	 * @param params
	 * @return
	 */
	public List<ReportRecord> findXgsjwzyqrd(Map<String,Object> params){
		return reportRecordDao.findXgsjwzyqrd(params);
	}
	
	/**
	 * 
	 * @param params
	 * @return
	 */
	public List<ReportRecord> findSjzlmtcontext(Map<String,Object> params){
		return reportRecordDao.findSjzlmtcontext(params);
	}
	
	/**
	 * 新帖文
	 * @param params
	 * @return
	 */
	public int findXtw(Map<String,Object> params){
		return reportRecordDao.findXtw(params);
	}
	/**
	 * 点击量
	 * @param params
	 * @return
	 */
	public int findDjl(Map<String,Object> params){
		return reportRecordDao.findDjl(params);
	}
	/**
	 * 回帖量
	 * @param params
	 * @return
	 */
	public int findHtl(Map<String,Object> params){
		return reportRecordDao.findHtl(params);
	}
	/**
	 * 查询图片
	 * @param params
	 * @return
	 */
	public String findImage(Map<String,Object> params){
		return reportRecordDao.findImage(params);
	}
	/**
	 * 删除多个
	 * @param recordIdList
	 */
	public void deleteRecord(List<String> recordIdList){
		reportRecordDao.deleteRecord(recordIdList);
	}
	
	/**
	 * 香港社交网站舆情热点方法2
	 * @param params
	 * @return
	 */
	public List<ReportRecord> findXgsjwzyqrd2(Map<String,Object> params){
		return reportRecordDao.findXgsjwzyqrd2(params);
	}
}
