package com.pengyue.ipo.dao.system;

import java.util.List;

import com.pengyue.ipo.bean.ForumUser;
import com.pengyue.ipo.bean.TbXtSource;
import com.pengyue.ipo.bean.TbXtTaskResult;
import com.pengyue.ipo.tree.Pie;

public interface TbXtTaskResDao {
	/**
	 * 保存一个任务结果对象
	 * @param tbXtTaskResult
	 */
	public void saveTaskRes(TbXtTaskResult tbXtTaskResult);
	
	/**
	 * 查询最高峰日期
	 * @return
	 */
	public String fastigiumDate(String taskId);
	
	/**
	 * 查询最高峰数量
	 * @return
	 */
	public String fastigiumCount(String taskId);
	
	/**
	 * 根据taskID查询源头舆论
	 * @param taskid
	 * @return
	 */
	public TbXtTaskResult firstTaskResByTask(String taskid);
	
	/**
	 * 根据taskid查询所有舆论
	 * @param taskid
	 * @return
	 */
	public List<TbXtTaskResult> queryTaskResByTask(String taskid);
	
	/**
	 * 根据taskid查询舆论网站来源饼图数据
	 * @param taskid
	 * @return
	 */
	public List<Pie> taskSourceSitesPie(String taskid);
	
	/**
	 * 根据taskid查询点击量前十舆论
	 * @param taskid
	 * @return
	 */
	public List<TbXtTaskResult> taskResListByClickTop10(String taskid);
	
	/**
	 * 根据taskid查询所有论坛数据
	 * @return
	 */
	public List<String> queryForumByTask(String taskid);
	
	/**
	 * 根据taskid查询某论坛前十发帖用户,空值则查询全部
	 * @return
	 */
	public List<ForumUser> queryForumUserTOP10(String taskid,String forumName);
	
	/**
	 * 根据taskid查询前十新闻媒体舆论
	 * @param taskid
	 * @return
	 */
	public List<TbXtTaskResult> queryNewsTop10(String taskid);
	
	/**
	 * 根据taskid查询前十论坛舆论
	 * @param taskid
	 * @return
	 */
	public List<TbXtTaskResult> queryForumTop10(String taskid);
}
