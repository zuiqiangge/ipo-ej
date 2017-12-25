package com.pengyue.ipo.bean;

import java.io.Serializable;
import java.util.UUID;

import com.pengyue.ipo.action.collect.TaskDetailVo;
import com.pengyue.ipo.action.system.Page;

public class TbXtTask extends Page<TbXtTask> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String taskname;
	private String queryword;
	private String querydateks;
	private String querydatejs;
	private String filterword;
	private String type="1";
	private String sourceid;
	private String isfinish="1";  //默认完成
	private String totalitem;
	private String totalclick;
	private TaskDetailVo taskDetailVoChild;
	
	public TbXtTask() {
		super();
		this.id=UUID.randomUUID().toString().replace("-", "");
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	public String getQueryword() {
		return queryword;
	}
	public void setQueryword(String queryword) {
		this.queryword = queryword;
	}
	public String getQuerydateks() {
		return querydateks;
	}
	public void setQuerydateks(String querydateks) {
		this.querydateks = querydateks;
	}
	public String getQuerydatejs() {
		return querydatejs;
	}
	public void setQuerydatejs(String querydatejs) {
		this.querydatejs = querydatejs;
	}
	public String getFilterword() {
		if (filterword==null) {
			filterword="";
		}
		return filterword;
	}
	public void setFilterword(String filterword) {
		this.filterword = filterword;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSourceid() {
		return sourceid;
	}
	public void setSourceid(String sourceid) {
		this.sourceid = sourceid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getIsfinish() {
		return isfinish;
	}

	public void setIsfinish(String isfinish) {
		this.isfinish = isfinish;
	}


	public String getTotalitem() {
		return totalitem;
	}


	public void setTotalitem(String totalitem) {
		this.totalitem = totalitem;
	}


	public String getTotalclick() {
		return totalclick;
	}


	public void setTotalclick(String totalclick) {
		this.totalclick = totalclick;
	}


	public TaskDetailVo getTaskDetailVoChild() {
		return taskDetailVoChild;
	}


	public void setTaskDetailVoChild(TaskDetailVo taskDetailVoChild) {
		this.taskDetailVoChild = taskDetailVoChild;
	}
	
	
}
