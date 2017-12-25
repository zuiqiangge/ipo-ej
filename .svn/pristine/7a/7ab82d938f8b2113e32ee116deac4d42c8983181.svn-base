package com.pengyue.ipo.service.system;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pengyue.ipo.bean.TbXtYhxx;
import com.pengyue.ipo.dao.system.TbXtYhxxDao;


/**
 *用户管理Service类
 *
 *@Author:zhuweiwei
 *@Date：2016-11-25
 */
@Service
@Transactional
public class TbXtYhxxService {
	@Autowired
	private TbXtYhxxDao tbXtYhxxDao;
	
 
	/**
	 * 根据登陆账号查询
	 * @param loginid
	 * @return
	 */
	public TbXtYhxx selectTbxtYhxxByLoginId(String loginid){
		return tbXtYhxxDao.selectTbxtYhxxByLoginId(loginid);
	}


	public void testinsertclob(Map<String, Object> params) {
		  tbXtYhxxDao.testinsertclob(params);
	}
	
	public void queryUser(TbXtYhxx tbXtYhxx){
		tbXtYhxx.setTotalRecord(tbXtYhxxDao.countUser(tbXtYhxx));
		tbXtYhxx.setResults(tbXtYhxxDao.queryUser(tbXtYhxx));
	}
	
	public void saveUser(TbXtYhxx tbXtYhxx){
		tbXtYhxxDao.saveUser(tbXtYhxx);
	}
	
	public void delUser(String userName){
		tbXtYhxxDao.delUser(userName);
	}
	
	public void editUser(TbXtYhxx tbXtYhxx){
		tbXtYhxxDao.editUser(tbXtYhxx);
	}
}
