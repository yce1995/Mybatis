package cn.easytop.lesson05.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestHelloWorld {

	public static SqlSession getSession() throws IOException{
		String resource = "cn/easytop/lesson05/xml/mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//工廠類
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=sqlSessionFactory.openSession();
		return session;
	}
	
	/**
	 * 一级缓存： 同一个session对象针对同一份数据的查询 产生的缓存
	 * 第一次查询 调用数据 获取数据
	 * 通过session设置到一级缓存
	 * 第二次查询时 通过session一级缓存判断是否存在 相同主键的数据值 如果存在 直接返回引用 否则 查询数据库
	 * @throws IOException
	 */
	@Test
	public void testXmlInterface() throws IOException{
		SqlSession session =getSession();
		StudentMapper fm=session.getMapper(StudentMapper.class);
		Student s = fm.queryStudentById("1");
		//从缓存中查询
		Student s1 = fm.queryStudentById("1");
		System.out.println(s==s1);
	}
	
	/**
	 * 一级缓存： 同一个session对象针对同一份数据的查询 产生的缓存
	 * 第一次查询 调用数据 获取数据
	 * 通过session设置到一级缓存
	 * 第二次查询时 通过session一级缓存判断是否存在 相同主键的数据值 如果存在 直接返回引用 否则 查询数据库
	 * @throws IOException
	 */
	@Test
	public void testXmlInterface1() throws IOException{
		SqlSession session =getSession();
		StudentMapper fm=session.getMapper(StudentMapper.class);
		Student s = fm.queryStudentById("1");
		//从缓存中查询
		Student s1 = fm.queryStudentById("1");
		System.out.println(s==s1);
	}
}
