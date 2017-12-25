package com.pengyue.ipo.timer;

import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import com.pengyue.ipo.bean.Plan;
import com.pengyue.ipo.mq.producer.QueueSender;
@Component
public class GetProperties {
	@Autowired private TaskScheduler scheduler;
	//启动容器时,开始一个定时任务,用来获取配置文件里的信息
	/*static{
		 scheduler.schedule(new Runnable() {
				public void run() {
			        System.out.printf("Task: %s, Current time: %s\n", 1, new Date().toLocaleString());
				}
			}, new CronTrigger("15,30,45 * * * * ?"));
	}*/
	 public void execute1(Plan plan){
	        scheduler.schedule(new Runnable() {
				public void run() {
			        System.out.printf("Task: %s, Current time: %s\n", 1, new Date().toLocaleString());
				}
			}, new CronTrigger(plan.getTimer()));
			/*String.format("15,30,45 * * * * ?",plan.getTimer()))*/
	 }

	 
	
}
