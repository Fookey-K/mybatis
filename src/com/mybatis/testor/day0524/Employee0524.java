package com.mybatis.testor.day0524;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.Session.MySqlSessionFactory;
import com.mybatis.dao.EmployeeDao;
import com.mybatis.entity.Employee;


public class Employee0524 {
	
	
	public static void main(String[] args){
		Employee0524 testor = new Employee0524();
		//testor.selectById();
		//testor.selectByName();
		//testor.selectResMap();
		testor.selectByCondition();
		//testor.updateEmployee();
	}
	/**
	 * 根据Id
	 */
	private void selectById(){
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
	/**
	 * 通过名称
	 */

	private void selectByName(){
		SqlSession session = null;
		
		try{
			session = MySqlSessionFactory.getSqlSession();
			//创建Dao实现类的实例
			EmployeeDao dao = session.getMapper(EmployeeDao.class);
			Employee empl = new Employee();
			empl.setFirst_name("c");
			List<Employee> emp = dao.selectByName(empl);
			for(Employee x:emp){
				System.out.println("员工信息:"+x.getEmployee_id()+";"
						+x.getFirst_name()+";"
						+x.getLast_name()+";"
						+x.getSalary());
			}	
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}
	/**
	 * 设置resultMap
	 */
	private void selectResMap(){
		SqlSession session = null;
		
		try{
			session = MySqlSessionFactory.getSqlSession();
			//创建Dao实现类的实例
			EmployeeDao dao = session.getMapper(EmployeeDao.class);
			Employee emp = dao.selectResMap(180);	
			System.out.println("员工信息:"+emp.getEmployee_id()+";"
						+emp.getFirst_name()+";"+emp.getSalary());
				
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}
	/**
	 * 通过动态sql
	 */
	
	private void selectByCondition(){
		SqlSession session = null;
		
		try{
			session = MySqlSessionFactory.getSqlSession();
			//创建Dao实现类的实例
			EmployeeDao dao = session.getMapper(EmployeeDao.class);
			Employee empl = new Employee();
			empl.setSalary(4000);
			List<Employee> emp = dao.selectByCondition(empl);
			for(Employee x:emp){
				System.out.println("员工信息:"+x.getEmployee_id()+";"
						+x.getFirst_name()+";"
						+x.getLast_name()+";"
						+x.getSalary());
			}	
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}
	/**
	 * 根据条件判断哪些更新，哪些不需要更新
	 * SET里面写条件
	 */
	
	public void updateEmployee(){
		SqlSession session = null;
		try{
			session = MySqlSessionFactory.getSqlSession();
			
			EmployeeDao dao = session.getMapper(EmployeeDao.class);
			Employee emp = new Employee();
			emp.setEmployee_id(180);
			emp.setFirst_name("NewName");
			emp.setLast_name("     ");
			emp.setSalary(4000);
			
			int cnt = dao.updateEmployee(emp);
			System.out.println(cnt);
			
			
		}finally{
			if(session != null){
				session.close();
			}
		}
	}

}
