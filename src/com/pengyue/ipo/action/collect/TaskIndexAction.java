package com.pengyue.ipo.action.collect;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pengyue.ipo.bean.ForumUser;
import com.pengyue.ipo.bean.TbXtTask;
import com.pengyue.ipo.bean.TbXtTaskResult;
import com.pengyue.ipo.collection.SourceInfo;
import com.pengyue.ipo.service.system.TbXtTaskSevice;
import com.pengyue.ipo.util.DateFormat;
import com.pengyue.ipo.util.DateUtil;
import com.pengyue.ipo.util.JsonUtil;
@Controller
@Scope("prototype")
public class TaskIndexAction extends ActionSupport implements ModelDriven<TbXtTask>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String jsonData;
	
	private TbXtTask tbXtTask;
	
	private ArrayList<String> ids;
	
	private List<TbXtTask> jingdian;
	
	private TaskDetailVo taskDetailVo;
	
	@Autowired
	private TbXtTaskSevice tbXtTaskSevice;
	
	public void solrCount(){
		HttpServletResponse rep=ServletActionContext.getResponse();
		try {
			int count=tbXtTaskSevice.countTaskData(tbXtTask);
			if (count<=SourceInfo.solrMaxSize&&count>0) {
				 rep.getWriter().println("1");
			}else {
				rep.getWriter().println("0");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				rep.getWriter().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String createTask(){
		jsonData=JsonUtil.objectToJson(tbXtTaskSevice.queryFidIsNull());
		return "createTask";
	}
	
	public void saveTask(){
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < this.ids.size(); i++) {
			if (ids.get(i).equals("0")) {
				continue;
			}
			sb.append(ids.get(i));
			if (i!=this.ids.size()-1) {
				sb.append(",");
			}
		}
		tbXtTask.setSourceid(sb.toString());
		tbXtTaskSevice.saveTask(tbXtTask);
	}
	
	public String taskIndex(){
		this.jingdian=tbXtTaskSevice.jingdian(tbXtTask.getType());
		for (TbXtTask tbXtTask : jingdian) {
			TaskDetailVo taskDetailVo=new TaskDetailVo();
			TbXtTaskResult res=tbXtTaskSevice.firstTaskResByTask(tbXtTask.getId());
			//将新闻发布的时间格式转换
			if (res.getResultpubtime()!=null&&!res.getResultpubtime().equals("")) {
				res.setResultpubtime(DateFormat.dateToTime(res.getResultpubtime().trim()));
			}else {
				res.setResultpubtime(DateFormat.dateToTime(DateUtil.fmtDt(new Date(), "yyyyMMddHHmmss")));
			}
			taskDetailVo.setFirstRes(res);
			tbXtTask.setTaskDetailVoChild(taskDetailVo);
		}
		return "taskIndex";
	}
	
	public String taskList1(){
		tbXtTaskSevice.queryTaskAll(tbXtTask);
		return "taskList1";
	}
	
	public void deleteTaskById(){
		HttpServletResponse rep=ServletActionContext.getResponse();
		try {
			tbXtTaskSevice.deleteTaskById(tbXtTask.getId());
			rep.getWriter().println("1");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				rep.getWriter().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String taskDetail(){
		tbXtTask=tbXtTaskSevice.getTaskById(tbXtTask.getId());
		taskDetailVo=new TaskDetailVo();
		taskDetailVo.setFastigiumCount(tbXtTaskSevice.fastigiumCount(tbXtTask.getId()));
		taskDetailVo.setFastigiumDate(DateUtil.parse(tbXtTaskSevice.fastigiumDate(tbXtTask.getId()), "yyyyMMdd"));
		List<TbXtTaskResult> listRes=tbXtTaskSevice.queryTaskResByTask(tbXtTask.getId());
		//将新闻发布的时间格式转换
		for (TbXtTaskResult res : listRes) {
			if (res.getResultpubtime()!=null&&!res.getResultpubtime().equals("")) {
				res.setResultpubtime(DateFormat.dateToTime(res.getResultpubtime().trim()));
			}else {
				res.setResultpubtime(DateFormat.dateToTime(DateUtil.fmtDt(new Date(), "yyyyMMddHHmmss")));
			}
		}
		taskDetailVo.setTaskResList(listRes);
		taskDetailVo.setSiteSourcePie(tbXtTaskSevice.taskSourceSitesPie(tbXtTask.getId()));
		listRes=tbXtTaskSevice.taskResListByClickTop10(tbXtTask.getId());
		for (TbXtTaskResult res : listRes) {
			if (res.getResultpubtime()!=null&&!res.getResultpubtime().equals("")) {
				res.setResultpubtime(DateFormat.dateToTime(res.getResultpubtime().trim()));
			}else {
				res.setResultpubtime(DateFormat.dateToTime(DateUtil.fmtDt(new Date(), "yyyyMMddHHmmss")));
			}
		}
		taskDetailVo.setTaskResListByClickTop10(listRes);
		//得到涉及的所有论坛
		taskDetailVo.setTbXtSourceList(tbXtTaskSevice.queryForumByTask(tbXtTask.getId()));
		//保存每个论坛用户发帖前十
		List<List<ForumUser>> forumUser=new ArrayList<List<ForumUser>>();
		forumUser.add(tbXtTaskSevice.queryForumUserTOP10(tbXtTask.getId(),""));
		for (String forumName : taskDetailVo.getTbXtSourceList()) {
			List<ForumUser> forumUserChild=tbXtTaskSevice.queryForumUserTOP10(tbXtTask.getId(),forumName);
			//为每个用户设置论坛头像
			for (ForumUser forumUser2 : forumUserChild) {
				forumUser2.setImage("sinaStyle/detail/app-more-icon-bbs.jpg");
			}
			forumUser.add(forumUserChild);
		}
		taskDetailVo.setForumUserList(forumUser);
		taskDetailVo.setTaskResListByNews(tbXtTaskSevice.queryNewsTop10(tbXtTask.getId()));
		taskDetailVo.setTaskResListByForum(tbXtTaskSevice.queryForumTop10(tbXtTask.getId()));
		return "taskDetail";
	}
	
	//————————————————————我是分割线————————————————————————————————
	
	
	
	public String getJsonData() {
		return jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TbXtTask getTbXtTask() {
		return tbXtTask;
	}

	public void setTbXtTask(TbXtTask tbXtTask) {
		this.tbXtTask = tbXtTask;
	}

	@Override
	public TbXtTask getModel() {
		if (this.tbXtTask==null) {
			this.tbXtTask=new TbXtTask();
		}
		return tbXtTask;
	}

	public ArrayList<String> getIds() {
		return ids;
	}

	public void setIds(ArrayList<String> ids) {
		this.ids = ids;
	}

	public TaskDetailVo getTaskDetailVo() {
		return taskDetailVo;
	}

	public void setTaskDetailVo(TaskDetailVo taskDetailVo) {
		this.taskDetailVo = taskDetailVo;
	}

	public List<TbXtTask> getJingdian() {
		return jingdian;
	}

	public void setJingdian(List<TbXtTask> jingdian) {
		this.jingdian = jingdian;
	}

}
