package com.pengyue.ipo.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.pengyue.ipo.bean.RegionKeyword;
import com.pengyue.ipo.service.news.RegionKeywordService;
import com.pengyue.ipo.util.RegionUtil;

public class RegionKeywordListener implements ServletContextListener {
	
	private RegionKeywordService regionKeywordService;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		regionKeywordService = springContext.getBean(RegionKeywordService.class);
		
		List<RegionKeyword> keywords = regionKeywordService.findRegionKeyWords();
		//设置地区关键词
		RegionUtil.setMap(keywords);
	}

}
