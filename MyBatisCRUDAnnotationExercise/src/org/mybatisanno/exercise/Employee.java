package org.mybatisanno.exercise;

public class Employee {
	 private int eid;
	 private String ename;
	 private int esal;
	 
	 
	 public int getEsal() {
		return esal;
	}

	public void setEsal(int esal) {
		this.esal = esal;
	}

	public Employee(String ename, int esal) {
		  this.ename = ename;
		  this.esal = esal;
		  
		 }

		 public Employee() {
		 }

		 public String toString() {
		  return "\nID: " + eid + " Name: " + ename + " Salary: " + esal ;
		 }
	 
	 
	 
	 public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	
}
