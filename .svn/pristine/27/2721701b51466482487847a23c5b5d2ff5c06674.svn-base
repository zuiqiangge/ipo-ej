package com.pengyue.ipo.service.news;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pengyue.ipo.action.system.SearchTools;
import com.pengyue.ipo.bean.News;
import com.pengyue.ipo.bean.NewsKeyWord;
import com.pengyue.ipo.dao.news.NewsDao;
import com.pengyue.ipo.dao.news.NewsKeywordDao;

/**
 * 新闻采集service
 * @author wanlongquan
 *
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService {
	
	@Autowired
	private NewsDao newsDao;
	@Autowired
	private NewsKeywordDao newsKeywordDao;

	/**
	 * 批量插入
	 */
	@Override
	public void batchInsert(List<News> newsList) {
		//去除List中News对象的url属性重复的数据
		for (int i = 0; i < newsList.size()-1; i++) {  
		    for (int j = newsList.size()-1; j > i; j--) {  
		        if (newsList.get(j).getUrl().equals(newsList.get(i).getUrl())) {  
		        	newsList.remove(j);
		        }
		    }
		}
		System.out.println("-----newsListSize:"+newsList.size());
		newsDao.batchInsert(newsList);
		
		//更新solr
		List<String> ids = new ArrayList<String>();
		for (News news : newsList) {
			ids.add(news.getId());
		}
		List<NewsKeyWord> keyWords = newsKeywordDao.queryAllKeyWord();//查询过滤词
		List<News> solrData = newsDao.selectNewsUpdateByIds(ids);
		List<News> filtNewsList=new ArrayList<News>();
		for (News news : solrData) {
			for (NewsKeyWord word : keyWords) {
				if (news.getTitle().contains(word.getKeyWord())||news.getContext().contains(word.getKeyWord())) {
					filtNewsList.add(news);
					break;
				}
			}
		}
		SearchTools.createIndexNews(filtNewsList);
	}
	
	/**
	 * url是否已存在
	 */
	@Override
	public boolean urlExists(String url) {
		int count = newsDao.findCountByUrl(url);
		if(count > 0)
			return true;
		return false;
	}
	
}
