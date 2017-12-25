package com.pengyue.ipo.service.news;

import java.util.List;

import com.pengyue.ipo.bean.News;
/**
 * 新闻采集service
 * @author wanlongquan
 *
 */
public interface NewsService {
	/**
	 * 批量插入
	 * @param newsList
	 */
	public void batchInsert(List<News> newsList);
	
	/**
	 * url是否已存在
	 * @param url
	 * @return
	 */
	public boolean urlExists(String url);
}
