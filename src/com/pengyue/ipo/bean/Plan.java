package com.pengyue.ipo.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement  
public class Plan {
	private String url;
	private String timer;
	private String rule;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Plan [url=" + url + ", timer=" + timer + ", rule=" + rule
				+ ", getUrl()=" + getUrl() + ", getTimer()=" + getTimer()
				+ ", getRule()=" + getRule() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	public String getTimer() {
		return timer;
	}
	public void setTimer(String timer) {
		this.timer = timer;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	
	
}
