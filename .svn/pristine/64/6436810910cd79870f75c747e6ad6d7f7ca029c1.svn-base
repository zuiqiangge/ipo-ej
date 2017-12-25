package com.pengyue.ipo.dao.news;

import java.util.List;
import java.util.Map;

import com.pengyue.ipo.bean.ReportRecord;

public interface ReportRecordDao {
	/**
	 * 保存
	 * @param record
	 */
	public void saveReportRecord(ReportRecord record);
	
	/**
	 * 通过板块和新闻id查询新闻数量
	 * @param params
	 * @return
	 */
	public int findCountByNewsIdAndAddrCode(Map<String,Object> params);
	/**
	 * 根据板块和时间段查询
	 * @param params
	 * @return
	 */
	public List<ReportRecord> findByCodeAndTime(Map<String,Object> params);
	/**
	 * 香港社交网站舆情热点
	 * @param params
	 * @return
	 */
	public List<ReportRecord> findXgsjwzyqrd(Map<String,Object> params);
	/**
	 * 
	 * @param params
	 * @return
	 */
	public List<ReportRecord> findSjzlmtcontext(Map<String,Object> params);
	/**
	 * 新帖文
	 * @param params
	 * @return
	 */
	public int findXtw(Map<String,Object> params);
	/**
	 * 点击量
	 * @param params
	 * @return
	 */
	public int findDjl(Map<String,Object> params);
	/**
	 * 回帖量
	 * @param params
	 * @return
	 */
	public int findHtl(Map<String,Object> params);
	/**
	 * 查询图片
	 * @param params
	 * @return
	 */
	public String findImage(Map<String,Object> params);
	/**
	 * 删除多个
	 * @param recordIdList
	 */
	public void deleteRecord(List<String> recordIdList);
	/**
	 * 香港社交网站舆情热点方法2
	 * @param params
	 * @return
	 */
	public List<ReportRecord> findXgsjwzyqrd2(Map<String,Object> params);
	
}
