package com.pengyue.ipo.service.system;

import java.util.ArrayList;
import java.util.List;

import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pengyue.ipo.action.system.SearchTools;
import com.pengyue.ipo.bean.ForumUser;
import com.pengyue.ipo.bean.TbXtSource;
import com.pengyue.ipo.bean.TbXtTask;
import com.pengyue.ipo.bean.TbXtTaskResult;
import com.pengyue.ipo.dao.system.TbXtSourceDao;
import com.pengyue.ipo.dao.system.TbXtTaskDao;
import com.pengyue.ipo.dao.system.TbXtTaskResDao;
import com.pengyue.ipo.tree.FancyTreeData;
import com.pengyue.ipo.tree.Pie;
import com.pengyue.ipo.util.DateFormat;

@Service
@Transactional
public class TbXtTaskSevice {
	
	@Autowired
	private TbXtSourceDao tbXtSourceDao;
	@Autowired
	private TbXtTaskDao tbXtTaskDao;
	@Autowired
	private TbXtTaskResDao tbXtTaskResDao;
	
	/**
	 * 返回solr查询记录数
	 * @param tbXtTask
	 * @return
	 */
	public int countTaskData(TbXtTask tbXtTask){
		 SolrDocumentList docs=SearchTools.searchTaskData(tbXtTask);
		 return docs.size();
	}
	
	public List<FancyTreeData> queryFidIsNull(){
		List<FancyTreeData> listData=new ArrayList<FancyTreeData>();
		List<FancyTreeData> childrenData=new ArrayList<FancyTreeData>();
		List<TbXtSource> listSource=tbXtSourceDao.queryFidIsNull();
		FancyTreeData parentNode=new FancyTreeData();
		parentNode.setTitle("全部数据来源");
		parentNode.setKey("0");
		parentNode.setParentId("0");
		for (TbXtSource tbXtSource : listSource) {
			childrenData.add(new FancyTreeData(tbXtSource));
		}
		parentNode.setChildren(childrenData);
		listData.add(parentNode);
		return listData;
	}
	
	public void saveTask(TbXtTask tbXtTask){
		SolrDocumentList docs=SearchTools.searchTaskData(tbXtTask);
		//SolrDocumentList docs=SearchTools.test(tbXtTask);
		List<TbXtTaskResult> listRes=new ArrayList<TbXtTaskResult>();
		Integer totalclick=0;
		for (SolrDocument doc : docs) {
			TbXtTaskResult res=new TbXtTaskResult();
			res.setEtlgxsj(DateFormat.nowDate24());
			res.setResultcounts(doc.getFieldValue("news_clickedCounts")+"");
			res.setResultdescribe(doc.getFieldValue("news_describe")+"");
			res.setResultpubtime(doc.getFieldValue("news_pubnisihTime_sj")+"");
			res.setResultsource(doc.getFieldValue("news_fname")+"");
			res.setResulttitle(doc.getFieldValue("news_title")+"");
			res.setResulturl(doc.getFieldValue("news_url")+"");
			res.setPubnisihuser(doc.getFieldValue("news_pubnisihuser")+"");
			res.setClickedCounts(doc.getFieldValue("news_clickedCounts")+"");
			totalclick+=new Integer(res.getClickedCounts());
			res.setTaskId(tbXtTask.getId());
			listRes.add(res);
		}
		tbXtTask.setTotalitem(listRes.size()+"");
		tbXtTask.setTotalclick(totalclick+"");
		tbXtTaskDao.saveTask(tbXtTask);
		for (TbXtTaskResult tbXtTaskResult : listRes) {
			tbXtTaskResDao.saveTaskRes(tbXtTaskResult);
		}
	}
	
	public TbXtTask queryTaskAll(TbXtTask tbXtTask){
		tbXtTask.setTotalRecord(tbXtTaskDao.countResult(tbXtTask));
		tbXtTask.setResults(tbXtTaskDao.queryTaskAll(tbXtTask));
		return tbXtTask;
	}
	
	public List<TbXtTask> jingdian(String type){
		return tbXtTaskDao.jingdian(type);
	}
	
	public TbXtTask getTaskById(String id){
		return tbXtTaskDao.getTaskById(id);
	}
	
	public String fastigiumCount(String taskId){
		return tbXtTaskResDao.fastigiumCount(taskId);
	}
	
	public String fastigiumDate(String taskId){
		return tbXtTaskResDao.fastigiumDate(taskId);
	}
	
	public TbXtTaskResult firstTaskResByTask(String taskid){
		return tbXtTaskResDao.firstTaskResByTask(taskid);
	}
	
	public List<TbXtTaskResult> queryTaskResByTask(String taskid){
		return tbXtTaskResDao.queryTaskResByTask(taskid);
	}
	
	public List<Pie> taskSourceSitesPie(String taskid){
		return tbXtTaskResDao.taskSourceSitesPie(taskid);
	}
	
	public List<TbXtTaskResult> taskResListByClickTop10(String taskid){
		return tbXtTaskResDao.taskResListByClickTop10(taskid);
	}
	
	public List<String> queryForumByTask(String taskid){
		return tbXtTaskResDao.queryForumByTask(taskid);
	}
	
	public List<ForumUser> queryForumUserTOP10(String taskid,String forumName){
		return tbXtTaskResDao.queryForumUserTOP10(taskid,forumName);
	}
	
	public List<TbXtTaskResult> queryNewsTop10(String taskid) {
		return tbXtTaskResDao.queryNewsTop10(taskid);
	}
	
	public List<TbXtTaskResult> queryForumTop10(String taskid) {
		return tbXtTaskResDao.queryForumTop10(taskid);
	}
	
	public void deleteTaskById(String id){
		tbXtTaskDao.deleteTaskById(id);
	}
}
