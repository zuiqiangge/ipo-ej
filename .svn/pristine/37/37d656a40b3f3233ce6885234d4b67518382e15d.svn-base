package com.pengyue.ipo.dao.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pengyue.ipo.bean.TbXtYhxx;

/**
 *用户管理dao
 * 
 *@Author:zhuweiwei
 *@Date：2016-11-25
 */
@Repository
public class TbXtYhxxImpl implements TbXtYhxxDao {
	private final String INSERT_SQL = "insertSql";
	private final String UPDATE_SQL = "updateSql";
	private final String DELETE_SQL = "deleteSql";
	private final String FIND_BYID = "findById";
	private final String SELECT_ALL_SQL = "selectAllSql";
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public TbXtYhxx selectTbxtYhxxByLoginId(String loginid) {
		TbXtYhxx o = new TbXtYhxx();
		try {
			o = sqlSessionTemplate
					.selectOne("selectTbxtYhxxByLoginId", loginid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return o;
	}

	@Override
	public void testinsertclob(Map<String, Object> params) {
		// TODO Auto-generated method stub
		SqlSession session=null;
		try {
//			 sqlSessionTemplate
//					.insert("testinsertclob", params);
			session= sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH,false);
			//通过新的session获取mapper
			 int lsize=10;
			 for (int i = 0, n=10; i < n; i++) {
				 params.put("id", i+"");
				 session.insert("testinsertclob", params);
				 if ((i>0 && i % 1000 == 0) || i == lsize - 1) {
					// 手动每1000个一提交，提交后无法回滚
					session.commit();
					// 清理缓存，防止溢出
					session.clearCache();
					}

			 }
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			session.close();
		}
		 
	}

	@Override
	public List<TbXtYhxx> queryUser(TbXtYhxx user) {
		List<TbXtYhxx> list=null;
		try {
			list=sqlSessionTemplate.selectList("queryUser", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public int countUser(TbXtYhxx tbXtYhxx) {
		int count=0;
		try {
			count=sqlSessionTemplate.selectOne("countUser", tbXtYhxx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public void saveUser(TbXtYhxx user) {
		try {
			sqlSessionTemplate.insert("saveUser", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delUser(String userName) {
		try {
			sqlSessionTemplate.delete("delUser", userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editUser(TbXtYhxx user) {
		try {
			sqlSessionTemplate.update("editUser", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

 
}
