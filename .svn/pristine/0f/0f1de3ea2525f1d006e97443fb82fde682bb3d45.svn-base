package com.pengyue.ipo.dao.system;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.pengyue.ipo.bean.TbXtTask;

@Repository
public class TbXtTaskImpl implements TbXtTaskDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void saveTask(TbXtTask tbXtTask) {
		try {
			sqlSessionTemplate.insert("saveTask", tbXtTask);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<TbXtTask>  queryTaskAll(TbXtTask tbXtTask){
		List<TbXtTask> list=null;
		try {
			list=sqlSessionTemplate.selectList("queryTaskAll",tbXtTask);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int countResult(TbXtTask tbXtTask) {
		int count=0;
		try {
			count=sqlSessionTemplate.selectOne("countResult", tbXtTask);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public TbXtTask getTaskById(String id){
		TbXtTask tbXtTask=null;
		try {
			tbXtTask=sqlSessionTemplate.selectOne("getTaskById", id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tbXtTask;
	}

	@Override
	public List<TbXtTask> jingdian(String type) {
		List<TbXtTask> jingdianList=null;
		try {
			jingdianList=sqlSessionTemplate.selectList("jingdian", type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jingdianList;
	}

	@Override
	public void deleteTaskById(String id) {
		try {
			sqlSessionTemplate.delete("deleteTaskById", id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
