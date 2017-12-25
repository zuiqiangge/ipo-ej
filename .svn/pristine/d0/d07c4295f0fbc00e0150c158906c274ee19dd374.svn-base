package com.pengyue.ipo.dao.system;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.pengyue.ipo.bean.TbXtReplay;

@Repository
public class TbXtFourmReplayImpl implements TbXtFourmReplayDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void saveReplay(TbXtReplay tbXtReplay) {
		try {
			sqlSessionTemplate.insert("saveReplay", tbXtReplay);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
