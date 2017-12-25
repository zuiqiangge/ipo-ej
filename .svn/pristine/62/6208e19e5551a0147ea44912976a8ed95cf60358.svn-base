package com.pengyue.ipo.action.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Page<T> {

	private int pageNo = 1;// 当前页码，默认是第一页
	private int pageSize = 10;// 每页显示的记录数，默认是10
	private int startRecord;// 分页查询起始记录数
	private int endRecord;// 分页查询结束记录数
	private int totalRecord;// 总记录数
	private int totalPage;// 总页数
	private int startPage;// 起始页码
	private int endPage;// 结束页码
	private int showMaxPage=5;// 最多显示多少页，防止太多页而影响页面美观，默认是显示五页
	private boolean getAllRecord;// 是否获取所有记录
	private List<T> results;// 对应的当前页记录
	private Map<String, Object> params = new HashMap<String, Object>();// 其他的参数我们把它封装成一个Map对象

	public boolean isGetAllRecord() {
		return getAllRecord;
	}

	public void setGetAllRecord(boolean getAllRecord) {
		this.getAllRecord = getAllRecord;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {

		
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		// 在设置总行数的时候计算出对应的总页数，在下面的三目运算中加法拥有更高的优先级，所以最后可以不加括号.
		int totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize
				: totalRecord / pageSize + 1;
		if(totalPage == 0)
			totalPage = 1;
		this.setTotalPage(totalPage);
		if(this.pageNo <=0)
			this.setPageNo(1);
		if(this.pageNo > this.totalPage)
			this.pageNo = this.totalPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	
	public int getStartRecord() {
		startRecord=(this.pageNo-1)*pageSize;
		return startRecord;
	}

	public void setStartRecord(int startRecord) {
		this.startRecord = startRecord;
	}
	
	public int getEndRecord() {
		endRecord=startRecord+pageSize+1;
		return endRecord;
	}

	public void setEndRecord(int endRecord) {
		this.endRecord = endRecord;
	}

	public int getStartPage() {
		int frontPage=0;//当前页码前面展示的页码数
		int backPage=0;//当前页码后面展示的页码数
		//判断当前最大展示页码的单双情况
		if (showMaxPage%2==0) {
			frontPage=showMaxPage/2-1;
			backPage=frontPage+1;
		}else {
			frontPage=(showMaxPage-1)/2;
			backPage=frontPage;
		}
		
		startPage=pageNo-frontPage;
		if (pageNo+backPage>totalPage) {
			startPage=startPage-(pageNo+backPage-totalPage);
		}
		if (startPage<1) {
			startPage=1;
		}
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		int frontPage=0;//当前页码前面展示的页码数
		int backPage=0;//当前页码后面展示的页码数
		//判断当前最大展示页码的单双情况
		if (showMaxPage%2==0) {
			frontPage=showMaxPage/2-1;
			backPage=frontPage+1;
		}else {
			frontPage=(showMaxPage-1)/2;
			backPage=frontPage;
		}
		endPage=pageNo+backPage;
		if (startPage-frontPage<0) {
			endPage=1-(pageNo-frontPage)+endPage;
		}
		if (endPage>totalPage) {
			endPage=totalPage;
		}
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getShowMaxPage() {
		return showMaxPage;
	}

	public void setShowMaxPage(int showMaxPage) {
		this.showMaxPage = showMaxPage;
	}
	
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Page [pageNo=").append(pageNo).append(", pageSize=")
				.append(pageSize).append(", results=").append(results)
				.append(", totalPage=").append(totalPage)
				.append(", totalRecord=").append(totalRecord).append("]");
		return builder.toString();
	}


	public Page<T> pageNo(int pageNo) {
		this.pageNo = pageNo;
		return this;
	}

	public Page<T> pageSize(int pageSize) {
		this.pageSize = pageSize;
		return this;
	}
 
	public Page<T> getAllRecord(boolean getAllRecord) {
		this.getAllRecord = getAllRecord;
		return this;
	}

	 
}
