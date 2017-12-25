package com.pengyue.ipo.bean;

import java.util.Date;

import org.apache.solr.client.solrj.beans.Field;

public class News {
	//id
	private String id;
	//标题
	private String title;
	//标题
	private String title_mh;
	//发布时间
	private String pubnisihTime;
	//发布时间
	private String pubnisihTime_sj;
	//网站id
	private String sourceId;
	//点击量
	private String clickedCounts = "0";
	//描述
	private String describe;
	//内容
	private String context;
	//内容
	private String context_mh;
	//链接
	private String url;
	//入库时间
	private Date etlgxsj;
	//关联的源头中文名
	private String sourceName;
	//关联的fid
	private String fid;
	//关联的faname
	private String fname;
	//Image
	private String image;
	//中立面
	private String zlm;
	//帖子作者
	private  String pubnisihuser;
	//地区
	private String ssdq;
	//地区名称
	private String ssdqname;
	//
	private String rqnyr;
	
	public News() { }

	public News(String title, String pubnisihTime, String sourceId,
			String clickedCounts, String describe, String context, String url) {
		super();
		this.title = title;
		this.pubnisihTime = pubnisihTime;
		this.sourceId = sourceId;
		this.clickedCounts = clickedCounts;
		this.describe = describe;
		this.context = context;
		this.url = url;
	}
	
	public News(String title, String pubnisihTime, String sourceId,
			String clickedCounts, String describe, String context, String url, String zlm) {
		super();
		this.title = title;
		this.pubnisihTime = pubnisihTime;
		this.sourceId = sourceId;
		this.clickedCounts = clickedCounts;
		this.describe = describe;
		this.context = context;
		this.url = url;
		this.zlm = zlm;
	}
	
	public News(String title, String pubnisihTime, String sourceId,
			String clickedCounts, String describe, String context, String url, String zlm, String ssdq) {
		super();
		this.title = title;
		this.pubnisihTime = pubnisihTime;
		this.sourceId = sourceId;
		this.clickedCounts = clickedCounts;
		this.describe = describe;
		this.context = context;
		this.url = url;
		this.zlm = zlm;
		this.ssdq = ssdq;
	}
	
	public News(String id,String title, String pubnisihTime, String sourceId,
			String clickedCounts, String describe, String context, String url, String zlm, String ssdq) {
		super();
		this.id = id;
		this.title = title;
		this.pubnisihTime = pubnisihTime;
		this.sourceId = sourceId;
		this.clickedCounts = clickedCounts;
		this.describe = describe;
		this.context = context;
		this.url = url;
		this.zlm = zlm;
		this.ssdq = ssdq;
	}
	
	
	public String getId() {
		return id;
	}
	@Field
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	@Field("news_title") 
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPubnisihTime() {
		return pubnisihTime;
	}
	@Field("news_pubnisihTime") 
	public void setPubnisihTime(String pubnisihTime) {
		this.pubnisihTime = pubnisihTime;
	}
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	public String getClickedCounts() {
		return clickedCounts;
	}
	@Field("news_clickedCounts") 
	public void setClickedCounts(String clickedCounts) {
		this.clickedCounts = clickedCounts;
	}
	public String getDescribe() {
		return describe;
	}
	@Field("news_describe") 
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getContext() {
		return context;
	}
	@Field("news_context") 
	public void setContext(String context) {
		this.context = context;
	}
	public String getUrl() {
		return url;
	}
	@Field("news_url") 
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getEtlgxsj() {
		return etlgxsj;
	}
	@Field("news_etlgxsj") 
	public void setEtlgxsj(Date etlgxsj) {
		this.etlgxsj = etlgxsj;
	}
	public String getSourceName() {
		return sourceName;
	}
	 @Field("news_sourceName") 
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public String getFid() {
		return fid;
	}
	@Field("news_fid") 
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	@Field("news_fname") 
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getTitle_mh() {
		return title_mh;
	}
	@Field("news_title_mh") 
	public void setTitle_mh(String titleMh) {
		title_mh = titleMh;
	}
	public String getPubnisihTime_sj() {
		return pubnisihTime_sj;
	}
	@Field("news_pubnisihTime_sj") 
	public void setPubnisihTime_sj(String pubnisihTimeSj) {
		pubnisihTime_sj = pubnisihTimeSj;
	}
	public String getContext_mh() {
		return context_mh;
	}
	@Field("news_context_mh") 
	public void setContext_mh(String contextMh) {
		context_mh = contextMh;
	}
	public String getImage() {
		return image;
	}
	@Field("news_image")
	public void setImage(String image) {
		this.image = image;
	}
	public String getZlm() {
		return zlm;
	}
	@Field("news_zlm") 
	public void setZlm(String zlm) {
		this.zlm = zlm;
	}

	public String getPubnisihuser() {
		return pubnisihuser;
	}
	@Field("news_pubnisihuser") 
	public void setPubnisihuser(String pubnisihuser) {
		this.pubnisihuser = pubnisihuser;
	}

	public String getSsdq() {
		return ssdq;
	}
	@Field("news_ssdq")
	public void setSsdq(String ssdq) {
		this.ssdq = ssdq;
	}

	public String getSsdqname() {
		return ssdqname;
	}
	@Field("news_ssdqname")
	public void setSsdqname(String ssdqname) {
		this.ssdqname = ssdqname;
	}

	public String getRqnyr() {
		return rqnyr;
	}
	@Field("news_rqnyr")
	public void setRqnyr(String rqnyr) {
		this.rqnyr = rqnyr;
	}
	
}
