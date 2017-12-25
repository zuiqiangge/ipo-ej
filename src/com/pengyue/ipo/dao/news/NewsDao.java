package com.pengyue.ipo.dao.news;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pengyue.ipo.bean.News;
/**
 * 新闻采集dao
 * @author wanlongquan
 *
 */
public interface NewsDao {
	
	/**
	 * 批量插入
	 * @param newsList
	 */
	public void batchInsert(List<News> newsList);
	
	/**
	 * 查询相同链接数量
	 * @param url
	 * @return
	 */
	public int findCountByUrl(String url);
	/**
	 * 获取需要更新的news
	 * @return
	 */
	public ArrayList<News> selectNewsNeedUpdate();
	
	public int getIndexHomeCount(Map<String, Object> params);
	
	public List<News> getIndexHomeList(Map<String, Object> params);
	
	public List<Map<String, Object>> groupCountBySourceFid(Map<String, Object> params);
	
	public List<Map<String, Object>> findAllParentSource();
	/**
	 * 按条件搜索新闻数量
	 * @param params
	 * @return
	 */
	public int searchNewsCountByMap(Map<String, Object> params);
	/**
	 * 按条件搜索新闻列表
	 * @param params
	 * @return
	 */
	public List<News> searchNewsListByMap(Map<String, Object> params);
	
	/**
	 * 查询新闻搜索的关键词
	 * @return
	 */
	public List<Map<String, Object>> findNewsKeyword();
	/**
	 * 通过id查询
	 * @param newsId
	 * @return
	 */
	public News solrFindNewsById(String newsId);
	/**
	 * 根据时间段和中立面统计数量
	 * @param params
	 * @return
	 */
	public int findCountByZlmAndTime(Map<String,Object> params);
	/**
	 * 高热度舆情话题
	 * @param params
	 * @return
	 */
	public List<News> findGrdyqht(Map<String,Object> params);

	public List<String> selectSourceList();

	public List<News> selectNewsNeedUpdateBySource(Map<String, Object> params);

	public int selectNewsNeedcountUpdateBySource(String sourceid);
	
	/**
	 * 统计不同地区新闻数量
	 * @return
	 */
	public List<Map<String,Object>> groupBySsdq(Map<String, Object> params);
	
	public List<News> findNewsBySSDQ(Map<String,Object> params);
	
	public List<Map<String,Object>> findNewsCountByZlm(Map<String, Object> params);
	
	public List<News> yqrdListByRownum(Map<String,Object> params);
	
	public List<News> selectNewsUpdateByIds(List<String> ids);
	
	public void updateNewsClickedcounts(News news);
	
	public int selectToDayNewsCount();
	
	public List<News> selectToDayNews(Map<String,Object> params);
	
}
