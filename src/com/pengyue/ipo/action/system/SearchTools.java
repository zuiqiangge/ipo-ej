package com.pengyue.ipo.action.system;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.FacetField.Count;
import org.apache.solr.client.solrj.response.Group;
import org.apache.solr.client.solrj.response.GroupCommand;
import org.apache.solr.client.solrj.response.GroupResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.GroupParams;
import org.apache.solr.common.params.ModifiableSolrParams;

import com.pengyue.ipo.bean.News;
import com.pengyue.ipo.bean.TbXtTask;
import com.pengyue.ipo.collection.SourceInfo;

public class SearchTools {
	// solr url
 
 
	//public static final String URL = "http://202.120.1.92:8080/solr";
	public static final String URL = "http://127.0.0.1:8080/solr";

//	public static final String URL = "http://192.168.1.246:8080/solr";
 
 
// 
//	 public static final String URL = "http://127.0.0.1:8080/solr";
//// 	 public static final String URL = "http://127.0.0.1:8080/solr";
// 
 
	// solr应用
	public static final String SERVER = "mycore1";
	public static final String NEWSSERVER = "news_ej";

	public static String[] docs = { "3333333Solr是一个独立的企业级搜索应用服务器萌萌哒",
			"文化部：並非別國申遺成功，遺產就成別人的" };

	public static SolrClient getSolrClient(String server) {
		return new HttpSolrClient(URL + "/" + server);
	}

	/**
	 * 新建索引
	 */
	public static void createIndex() {
		SolrClient client = getSolrClient(NEWSSERVER);
		int i = 11;
		List<SolrInputDocument> docList = new ArrayList<SolrInputDocument>();
		for (String str : docs) {
			SolrInputDocument doc = new SolrInputDocument();
			doc.addField("id", "sadfasd1f");
			doc.addField("news_fid", str);
			docList.add(doc);
		}
		try {
			client.add(docList);
			client.commit();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	};

	/**
	 * 搜索
	 */
	public static void search() {
		SolrClient client = getSolrClient(NEWSSERVER);
		SolrQuery query = new SolrQuery();
		query.setQuery("news_title:政策 ");

		// query.setQuery("*:*");
		// query.setQuery("news_title:政策  AND news_context:北京 ");
		// query.setHighlight(true).setHighlightSimplePre("<span class='red'>")
		// .setHighlightSimplePost("</span>");

		// hl.fl表示高亮的field，也就是高亮的区域
		// query.setParam("hl.fl", "news_title,news_context");
		// query.setStart(1);
		// query.setRows(4);
		// query.setIncludeScore(false);
		// query.setFacet(true);
		// query.addFacetField("city");
		// query.setSort("");
		// query.setQuery("*:*");
		// *:*
		QueryResponse response = null;
		try {
			response = client.query(query);
			System.out.println(response.toString());
			System.out.println();
			SolrDocumentList docs = response.getResults();
			System.out.println("文档个数：" + docs.getNumFound());
			System.out.println("查询时间：" + response.getQTime());
			for (SolrDocument doc : docs) {
				System.out.println("id: "
						+ doc.getFieldValue("id")
						+ response.getHighlighting().get(
								doc.getFieldValue("id")).get("news_title")
						+ "      news_title: "
						+ doc.getFieldValue("news_title") + "     context:"
						+ doc.getFieldValue("news_context"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			query.clear();
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 分组
	 */
	public static void search1() {
		SolrClient client = getSolrClient(NEWSSERVER);
		SolrQuery query = new SolrQuery();
		query.setQuery("*:* ");
		query.setParam(GroupParams.GROUP, true);
		query.setParam(GroupParams.GROUP_FIELD, "news_fid");
		// query.setParam(GroupParams.GROUP_FIELD, "news_fname");
		// query.setParam(GroupParams.GROUP_LIMIT, "200");
		query.setRows(100);
		// query.setQuery("*:*");
		// query.setQuery("news_title:政策  AND news_context:北京 ");
		// query.setHighlight(true).setHighlightSimplePre("<span class='red'>")
		// .setHighlightSimplePost("</span>");

		// hl.fl表示高亮的field，也就是高亮的区域
		// query.setParam("hl.fl", "news_title,news_context");
		// query.setStart(1);
		// query.setRows(4);
		// query.setIncludeScore(false);
		// query.setFacet(true);
		// query.addFacetField("city");
		// query.setSort("");
		// query.setQuery("*:*");
		// *:*
		QueryResponse response = null;
		try {
			response = client.query(query);
			Map<String, Integer> info = new HashMap<String, Integer>();
			GroupResponse groupResponse = response.getGroupResponse();
			if (groupResponse != null) {
				List<GroupCommand> groupList = groupResponse.getValues();
				for (GroupCommand groupCommand : groupList) {
					List<Group> groups = groupCommand.getValues();
					for (Group group : groups) {
						info.put(group.getGroupValue(), (int) group.getResult()
								.getNumFound());
						System.out.println(group.getGroupValue() + ":"
								+ (int) group.getResult().getNumFound());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			query.clear();
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		TbXtTask t=new TbXtTask();
		t.setQueryword("习近平");
		//t.setFilterword("北京+深圳");
		t.setQuerydateks("2016-12-15");
		t.setQuerydatejs("2016-12-30");
		SearchTools.searchTaskData(t);
	}

 
	 

	// 创建新闻内索引
	public static boolean createIndexNews(List<News> newsList) {
		if (newsList == null || newsList.size() < 1) {
			return true;
		}
		Boolean flag = false;
		SolrClient client = getSolrClient(NEWSSERVER);

		List<SolrInputDocument> docList = new ArrayList<SolrInputDocument>();

		// for (News news : newsList) {
		// SolrInputDocument doc = new SolrInputDocument();
		// doc.addField("id", news.getId());
		// doc.addField("news_title", news.getTitle());
		// doc.addField("news_pubnisihTime", news.getPubnisihTime());
		// doc.addField("news_sourceName", news.getSourceName());
		// doc.addField("news_clickedCounts", news.getClickedCounts());
		// doc.addField("news_describe", news.getDescribe());
		// doc.addField("news_context", news.getContext());
		// doc.addField("news_url", news.getUrl());
		// doc.addField("news_etlgxsj", news.getEtlgxsj());
		// doc.addField("news_fid", news.getFid());
		// doc.addField("news_fname", news.getFname());
		// docList.add(doc);
		// }
		try {
			client.addBeans(newsList);
			// client.add(docList);
			client.commit();
			client.close();
			flag = true;
			System.out.println("索引创建完毕");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	};

	public static int searchNewscount(String queryWord) {
		int res = 0;
		if (queryWord != null) {
			queryWord = queryWord.trim();
		}
		SolrClient client = getSolrClient(NEWSSERVER);
		SolrQuery query = new SolrQuery();
		if (queryWord == null || queryWord.length() < 1) {
			query.setQuery("*:*");
		} else {
			query.setQuery("news_title:" + queryWord + "  OR news_context:"
					+ queryWord);
		}

		QueryResponse response = null;
		try {
			response = client.query(query);

			SolrDocumentList docs = response.getResults();
			res = (int) docs.getNumFound();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			query.clear();
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}
	
	/**
	 * 按条件搜索新闻数量
	 * @param params
	 * @return
	 */
	public static int searchNewsCountByMap(Map<String, Object> params) {
		int res = 0;
		String queryWord = (String) params.get("queryWord");
		String parentSourceId = (String) params.get("parentSourceId");
		
		String startTime = (String) params.get("startTime");
		String endTime = (String) params.get("endTime");
		
		if (queryWord != null) {
			queryWord = queryWord.trim();
		}
		SolrClient client = getSolrClient(NEWSSERVER);
		SolrQuery query = new SolrQuery();
		StringBuffer qy = new StringBuffer("*:*");
		//关键词是否为空
		if (queryWord != null && queryWord.length() > 0) {
			Boolean fenci = (Boolean) params.get("fenci");
			qy.setLength(0);
			//是否分词
			if(fenci != null && fenci == false){
				queryWord = "*" + queryWord + "*";//使用模糊查询格式
				qy.append("news_title_mh:");
				qy.append(queryWord);
			}else{
				qy.append("(");
				qy.append("news_title:");
				qy.append(queryWord);
				qy.append(" OR news_context:");
				qy.append(queryWord);
				qy.append(")");
			}
		}
		//时间区间
		if(startTime != null && startTime.trim().length() > 0 && endTime != null && endTime.trim().length() > 0){
			if(qy.toString().equals("*:*")){
				qy.setLength(0);
			}else{
				qy.append(" AND ");
			}
			qy.append("news_pubnisihTime_sj:[");
			qy.append(startTime);
			qy.append(" TO ");
			qy.append(endTime);
			qy.append("]");
		}
		//网站id是否为空
		if(parentSourceId != null && parentSourceId.trim().length() > 0){
			if(qy.toString().equals("*:*")){
				qy.setLength(0);
			}else{
				qy.append(" AND ");
			}
			qy.append("news_fid:");
			qy.append(parentSourceId.trim());
		}
		query.setQuery(qy.toString());

		QueryResponse response = null;
		try {
			response = client.query(query);
			SolrDocumentList docs = response.getResults();
			res = (int) docs.getNumFound();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			query.clear();
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	/**
	 * 按条件搜索新闻列表
	 * @param params
	 * @return
	 */
	public static List<News> searchNewsListByMap(Map<String, Object> params) {
		List<News> res = new ArrayList<News>();
		String queryWord = (String) params.get("queryWord");
		String parentSourceId = (String) params.get("parentSourceId");
		String start = params.get("solrqsPage") + "";
		String rows = params.get("solrendPage") + "";
		String startTime = (String) params.get("startTime");
		String endTime = (String) params.get("endTime");
		
		if (queryWord != null) {
			queryWord = queryWord.trim();
		}
		SolrClient client = getSolrClient(NEWSSERVER);
		SolrQuery query = new SolrQuery();
		StringBuffer qy = new StringBuffer("*:*");
		//关键词是否为空
		if (queryWord != null && queryWord.length() > 0) {
			Boolean fenci = (Boolean) params.get("fenci");
			qy.setLength(0);
			//是否分词
			if(fenci != null && fenci == false){
				queryWord = "*" + queryWord + "*";//使用模糊查询格式
				qy.append("news_title_mh:");
				qy.append(queryWord);
			}else{
				qy.append("(");
				qy.append("news_title:");
				qy.append(queryWord);
				qy.append(" OR news_context:");
				qy.append(queryWord);
				qy.append(")");
			}
		}
		//时间区间
		if(startTime != null && startTime.trim().length() > 0 && endTime != null && endTime.trim().length() > 0){
			if(qy.toString().equals("*:*")){
				qy.setLength(0);
			}else{
				qy.append(" AND ");
			}
			qy.append("news_pubnisihTime_sj:[");
			qy.append(startTime);
			qy.append(" TO ");
			qy.append(endTime);
			qy.append("]");
		}
		//网站id是否为空
		if(parentSourceId != null && parentSourceId.trim().length() > 0){
			if(qy.toString().equals("*:*")){
				qy.setLength(0);
			}else{
				qy.append(" AND ");
			}
			qy.append("news_fid:");
			qy.append(parentSourceId.trim());
		}
		query.setQuery(qy.toString());
		query.setSort("news_clickedCounts", ORDER.desc);
		query.setStart(Integer.parseInt(start));
		query.setRows(Integer.parseInt(rows));
		query.setHighlight(true).setHighlightSimplePre("<font color='red'>")
				.setHighlightSimplePost("</font>");
		// hl.fl表示高亮的field，也就是高亮的区域
		query.setParam("hl.fl", "news_title,news_context");
		QueryResponse response = null;
		try {
			response = client.query(query);

			SolrDocumentList docs = response.getResults();
			for (SolrDocument doc : docs) {
				News o = new News();
				o.setId((String) doc.getFieldValue("id"));
				if (queryWord == null || queryWord.trim().length() < 1)
					o.setTitle(doc.getFieldValue("news_title") + "");
				else{
					
					if(response.getHighlighting().get(doc.getFieldValue("id"))
							.get("news_title") == null){
						o.setTitle(doc.getFieldValue("news_title") + "");
					}else{
						o.setTitle(response.getHighlighting().get(
								doc.getFieldValue("id")).get("news_title")
								+ "");
					}
				}
//				o.setPubnisihTime_sj((String) doc
//						.getFieldValue("news_pubnisihTime_sj"));
				o.setImage((String) doc.getFieldValue("news_image"));
				o.setZlm((String) doc.getFieldValue("news_zlm"));
				
				o.setPubnisihTime((String) doc
						.getFieldValue("news_pubnisihTime"));
				o.setSourceName((String) doc.getFieldValue("news_sourceName"));
				if (queryWord == null || queryWord.trim().length() < 1)
					o.setContext(doc.getFieldValue("news_context") + "");
				else {
					if(response.getHighlighting().get(doc.getFieldValue("id"))
							.get("news_context") == null){
						o.setContext(doc.getFieldValue("news_context") + "");
					}else{
						o.setContext(response.getHighlighting().get(
								doc.getFieldValue("id")).get("news_context")
								+ "");
					}
				}
				o.setClickedCounts(""+doc
						.getFieldValue("news_clickedCounts"));
				o.setDescribe((String) doc.getFieldValue("news_describe"));

				o.setUrl(doc.getFieldValue("news_url") + "");
				res.add(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			query.clear();
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	/**
	 * 获取首页上显示的内容列表
	 * 
	 * @param params
	 * @return
	 */
	public static List<News> getIndexHomeList(Map<String, Object> params) {
		List<News> res = new ArrayList<News>();
		String queryWord = (String) params.get("queryWord");
		String start = params.get("solrqsPage") + "";
		String rows = params.get("solrendPage") + "";
		if (queryWord != null) {
			queryWord = queryWord.trim();
		}
		SolrClient client = getSolrClient(NEWSSERVER);
		SolrQuery query = new SolrQuery();
		if (queryWord == null || queryWord.length() < 1) {
			query.setQuery("*:*");
		} else {
			query.setQuery("news_title:" + queryWord + "  OR news_context:"
					+ queryWord);
		}
		query.setStart(Integer.parseInt(start));
		query.setRows(Integer.parseInt(rows));
		query.setSort("news_clickedCounts", ORDER.desc);
		query.setHighlight(true).setHighlightSimplePre("<font color='red'>")
				.setHighlightSimplePost("</font>");
		// hl.fl表示高亮的field，也就是高亮的区域
		query.setParam("hl.fl", "news_title,news_context");
		QueryResponse response = null;
		try {
			response = client.query(query);

			SolrDocumentList docs = response.getResults();
			for (SolrDocument doc : docs) {
				News o = new News();
				o.setId((String) doc.getFieldValue("id"));
				if (queryWord == null || queryWord.trim().length() < 1)
					o.setTitle(doc.getFieldValue("news_title") + "");
				else {

					if (response.getHighlighting().get(doc.getFieldValue("id"))
							.get("news_title") == null) {
						o.setTitle(doc.getFieldValue("news_title") + "");
					} else {
						o.setTitle(response.getHighlighting().get(
								doc.getFieldValue("id")).get("news_title")
								+ "");
					}
				}
				o.setPubnisihTime((String) doc
						.getFieldValue("news_pubnisihTime"));
				o.setSourceName((String) doc.getFieldValue("news_sourceName"));
				if (queryWord == null || queryWord.trim().length() < 1)
					o.setContext(doc.getFieldValue("news_context") + "");
				else {
					if (response.getHighlighting().get(doc.getFieldValue("id"))
							.get("news_context") == null) {
						o.setContext(doc.getFieldValue("news_context") + "");
					} else {
						o.setContext(response.getHighlighting().get(
								doc.getFieldValue("id")).get("news_context")
								+ "");
					}
				}
				o.setClickedCounts( doc
						.getFieldValue("news_clickedCounts")+"");
				o.setDescribe((String) doc.getFieldValue("news_describe"));

				o.setUrl(doc.getFieldValue("news_url") + "");
				res.add(o);
			}
			// res = response.getBeans(News.class);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			query.clear();
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}

	/**
	 * 分组统计
	 * 
	 * @return
	 */
	public static List<Map<String,Object>> groupCountBySourceFid(Map<String, Object> params){
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		SolrClient client = getSolrClient(NEWSSERVER);
		SolrQuery query = new SolrQuery();
		String queryWord = (String) params.get("queryWord");
		String startTime = (String) params.get("startTime");
		String endTime = (String) params.get("endTime");
		if (queryWord != null) {
			queryWord = queryWord.trim();
		}
		try {
			StringBuffer qy = new StringBuffer("*:*");
			//关键词
			if(queryWord != null && queryWord.length() > 0){
				Boolean fenci = (Boolean) params.get("fenci");
				qy.setLength(0);
				//是否分词
				if(fenci != null && fenci == false){
					queryWord = "*" + queryWord + "*";//使用模糊查询格式
					qy.append("news_title_mh:");
					qy.append(queryWord);
				}else{
					qy.append("(");
					qy.append("news_title:");
					qy.append(queryWord);
					qy.append(" OR ");
					qy.append("news_context:");
					qy.append(queryWord);
					qy.append(")");
				}
			}
			//时间区间
			if(startTime != null && startTime.trim().length() > 0 && endTime != null && endTime.trim().length() > 0){
				if(qy.toString().equals("*:*")){
					qy.setLength(0);
				}else{
					qy.append(" AND ");
				}
				qy.append("news_pubnisihTime_sj:[");
				qy.append(startTime);
				qy.append(" TO ");
				qy.append(endTime);
				qy.append("]");
			}
			
			query.setQuery(qy.toString());
			query.setIncludeScore(false);// 是否按每组数量高低排序
//			query.setParam(GroupParams.GROUP, true);  
//			query.setParam(GroupParams.GROUP_FIELD, "news_fid");
//			QueryResponse response = client.query(query);
//	        GroupResponse groupResponse = response.getGroupResponse();  
//	        if(groupResponse != null) {  
//	            List<GroupCommand> groupList = groupResponse.getValues();  
//	            for(GroupCommand groupCommand : groupList) {  
//	                List<Group> groups = groupCommand.getValues();  
//	                for(Group group : groups) {
//	                	Map<String, Object> info = new HashMap<String, Object>();  
//	                	System.out.println(group.getGroupValue()+":"+(int)group.getResult().getNumFound());
//	                    info.put("fid", group.getGroupValue());
//	                    info.put("count", group.getResult().getNumFound());
//	                    result.add(info);
//	                }
//	            }
//	        }
			
			query.setFacet(true);// 是否分组查询
			query.addFacetField("news_fid");// 增加分组字段
			QueryResponse response = client.query(query);
			List<Count> returnList = response.getFacetField("news_fid")
					.getValues();// 这里要和addFacetField相对应
			for (Count count : returnList) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("fid", count.getName());
				map.put("count", count.getCount());
				result.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			query.clear();
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * 根据字段分组统计
	 * 
	 * @return
	 */
	public static List<Map<String,Object>> groupCountBySourceFid(Map<String, Object> params,String facetField){
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		SolrClient client = getSolrClient(NEWSSERVER);
		SolrQuery query = new SolrQuery();
		String queryWord = (String) params.get("queryWord");
		String startTime = (String) params.get("startTime");
		String endTime = (String) params.get("endTime");
		if (queryWord != null) {
			queryWord = queryWord.trim();
		}
		try {
			StringBuffer qy = new StringBuffer("*:*");
			//关键词
			if(queryWord != null && queryWord.length() > 0){
				Boolean fenci = (Boolean) params.get("fenci");
				qy.setLength(0);
				//是否分词
				if(fenci != null && fenci == false){
					queryWord = "*" + queryWord + "*";//使用模糊查询格式
					qy.append("news_title_mh:");
					qy.append(queryWord);
				}else{
					qy.append("(");
					qy.append("news_title:");
					qy.append(queryWord);
					qy.append(" OR ");
					qy.append("news_context:");
					qy.append(queryWord);
					qy.append(")");
				}
			}
			//时间区间
			if(startTime != null && startTime.trim().length() > 0 && endTime != null && endTime.trim().length() > 0){
				if(qy.toString().equals("*:*")){
					qy.setLength(0);
				}else{
					qy.append(" AND ");
				}
				qy.append("news_pubnisihTime_sj:[");
				qy.append(startTime);
				qy.append(" TO ");
				qy.append(endTime);
				qy.append("]");
			}
			
			query.setQuery(qy.toString());
			query.setParam(GroupParams.GROUP, "true");  
			query.setParam(GroupParams.GROUP_FIELD, facetField);  
//			query.setSort(facetField, ORDER.asc);
//			query.setIncludeScore(false);// 是否按每组数量高低排序
//			query.setFacet(true);// 是否分组查询
//			query.addFacetField(facetField);// 增加分组字段
			QueryResponse response = client.query(query);
			GroupResponse groupResponse = response.getGroupResponse();  
			if(groupResponse != null) {  
				List<GroupCommand> groupList = groupResponse.getValues(); 
				if (groupList.size()>0) {
					List<Group> groups = groupList.get(0).getValues();  
					for(Group group : groups) {
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("name", group.getGroupValue());
						map.put("count", group.getResult().getNumFound()+"");
						result.add(map);
					}  
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			query.clear();
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static SolrDocumentList searchTaskData(TbXtTask tbXtTask) {
		SolrDocumentList docs=null;
		SolrClient client = getSolrClient(NEWSSERVER);
		ModifiableSolrParams params = new ModifiableSolrParams(); 
		SolrQuery query = new SolrQuery();
		String queryWord=tbXtTask.getQueryword();
		String firstStr=queryWord.substring(0,1);
		if (firstStr.equals("+")||firstStr.equals("|")) {
			queryWord=queryWord.substring(1);
		}
		String lastStr=queryWord.substring(queryWord.length()-1);
		if (lastStr.equals("+")||lastStr.equals("|")) {
			queryWord=queryWord.substring(0,queryWord.length()-1);
		}
		queryWord=queryWord.replace("+", " AND ").replace("|", " OR ");
		String filterword=tbXtTask.getFilterword();
		filterword=filterword.replace("+", " AND ").replace("|", " OR ");
		StringBuffer sb=new StringBuffer();
		sb.append("(").append("news_title:").append("(").append(queryWord).append(")").append(" OR news_context:").append("(").append(queryWord).append(")").append(")");
		if (filterword!=null&&!filterword.equals("")) {
			sb.append(" NOT news_title:").append("(").append(filterword).append(")").append(" NOT news_context:").append("(").append(filterword).append(")");
		}
		sb.append(" AND ");
		sb.append("news_pubnisihTime_sj:[");
		sb.append(tbXtTask.getQuerydateks().replace("-", "")+"000000");
		sb.append(" TO ");
		sb.append(tbXtTask.getQuerydatejs().replace("-", "")+"000000");
		sb.append("]");
		System.out.println(sb.toString());
		params.set("q",sb.toString());
		params.set("start", 0);
	    params.set("rows", SourceInfo.solrMaxSize+1);
	    params.set("defType", "edismax");
	    params.set("mm", "80%");
		//query.setQuery(sb.toString());
		//query.setParam("mm", "10%");
		//query.setSort("news_clickedCounts", ORDER.desc);
		// query.setQuery("news_title:政策  AND news_context:北京 ");
		/*query.setHighlight(true).setHighlightSimplePre("<span class='red'>")
				.setHighlightSimplePost("</span>");*/
		//query.setStart(0);
		//query.setRows(SourceInfo.solrMaxSize+1);
		// hl.fl表示高亮的field，也就是高亮的区域
		//query.setParam("hl.fl", "news_title,news_context");
		//query.setStart(1);
		//query.setRows(4); 
		// query.setIncludeScore(false);
		// query.setFacet(true);
		// query.addFacetField("city");
		// query.setSort("");
		// query.setQuery("*:*");
		// *:*news_clickedCounts
		QueryResponse response = null;
		try {
			response = client.query(params);
			docs = response.getResults();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			query.clear();
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return docs;
	}
	
	public static SolrDocumentList test(TbXtTask tbXtTask){
		SolrDocumentList docs=null;
//		String queryWord = tbXtTask.getQueryword();
//		queryWord=queryWord.replace("+", " AND ").replace("|"," OR ");
		//String parentSourceId = tbXtTask.getSourceid();
		String startTime = tbXtTask.getQuerydateks();
		String endTime = tbXtTask.getQuerydatejs();
		SolrClient client = getSolrClient(NEWSSERVER);
		SolrQuery query = new SolrQuery();
		StringBuffer qy = new StringBuffer("*:*");
		query.setQuery("(news_title:测试   OR news_title:中国) AND (news_context:测试) AND news_pubnisihTime_sj:[20170101 TO 20170120]");
		//query.setSort("news_clickedCounts", ORDER.desc);
		query.setHighlight(true).setHighlightSimplePre("<font color='red'>")
				.setHighlightSimplePost("</font>");
		
		query.setRows(2000);
		
		// hl.fl表示高亮的field，也就是高亮的区域
		QueryResponse response = null;
		try {
			response = client.query(query);
			docs = response.getResults();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			query.clear();
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return docs;
	}
	
	/**
	 * 查询指定的新闻
	 * @param newsId
	 * @return
	 */
	public static News searchNewsById(String newsId) {
		SolrClient client = getSolrClient(NEWSSERVER);
		SolrQuery query = new SolrQuery();
		query.setQuery("id:"+newsId);
		QueryResponse response = null;
		News o = new News();
		try {
			response = client.query(query);
			SolrDocumentList docs = response.getResults();
			if (docs != null && docs.size() > 0) {
				SolrDocument doc = docs.get(0);
				o.setId((String) doc.getFieldValue("id"));
				o.setTitle(doc.getFieldValue("news_title") + "");
//				o.setPubnisihTime((String) doc.getFieldValue("news_pubnisihTime"));
//				o.setSourceName((String) doc.getFieldValue("news_sourceName"));
//				o.setContext((String) doc.getFieldValue("news_context"));
//				o.setDescribe((String) doc.getFieldValue("news_describe"));
//				o.setUrl(doc.getFieldValue("news_url") + "");
				o.setClickedCounts(doc.getFieldValue("news_clickedCounts") + "");
				o.setFname((String) doc.getFieldValue("news_fname"));
				o.setZlm((String) doc.getFieldValue("news_zlm"));
				o.setPubnisihuser((String) doc.getFieldValue("news_pubnisihuser"));
				o.setPubnisihTime_sj((String) doc.getFieldValue("news_pubnisihTime_sj"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			query.clear();
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return o;
	}
}