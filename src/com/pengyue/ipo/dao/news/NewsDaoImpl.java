package com.pengyue.ipo.dao.news;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pengyue.ipo.action.system.SearchTools;
import com.pengyue.ipo.bean.News;

/**
 * 新闻采集dao
 * 
 * @author wanlongquan
 * 
 */
@Repository("newsDao")
public class NewsDaoImpl implements NewsDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	// /**
	// * 批量插入
	// */
	// @Override
	// public void batchInsert(List<News> newsList) {
	// sqlSessionTemplate.insert("BatchInsertNews", newsList);
	// }

	/**
	 * 批量插入
	 * 
	 * @param newsList
	 */
	public synchronized void batchInsert(List<News> newsList) {
		SqlSession session = null;
		try {
			session = sqlSessionTemplate.getSqlSessionFactory().openSession(
					ExecutorType.BATCH, false);
			for (int i = 0; i < newsList.size(); i++) {
				//有时相同数据还需再判断一次
//				int count = session.selectOne("FindCountByUrl",newsList.get(i).getUrl());
//				if(count > 0 ){
//					continue;
//				}
				
				session.insert("InsertNews", newsList.get(i));
				// 每100个提交一次或者集合元素遍历完成提交
				if ((i > 0 && i % 100 == 0) || i == newsList.size() - 1) {
					// 手动每100个一提交，提交后无法回滚
					session.commit();
					// 清理缓存，防止溢出
					session.clearCache();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}

	/**
	 * 查询相同链接数量
	 */
	@Override
	public int findCountByUrl(String url) {
		return sqlSessionTemplate.selectOne("FindCountByUrl", url);
	}

	@Override
	public ArrayList<News> selectNewsNeedUpdate() {
		// TODO Auto-generated method stub
		List<News> o = new ArrayList<News>();
		try {
			System.out.println("aaaaabbb");
			o = sqlSessionTemplate.selectList("selectNewsNeedUpdate");
			System.out.println("aaaaa");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (ArrayList<News>) o;
	}

	@Override
	public int getIndexHomeCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		String queryWord = (String) params.get("queryWord");
		int res = 0;

		res = SearchTools.searchNewscount(queryWord);

		return res;
	}

	@Override
	public List<News> getIndexHomeList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		List<News> res = new ArrayList<News>();

		res = SearchTools.getIndexHomeList(params);
		return res;
	}
	
	/**
	 * 按fid分组统计
	 * @return
	 */
	public List<Map<String,Object>> groupCountBySourceFid(Map<String, Object> params){
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		result = SearchTools.groupCountBySourceFid(params);
		return result;
	}
	
	/**
	 * 查询所有采集网站
	 * @return
	 */
	public List<Map<String,Object>> findAllParentSource(){
		return sqlSessionTemplate.selectList("findAllParentSource");
	}

	@Override
	public int searchNewsCountByMap(Map<String, Object> params) {
		int res = 0;
		res = SearchTools.searchNewsCountByMap(params);
		return res;
	}

	@Override
	public List<News> searchNewsListByMap(Map<String, Object> params) {
		List<News> res = new ArrayList<News>();
		res = SearchTools.searchNewsListByMap(params);
		return res;
	}

	@Override
	public List<Map<String, Object>> findNewsKeyword() {
		return sqlSessionTemplate.selectList("findNewsKeyword");
	}

	@Override
	public News solrFindNewsById(String newsId) {
		return SearchTools.searchNewsById(newsId);
	}

	@Override
	public int findCountByZlmAndTime(Map<String, Object> params) {
		return sqlSessionTemplate.selectOne("findCountByZlmAndTime", params);
	}

	@Override
	public List<News> findGrdyqht(Map<String, Object> params) {
		try {
			return sqlSessionTemplate.selectList("findGrdyqht", params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<String> selectSourceList() {
		// TODO Auto-generated method stub
		try {
			return sqlSessionTemplate.selectList("selectSourceList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<News> selectNewsNeedUpdateBySource(Map<String, Object> params) {
		// TODO Auto-generated method stub
		try {
			//判断有多少条，防止内存溢出
			
			
			return sqlSessionTemplate.selectList("selectNewsNeedUpdateBySource",params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int selectNewsNeedcountUpdateBySource(String sourceid) {
		// TODO Auto-generated method stub
		try {
			 
			
			
			return sqlSessionTemplate.selectOne("selectNewsNeedcountUpdateBySource",sourceid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Map<String, Object>> groupBySsdq(Map<String, Object> params) {
		return sqlSessionTemplate.selectList("groupBySsdq",params);
	}

	@Override
	public List<News> findNewsBySSDQ(Map<String, Object> params) {
		return sqlSessionTemplate.selectList("findNewsBySSDQ",params);
	}

	@Override
	public List<Map<String, Object>> findNewsCountByZlm(
			Map<String, Object> params) {
		return sqlSessionTemplate.selectList("findNewsCountByZlm",params);
	}

	@Override
	public List<News> yqrdListByRownum(Map<String, Object> params) {
		return sqlSessionTemplate.selectList("yqrdListByRownum",params);
	}

	@Override
	public List<News> selectNewsUpdateByIds(List<String> ids) {
		return sqlSessionTemplate.selectList("selectNewsUpdateByIds", ids);
	}

	@Override
	public void updateNewsClickedcounts(News news) {
		sqlSessionTemplate.update("updateNewsClickedcounts", news);
	}

	@Override
	public int selectToDayNewsCount() {
		return sqlSessionTemplate.selectOne("selectToDayNewsCount");
	}

	@Override
	public List<News> selectToDayNews(Map<String, Object> params) {
		return sqlSessionTemplate.selectList("selectToDayNews", params);
	}

}
