package com.mybatis.mapper;

import com.mybatis.entity.Employee;

public interface EmployeeMapper {
	
	/**
	 * 根据ID查找
	 * @param employee_id
	 * @return
	 */
	
	Employee selectById(int employee_id);


}
