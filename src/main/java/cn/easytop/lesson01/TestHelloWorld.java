package cn.easytop.lesson01;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestHelloWorld {
	
	public static SqlSession getSession() throws IOException{
		String resource = "cn/easytop/lesson01/mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//工厂类
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();	
		return session;
	}
	
	public static void main(String[] args) throws IOException {
		SqlSession session=getSession();
		//session操作是 指向sql语句的一个唯一标识符
		List selectList = session.selectList("a.selectFood");
		//Mapped
		//键 = sql语句
		System.out.println(selectList);
	}
	
	
	
	@Test
	public void testQueryParam() throws IOException{
		SqlSession session=getSession();
		Map map =new HashMap();
		map.put("myfoodname", "青椒炒肉");
		map.put("myprice", "12");
		List selectList=session.selectList("a.selectFoodByParam",map);
		System.out.println(selectList);
	}
	
	@Test
	public void saveParam() throws IOException{
		SqlSession session=getSession();
		Map map =new HashMap();
		map.put("foodname", "西红柿炒蛋");
		map.put("price", "13");
		session.insert("a.saveFood",map);
		session.commit();
	}
}
