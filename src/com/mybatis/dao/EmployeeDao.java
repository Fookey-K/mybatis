package com.mybatis.dao;

import java.lang.reflect.Array;
import java.util.List;

import com.mybatis.entity.Department;
import com.mybatis.entity.Employee;

public interface EmployeeDao {
	
	/**
	 * 取得员工信息
	 * @param employee_id
	 * @return
	 */
	
	Employee selectById(int employee_id);
	
	List<Employee> selectByName(Employee employee);
	
	Employee selectResMap(int employee_id);
	
	/**
	 * 动态sql查找
	 * @param employee
	 * @return
	 */
	List<Employee> selectByCondition(Employee employee);
	
	/**
	 * 动态SQL更新
	 * @param employee
	 * @return
	 */
	int updateEmployee(Employee employee);
	
	/**
	 * POJO的属性为list
	 * @param dept
	 * @return
	 */
	List<Employee> selectByEmplist(Department dept);
	
	/**
	 * 传入类型为list
	 * @param list
	 * @return
	 */
	List<Employee> selectByEmplist1(List<Integer> list);
	
	/**
	 * 传入类型为数组
	 * @param array
	 * @return
	 */
	List<Employee> selectByEmplist2(Integer[] array);
	
	/**
	 * 测试trim
	 * @param employee
	 * @return
	 */
	List<Employee> selectByEmpList(Employee employee);
	
	/**
	 * 一对一查询
	 * @param dept_id
	 * @return
	 */
	List<Employee> selectByEmpDept(int dept_id);
	
	

}
