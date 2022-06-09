package com.zensar.beans;

public class Departemnt {
	private int deptId;
	private String deptName;
	public Departemnt() {
		super();
	}
	public Departemnt(int deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		return "Departemnt [deptId=" + deptId + ", deptName=" + deptName + "]";
	}
	
}
