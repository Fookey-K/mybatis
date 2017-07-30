package com.mybatis.testor.day0523;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.Session.MySqlSessionFactory;
import com.mybatis.dao.EmployeeDao;
import com.mybatis.entity.Employee;

public class Employee0523 {
	
	public static void main(String[] args){
		Employee0523 testor = new Employee0523();
		testor.selectById();
	}
	
	void selectById(){
		SqlSession session = null;
		
		try{
			session = MySqlSessionFactory.getSqlSession();
			//创建Dao实现类的实例
			EmployeeDao dao = session.getMapper(EmployeeDao.class);
			Employee emp = dao.selectById(180);
			System.out.println("员工信息:"+emp.getEmployee_id()+";"
								+emp.getFirst_name()+";"
								+emp.getLast_name()+";"
								+emp.getSalary());
	
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}

}
