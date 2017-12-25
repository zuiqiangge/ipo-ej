package com.pengyue.ipo.dao.news;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pengyue.ipo.bean.NewsKeyWord;
import com.pengyue.ipo.collection.SourceInfo;

@Repository()
public class NewsKeywordDaoImpl implements NewsKeywordDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<NewsKeyWord> queryKeyWord(NewsKeyWord newsKeyWord) {
		return sqlSessionTemplate.selectList("queryKeyWord", newsKeyWord);
	}

	@Override
	public int countWord(NewsKeyWord newsKeyWord) {
		int counts=0;
		try {
			counts=sqlSessionTemplate.selectOne("countWord",newsKeyWord);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return counts;
	}

	@Override
	public void addKeyWord(String keyWord) {
		/*String[] k=SourceInfo.FiltWord.split(",");
		for (int i = 0; i < k.length; i++) {
			sqlSessionTemplate.insert("addKeyWord", k[i]);
		}*/
		sqlSessionTemplate.insert("addKeyWord", keyWord);
	}

	@Override
	public void delKeyWord(String id) {
		sqlSessionTemplate.delete("delKeyWord",id);
	}

	@Override
	public void editKeyWord(NewsKeyWord newsKeyWord) {
		sqlSessionTemplate.update("editKeyWord", newsKeyWord);
	}

	@Override
	public List<NewsKeyWord> queryAllKeyWord() {
		return sqlSessionTemplate.selectList("queryAllKeyWord");
	}
}
