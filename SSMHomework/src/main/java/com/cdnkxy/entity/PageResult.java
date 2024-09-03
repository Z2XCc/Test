package com.cdnkxy.entity;

import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable{
	private long total;//总数
	private List row;//返回的数据集合
	public PageResult(long total, List row) {
		super();
		this.total = total;
		this.row = row;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List getRow() {
		return row;
	}
	public void setRow(List row) {
		this.row = row;
	}
	
}
