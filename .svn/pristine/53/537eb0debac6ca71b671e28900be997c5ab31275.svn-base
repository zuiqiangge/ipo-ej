package com.pengyue.ipo.dao.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pengyue.ipo.bean.ForumUser;
import com.pengyue.ipo.bean.TbXtSource;
import com.pengyue.ipo.bean.TbXtTaskResult;
import com.pengyue.ipo.tree.Pie;

@Repository
public class TbXtTaskResImpl implements TbXtTaskResDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void saveTaskRes(TbXtTaskResult tbXtTaskResult) {
		try {
			sqlSessionTemplate.insert("saveTaskRes", tbXtTaskResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String fastigiumDate(String taskId) {
		String date="";
		try {
			date=sqlSessionTemplate.selectOne("fastigiumDate",taskId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	@Override
	public String fastigiumCount(String taskId) {
		String count="";
		try {
			count=sqlSessionTemplate.selectOne("fastigiumCount",taskId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	@Override
	public TbXtTaskResult firstTaskResByTask(String taskid) {
		TbXtTaskResult res=null;
		try {
			res=sqlSessionTemplate.selectOne("firstTaskResByTask", taskid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<TbXtTaskResult> queryTaskResByTask(String taskid) {
		List<TbXtTaskResult> list=null;
		try {
			list=sqlSessionTemplate.selectList("queryTaskResByTask",taskid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Pie> taskSourceSitesPie(String taskid) {
		List<Pie> list=null;
		try {
			list=sqlSessionTemplate.selectList("taskSourceSitesPie", taskid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<TbXtTaskResult> taskResListByClickTop10(String taskid) {
		List<TbXtTaskResult> list=null;
		try {
			list=sqlSessionTemplate.selectList("taskResListByClickTop10",taskid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<String> queryForumByTask(String taskid) {
		List<String> list=null;
		try {
			list=sqlSessionTemplate.selectList("queryForumByTask",taskid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ForumUser> queryForumUserTOP10(String taskid,String forumName) {
		List<ForumUser> list=null;
		Map<String, String> param=new HashMap<String, String>();
		param.put("taskid",taskid);
		param.put("forumName",forumName);
		try {
			list=sqlSessionTemplate.selectList("queryForumUserTOP10", param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<TbXtTaskResult> queryNewsTop10(String taskid) {
		List<TbXtTaskResult> list=null;
		try {
			list=sqlSessionTemplate.selectList("queryNewsTop10",taskid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<TbXtTaskResult> queryForumTop10(String taskid) {
		List<TbXtTaskResult> list=null;
		try {
			list=sqlSessionTemplate.selectList("queryForumTop10",taskid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
}
