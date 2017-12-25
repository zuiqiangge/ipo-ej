package com.pengyue.ipo.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.pengyue.ipo.bean.Plan;
import com.pengyue.ipo.mq.producer.QueueSender;
import com.pengyue.ipo.timer.GetProperties;

/**
 * 
 * @author liang
 * @description controller测试
 */
@Controller
@Scope("prototype")
public class ActivemqController extends ActionSupport{
	
	@Autowired
	QueueSender queueSender;
	
	@Autowired private TaskScheduler scheduler;
    public void execute1(){
        scheduler.schedule(new Runnable() {
			
			public void run() {
		        System.out.printf("Task: %s, Current time: %s\n", 1, new Date().toLocaleString());

				
			}
		}, new CronTrigger("15,30,45 * * * * ?"));
    }

	/**
	 * 发送消息到队列
	 * Queue队列：仅有一个订阅者会收到消息，消息一旦被处理就不会存在队列中
	 * @param message
	 * @return String
	 */
	
	public String queueSender(){
 		String opt="";
		try {
			queueSender.send("plan", "fsfsdfsd");
			opt = "suc";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NONE;
	}
	
	
	
	
	public static void main(String[] args) {
		ApplicationContext context1 = new ClassPathXmlApplicationContext("scheduler.xml");
		GetProperties s = context1.getBean(GetProperties.class);
		File file = new File("D:\\workSpace\\ipo_ej\\WebRoot\\WEB-INF\\classes\\plan.xml");
		String f ="";
		try {
			Scanner in =new Scanner(new FileReader(file));
			
			while(in.hasNext()){
				f+=in.next();
				f+=" ";
			}
			System.out.println(f);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {  
            JAXBContext context = JAXBContext.newInstance(Plan.class);  
            Unmarshaller unmarshaller = context.createUnmarshaller();  
            Plan plan = (Plan)unmarshaller.unmarshal(new StringReader(f));  
            System.out.println(plan); 
           s.execute1(plan);
        } catch (JAXBException e) {  
            e.printStackTrace();  
        }  
		
	}
}



