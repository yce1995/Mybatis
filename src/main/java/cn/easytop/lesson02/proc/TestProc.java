package cn.easytop.lesson02.proc;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestProc {
	
	public static SqlSession getSession() throws IOException{
		String resource = "cn/easytop/lesson02/proc/mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//π§≥ß¿‡
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();	
		return session;
	}
	
	
	@Test
	public void textXmlInterface() throws IOException{
		SqlSession session=getSession();
		Map map = new HashMap();
		map.put("p1",100);
		map.put("p2",200);
		map.put("result",0);
		session.selectOne("proc.call_prg_add",map);
		System.out.println(map.get("result"));
	}
	
	@Test
	public void textXmlInterface1() throws IOException{
		SqlSession session=getSession();
		Map map = new HashMap();
		map.put("p1",100);
		map.put("p2",200);
		map.put("result",0);
		session.selectOne("proc.call_fun_add",map);
		System.out.println(map.get("result"));
	}
}
