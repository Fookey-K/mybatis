package com.mybatis.testor.day0524;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.Session.MySqlSessionFactory;
import com.mybatis.dao.DepartmentDao;
import com.mybatis.dao.EmployeeDao;
import com.mybatis.entity.DepLocation;
import com.mybatis.entity.Department;
import com.mybatis.entity.Employee;
import com.mybatis.entity.Location;

public class Department0524 {

	public static void main(String[] args) {
		Department0524 testor = new Department0524();
		testor.selectDeptInfo();

	}

	
	private void selectDeptInfo(){
		SqlSession session = null;
		
		try{
			session = MySqlSessionFactory.getSqlSession();
			//创建Dao实现类的实例
			DepartmentDao dao = session.getMapper(DepartmentDao.class);
					
			Department dep = new Department();
			dep.setDepartment_name("c");
			
			Location lo = new Location();
			lo.setStreet_address("c");
			
			DepLocation dept = new DepLocation();
			dept.setDepartment(dep);
			dept.setLocation(lo);
			
			List<Department> deplist = dao.selectDeptInfo(dept);

			for(Department x:deplist){			
				System.out.println("结果"+x.getDepartment_id()+x.getDepartment_name());
			}	
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}
	
	

}
