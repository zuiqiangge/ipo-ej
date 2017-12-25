package com.pengyue.ipo.bean;

import java.io.Serializable;
import java.util.UUID;

public class TbXtTaskResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String taskId;
	
	private String resulttitle;

	private String resultdescribe;
	
	private String resultpubtime;
	
	private String resulturl;
	
	private String resultsource;
	
	private String etlgxsj;
	
	private String resultcounts;
	
	private String pubnisihuser;
	
	private String clickedCounts;
	

	public TbXtTaskResult() {
		super();
		this.id=UUID.randomUUID().toString().replace("-", "");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getResulttitle() {
		return resulttitle;
	}

	public void setResulttitle(String resulttitle) {
		this.resulttitle = resulttitle;
	}

	public String getResultdescribe() {
		return resultdescribe;
	}

	public void setResultdescribe(String resultdescribe) {
		this.resultdescribe = resultdescribe;
	}

	public String getResultpubtime() {
		return resultpubtime;
	}

	public void setResultpubtime(String resultpubtime) {
		this.resultpubtime = resultpubtime;
	}

	public String getResulturl() {
		return resulturl;
	}

	public void setResulturl(String resulturl) {
		this.resulturl = resulturl;
	}

	public String getResultsource() {
		return resultsource;
	}

	public void setResultsource(String resultsource) {
		this.resultsource = resultsource;
	}

	public String getEtlgxsj() {
		return etlgxsj;
	}

	public void setEtlgxsj(String etlgxsj) {
		this.etlgxsj = etlgxsj;
	}

	public String getResultcounts() {
		return resultcounts;
	}

	public void setResultcounts(String resultcounts) {
		this.resultcounts = resultcounts;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPubnisihuser() {
		return pubnisihuser;
	}

	public void setPubnisihuser(String pubnisihuser) {
		this.pubnisihuser = pubnisihuser;
	}

	public String getClickedCounts() {
		return clickedCounts;
	}

	public void setClickedCounts(String clickedCounts) {
		this.clickedCounts = clickedCounts;
	}
	
}
