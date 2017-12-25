package com.pengyue.ipo.dao.system;

import java.util.List;

import com.pengyue.ipo.bean.TbXtTask;
public interface TbXtTaskDao {
	/**
	 * 保存一个任务对象
	 * @param tbXtTask
	 */
	public void saveTask(TbXtTask tbXtTask);
	
	/**
	 * 查询已创建任务页面数据
	 * @param tbXtTask
	 * @return
	 */
	public List<TbXtTask> queryTaskAll(TbXtTask tbXtTask);
	
	/**
	 * 统计某类型任务总个数
	 * @param tbXtTask
	 * @return
	 */
	public int countResult(TbXtTask tbXtTask);
	
	/**
	 * 根据id获取一个任务
	 * @param id
	 * @return
	 */
	public TbXtTask getTaskById(String id);
	
	/**
	 * 根据type查询经典案列
	 * @param type
	 * @return
	 */
	public List<TbXtTask> jingdian(String type);
	
	/**
	 * 根据id删除任务
	 * @param id
	 */
	public void deleteTaskById(String id);
}
