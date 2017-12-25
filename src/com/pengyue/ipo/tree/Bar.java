package com.pengyue.ipo.tree;

import java.util.List;

public class Bar {
	//X轴名称
	private List<String> x;
	//Y轴数量
	private List<String> y;
	
	public Bar() {
		super();
	}
	
	public Bar(List<String> x,List<String> y) {
		super();
		this.x=x;
		this.y=y;
	}

	public List<String> getX() {
		return x;
	}

	public void setX(List<String> x) {
		this.x = x;
	}

	public List<String> getY() {
		return y;
	}

	public void setY(List<String> y) {
		this.y = y;
	} 
	
}
