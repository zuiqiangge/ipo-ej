package com.pengyue.ipo.dao.news;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pengyue.ipo.bean.ReportRecord;

@Repository("reportRecordDao")
public class ReportRecordDaoImpl implements ReportRecordDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void saveReportRecord(ReportRecord record) {
		sqlSessionTemplate.insert("InsertReportRecord", record);
	}

	@Override
	public int findCountByNewsIdAndAddrCode(Map<String, Object> params) {
		return sqlSessionTemplate.selectOne("selectRecordCount",params);
	}
	@Override
	public List<ReportRecord> findByCodeAndTime(Map<String,Object> params) {
		return sqlSessionTemplate.selectList("findByCodeAndTime",params);
	}

	@Override
	public List<ReportRecord> findXgsjwzyqrd(Map<String, Object> params) {
		return sqlSessionTemplate.selectList("findXgsjwzyqrd", params);
	}

	@Override
	public List<ReportRecord> findSjzlmtcontext(
			Map<String, Object> params) {
		return sqlSessionTemplate.selectList("findSjzlmtcontext", params);
	}
	
	@Override
	public int findXtw(Map<String, Object> params) {
		Integer result = sqlSessionTemplate.selectOne("findXtw", params);
		return result == null ? 0 : result;
	}

	@Override
	public int findDjl(Map<String, Object> params) {
		Integer result = sqlSessionTemplate.selectOne("findDjl", params);
		return result == null ? 0 : result;
	}

	@Override
	public int findHtl(Map<String, Object> params) {
		Integer result = sqlSessionTemplate.selectOne("findHtl", params);
		return result == null ? 0 : result;
	}

	@Override
	public String findImage(Map<String, Object> params) {
		return sqlSessionTemplate.selectOne("findImage", params);
	}

	@Override
	public void deleteRecord(List<String> recordIdList) {
		sqlSessionTemplate.delete("deleteRecord", recordIdList);
	}

	@Override
	public List<ReportRecord> findXgsjwzyqrd2(Map<String, Object> params) {
		try {
			return sqlSessionTemplate.selectList("findxgsjwzyqrd2",params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
