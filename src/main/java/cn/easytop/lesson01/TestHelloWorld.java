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
		//������
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();	
		return session;
	}
	
	public static void main(String[] args) throws IOException {
		SqlSession session=getSession();
		//session������ ָ��sql����һ��Ψһ��ʶ��
		List selectList = session.selectList("a.selectFood");
		//Mapped
		//�� = sql���
		System.out.println(selectList);
	}
	
	
	
	@Test
	public void testQueryParam() throws IOException{
		SqlSession session=getSession();
		Map map =new HashMap();
		map.put("myfoodname", "�ཷ����");
		map.put("myprice", "12");
		List selectList=session.selectList("a.selectFoodByParam",map);
		System.out.println(selectList);
	}
	
	@Test
	public void saveParam() throws IOException{
		SqlSession session=getSession();
		Map map =new HashMap();
		map.put("foodname", "����������");
		map.put("price", "13");
		session.insert("a.saveFood",map);
		session.commit();
	}
}
