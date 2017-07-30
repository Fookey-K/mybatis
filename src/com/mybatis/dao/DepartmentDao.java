package com.mybatis.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.mybatis.entity.DepLocation;
import com.mybatis.entity.Department;
import com.mybatis.entity.Employee;


public interface DepartmentDao {
	
	List<Department> selectDeptInfo(DepLocation depLocation);
	
	/*List<Department> selectDeptHash(HashMap hashmap);*/
	
	/**
	 * 一对多查询
	 * @param dept_id
	 * @return
	 */
	Department selectByDept(int dept_id);
	
	@Select("select * from departments where department_id = #{deptid}")
	Department selectDepartment(int deptid);

}
