package com.pengyue.ipo.service.news;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pengyue.ipo.bean.NewsZlm;
import com.pengyue.ipo.bean.Report;
import com.pengyue.ipo.bean.ReportChartsBean;
import com.pengyue.ipo.bean.Tbfmc;
import com.pengyue.ipo.dao.news.ReportDao;

@Service
@Transactional
public class ReportService {
	@Autowired
	private ReportDao reportDao;
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Report> findAll() {
		return reportDao.findAll();
	}
	/**
	 * 查询总数
	 * @param params 
	 * @return
	 */
	public int findCount(Map<String, Object> params){
		return reportDao.findCount(params);
	}
	/**
	 * 查询分页
	 * @param params
	 * @return
	 */
	public List<Report> findPage(Map<String,Object> params){
		return reportDao.findPage(params);
	}
	public List<String> getDateTempBySjd(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return reportDao.getDateTempBySjd(params);
	}
	/**
	 * 通过id删除
	 * @param reportId
	 */
	public void deleteReportById(String reportId) {
		reportDao.deleteReportById(reportId);
	}
	public List<ReportChartsBean> getRReportChartsByZlm(
			Map<String, Object> params) {
		// TODO Auto-generated method stub
		return reportDao.getRReportChartsByZlm(params);
	}
	public String saveReport(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return reportDao.saveReport(params);
	}
	public NewsZlm getZlmByContext(Map<String, Object> params) {
		// TODO Auto-generated method stub
		if(params.get("context")==null)return null;
		return reportDao.getZlmByContext(params);
	}
	
	/**
	 * 按id查询
	 * @param reportId
	 * @return
	 */
	public Report findReportById(String reportId){
		return reportDao.findReportById(reportId);
	}
	/**
	 * 更新
	 * @param report
	 */
	public void updateReport(Report report) {
		reportDao.updateReport(report);
	}
	
	/**
	 * 条件查询
	 * @param params
	 * @return
	 */
	public List<Report> findReportByMap(Map<String,Object> params){
		return reportDao.findReportByMap(params);
	}
	public List<Tbfmc> getwords() {
		// TODO Auto-generated method stub
		return reportDao.getwords();
	}
	public void updateFmc(Map<String, Object> params) {
		// TODO Auto-generated method stub
		reportDao.updateFmc(params);
	}
}
