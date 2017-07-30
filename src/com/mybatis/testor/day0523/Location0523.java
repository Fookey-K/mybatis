package com.mybatis.testor.day0523;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.Session.MySqlSessionFactory;
import com.mybatis.dao.LocationDao;
import com.mybatis.entity.Location;



public class Location0523 {
	
	public static void main(String[] args){
		//selectLocationById();
		//insertLocation();
		//updateLocation();
		deleteLocation();
		
	}
	/**
	 * 根据ID查找信息
	 */
	
	public static void selectLocationById(){
		SqlSession session = null;		
		try{
			//获取个SqlSession
			session = MySqlSessionFactory.getSqlSession();
			//获取一个Dao的实现类的实例
			LocationDao dao = session.getMapper(LocationDao.class);
			Location location = dao.selectLocationById(2500);
			System.out.println("Country_id:"+location.getCountry_id()+";"
								+location.getState_province()+";"
								+location.getCity()+";"
								+location.getPostal_code()+";"
								+location.getStreet_address());			
		}finally{
			if(session != null){
				session.close();
			}
		}
	}
	/**
	 * 插入数据
	 */
	
	public static void insertLocation(){
		SqlSession session = null;		
		try{
			//获取个SqlSession
			session = MySqlSessionFactory.getSqlSession();
			//获取一个Dao的实现类的实例
			LocationDao dao = session.getMapper(LocationDao.class);
			Location location = new Location();
			location.setCity("CityA");
			location.setCountry_id("IT");
			location.setLocation_id(600);
			location.setPostal_code("09094");
			location.setState_province("privince");
			location.setStreet_address("address");
			
			int cnt = dao.insertLocation(location);
			session.commit();
			
			System.out.println(cnt);
						
		}finally{
			if(session != null){
				session.close();
			}
		}
	}
	/**
	 * 修改数据
	 */
	
	public static void updateLocation(){
		SqlSession session = null;		
		try{
			//获取个SqlSession
			session = MySqlSessionFactory.getSqlSession();
			//获取一个Dao的实现类的实例
			LocationDao dao = session.getMapper(LocationDao.class);
			Location location = new Location();
			location.setStreet_address("adress0523");
			location.setState_province("province0000");
			location.setLocation_id(700);
			
			int cnt = dao.updateLocation(location);
			session.commit();
			
			System.out.println(cnt);
						
		}finally{
			if(session != null){
				session.close();
			}
		}
	}
	
	/**
	 * 删除数据
	 */
	public static void deleteLocation(){
		SqlSession session = null;		
		try{
			//获取个SqlSession
			session = MySqlSessionFactory.getSqlSession();
			//获取一个Dao的实现类的实例
			LocationDao dao = session.getMapper(LocationDao.class);
			int cnt = dao.deleteLocation(700);
			session.commit();	
			System.out.println(cnt);
						
		}finally{
			if(session != null){
				session.close();
			}
		}
	}
}
