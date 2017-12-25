package com.pengyue.ipo.dao.system;

import java.util.List;
import java.util.Map;

import com.pengyue.ipo.bean.TbXtYhxx;


/**
 *用户管理Dao接口
 *
 *@Author:zhuweiwei
 *@Date：2016-11-25
*/
public interface TbXtYhxxDao {
 
	public TbXtYhxx selectTbxtYhxxByLoginId(String loginid);

	public void testinsertclob(Map<String, Object> params);
	
	/**
	 * 分页查询用户
	 * @param user
	 * @return
	 */
	public List<TbXtYhxx> queryUser(TbXtYhxx user);
	
	/**
	 * 统计总记录数
	 * @param tbXtYhxx
	 * @return
	 */
	public  int countUser(TbXtYhxx tbXtYhxx); 
	
	/**
	 * 主策新用户
	 * @param user
	 */
	public void saveUser(TbXtYhxx user);

	/**
	 * 删除用户
	 * @param userName
	 */
	public void delUser(String userName);
	
	/**
	 * 修改密码
	 * @param user
	 */
	public void editUser(TbXtYhxx user);

}
