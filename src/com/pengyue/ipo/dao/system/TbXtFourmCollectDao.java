package com.pengyue.ipo.dao.system;

import java.util.List;

import com.pengyue.ipo.bean.TbXtCollect;

public interface TbXtFourmCollectDao {
	/**
	 * 保存一个帖子对象
	 * @param tbXtCollect
	 * @return
	 */
	public int savePost(TbXtCollect tbXtCollect);
	
	/**
	 * 根据URL统计记录数
	 * @return
	 */
	public int count(String url); 
}
