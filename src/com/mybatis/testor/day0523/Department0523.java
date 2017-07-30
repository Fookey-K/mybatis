package com.mybatis.testor.day0523;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.Session.MySqlSessionFactory;
import com.mybatis.entity.Department;

public class Department0523 {
	
	public static void main(String[] args){
		//selectDeptByName();
		//selectDeptByName1();
		//insertDept();
		//selectDeptOrdered();
		//selectTop5();
		//selectCnt();
		//updateDept();
		//deleteDept();
		deleteDept1();
	}
	
	/**
	 * 按照名称模糊查询
	 * parameterType="com.mybatis.entity.Department"
	 */
	private static void selectDeptByName(){
		SqlSession session = null;
		try{
			//取得一个sqlsession
			//调用MySqlSessionFactory里面的getSqlSession方法
			Department dept1 = new Department();
			dept1.setDepartment_name("h");
			session = MySqlSessionFactory.getSqlSession();
			List<Department> deptList = session.selectList("test.selectDeptByName",dept1);
			for(Department tmp:deptList){
				System.out.println("部门名称：" + tmp.getDepartment_name());
			}	
		}finally{
			if(session != null){
				session.close();
			}
		}
	}
	/**
	 * 按照名称模糊查询
	 * parameterType="string"
	 */
	
	private static void selectDeptByName1(){
		SqlSession session = null;
		try{
			//取得一个sqlsession
			//调用MySqlSessionFactory里面的getSqlSession方法
			/*Department dept1 = new Department();
			dept1.setDepartment_name("h");*/
			session = MySqlSessionFactory.getSqlSession();
			List<Department> deptList = session.selectList("test.selectDeptByName1","%h%");
			for(Department tmp:deptList){
				System.out.println("部门名称：" + tmp.getDepartment_name());
			}	
		}finally{
			if(session != null){
				session.close();
			}
		}
	}
	/**
	 * 向数据库中添加一条数据
	 */
	private static void insertDept(){
		SqlSession session = null;
		try {
			//取得一个sqlSession
			session = MySqlSessionFactory.getSqlSession();
			Department dept = new Department();
			dept.setDepartment_id(523);
			dept.setDepartment_name("523测试数据-111");
			dept.setManager_id(200);
			dept.setLocation_id(1700);
			
			int cnt = session.insert("test.insertDept",dept);	
			//手动commit，否则取不到
			session.commit();
			System.out.println(cnt);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	/**
	 * 按照指定字段进行排序
	 * parameterType="com.mybatis.entity.Department"
	 */
	private static void selectDeptOrdered(){
		SqlSession session = null;
		try{
			//取得一个sqlsession
			//调用MySqlSessionFactory里面的getSqlSession方法
			session = MySqlSessionFactory.getSqlSession();
			Department dept1 = new Department();
			dept1.setOrderNum("department_name desc,manager_id");		
			List<Department> deptList = session.selectList("test.selectDeptOrdered",dept1);
			for(Department tmp:deptList){
				System.out.println("部门名称：" + tmp.getDepartment_name());
			}	
		}finally{
			if(session != null){
				session.close();
			}
		}
	}
	/**
	 * 取前五条数据
	 */
	
	private static void selectTop5() {
		SqlSession  session = null;
		try {
			//取得一个sqlSession
			session = MySqlSessionFactory.getSqlSession();
			List<Department> deptList = session.selectList("test.selectTop5");		
			for (Department dept: deptList) {
				System.out.println("部门名称:" + dept.getDepartment_name());
			}
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	/**
	 * 读取某个表的数据行数
	 */
	
	private static void selectCnt() {
		SqlSession  session = null;
		try {
			//取得一个sqlSession
			session = MySqlSessionFactory.getSqlSession();
			int cnt = session.selectOne("test.selectCnt");		
			System.out.println("数据行数："+cnt);
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	/**
	 * 修改更新部分数据
	 */	
	private static void updateDept(){
		SqlSession  session = null;
		try {
			//取得一个sqlSession
			session = MySqlSessionFactory.getSqlSession();
			Department dept1 = new Department();
			dept1.setDepartment_id(523);
			dept1.setDepartment_name("new name");
			dept1.setLocation_id(2500);
			int cnt = session.update("test.updateDept",dept1);	
			session.commit();
			System.out.println("数据行数："+cnt);
			
		} finally {
			if (session != null) {
				session.close();
			}
		}	
	}
	
	/**
	 * 删除数据
	 * parameterType="com.mybatis.entity.Department"
	 */
	private static void deleteDept(){
		SqlSession  session = null;
		try {
			//取得一个sqlSession
			session = MySqlSessionFactory.getSqlSession();
			Department dept1 = new Department();
			dept1.setDepartment_id(999);
			int cnt = session.delete("test.deleteDept",dept1);	
			session.commit();
			System.out.println("数据行数："+cnt);
			
		} finally {
			if (session != null) {
				session.close();
			}
		}	
	}
	/**
	 * 删除数据
	 * parameterType="int"
	 */
	private static void deleteDept1(){
		SqlSession  session = null;
		try {
			//取得一个sqlSession
			session = MySqlSessionFactory.getSqlSession();
			int cnt = session.delete("test.deleteDept1",902);	
			session.commit();
			System.out.println("数据行数："+cnt);
			
		} finally {
			if (session != null) {
				session.close();
			}
		}	
	}
	

}
