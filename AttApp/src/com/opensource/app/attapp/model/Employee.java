package com.opensource.app.attapp.model;

public class Employee {

	private int empid;
	private String emp_fname;
	private String emp_lname;
	private String emp_desig;
	private int emp_doj;
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmp_fname() {
		return emp_fname;
	}
	public void setEmp_fname(String emp_fname) {
		this.emp_fname = emp_fname;
	}
	public String getEmp_lname() {
		return emp_lname;
	}
	public void setEmp_lname(String emp_lname) {
		this.emp_lname = emp_lname;
	}
	public String getEmp_desig() {
		return emp_desig;
	}
	public void setEmp_desig(String emp_desig) {
		this.emp_desig = emp_desig;
	}
	public int getEmp_doj() {
		return emp_doj;
	}
	public void setEmp_doj(int i) {
		this.emp_doj = i;
	}
	
	@Override
	public String toString(){
		return "[[empid = "+empid+"][ emp_lname = "+emp_fname+" ]]";
		
	}
	
}
