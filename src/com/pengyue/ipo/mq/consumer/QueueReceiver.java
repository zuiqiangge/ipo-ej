package com.pengyue.ipo.mq.consumer;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.pengyue.ipo.bean.News;

/**
 * 
 * @author liang
 * @description  队列消息监听器
 * 
 */
@Component
public class QueueReceiver implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("QueueReceiver1接收到消息:"+((TextMessage)message).getText());
			String json = ((TextMessage)message).getText();
			JSONArray jsonArray = JSONArray.fromObject(json);
			List<News> news= JSONArray.toList(jsonArray,News.class);
			for(News ne :news){
				System.out.println(ne.getFname());
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	
	
}

