package com.pengyue.ipo.dao.news;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pengyue.ipo.bean.NewsZlm;
import com.pengyue.ipo.bean.Report;
import com.pengyue.ipo.bean.ReportChartsBean;
import com.pengyue.ipo.bean.Tbfmc;
import com.pengyue.ipo.util.AutoId;

@Repository("reportDao")
public class ReportDaoImpl implements ReportDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<Report> findAll() {
		return sqlSessionTemplate.selectList("FindAllReport");
	}

	@Override
	public List<Report> findPage(Map<String, Object> params) {
		return sqlSessionTemplate.selectList("FindPage", params);
	}

	@Override
	public int findCount(Map<String, Object> params) {
		return sqlSessionTemplate.selectOne("FindCount", params);
	}

	@Override
	public List<String> getDateTempBySjd(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("getDateTempBySjd", params);
	}

	@Override
	public void deleteReportById(String reportId) {
		sqlSessionTemplate.delete("DeleteReport", reportId);
	}

	@Override
	public List<ReportChartsBean> getRReportChartsByZlm(
			Map<String, Object> params) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("getRReportChartsByZlm", params);
	}

	@Override
	public String saveReport(Map<String, Object> params) {
		// TODO Auto-generated method stub
		String resString = "1";
	 
		
		SqlSession session=null;
		try {
 
			session= sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH,false);
	 
			params.put("id",AutoId.getCode());
			session.insert("saveReport", params);
//			session.insert("saveReportImage", params);
			session.commit();
			 
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
			resString="0";
		}finally{
			session.close();
		}
		return resString;
	}

	@Override
	public NewsZlm getZlmByContext(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("getZlmByContext", params);
	}

	@Override
	public Report findReportById(String reportId) {
		return sqlSessionTemplate.selectOne("findReportById", reportId);
	}

	@Override
	public void updateReport(Report report) {
		sqlSessionTemplate.update("updateReport",report);
	}

	@Override
	public List<Report> findReportByMap(Map<String, Object> params) {
		return sqlSessionTemplate.selectList("FindReportByMap",params);
	}

	@Override
	public List<Tbfmc> getwords() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("getwords");
	}

	@Override
	public void updateFmc(Map<String, Object> params) {
		// TODO Auto-generated method stub
		  try {
			sqlSessionTemplate.update("updateFmc",params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
