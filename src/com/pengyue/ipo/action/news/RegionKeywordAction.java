package com.pengyue.ipo.action.news;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.pengyue.ipo.bean.RegionKeyword;
import com.pengyue.ipo.service.news.NewsSsdqService;
import com.pengyue.ipo.service.news.RegionKeywordService;
import com.pengyue.ipo.util.RegionUtil;

@Controller
@Scope("prototype")
public class RegionKeywordAction {
	
	@Autowired
	private RegionKeywordService regionKeywordService;
	@Autowired
	private NewsSsdqService newsSsdqService;
	
	private RegionKeyword keyword;
	
	/**
	 * 查询所有地区和对应关键词
	 * @return
	 */
	public String findAll(){
		List<Map<String,Object>> result = newsSsdqService.findNewsSsdq();
		ActionContext.getContext().getValueStack().set("result", result);
		return "findAllSuccess";
	}
	
	/**
	 * 通过地区id查询地区关键词
	 */
	public void findKeywordBySsdq(){
        /* 获得response */
        HttpServletResponse response = ServletActionContext.getResponse();
        /* 设置格式为text/json    */
        response.setContentType("text/json");
        /*设置字符集为'UTF-8'*/
        response.setCharacterEncoding("UTF-8"); 
		keyword = regionKeywordService.findRegionKeyWordsBySsdq(keyword.getSsdq());
		JSONObject json = JSONObject.fromObject(keyword);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改关键词
	 * @return
	 */
	public String update(){
		regionKeywordService.updateRegionKeyWords(keyword);
		List<RegionKeyword> keywords = regionKeywordService.findRegionKeyWords();
		//修改关键词之后重新设置关键词
		RegionUtil.setMap(keywords);
		return "updateSuccess";
	}
	
	public RegionKeyword getKeyword() {
		return keyword;
	}
	public void setKeyword(RegionKeyword keyword) {
		this.keyword = keyword;
	}
	
	
}
