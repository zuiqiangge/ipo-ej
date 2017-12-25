package com.pengyue.ipo.action.system;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.Group;
import org.apache.solr.client.solrj.response.GroupCommand;
import org.apache.solr.client.solrj.response.GroupResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.GroupParams;

/**
 * solr 5.3.0 Created by daxiong on 2015/10/23.
 */
public class MySolr {

	// solr url
	public static final String URL = "http://192.168.1.246:8080/solr";
	// solr应用
	public static final String SERVER = "news_ej";
	// 待索引、查询字段
	// public static String[] docs = {"Solr是一个独立的企业级搜索应用服务器萌萌哒",
	// "它对外提供类似于Web-service的API接口",
	// "用户可以通过http请求",
	// "向搜索引擎服务器提交一定格式的XML文件生成索引",
	// "也可以通过Http Get操作提出查找请求",
	// "并得到XML格式的返回结果"};
	public static String[] docs = { "5555Solr是一个独立的企业级搜索应用服务器萌萌哒" };

	public static SolrClient getSolrClient() {
		return new HttpSolrClient(URL + "/" + SERVER);
	}

	/**
	 * 新建索引
	 */
	public static void createIndex() {
		SolrClient client = getSolrClient();
		int i = 11;
		List<SolrInputDocument> docList = new ArrayList<SolrInputDocument>();

		SolrInputDocument doc = new SolrInputDocument();
		doc.addField("id", "20161207000003");
		doc.addField("testfield_ik", "sadfa撒旦放假了就爱上了对方的家里家啊上海交通大学");
		doc.addField("testfield_ik1", "1 ");
		docList.add(doc);

		SolrInputDocument doc1 = new SolrInputDocument();
		doc1.addField("id", "20161207000001");
		doc1.addField("testfield_ik", "艾弗森撒点粉撒java333点粉撒旦放假了就爱上了对方家里家啊 ");
		doc1.addField("testfield_ik1", "上海交通大学大学");
		try {
			 client.add(docList);
			 // client.deleteById("AFDB602A08284A12A46FE45D54F1F5C3");
		 
			client.commit();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	};

 
	
	
	public static void search_group() {
		SolrClient server = getSolrClient();
        SolrQuery param = new SolrQuery();  
        param.setQuery("news_title:年  OR  news_context:政策 ");
        param.setRows(100);  
        param.setParam(GroupParams.GROUP, true);  
       // param.setParam(GroupParams.GROUP_MAIN, false);  
       // param.setParam(GroupParams., "news_fname");  
        param.setParam(GroupParams.GROUP_FIELD, "news_fid","news_fname");  
        param.setParam(GroupParams.GROUP_LIMIT, "100");
        param.set("group.format", "grouped"); //default:simple, other:grouped  
      //  param.set("group.main", "false");    // when /*group.format=simple and */ group.main=true, just return the documentList only!!!   
        QueryResponse response = null;  
        try {  
            response = server.query(param);  
        } catch ( Exception e) {  
        }  
        Map<String, Integer> info = new HashMap<String, Integer>();  
        GroupResponse groupResponse = response.getGroupResponse();  
        if(groupResponse != null) {  
            List<GroupCommand> groupList = groupResponse.getValues();  
            for(GroupCommand groupCommand : groupList) {  
                List<Group> groups = groupCommand.getValues();  
                for(Group group : groups) {
                	System.out.println(group.getGroupValue()+":"+(int)group.getResult().getNumFound());
                    info.put(group.getGroupValue(), (int)group.getResult().getNumFound());  
                }  
            }  
        } 
	}
	
	public static void search_group2(){
		SolrClient solr = getSolrClient();
		SolrQuery params = new SolrQuery();  
        
        //the common parameters for all search  
		 params.setQuery("news_title_mh:*年*");  
//        params.set("fq", "age:[20 TO 30]", "grade:[70 TO *]"); // filter query  
//        params.set("fl", "*,score");  // field list  
//        params.set("sort", "grade desc" );  //default score desc.         
//        params.set("start", "0");  
//        params.set("rows", "10");  
//        params.set("timeAllowed", "30000"); //miliseconds  
//        //params.set("wt", "xml"); // the response writer type  
//        params.set("omitHeader", "true"); //default false  
//        params.set("cache", "false");     //default true  
          
        //parameters only for grouping result  
        params.set("group", "true");          
        params.set("group.field", "news_fname","news_fid");  
       // params.set("group.query", "学生", "学习", "grade:[0 TO 59.9]", "grade:[60 TO *]", "age:[10 TO 19]", "age:[20 TO *]" );  
        //params.set("group.func", "grade GRATERTHAN 60"); // not found, don't use it!!!      
          
       // params.set("group.sort", "grade desc");  
        params.set("group.format", "grouped"); //default:simple, other:grouped  
        params.set("group.main", "false");    // when /*group.format=simple and */ group.main=true, just return the documentList only!!!   
          
        params.set("group.ngroups", "true");  
        params.set("group.truncate", "true"); //default is false;  
          
        params.set("group.cache.percent", "50"); //default is 0;  
          
        params.set("group.offset", "0");  
        params.set("group.limit", "1000");  
          
        // 分布式设置  
        //params.set("shards", "localhost:8983/solr1", "localhost:8983/solr2"); //shards=host:port/base_url[,host:port:/base_url,[....]]  
        //params.set("shards.qt", "/select"); // qt: query type// to indicate the request Handler to use  
  
        QueryResponse response = null;  
        try {  
            response = solr.query(params);  
            //System.out.println("查询耗时：" + response.getQTime());  
        } catch (SolrServerException e) {  
            System.err.println(e.getMessage());  
            e.printStackTrace();  
        } catch (Exception e) {  
            System.err.println(e.getMessage());  
            e.printStackTrace();  
        } finally {  
            solr.shutdown();  
        }  
          
        if (response != null) {  
            GroupResponse groupResponse = response.getGroupResponse();  
      
            if (groupResponse != null) {  
                List<GroupCommand> groupCommandList = groupResponse.getValues();  
                for (GroupCommand groupCommand : groupCommandList) {  
                    System.out.println("GroupCommand Name : " + groupCommand.getName());  
                    System.out.println("Num of Groups Found: " + groupCommand.getNGroups());  
                    System.out.println("Num of documents Found: " + groupCommand.getMatches());  
  
                    System.out.println("The groups are: ");  
                    List<Group> groups = groupCommand.getValues();  
                    for (Group group : groups) {  
                        System.out.println("group value: " + group.getGroupValue());  
                        SolrDocumentList solrDocumentList = group.getResult();  
                        System.out.println("Num of Documents in this group: " + solrDocumentList.getNumFound());  
                        System.out.println("start: " + solrDocumentList.getStart());  
                        System.out.println("Max score: " + solrDocumentList.getMaxScore());  
                        // solrDocumentList.get(index)  
                      
                        for (SolrDocument doc : solrDocumentList) {  
                            System.out.println("the Fields of document:");  
                            Collection<String> names = doc.getFieldNames();  
                            for (String name : names) {  
                                System.out.println(name + ": " + doc.getFieldValue(name));  
                            }  
                            System.out.println("n");  
                        }  
                        System.out.println("nn");  
                    }  
                    System.out.println("nn");  
                }  
            }  
              
            //System.out.println("response = " + response);  
            //System.out.println(response.getStatus());  
            System.out.println("查询耗时：" + response.getQTime());  
        }  
	}

	
	/**
	 * 搜索
	 */
	public static void search() {
		SolrClient client = getSolrClient();
		SolrQuery query = new SolrQuery();
		// 条件组合
		// query.setQuery("testfield_ik:服务 NOT testfield_ik1:共产党");//
		// 模糊检索
	//	query.addFilterQuery("testfield_ik:" + "*"+"上海交通"+"*");
		  query.setQuery("(news_title:上海  OR news_context:上海)  AND news_pubnisihTime_sj:[20170201000000 TO 20170228235959]");
		 // query.setQuery(" ");
		// 单字段排序
		    query.setSort("news_pubnisihTime_sj",SolrQuery.ORDER.asc);
 		   query.setStart(1);
 		   query.setRows(10);
		// 多字段排序
		// SortClause sortClause = new SortClause("testfield_ik",
		// SolrQuery.ORDER.desc);
		// SortClause sortClause1 = new SortClause("testfield_ik1",
		// SolrQuery.ORDER.asc);
		// query.addOrUpdateSort(sortClause);
		// query.addOrUpdateSort(sortClause1);
		//+AB:america 表示必须存在
		// query.setQuery("testfield_ik:\"方的\"");//
		//id: 1      content: sadfa撒旦放假了就爱上了对方的家里家啊                fd:sadf共产党
		//id: 2      content: 艾弗森撒点粉撒点粉撒旦放假了就爱上了对方家里家啊                fd:中国
		//  query.setQuery("testfield_ik:*");//
// 		   //分组测试
// 		  query.setParam(GroupParams.GROUP, GROUP);  
// 		 query.setParam(GroupParams.GROUP_FIELD, "news_fname");  
// 		query.setParam(GroupParams.GROUP_LIMIT, GROUP_LIMIT); 
 		   
		QueryResponse response = null;
		try {
			response = client.query(query);
			System.out.println(response.toString());
			SolrDocumentList docs = response.getResults();
			System.out.println("文档个数：" + docs.getNumFound());
			System.out.println("查询时间：" + response.getQTime());
			for (SolrDocument doc : docs) {
				System.out.println("id: " + doc.getFieldValue("id")
						+ "      ftitle: " + doc.getFieldValue("news_title")
						+ "               内容:"
						+ doc.getFieldValue("news_context"));
			}
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	   	SolrClient client = getSolrClient();
		SolrQuery param = new SolrQuery();  
		param.setQuery("news_pubnisihTime_sj:[20170307000000 TO 20170315235959]");  
//		param.setRows(10);
		param.setParam(GroupParams.GROUP, "true");  
		param.setParam(GroupParams.GROUP_FIELD, "news_rqnyr");  
//		param.setParam(GroupParams.GROUP_LIMIT, "10");
		QueryResponse response = null;
		try {  
			response = client.query(param);  
		} catch (SolrServerException e) {  
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		GroupResponse groupResponse = response.getGroupResponse();  
		if(groupResponse != null) {  
			List<GroupCommand> groupList = groupResponse.getValues();  
			for(GroupCommand groupCommand : groupList) {  
				List<Group> groups = groupCommand.getValues();  
				for(Group group : groups) {  
				    System.out.println(group.getGroupValue() + ":" + (int)group.getResult().getNumFound());  
				}  
			}  
		}  
	}
}