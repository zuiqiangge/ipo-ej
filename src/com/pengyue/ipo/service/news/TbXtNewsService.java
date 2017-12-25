package com.pengyue.ipo.service.news;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.record.Buffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pengyue.ipo.action.system.SearchTools;
import com.pengyue.ipo.bean.News;
import com.pengyue.ipo.bean.NewsKeyWord;
import com.pengyue.ipo.dao.news.NewsDao;
import com.pengyue.ipo.dao.news.NewsKeywordDao;
import com.pengyue.ipo.tree.Bar;
import com.pengyue.ipo.tree.Pie;

import javassist.compiler.ast.Keyword;

/**
 * 新闻管理Service类
 * 
 * @Author:zhuweiwei
 * @Date：2016-11-25
 */
@Service
@Transactional
public class TbXtNewsService {
	@Autowired
	private NewsDao newsDao;
	@Autowired
	private NewsKeywordDao newsKeywordDao;

	/**
	 * 获取需要更新的news
	 * 
	 * @param loginid
	 * @return
	 */
	public ArrayList<News> selectNewsNeedUpdate() {
		return newsDao.selectNewsNeedUpdate();
	}

	/**
	 * 获取首页上显示的
	 * 
	 * @return
	 */
	public List<News> getIndexHomeList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return newsDao.getIndexHomeList(params);
	}

	/**
	 * 获取首页上显示的条数
	 * 
	 * @return
	 */
	public int getIndexHomeCount(Map<String, Object> params) {
		return newsDao.getIndexHomeCount(params);
	}

	/**
	 * 采集网站信息统计
	 * 
	 * @return
	 */
	public List<Map<String, Object>> findAllSource(Map<String, Object> params) {
		List<Map<String,Object>> sourceMapList = new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> result = newsDao
				.groupCountBySourceFid(params);
		List<Map<String, Object>> sourceList = newsDao.findAllParentSource();
		long count = 0;
		for (Map<String, Object> sourceMap : sourceList) {
			Map<String,Object> sMap = new HashMap<String,Object>();
			sMap.put("fid", sourceMap.get("ID"));
			sMap.put("count", "0");
			sMap.put("fname", sourceMap.get("NAME"));
			for (Map<String, Object> map : result) {
				String fid = (String) map.get("fid");
				String id = (String) sourceMap.get("ID");
				if (fid.equals(id)) {
					sMap.put("count", map.get("count"));
					break;
				}
			}
			sourceMapList.add(sMap);
			count += Long.parseLong(sMap.get("count").toString());
		}
		
//		for (Map<String, Object> map : result) {
//			for (Map<String, Object> sourceMap : sourceList) {
//				String fid = (String) map.get("fid");
//				String id = (String) sourceMap.get("ID");
//				if (fid.equals(id)) {
//					map.put("fname", sourceMap.get("NAME"));
//					break;
//				}
//			}
//			count += Long.parseLong(map.get("count").toString());
//		}

		Map<String, Object> all = new HashMap<String, Object>();
		all.put("fid", "");
		all.put("fname", "全部");
		all.put("count", count);
		sourceMapList.add(0, all);
		return sourceMapList;
	}
	
	/**
	 * 饼图按国别统计总数
	 * @return
	 */
	public List<Pie> pieCountByGB(Map<String, Object> params){
		List<Pie> pieList=new ArrayList<Pie>();
		List<Map<String, Object>> listData=SearchTools.groupCountBySourceFid(params, "news_ssdqname");
		for (Map<String, Object> map : listData) {
			pieList.add(new Pie((String)map.get("name"),(String)map.get("count")));
		}
		return pieList;
	}
	
	/**
	 * 统计图按天统计总数
	 * @return
	 */
	public Bar barCountByDay(Map<String, Object> params){
		List<String> x=new ArrayList<String>();
		List<String> y=new ArrayList<String>();
		List<Map<String, Object>> listData=SearchTools.groupCountBySourceFid(params, "news_rqnyr");
		Collections.sort(listData, new Comparator<Map<String, Object>>() {
			@Override
			public int compare(Map<String, Object> o1, Map<String, Object> o2) {
				return new Integer((String)o1.get("name"))-new Integer((String)o2.get("name"));
			}
		});
		for (Map<String, Object> map : listData) {
			x.add(new StringBuffer(((String)map.get("name")).substring(4)).insert(2, "-").toString());
			y.add((String)map.get("count"));
		}
		return new Bar(x,y);
	}

	/**
	 * 按条件搜索新闻数量
	 * 
	 * @param params
	 * @return
	 */
	public int searchNewsCountByMap(Map<String, Object> params) {
		return newsDao.searchNewsCountByMap(params);
	}

	/**
	 * 按条件搜索新闻列表
	 * 
	 * @param params
	 * @return
	 */
	public List<News> searchNewsListByMap(Map<String, Object> params) {
		return newsDao.searchNewsListByMap(params);
	}

	/**
	 * 查询搜索新闻的关键词
	 * 
	 * @return
	 */
	public List<Map<String, Object>> findNewsKeyword() {
		return newsDao.findNewsKeyword();
	}
	
	/**
	 * 根据id查询
	 * @param newsId
	 * @return
	 */
	public News solrFindNewsById(String newsId){
		return newsDao.solrFindNewsById(newsId);
	}
	/**
	 * 根据这里面和时间段查询数量
	 * @param params
	 * @return
	 */
	public int findCountByZlmAndTime(Map<String,Object> params){
		return newsDao.findCountByZlmAndTime(params);
	}
	
	/**
	 * 高热度舆情话题
	 * @param params
	 * @return
	 */
	public List<News> findGrdyqht(Map<String,Object> params){
		return newsDao.findGrdyqht(params);
	}

	public List<String> selectSourceList() {
		// TODO Auto-generated method stub
		return newsDao.selectSourceList();
	}

	public List<News> selectNewsNeedUpdateBySource(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return newsDao.selectNewsNeedUpdateBySource(params);
	}

	public int selectNewsNeedcountUpdateBySource(String sourceid) {
		// TODO Auto-generated method stub
		return newsDao.selectNewsNeedcountUpdateBySource(sourceid);
	}
	
	/**
	 * 统计不同地区新闻数量
	 * @return
	 */
	public List<Map<String,Object>> groupBySsdq(Map<String, Object> params){
		return newsDao.groupBySsdq(params);
	}
	
	/**
	 * 查询指定地区前五条新闻
	 * @param params
	 * @return
	 */
	public List<News> findNewsBySSDQ(Map<String,Object> params){
		return newsDao.findNewsBySSDQ(params);
	}
	
	public List<Map<String, Object>> findNewsCountByZlm(
			Map<String, Object> params) {
		return newsDao.findNewsCountByZlm(params);
	}
	
	public List<News> yqrdListByRownum(Map<String, Object> params) {
		return newsDao.yqrdListByRownum(params);
	}

	public void addKeyWord(String keyWord ){
		newsKeywordDao.addKeyWord(keyWord);
	}
	
	public void delKeyWord(String id ){
		newsKeywordDao.delKeyWord(id);
	}
	
	public void editKeyWord(NewsKeyWord newsKeyWord ){
		newsKeywordDao.editKeyWord(newsKeyWord);
	}
	
	public void queryKeyWord(NewsKeyWord newsKeyWord){
		newsKeyWord.setTotalRecord(newsKeywordDao.countWord(newsKeyWord));
		newsKeyWord.setResults(newsKeywordDao.queryKeyWord(newsKeyWord));
	}
	
	public List<NewsKeyWord> queryAllKeyWord(){
		return newsKeywordDao.queryAllKeyWord();
	}
	
	public void updateNewsClickedcounts(News news){
		newsDao.updateNewsClickedcounts(news);
	}
	
	public int selectToDayNewsCount(){
		return newsDao.selectToDayNewsCount();
	}
	
	public List<News> selectToDayNews(Map<String,Object> params){
		return newsDao.selectToDayNews(params);
	}
}
