package com.mybatis.testor.day0525;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.Session.MySqlSessionFactory;
import com.mybatis.dao.DepartmentDao;
import com.mybatis.entity.Department;
import com.mybatis.entity.Employee;



public class Department0525 {

	public static void main(String[] args) {
		Department0525 testor = new Department0525();
		//testor.selectByDept();
		testor.selectDepartment();
		
	}
	
	/**
	 * 一对多查询
	 */
	private void selectByDept(){
		SqlSession session = null;
		
		try{
			session = MySqlSessionFactory.getSqlSession();			
			DepartmentDao dao = session.getMapper(DepartmentDao.class);

			Department dep = dao.selectByDept(90);

			List<Employee> empList = dep.getEmpList();
			for(Employee emp:empList){
				System.out.println("结果："+emp.getDepartment_id()+";"
						+emp.getEmployee_id()+";"
						+emp.getFirst_name());
			}	
		}finally{
			if(session != null){
				session.close();
			}
		}		
	}
	
	/**
	 * 用注解方式进行查找
	 * 不推荐（仅限于非常简单的sql查找，且方便代码维护）
	 */
	private void selectDepartment() {
		SqlSession session = null;
		try {
			session = MySqlSessionFactory.getSqlSession();
			DepartmentDao dao =  session.getMapper(DepartmentDao.class);
			Department dept = dao.selectDepartment(90);
			
			System.out.println("部门：" + dept.getDepartment_name());
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	

}
