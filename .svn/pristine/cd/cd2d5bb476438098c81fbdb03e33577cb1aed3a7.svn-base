package com.pengyue.ipo.service.system;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pengyue.ipo.bean.TbXtCollect;
import com.pengyue.ipo.bean.TbXtReplay;
import com.pengyue.ipo.dao.system.TbXtFourmCollectDao;
import com.pengyue.ipo.dao.system.TbXtFourmReplayDao;
import com.pengyue.ipo.util.HanLPUtil;

@Service
@Transactional
public class CollectSevice {
	@Autowired
	private TbXtFourmCollectDao  tbXtFourmCollectDao;
	@Autowired
	private TbXtFourmReplayDao	tbXtFourmReplayDao;
	
	public boolean isExist(String url){
		boolean flag=false;
		//URL是否已存在
		if (tbXtFourmCollectDao.count(url)>0) {
			flag=true;
		}
		return flag;
	}
	
	public void saveData(List<TbXtCollect> colList, List<TbXtReplay> repList){
		List<String> ids=new ArrayList<String>();
		try {
			for (TbXtCollect tbXtCollect : colList) {
				tbXtCollect.setTitle(HanLPUtil.simplifiedChinese(tbXtCollect.getTitle()));
				tbXtCollect.setContext(HanLPUtil.simplifiedChinese(tbXtCollect.getContext()));
				int x=tbXtFourmCollectDao.savePost(tbXtCollect);
				if (x==1) {
					ids.add(tbXtCollect.getId());
				}
			}
			for (TbXtReplay tbXtReplay : repList) {
				if (ids.contains(tbXtReplay.getForumid())) {
					tbXtReplay.setContext(HanLPUtil.simplifiedChinese(tbXtReplay.getContext()));
					tbXtFourmReplayDao.saveReplay(tbXtReplay);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}
