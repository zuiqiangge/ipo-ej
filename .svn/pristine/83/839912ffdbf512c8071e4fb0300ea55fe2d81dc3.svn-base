package com.pengyue.ipo.dao.news;

import java.util.List;
import java.util.Map;

import com.pengyue.ipo.bean.NewsZlm;
import com.pengyue.ipo.bean.Report;
import com.pengyue.ipo.bean.ReportChartsBean;
import com.pengyue.ipo.bean.Tbfmc;

public interface ReportDao {
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Report> findAll();
	/**
	 * 查询分页
	 * @param params
	 * @return
	 */
	public List<Report> findPage(Map<String,Object> params);
	/**
	 * 查询总数
	 * @param params 
	 * @return
	 */
	public int findCount(Map<String, Object> params);
	public List<String> getDateTempBySjd(Map<String, Object> params);
	/**
	 * 通过id删除
	 * @param reportId
	 */
	public void deleteReportById(String reportId);
	public List<ReportChartsBean> getRReportChartsByZlm(
			Map<String, Object> params);
	public String saveReport(Map<String, Object> params);
	public NewsZlm getZlmByContext(Map<String, Object> params);
	
	/**
	 * 按id查询
	 * @param reportId
	 * @return
	 */
	public Report findReportById(String reportId);
	/**
	 * 更新
	 * @param report
	 */
	public void updateReport(Report report);
	
	/**
	 * 条件查询
	 * @param params
	 * @return
	 */
	public List<Report> findReportByMap(Map<String,Object> params);
	public List<Tbfmc> getwords();
	public void updateFmc(Map<String, Object> params);
	
}
