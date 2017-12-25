package com.pengyue.ipo.action.collect;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pengyue.ipo.bean.ForumUser;
import com.pengyue.ipo.bean.TbXtTaskResult;
import com.pengyue.ipo.tree.Pie;
import com.pengyue.ipo.util.JsonUtil;

public class TaskDetailVo    {
	/**
	 * 
	 */
	 
	//最高峰日期parseDate
	private Date fastigiumDate;
	//最高峰数量
	private String fastigiumCount;
	//源头新闻
	private TbXtTaskResult firstRes;
	//事件主要来源网址名称饼图数据
	private List<Pie> siteSourcePie;
	//事件主要来源网址名称饼图json数据
	private String siteSourcePieJson;
	//事件所有新闻
	private List<TbXtTaskResult> taskResList;
	//事件点击量前十新闻
	private List<TbXtTaskResult> taskResListByClickTop10;
	//事件主要来源网址名称数据
	private List<String> siteSource;
	//事件主要来源网址名称json数据
	private String siteSourceJson;
	//事件涉及的所有论坛数据
	private List<String> tbXtSourceList;
	//查询每个论坛发帖前十用户
	private List<List<ForumUser>> forumUserList;
	//事件新闻网站发布前十
	private List<TbXtTaskResult> taskResListByNews;
	//事件论坛网站发布前十
	private List<TbXtTaskResult> taskResListByForum;
	
	public Date getFastigiumDate() {
		return fastigiumDate;
	}
	public void setFastigiumDate(Date fastigiumDate) {
		this.fastigiumDate = fastigiumDate;
	}
	
	public TbXtTaskResult getFirstRes() {
		return firstRes;
	}
	public void setFirstRes(TbXtTaskResult firstRes) {
		this.firstRes = firstRes;
	}
	public String getFastigiumCount() {
		return fastigiumCount;
	}
	public void setFastigiumCount(String fastigiumCount) {
		this.fastigiumCount = fastigiumCount;
	}
	public List<TbXtTaskResult> getTaskResList() {
		return taskResList;
	}
	public void setTaskResList(List<TbXtTaskResult> taskResList) {
		this.taskResList = taskResList;
	}
	 
	public List<Pie> getSiteSourcePie() {
		return siteSourcePie;
	}
	public void setSiteSourcePie(List<Pie> siteSourcePie) {
		this.siteSourcePie = siteSourcePie;
	}
	public List<String> getSiteSource() {
		siteSource=new ArrayList<String>();
		for (Pie pie : siteSourcePie) {
			siteSource.add(pie.getName());
		}
		return siteSource;
	}
	public void setSiteSource(List<String> siteSource) {
		this.siteSource = siteSource;
	}
	public String getSiteSourceJson() {
		siteSourceJson=JsonUtil.objectToJson(siteSource);
		return siteSourceJson;
	}
	public void setSiteSourceJson(String siteSourceJson) {
		this.siteSourceJson = siteSourceJson;
	}
	public String getSiteSourcePieJson() {
		siteSourcePieJson=JsonUtil.objectToJson(this.siteSourcePie);
		return siteSourcePieJson;
	}
	public void setSiteSourcePieJson(String siteSourcePieJson) {
		this.siteSourcePieJson = siteSourcePieJson;
	}
	public List<TbXtTaskResult> getTaskResListByClickTop10() {
		return taskResListByClickTop10;
	}
	public void setTaskResListByClickTop10(List<TbXtTaskResult> taskResListByClickTop10) {
		this.taskResListByClickTop10 = taskResListByClickTop10;
	}
	
	public List<String> getTbXtSourceList() {
		return tbXtSourceList;
	}
	public void setTbXtSourceList(List<String> tbXtSourceList) {
		this.tbXtSourceList = tbXtSourceList;
	}
	public List<List<ForumUser>> getForumUserList() {
		return forumUserList;
	}
	public void setForumUserList(List<List<ForumUser>> forumUserList) {
		this.forumUserList = forumUserList;
	}
	public List<TbXtTaskResult> getTaskResListByNews() {
		return taskResListByNews;
	}
	public void setTaskResListByNews(List<TbXtTaskResult> taskResListByNews) {
		this.taskResListByNews = taskResListByNews;
	}
	public List<TbXtTaskResult> getTaskResListByForum() {
		return taskResListByForum;
	}
	public void setTaskResListByForum(List<TbXtTaskResult> taskResListByForum) {
		this.taskResListByForum = taskResListByForum;
	}
	
}
