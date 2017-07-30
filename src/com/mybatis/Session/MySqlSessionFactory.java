package com.mybatis.Session;

import java.io.IOException;
import java.io.Reader;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySqlSessionFactory {
	/*SqlSessionFactory 的实例可以通过 SqlSessionFactoryBuilder 获得。
	而 SqlSessionFactoryBuilder 则可以从 XML 配置文件或一个预先定制的 Configuration 的实例构建出
	SqlSessionFactory 的实例。*/	
	public static SqlSession getSqlSession(){
		SqlSession session = null;
		SqlSessionFactory factory = null;
		String rs = "mySqlConfig.xml";
		try {
			//读取配置文件
			/*Resources 是 MyBatis 提供的一个工具类，它用于简化资源文件的加载，它可以访问各种路径的文件，不过最常用
			的还是示例中这种基于类路径（class path）的表示方式。默认的是src下面*/
			Reader rd = Resources.getResourceAsReader(rs);
			factory = new SqlSessionFactoryBuilder().build(rd);
			//拿到一个SqlSession
			session = factory.openSession();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return session;		
	}
}