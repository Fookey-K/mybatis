package com.mybatis.entity;

import java.util.List;
/**
 * 部门信息表
 * @author 孔慧真
 *
 */

public class Department {

	
	private int department_id;
	private String department_name;	
	private int manager_id;
	private int location_id;
	private String orderNum;
	/**
	 * 本部门的员工Id
	 */
	private List<Integer> empId;
	
	/**
	 * 部门员工信息
	 */
	private List<Employee> empList;
	
	
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public List<Integer> getEmpId() {
		return empId;
	}
	public void setEmpId(List<Integer> empId) {
		this.empId = empId;
	}
	public List<Employee> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
	
	


}
