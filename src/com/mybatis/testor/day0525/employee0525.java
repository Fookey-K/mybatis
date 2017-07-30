package com.mybatis.testor.day0525;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.Session.MySqlSessionFactory;
import com.mybatis.dao.EmployeeDao;
import com.mybatis.entity.Department;
import com.mybatis.entity.Employee;

public class employee0525 {

	public static void main(String[] args) {
		employee0525 testor = new employee0525();
		//testor.selectByEmplist();
		//testor.selectByEmplist1();
		//testor.selectByEmplist2();
		//testor.selectByEmpList();
		testor.selectByEmpDept();
	}
	/**
	 * 传入类型为POJO的list属性
	 */
	
	private void selectByEmplist(){
		SqlSession session = null;
		
		try{
			session = MySqlSessionFactory.getSqlSession();
			
			EmployeeDao dao = session.getMapper(EmployeeDao.class);
			Department dept = new Department();
			List<Integer> deptList = new ArrayList<>();
			deptList.add(110);
			deptList.add(120);
			deptList.add(130);
			deptList.add(140);
			//将deptList放入到dept
			dept.setEmpId(deptList);
			
			List<Employee> empList = dao.selectByEmplist(dept);
			
			for(Employee emp:empList){
				System.out.println("结果："+emp.getEmployee_id()+emp.getFirst_name());
			}	
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}
	/**
	 * 传入类型为数list
	 */
	
	private void selectByEmplist1(){
		SqlSession session = null;
		
		try{
			session = MySqlSessionFactory.getSqlSession();
			
			EmployeeDao dao = session.getMapper(EmployeeDao.class);
			List<Integer> deptList = new ArrayList<>();
			deptList.add(110);
			deptList.add(120);
			deptList.add(130);
			deptList.add(140);
			
			List<Employee> empList = dao.selectByEmplist1(deptList);
			
			for(Employee emp:empList){
				System.out.println("结果："+emp.getEmployee_id()+emp.getFirst_name());
			}	
		}finally{
			if(session != null){
				session.close();
			}
		}		
	}
	/**
	 * 传入类型为数组
	 */
	
	private void selectByEmplist2(){
		SqlSession session = null;
		
		try{
			session = MySqlSessionFactory.getSqlSession();
			
			EmployeeDao dao = session.getMapper(EmployeeDao.class);
			Integer[] deptList = new Integer[4];
			deptList[0]=110;
			deptList[1]=120;
			deptList[2]=130;
			deptList[3]=140;
			
			List<Employee> empList = dao.selectByEmplist2(deptList);
			
			for(Employee emp:empList){
				System.out.println("结果："+emp.getEmployee_id()+emp.getFirst_name());
			}	
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}
	
	/**
	 * 测试trim
	 */
	
	private void selectByEmpList(){
		SqlSession session = null;
		
		try{
			session = MySqlSessionFactory.getSqlSession();			
			EmployeeDao dao = session.getMapper(EmployeeDao.class);
			
			Employee emplpyee = new Employee();
			//emplpyee.setEmployee_id(111);
			emplpyee.setFirst_name("h");
			//emplpyee.setLast_name("c");

			List<Employee> empList = dao.selectByEmpList(emplpyee);
			
			for(Employee emp:empList){
				System.out.println("结果："+emp.getEmployee_id()+emp.getFirst_name());
			}	
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}
	
	private void selectByEmpDept(){
		SqlSession session = null;
		
		try{
			session = MySqlSessionFactory.getSqlSession();			
			EmployeeDao dao = session.getMapper(EmployeeDao.class);

			List<Employee> empList = dao.selectByEmpDept(90);
			System.out.println("empList:"+empList.size());
			
			for(Employee emp:empList){
				System.out.println("结果："+emp.getDepartment_id()+";"
						+emp.getEmployee_id()+";"
						+emp.getFirst_name()+";"
						+emp.getDept().getDepartment_name());
			}	
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}
	
}
