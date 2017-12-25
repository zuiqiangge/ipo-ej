package com.pengyue.ipo.tree;

import java.util.ArrayList;
import com.pengyue.ipo.bean.TbXtTaskResult;

public class Pie {
	//显示的数量
	private String value;
	//显示的名称
	private String name;
	
	public Pie() {
		super();
	}
	
	public Pie(TbXtTaskResult tbXtTaskResult) {
		super();
		this.value=tbXtTaskResult.getClickedCounts();
		this.name=tbXtTaskResult.getResultsource();
	}
	
	/**
	 * name:名称，value：数量
	 * @param name
	 * @param value
	 */
	public Pie(String name,String value){
		super();
		this.name=name;
		this.value=value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
