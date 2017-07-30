package com.mybatis.testor.day0523;

import org.apache.ibatis.session.SqlSession;
import com.mybatis.entity.Department;

import java.util.List;

import com.mybatis.Session.MySqlSessionFactory;

public class DepartmentTestor {
	
	public static void main(String[] args){
		//调用函数的两种方式
		//1：当需要调用的方法为非静态方法的时候采用以下调用方法
		
		/*DepartmentTestor testor = new DepartmentTestor();
		testor.selectDeptById();*/
		
		//2：把方法变为静态方法，直接调用
		//selectDeptById();
		
		selectDeptByLocation();
	}
	
	/**
	 * 取一条数据
	 * SqlSession.selectOne()
	 */
	private static void selectDeptById(){
		SqlSession session = null;
		try{
			//取得一个sqlsession
			//调用MySqlSessionFactory里面的getSqlSession方法
			session = MySqlSessionFactory.getSqlSession();
			/*调用sqlSession.selectOne
			 	selectOne:只能返回一条数据，如果mapper返回的是多条数据，会抛出异常
			  	test:mapper文件的namespace
			  	selectDeptById: sql对应的ID*/
			Department dept = session.selectOne("test.selectDeptById",180);
			System.out.println("部门名称：" + dept.getDepartment_name());
		}finally{
			if(session != null){
				session.close();
			}
		}
	}
	/**
	 * 取多条数据  
	 * SqlSession.selectList()
	 */
	
	private static void selectDeptByLocation(){
		SqlSession session = null;
		try{
			//取得一个sqlsession
			//调用MySqlSessionFactory里面的getSqlSession方法
			session = MySqlSessionFactory.getSqlSession();
			/*调用sqlSession.selectOne
			 	selectOne:只能返回一条数据，如果mapper返回的是多条数据，会抛出异常
			  	test:mapper文件的namespace
			  	selectDeptById: sql对应的ID*/
			List<Department> deptList =  session.selectList("test.selectDeptByLocation",1700);
			for(Department tmp:deptList){
				System.out.println("部门名称：" + tmp.getDepartment_name());
			}			
		}finally{
			if(session != null){
				session.close();
			}
		}
	}

}